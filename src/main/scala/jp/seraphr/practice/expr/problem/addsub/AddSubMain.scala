package jp.seraphr.practice.expr.problem.addsub

object AddSubMain {
  object AddSubNode extends AddSubNode
  object CalculateImples extends AddSubNode.CalculateImpls

  def main(args: Array[String]): Unit = {
    import AddSubNode._
    import CalculateImples._
    import language.reflectiveCalls

    val tNode = ValueNode(10) -- ValueNode(5)
    println(calc(tNode))

    val tNode2 = ValueNode(5) ++ ValueNode(4) -- ValueNode(2)
    println(calc(tNode2))

    val tNode3 = ValueNode(5) -- (ValueNode(4) -- ValueNode(2))
    println(calc(tNode3))
  }
}