val fruit = List("apples","oranges")
val diag3 = List(
  List(1,0,0), List(0,1,0), List(0,0,1)
)
val empty : List[Nothing] = List()

println(diag3)

//regular insertion sort
def insert(x:Int, xs:List[Int]):List[Int] =
  if(xs.isEmpty || x<=xs.head) x::xs
  else xs.head :: insert(x,xs.tail)

def insertionSort(xs:List[Int]):List[Int] =
  if(xs.isEmpty) Nil
  else insert(xs.head, insertionSort(xs.tail))

val toSort = List(65,234,6535,23,675,3432,98,757,2,9)

println(insertionSort(toSort))

//insertion sort with pattern matching
def isort(xs:List[Int]):List[Int] = xs match {
  case List() => List()
  case x :: xs1 => insert(x, isort(xs1))
}

def isortHelper(x:Int, xs:List[Int]):List[Int] = xs match {
  case List() => List(x)
  case y :: ys => {
    if(x<=y) x::xs
    else y :: insert(x,ys)
  }
}

println(isort(toSort))

def msort[T](less: (T,T)=>Boolean)
            (xs:List[T]):List[T] = {
  def merge(xs:List[T], ys:List[T]):List[T] =
    (xs,ys) match {
      case (Nil, _) => ys
      case(_, Nil) => xs
      case(x::xs1, y::ys1) => {
        if(less(x,y)) x::merge(xs1,ys)
        else y::merge(xs, ys1)
      }
    }

  val n = xs.length/2
  if(n==0) xs
  else {
    val (ys,zs) = xs splitAt n
    merge(msort(less)(ys), msort(less)(zs))
  }
}

val intSort = msort((x:Int, y:Int) => x<y) _
val reverseIntSort = msort((x:Int, y:Int) => x>y) _

println(intSort(List(4,1,9,0,5,8,3,6,2,7)))
println(reverseIntSort(List(0,1,2,3,4,5,6,7,8,9)))

def reverseLeft[T](xs:List[T]) =
  (List[T]() /: xs) {(ys, y) => y :: ys}

val squares = List.tabulate(6)(n => n * n)
println( "squares : " + squares  )


val mul = List.tabulate( 4,5 )( _ * _ )
println( "mul : " + mul  )


// List.range creates a list of numbers
assert(List.range(1, 4) == List(1, 2, 3))
assert(List.range(1, 9, 3) == List(1, 4, 7))
assert(List.range(9, 1, -3) == List(9, 6, 3))

// List.make, creates lists containing the same element
assert(List.make(3, 1) == List(1, 1, 1))
assert(List.make(3, 'a') == List('a', 'a', 'a'))

// List.unzip zips up a list of tuples
assert(List.unzip(List(('a', 1), ('b', 2))) == (List('a', 'b'), List(1, 2)))

// List.flatten flattens a list of lists
assert(List.flatten(List(List(1, 2), List(3, 4), List(5, 6))) == List(1, 2, 3, 4, 5, 6))

// List.concat concatenates a bunch of lists
assert(List.concat(List(1, 2), List(3, 4), List(5, 6)) == List(1, 2, 3, 4, 5, 6))

// List.map2 maps two lists
assert(List.map2(List.range(1, 999999), List('a', 'b'))((_, _)) == List((1, 'a'), (2, 'b')))

// List.forall2
assert(List.forall2(List("abc", "de"), List(3, 2)) (_.length == _))

// List.exists2
assert(List.exists2(List("abc", "de"), List(3, 4)) (_.length != _))

// Define the sum function for lists with fold left
def sum(xs:List[Int]): Int = (0 /: xs)(_ + _)
assert(sum(List(2, 3, 4)) == 9)

// Define the product function for lists with fold right
def prod(xs:List[Int]): Int = (xs :\ 1)(_ * _)
assert(prod(List(2, 3, 4)) == 24)

// Define reverse in terms of fold
def reverse[T](xs: List[T]) = (List[T]() /: xs) ((ys, y) => y :: ys)
assert(reverse(List(1, 2, 3)) == List(3, 2, 1))
