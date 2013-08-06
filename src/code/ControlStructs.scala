package code

import java.io.File
import scala.Predef._

object ControlStructs {

  val filesHere = (new File(("src/code"))).listFiles();

  def main(args : Array[String]){
    grep(".*gcd.*")
    println(searchFrom(0, args))
    println(multiTable())
  }

  def scalaFiles =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
    } yield file

  def fileLines(file : java.io.File) =
    scala.io.Source.fromFile(file).getLines().toList

  def grep(pattern:String) =
    for (
      file <- filesHere
      if file.getName.endsWith(".scala");
      line <- fileLines(file);
      trimmed = line.trim
      if trimmed.matches(pattern)
    ) println(file + ": " + trimmed)

  def forLineLengths =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala");
      line <- fileLines(file);
      trimmed = line.trim
      if trimmed.matches(".*for.*")
    } yield trimmed.length

  def searchFrom(i:Int, args:Array[String]):Int =
    if(i >= args.length) -1
    else if (args(i).startsWith("vanita")) searchFrom(i+1, args)
    else if (args(i).endsWith("s")) i
    else searchFrom(i+1, args)

  def makeRowSeq(row:Int)=
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4-prod.length)
      padding + prod
    }

  def makeRow(row:Int)= makeRowSeq(row).mkString

  def multiTable() = {
    val tableSeq =
      for (row <- 1 to 10)
      yield makeRow(row)
    tableSeq.mkString("\n")
  }

}
