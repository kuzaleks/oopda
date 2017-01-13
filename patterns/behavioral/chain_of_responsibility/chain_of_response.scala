/*
 * Avoid coupling the sender of the request to the receiver by giving more than one object
 the chance to handle the request
*/


abstract class Request
case class StringRequest(s: String) extends Request


abstract class Handler {
  val handler: Option[Handler]
  def handle(req: Request) {
    if (handler.isDefined) handler.get.handle(req)
  }
}


class ConcreteHandler1(override val handler: Option[Handler]) extends Handler {
  override def handle(req: Request) {
    req match {
      case StringRequest("1") => println("First Concrete")
      case _ => handler map (_.handle(req))
    }
  }
}


class ConcreteHandler2(override val handler: Option[Handler]) extends Handler {
  override def handle(req: Request) {
    req match {
      case StringRequest("2") => println("Second Concrete")
      case _ => handler map (_.handle(req))
    }
  }
}


class Application extends Handler {
  override val handler = Option(null)
  override def handle(req: Request) {
    println("Application 1.0")
  }
}


object Client {
  def main(args: Array[String]) {
    println("Hello")

    val app = new Application
    val h2 = new ConcreteHandler2(Option(app))
    val h1 = new ConcreteHandler1(Option(h2))
  
    h1.handle(StringRequest("1"))
    h1.handle(StringRequest("2"))
    h1.handle(StringRequest("Hello"))
  }
}
