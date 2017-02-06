/*
 Compose objects into tree structures to represent part-whole hierarchies. 
 */

import scala.collection.mutable.MutableList


abstract class Component {
  def operation
}


class Composite extends Component {
  var children = List[Component]()

  override def operation {
    println("Operation by Composite")
    children foreach {_.operation}
  }

  def add(child: Component) {children = child::children}
  def remove(child: Component) {
    children = children.filter(_ != child)
  }
}


class Leaf extends Component {
  override def operation {println("operation by Leaf")}
}


object Client {
  def operation(component: Component) {
    component.operation
  }

  def main(args: Array[String]) {
    val composite = new Composite
    operation(composite)

    val leaf = new Leaf
    operation(leaf)

    composite.add(leaf)
    composite.add(new Leaf)

    operation(composite)
  }
}
