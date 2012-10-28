package jp.seraphr.practice.expr.problem.merge

import jp.seraphr.practice.expr.problem.addshow.AddShow
import jp.seraphr.practice.expr.problem.addsub.AddSubNode

trait MergeSubAndShow extends AddShow with AddSubNode {

  trait CalculateImpls extends super.CalculateImpls
  trait ShowImpls extends super.ShowImpls {

    implicit def ShowSub[_L: Show, _R: Show] = new Show[SubNode[_L, _R]] {
      override def apply(aNode: SubNode[_L, _R]) = "(%s - %s)".format(show(aNode.left), show(aNode.right))
    }
  }
}