package code

object FallWinterSpringSummer extends Application{
  for(season <- List("fall" , "winter" , "spring"))
    println(season+": "+ChecksumAccumulator.calculate(season))
}
