/*
 Provide a surrogate or placyholder for another object to control the access to it.

 Variants:
 - Remote Prxy (Ambassador)
 - Virtual Proxy
 - Protection Proxy
 - Smart Reference

 */


abstract class Subject {
  def request(arg: String)
}


class ConcreteSubject extends Subject {
  def request(arg: String) {
    println(s"Handle request $arg.")
  }
}


class Proxy extends Subject {
  var subject: Option[ConcreteSubject] = None
  def getSubject: Subject = subject match {
    case Some(s) => s
    case None => {
      val s = new ConcreteSubject
      println("Creating subject")
      subject = Some(s)
      s
    }
  }

  def request(arg: String) {
    getSubject.request(arg)
  }
}


object Client {

  def request(subject: Subject, reqMsg: String) {
    subject.request(reqMsg)
  }

  def main(args: Array[String]) {
    println("Hello Proxy!")

    val proxy = new Proxy
    request(proxy, "One")
    request(proxy, "Two")
  }
}
