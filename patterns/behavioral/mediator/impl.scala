/*
 * Define an object that encapsulates how a set of objects interact.
*/


class Colleague(val mediator: Mediator) {
  def changed {mediator.colleagueChanged(this)}
}


class ConcreteColleague1(mediator: Mediator) extends Colleague(mediator) {
  def react {println("React 1"); changed}
}


class ConcreteColleague2(mediator: Mediator) extends Colleague(mediator) {
  def react {println("React 2"); changed}
}


abstract class Mediator {
  // def createColleagues
  def colleagueChanged(colleague: Colleague)
}


class ConcreteMediator extends Mediator {
  
  val colleague1 = new ConcreteColleague1(this)
  val colleague2 = new ConcreteColleague2(this)

  override def colleagueChanged(colleague: Colleague) {
    if (colleague == colleague1) {println("Transfer from 1 to 2"); colleague2.react}
    else if (colleague == colleague2) {println("Got call from 2")}
  }
}


object Client {
  def main(args: Array[String]) {
    println("Hello")
  
    val cm = new ConcreteMediator
    cm.colleague1.react

    cm.colleague2.react
  }
}
