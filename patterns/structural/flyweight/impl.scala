/*
 Use sharing to support large numbers of fine-grained objects efficiently.
 */


abstract class Flyweight {
  def operation(context: Int)
}


class ConcreteFlyweight(name: String) extends Flyweight {
  var state: String = name
  def operation(context: Int) {
    val msg = (for (i <- 1 to context) yield state) mkString(" ")
    println(msg)
  }
}


class UnsharedConcreteFlyweight extends Flyweight {
  def operation(context: Int) {
    val msg = (for (i <- 1 to context) yield "U") mkString(" ")
    println(msg)
  }
}


class FlyweightFactory {
  var flyweights = Map[String, Flyweight]()
  def getFlyweight(key: String): Flyweight = {
    if (! (flyweights contains key))
      if (key.length % 2 == 0)
        flyweights = flyweights + (key -> new ConcreteFlyweight(key))
      else
        flyweights = flyweights + (key -> new UnsharedConcreteFlyweight)
    flyweights(key)
  }
}



object Client {

  def main(args: Array[String]) {
    println("Hello Flyweight!")

    val fwFactory = new FlyweightFactory

    val flw1 = fwFactory.getFlyweight("Hanna")
    val flw2 = fwFactory.getFlyweight("Elly")

    flw1.operation(5)
    flw2.operation(4)
  }
}
