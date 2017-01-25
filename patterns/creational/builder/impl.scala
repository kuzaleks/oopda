/*
 Separate construction of a complex object from it's representation so that the
 same construction process can create different representations
 */

import scala.collection.mutable.MutableList


class Builder {
  def buildPartA {}
  def buildPartB {}
  def buildPartC {}
}


class ConcreteBuilder extends Builder {
  val product = MutableList[String]()
  override def buildPartA {println("Build Part A"); product += "A"}
  override def buildPartB {println("Build Part B"); product += "B"}
  override def buildPartC {println("Build Part C"); product += "C"}

  def getProduct = product
}


object Client {

  def director(builder: Builder) {
    builder.buildPartA
    builder.buildPartB
    builder.buildPartC
  }

  def main(args: Array[String]) {
    println("Hello")

    val builder = new ConcreteBuilder
    director(builder)

    println(builder.getProduct)
  }
}

