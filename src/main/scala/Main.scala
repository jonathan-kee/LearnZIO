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

  // run is an override
  override def run = myAppLogic.fold(
    fail => println("Fail"),
    success => println("Success")
  )
}