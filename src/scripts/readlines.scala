import scala.io.Source;

if (args.length > 0){
  val allLines = Source.fromFile(args(0)).getLines().toList
  val longestLine = allLines.reduceLeft((a,b) => if ( a.length > b.length) a else b)
  val maxWidth = widthOfLength(longestLine)
  for( line <- allLines ){
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = "" * numSpaces;
    println(padding + line.length + " | " + line)
  }
} else {
  Console.err.println("please enter filename")
}

def widthOfLength(s : String) : Int = {
  s.length;
}