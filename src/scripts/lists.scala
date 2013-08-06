val oneTwoThree = List(1,2,3)
oneTwoThree.foreach(println)

val fourFiveSix = List(4,5,6)
val concatenation = oneTwoThree:::fourFiveSix;
println("concatenation result "+ concatenation)

val literalList = 1::2::3::Nil;
println(literalList)

val thrill = "Will" :: "fill" :: "until" :: Nil;
println("thrill(2): "+thrill(2))
println("thrill.count(s => s.length == 4): "+ thrill.count(s => s.length == 4))
println(thrill.drop(2))
println(thrill.dropRight(2))
println(thrill.exists(s => s == "until"))
println(thrill.filter(s=>s.length==4))
println(thrill.forall(s=>s.endsWith("l")))
println(thrill.head)
println(thrill.init)
println(thrill.last)
println(thrill.reverse)
println(thrill.tail)
