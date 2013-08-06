package code

import java.io.{PrintWriter, File}

object ControlAbstractions {
  def main(args : Array[String]){
    val second = first(1)
    println(second(2))

    val onePlus = curriedSum(1)_
    println(onePlus(7))

    println(twice(_ + 1, 5))

    val thisFile = new File("test.txt")
    withPrintWriter(thisFile){
      writer => writer.println(new java.util.Date())
    }
  }

  private def curriedSum(x:Int)(y:Int) = x + y;
  private def first(x:Int) = (y:Int) => x+y
  private def twice(op:Double => Double, x:Double) = op(op(x))
  private def withPrintWriter(file:File)(op : PrintWriter => Unit){
    val writer = new PrintWriter(file)
    try{
      op(writer)
    } finally {
      writer.close()
    }
  }
}
