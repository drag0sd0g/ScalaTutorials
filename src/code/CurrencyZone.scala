package code

abstract class CurrencyZone {
  type Currency <: AbstractCurrency
  def make(x: Long): Currency

  abstract class AbstractCurrency {
    val amount: Long
    def designation: String

    def + (that: Currency): Currency =
      make(this.amount + that.amount)

    def * (x:Double): Currency =
      make((this.amount * x).toLong)

    def - (that: Currency): Currency =
      make(this.amount - that.amount)

    def / (that: Double) =
      make((this.amount/that).toLong)

    def / (that: Currency) =
      this.amount.toDouble / that.amount

    def from(other: CurrencyZone#AbstractCurrency): Currency =
      make(math.round(other.amount.toDouble * Converter.exchangeRate
        (other.designation)(this.designation)))

    private def decimals(n:Long): Int =
      if (n == 1) 0 else 1 + decimals(n/10)

    override def toString =
      ((amount.toDouble / CurrencyUnit.amount.toDouble)) formatted(("%." + decimals(CurrencyUnit.amount) + "f" + " " + designation))

  }

  val CurrencyUnit: Currency
}

object Converter {
  var exchangeRate = Map(
    "EUR" -> Map("USD" -> 1.316, "JPY" -> 1.594, "EUR" -> 1.0),
    "JPY" -> Map("USD" -> 9.316, "EUR" -> 1.232, "JPY" -> 1.0)
  )
}

object Europe extends CurrencyZone{
  abstract class Euro extends AbstractCurrency{
    def designation = "EUR"
  }

  type Currency = Euro
  def make(cents: Long) = new Euro {
    val amount = cents
  }

  val Cent = make(1)
  val Euro = make(100)
  val CurrencyUnit = Euro
}

object Japan extends CurrencyZone {
  abstract class Yen extends AbstractCurrency {
    def designation = "JPY"
  }
  type Currency = Yen
  def make(yen: Long) = new Yen {
    val amount = yen
  }

  val Yen = make(1)
  val CurrencyUnit = Yen
}
