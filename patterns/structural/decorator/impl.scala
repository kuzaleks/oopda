/*
 Attach additional responsibilities to an object dynamically. Decorators provide
 a flexible alternative to subclassing for extending functionality.
 */


abstract class Component {
  def operation(context: String)
}


class ConcreteComponent extends Component {
  def operation(context: String) {
    println("Concrete Component in " + context)
  }
}


abstract class Decorator(val component: Component) extends Component {
  def operation(context: String) {
    component.operation(context)
  }
}


class ConcreteDecoratorA(component: Component) extends Decorator(component) {
  val state = 0
  override def operation(context: String) {
    super.operation(context)
    println(" in state: " + state)
  }
}


class ConcreteDecoratorB(component: Component) extends Decorator(component) {
  def addedBehavior {
    println(
      (for (i <- 1 to 10) yield '#').mkString("")
    )
  }
  override def operation(context: String) {
    super.operation(context)
    addedBehavior
  }
}


object Client {
  def operation(component: Component) {
    component.operation("Client")
  }

  def main(args: Array[String]) {

    val component = new ConcreteComponent
    operation(component)

    val decoratorA = new ConcreteDecoratorA(component)
    operation(decoratorA)

    val decoratorB = new ConcreteDecoratorB(component)
    operation(decoratorB)

    operation(new ConcreteDecoratorA(decoratorB))
    operation(new ConcreteDecoratorB(decoratorA))
  }
}
