/*
 Defines a one-to-many dependency between objects so that when one object changes the state
 * all its dependancts get notified and updated automatically.
*/

import scala.collection.mutable.MutableList


abstract class Observer(val subject: Subject) {
  subject.attach(this)
  def update(subj: Subject)
}


class Subject {
  var observers = MutableList[Observer]()
  def notifyObservers = observers map {_.update(this)} 
  def attach(obs: Observer) {observers += obs}
  def detach(obs: Observer) {
    observers = observers.filter(_ == obs)
  }
}


class StatefulSubject extends Subject {
  var state = 0
  def change(v: Int) {
    state = v
    notifyObservers
  }
  def getState: Int = state
}


class ConcreteObserver1(subject: StatefulSubject) extends Observer(subject) {
  def update(other: Subject) {
    if (subject == other) {
      print("Observer 1 ")
      println(subject.getState)
    }
  }
}


class ConcreteObserver2(subject: StatefulSubject) extends Observer(subject) {
  def update(other: Subject) {
    if (subject == other) {
      print("Observer 2 ")
      println(subject.getState)
    }
  }
}


object Client {
  def main(args: Array[String]) {
    println("Hello")
    val subj = new StatefulSubject()
  
    val obs1 = new ConcreteObserver1(subj)
    val obs2 = new ConcreteObserver2(subj)

    subj.change(2)
  }
}
