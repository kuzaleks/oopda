/*
 Converts the interface of the class into another interface that client expects
 */

class Adaptee {
  def specificRequest {println("call specific request")}
}


abstract class Target {
  def request
}


class Adapter(val adaptee: Adaptee) extends Target {
  override def request {adaptee.specificRequest}
}


object Client {
  def callTarget(target: Target) {
    target.request
  }

  def main(args: Array[String]) {
    val adaptee = new Adaptee
    val adapter = new Adapter(adaptee)

    callTarget(adapter)
  }
}
