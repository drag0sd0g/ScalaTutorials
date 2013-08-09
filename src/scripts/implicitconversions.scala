import java.awt.event.{ActionListener, ActionEvent}
import javax.swing.JButton

implicit def function2ActionListener(f:ActionEvent => Unit) =
  new ActionListener {
    def actionPerformed(e: ActionEvent) = f(e)
  }

val button = new JButton
button.addActionListener(
  function2ActionListener(
    (_:ActionEvent) => println("pressed!")
  )
)

implicit def doubleToInt(x:Double) = x.toInt
val i:Int = 3.5
println(i)

class PreferredPrompt(val preference:String)
class PreferredDrink(val preference:String)

object Greeter {
  def greet(name:String)(implicit prompt:PreferredPrompt, drink:PreferredDrink){
    println("Welcom "+name+" The system is ready muhfuguh")
    print("but while you work, ")
    println("why not enjoy a cup of "+drink.preference)
    println(prompt.preference)
  }
}

object JoesPrefs {
  implicit val prompt = new PreferredPrompt("yes master> ")
  implicit val drink = new PreferredDrink("absynth")
}
import JoesPrefs._

Greeter.greet("Joe")

def maxListUpBound[T](elements:List[T])(implicit orderer:T=>Ordered[T]):T =
  elements match {
    case List() => throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest => {
      val maxRest = maxListUpBound(rest)
      if(orderer(x)>maxRest) x
      else maxRest
    }
  }