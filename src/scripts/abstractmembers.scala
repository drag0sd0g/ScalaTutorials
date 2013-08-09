trait LazyRationalTrait{
  val numerArg:Int
  val denomArg:Int

  lazy val numer = numerArg  / g
  lazy val denom = denomArg / g

  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }

  private def gcd(a:Int, b:Int):Int =
    if(b==0) a else gcd(b,a%b)

  override def toString = numer + "/" + denom
}


val x = 2
new LazyRationalTrait {
  val numerArg = 1 * x
  val denomArg = 2 * x
}

import code.Europe
import code.Japan

Japan.Yen from Europe.Euro
