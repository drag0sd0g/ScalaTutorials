package code

import scala.collection.mutable.ArrayBuffer

class Animal

trait HasLegs

class Frog extends Animal with Philosophical with HasLegs{
  override def toString = "greenFrog"
}

trait Philosophical {
  def philosophize(){
    println("cugito ergo sum")
  }
}


trait Rectangular{
  def topLeft:Point
  def bottomRight:Point
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}

class Point(val x:Int, val y:Int)

abstract class IntQueue{
  def get():Int
  def put(x:Int)
}

class BasicIntQueue extends IntQueue{
  private val buf = new ArrayBuffer[Int]()
  def get() = buf.remove(0)
  def put(x:Int) = buf+=x
}

trait Doubling extends IntQueue{
  abstract override def put(x:Int) {super.put(2*x)}
}

trait Filtering extends IntQueue{
  abstract override def put(x:Int) {super.put(x+1)}
}

trait Incrementing extends IntQueue{
  abstract override def put(x:Int) { if (x>=0) super.put(x)}
}