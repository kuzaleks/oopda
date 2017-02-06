/*
 Decouple abstraction from its implementation so that the two can very
 independently.
 */


abstract class Implementation {
  def operation
}


class ConcreteImplementationA extends Implementation {
  override def operation {
    println("Concrete Operation A")
  }
}


class ConcreteImplementationB extends Implementation {
  override def operation {
    println("Concrete Operation B")
  }
}


abstract class Abstraction(val imp: Implementation) {
  def operation {imp.operation}
}


class RefinedAbstraction(imp: Implementation) extends Abstraction(imp) {
  def refinedOperation {
    println("Refined Operation")
    operation
    operation
  }
}

object Client {

  def operation(obj: RefinedAbstraction) {
    obj.refinedOperation
  }

  def main(args: Array[String]) {
    val implA = new ConcreteImplementationA
    val implB = new ConcreteImplementationB

    operation(new RefinedAbstraction(implA))
    operation(new RefinedAbstraction(implB))
  }
}

