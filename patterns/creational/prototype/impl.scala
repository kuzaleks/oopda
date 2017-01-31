/*
 INTENT

 Specify the kinds of objects to create using prototypical instance, and 
 create new objects by copying this prototype.
*/


trait Prototype {
  def deepClone: Prototype
  def operation {println(data)}
  val data: Int
}


class ConcretePrototype1(val data: Int) extends Prototype {
  def deepClone = new ConcretePrototype1(data)
}


class ConcretePrototype2(val data: Int) extends Prototype {
  def deepClone = new ConcretePrototype2(data)
}


object Client {
  def operation(prototype: Prototype) {
    val operand = prototype.deepClone
    println(operand.data)
  }

  def main(args: Array[String]) {
    println("Hello")

    operation(new ConcretePrototype1(1))
    operation(new ConcretePrototype2(2))
  }
}

