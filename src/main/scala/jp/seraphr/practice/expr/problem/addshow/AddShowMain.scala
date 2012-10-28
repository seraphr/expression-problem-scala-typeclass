package jp.seraphr.practice.expr.problem.addshow

object AddShowMain {
  object AddShow extends AddShow
  object CalculateImples extends AddShow.CalculateImpls
  object ShowImples extends AddShow.ShowImpls

  def main(args: Array[String]): Unit = {
    import AddShow._
    import CalculateImples._
    import ShowImples._
    import language.reflectiveCalls

    val tNode = AddNode(ValueNode(1), AddNode(AddNode(ValueNode(2), ValueNode(3)), ValueNode(4)))
    println(show(tNode) + " = " + calc(tNode))

    val tNode2 = ValueNode(1) add (ValueNode(2) add ValueNode(10))
    println(show(tNode2) + " = " + calc(tNode2))

  }

}