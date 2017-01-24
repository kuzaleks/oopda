/*
 Provide an interface for creating families of related or dependent objects without
 specifieng their concrete classes
 */


abstract class AbstractProductA {}


class ConcreteProductA1 extends AbstractProductA {
  override def toString = "Product A1"
}
class ConcreteProductA2 extends AbstractProductA {
  override def toString = "Product A2"
}


abstract class AbstractProductB {}


class ConcreteProductB1 extends AbstractProductB {
  override def toString = "Product B1"
}
class ConcreteProductB2 extends AbstractProductB {
  override def toString = "Product B2"
}


abstract class AbstractFactory {
  def createProductA: AbstractProductA
  def createProductB: AbstractProductB
}


class ConcreteFactory1 extends AbstractFactory {
  override def createProductA = new ConcreteProductA1
  override def createProductB = new ConcreteProductB1
}


class ConcreteFactory2 extends AbstractFactory {
  override def createProductA = new ConcreteProductA2
  override def createProductB = new ConcreteProductB2
}


object Client {
  def createProductA(factory: AbstractFactory) = factory.createProductA
  def createProductB(factory: AbstractFactory) = factory.createProductB

  def main(args: Array[String]) {
    println("Hello")

    val factory1 = new ConcreteFactory1
    println(createProductA(factory1))
    println(createProductB(factory1))

    val factory2 = new ConcreteFactory2
    println(createProductA(factory2))
    println(createProductB(factory2))
  }
}

