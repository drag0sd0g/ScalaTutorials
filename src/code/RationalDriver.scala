package code
object RationalDriver {
  def main(args : Array[String]){
    println(new Rational(1,3))
    println(new Rational(5,7))

    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)

    println ( oneHalf + twoThirds )
    println(new Rational(13))
    //println(new Rational(1,0)) <-- IllegalArgumentException, requirement failed
  }
}
