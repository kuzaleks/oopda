/*
 Provides a unified interface to a set of interfaces in a subsystem. Facade defines
 a higher-level interface that makes the subsystem easear to use.
 */


abstract class Stream {
  def bytes: Iterable[String]
}

class Scanner(val inputStream: Stream) {
  def scan(): Iterable[String] = inputStream.bytes
}


abstract class Expression
case class Var(name: String) extends Expression
case class Number(num: Double) extends Expression
case class UnOp(operator: String, arg: Expression) extends Expression
case class BinOp(
  operator: String,left: Expression, right: Expression
) extends Expression


abstract class NodeBuilder {
  def buildVar(name: String)
  def buildNum(num: Double)
  def buildUnOp(operator: String, arg: Expression)
  def buildBinOp(
    operator: String,left: Expression, right: Expression
  )
  val rootNode: Expression
}


abstract class Parser {
  def parse(scanner: Scanner, builder: NodeBuilder)
}


class Evaluator {
  def evaluate(input: String) {
    // val scanner = new Scanner(new Stream(input))
    // val builder = new NodeBuilder
    // val parser = new Parser(scanner, builder)
    // val exprTree = builder.rootNode
    // eval(exprTree)
  }
}


object Client {
  def main(args: Array[String]) {
    println("Hello Facade!")
  }
}
