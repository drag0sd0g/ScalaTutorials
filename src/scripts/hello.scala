println("script hello")

// begin imperative style
var i = 0
while(i<args.length)              {
  println("the argument is "+args(i))
  i+=1
}
//end imperative style

//begin functional style
args.foreach(arg => println("functional print of "+arg))
//end functional style

//being super functional style
args.foreach(println)
//end super functional style
