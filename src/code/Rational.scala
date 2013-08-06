package code

class Rational (n : Int, d : Int) {
  require (d != 0)
  private val simplifyFactor = gcd (n.abs, d.abs)
  val numerator : Int = n / simplifyFactor;
  val denominator : Int = d / simplifyFactor;

  override def toString = n+"/"+d

  def this(n:Int) = this(n, 1)

  def +(that : Rational) : Rational =
    new Rational(numerator * that.denominator + that.numerator * denominator, denominator * that.denominator)
  def +(i:Int):Rational =
    new Rational(numerator + i*denominator, denominator)

  def -(that:Rational):Rational =
    new Rational(numerator*that.denominator - that.numerator*denominator, denominator*that.denominator)
  def -(that:Int):Rational =
    new Rational(numerator - that*denominator, denominator)


  def *(that:Rational):Rational =
    new Rational(numerator * that.numerator, denominator * that.denominator)
  def *(i:Int):Rational =
    new Rational(numerator*i, denominator)

  def /(i:Int):Rational =
    new Rational(numerator, denominator*i)
  def /(that:Rational):Rational =
    new Rational(numerator*that.denominator, denominator*that.numerator)

  private def gcd(a:Int, b:Int):Int =
    if (b==0) a else gcd(b, a%b)

}
