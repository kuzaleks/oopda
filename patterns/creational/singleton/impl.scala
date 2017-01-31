/*
 Ensure a class only has one instance, and provide the global point of access to it.
 */


object Singleton {
  private var data = 0
  def singletonOperation {println("Singleton Operation")}
  def getSingletonData = data
}


object Client {

  def main(args: Array[String]) {
    println("Hello")

    Singleton.singletonOperation
    println(Singleton.getSingletonData)
  
  }
}

