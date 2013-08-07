package code

abstract class Element {
  def contents : Array[String]

  def height : Int = contents.length

  def width : Int = if (height == 0) 0 else contents(0).length

  def demo() { println("Element demo()")}

  def above(that:Element) =
    ElementFactory.elem(this.contents ++ that.contents)

  def beside(that:Element):Element = {
    ElementFactory.elem(
      for(
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )
  }

  def widen(w:Int):Element=
    if(w<=width) this
    else {
      val left = ElementFactory.elem(' ', (w-width)/2,height)
      val right = ElementFactory.elem(' ',w-width-left.width,height)
      left beside this beside right
    }

  def heighten(h:Int):Element=
    if(h<=height) this
    else {
      val top = ElementFactory.elem(' ', width, (h-height)/2)
      val bottom = ElementFactory.elem(' ',width, h-height-top.height)
      top above this above bottom
    }

  override def toString = contents mkString "\n"
}

object ElementFactory { //companion Element singleton, playing the role of a factory
def elem(contents:Array[String]):Element = new ArrayElement(contents)
  def elem(line:String):Element = new LineElement(line)
  def elem(chr:Char, width:Int, height:Int):Element = new UniformElement(chr, width, height)
}


class ArrayElement(conts: Array[String]) extends Element{
  def contents : Array[String] = conts //or, if you want to make it a field: val contents : Array[String]  = conts
  override def demo() { println("ArrayElement demo()")}
}

final class LineElement(s:String) extends ArrayElement(Array(s)){
  override def width = s.length
  override def height = 1;
  override def demo() { println("LineElement demo()")}
}

class UniformElement(
                      ch: Char,
                      override val width: Int,
                      override val height: Int
                      ) extends Element{ // will inherit Element's demo() impl
private val line = ch.toString * width
  def contents = Array.fill(height)(line)
}
