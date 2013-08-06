import scala.collection.immutable.HashSet
import scala.collection.mutable.Map

var movieSet = HashSet("abc", "def")
movieSet += "ghi"
movieSet.foreach(println)

val treasureMap = Map[Int, String]()
treasureMap += (1->"go to island")
treasureMap += (2-> "find big x")
treasureMap += (3-> "dig")

println(treasureMap(2))