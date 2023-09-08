import zio._
import zio.Console._

import java.io.IOException

object Main extends ZIOAppDefault {
  // Any is Environment Type
  // IOException is Failure Type
  // Unit is Success Type
  val myAppLogic: ZIO[Any, IOException, Unit] =
    for {
      _ <- printLine("Hello! What is your name?")
      name <- readLine
      _ <- printLine(s"Hello, ${name}, welcome to ZIO!")
    } yield ()

  val myAppLogic2:ZIO[Any, Nothing, Int] = ZIO.succeed(42)

  // run is an override
//  override def run = myAppLogic.fold(
//    fail => println("Fail"),
//    success => println("Success")
//  )

  def max(x: Int, y: Int): Int = {
    if (x > y) x else y
  }

  // If I am not mistaken, the for {} syntax only work if it's like the last argument
  // the for {} syntax helps you to not use ; to indicate new statement
  val myAppLogic3 = for {
    _ <- printLine(max(2, 3))
    _ <- printLine(max(3, 4))
  } yield ()

  // Using a reference to an Array in the next line and print it
  val myAppLogic4 = for {
    i <- ZIO.succeed(Array(1,2,3)) // Array(1, 2, 3);
    _ <- ZIO.succeed(i.foreach(println))
  } yield ()

  // From RockJvm repo
  // https://github.com/rockthejvm/zio-course/blob/master/src/main/scala/com/rockthejvm/part2effects/ZIOEffects.scala
  val meaningOfLife: ZIO[Any, Nothing, Int] = ZIO.succeed(42)
  val printingMOL = meaningOfLife.flatMap(mol => ZIO.succeed(println(mol)))

  override def run = myAppLogic4
}