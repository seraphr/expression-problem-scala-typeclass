package jp.seraphr.practice.expr.problem.merge

object MergeMain {
  object MergeSubAndShow extends MergeSubAndShow
  object CalculateImpls extends MergeSubAndShow.CalculateImpls
  object ShowImpls extends MergeSubAndShow.ShowImpls

  def main(args: Array[String]): Unit = {
    import MergeSubAndShow._
    import CalculateImpls._
    import ShowImpls._
    import language.reflectiveCalls


    val tNode = ValueNode(10) sub ValueNode(5)
    println(show(tNode) + " = " + calc(tNode))

    val tNode2 = ValueNode(5) add ValueNode(4) sub ValueNode(2)
    println(show(tNode2) + " = " + calc(tNode2))

    val tNode3 = ValueNode(5) sub (ValueNode(4) sub ValueNode(2))
    println(show(tNode3) + " = " + calc(tNode3))
  }

}