val greetStrings = new Array[String](3)

greetStrings(0) = "yoyo"
greetStrings.update(1, "dodo")
greetStrings(2) = "bobo"

for(i<-0 to 2)
  println(greetStrings.apply(i))

val differentArray = Array("abc", "def", "ghi")
println(differentArray(1))