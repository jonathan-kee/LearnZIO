import zio._
import zio.Console._

object Main extends ZIOAppDefault {

  val myAppLogic =
    for {
      _ <- printLine("Hello! What is your name?")
      name <- readLine
      _ <- printLine(s"Hello, ${name}, welcome to ZIO!")
    } yield ()

  def run = myAppLogic
}