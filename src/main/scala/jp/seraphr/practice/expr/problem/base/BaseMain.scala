package jp.seraphr.practice.expr.problem.base

object BaseMain {
  def main(args: Array[String]): Unit = {
    object BaseNodes extends BaseNodes
    object CalculateImpls extends BaseNodes.CalculateImpls
    import BaseNodes._
    import CalculateImpls._
    import language.reflectiveCalls

    val tNode = AddNode(ValueNode(1), AddNode(AddNode(ValueNode(2), ValueNode(3)), ValueNode(4)))
    println(calc(tNode)) // => 10

    val tNode2 = ValueNode(1) ++ (ValueNode(2) ++ ValueNode(10))
    println(calc(tNode2)) // => 13
  }
}