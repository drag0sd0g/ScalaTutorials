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

// List in Scala or homogenous, they are declared as List[T]
val names: List[String] = List("Arnold", "George", "Obama")

// Lists are constructed from two building blocks :: and Nil
assert(names == "Arnold" :: "George" :: "Obama" :: Nil)

// Gets the first element of a list
assert(names.head == "Arnold")

// Gets the rest of the list
assert(names.tail == "George" :: "Obama" :: Nil)

// Checks if the list is empty
assert(List().isEmpty)

// List length
assert(names.length == 3)

// ::: appends two lists
val namesTwice = names ::: names
assert(namesTwice == List("Arnold", "George", "Obama", "Arnold", "George", "Obama"))

// last gets the last element
assert(names.last == "Obama")

// init gets all but the last
assert(names.init == "Arnold" :: "George" :: Nil)

// reverse reverses the list
assert(names.reverse == "Obama" :: "George" :: "Arnold" :: Nil)

// drop drops the first n items
assert(names.drop(2) == "Obama" :: Nil)

// take keeps the first n items
assert(names.take(1) == "Arnold" :: Nil)

// splitAt, does both take and drop at the same time, returning a tuple
assert(names.splitAt(1) == (List("Arnold"), List("George", "Obama")))

// indeces, gives my the indeces of the list
assert(names.indices == List(0, 1, 2))

// zip, zips two lists together
assert(names.zip(names.indices) == List(("Arnold", 0), ("George", 1), ("Obama", 2)))

// toString returns a list as String
assert(names.toString == "List(Arnold, George, Obama)")

// mkString, lets you join the string with a separator
assert(names.mkString("-") == "Arnold-George-Obama")


val array = Array("Arnold", "George", "Obama")

// Convert the list to an Array

/*assert(names.toArray == array)  Equality does not work for arrays
java.lang.AssertionError: assertion failed
  at scala.Predef$.assert(Predef.scala:87)
...
*/

// If we convert it back it works
assert(names.toArray.toList == names)

// We can also mutate the array with copyToArray
List("Hilary").copyToArray(array, 1)
assert(array.toList == List("Arnold", "Hilary", "Obama"))

// elements will give me an iterator
val it = names.iterator
assert (it.next == "Arnold")

// map, converts from one list to another, notice the placeholder syntax (_)
assert(names.map(_.length) == List(6 ,6, 5))

// Get the first char of the words
assert(names.map(_.charAt(0)) == List('A', 'G', 'O'))

// Get the names as lists
assert(names.map(_.toList) == List(List('A', 'r', 'n', 'o', 'l', 'd'),
  List('G', 'e', 'o', 'r', 'g', 'e'), List('O', 'b', 'a', 'm', 'a')))

// When you have a list of lists, you can use flatMap
assert(names.flatMap(_.toList) == List('A', 'r', 'n', 'o', 'l', 'd',
  'G', 'e', 'o', 'r', 'g', 'e', 'O', 'b', 'a', 'm', 'a'))

// Filter is used to filter out specific elements that satisfy the predicate.

// Filter out all names of length 6
assert(names.filter(_.length == 6) == List("Arnold", "George"))

val chars = names.flatMap(_.toList)

// Filter out all chars larger than 'a' (capitals are smaller in ascii)
assert(chars.filter(_ > 'a') == List('r', 'n', 'o', 'l', 'd', 'e', 'o',
  'r', 'g', 'e', 'b', 'm'))

// And combine them
// Give me the first letter of all words with length 6
assert(names.filter(_.length == 6).map(_.charAt(0)) == List('A', 'G'))

// partition returns a pair of list (satisfied, not satisfied)
assert(names.partition(_.length == 6) == (List("Arnold", "George"), List("Obama")))

// find returns the first element that satisfy the predicate
// Since this function may not be satisfied, an optional value is used
assert(names.find(_.length == 6) == Some("Arnold"))

// An optional value returns Some(value) or None
assert(names.find(_.length == 7) == None)

// takeWhile and dropWhile take resp. drop while the predicate is fulfilled
assert(chars.takeWhile(_ != 'o') == List('A', 'r', 'n'))
assert(chars.dropWhile(_ != 'm') == List('m', 'a'))

// Span does both at the same time
assert(chars.span(_ != 'o') == (List('A', 'r', 'n'),
  List('o', 'l', 'd', 'G', 'e', 'o', 'r', 'g', 'e', 'O', 'b', 'a', 'm', 'a')))

// forall checks that a predicate is true for all elements of the list
assert(!chars.forall(_ == 'a'))
assert(chars.forall(_ >= 'A'))

// exists checks that a predicate is true for some element of the list
assert(names.exists(_.length == 5))
assert(!names.exists(_.length == 7))
