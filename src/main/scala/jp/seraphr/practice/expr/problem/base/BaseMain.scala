package jp.seraphr.practice.expr.problem.base

object BaseMain {
  object BaseNodes extends BaseNodes
  object CalculateImpls extends BaseNodes.CalculateImpls

  def main(args: Array[String]): Unit = {
    import BaseNodes._
    import CalculateImpls._
    import language.reflectiveCalls

    val tNode = AddNode(ValueNode(1), AddNode(AddNode(ValueNode(2), ValueNode(3)), ValueNode(4)))
    println(calc(tNode))

    val tNode2 = ValueNode(1) add (ValueNode(2) add ValueNode(10))
    println(calc(tNode2))
  }

}