/*
 Converts the interface of the class into another interface that client expects
 */


trait Adaptee {
  def specificRequest {println("Call specific request")}
}


abstract class Target {
  def request
}


class Adapter extends Target with Adaptee {
  override def request {super.specificRequest}
}


object Client {
  def callTarget(target: Target) {
    target.request
  }

  def main(args: Array[String]) {
    callTarget(new Adapter)
  }
}
