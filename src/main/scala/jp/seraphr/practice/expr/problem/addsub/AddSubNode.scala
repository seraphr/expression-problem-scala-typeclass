package jp.seraphr.practice.expr.problem.addsub

import jp.seraphr.practice.expr.problem.base.BaseNodes

trait AddSubNode extends BaseNodes {
  import language.implicitConversions

  case class SubNode[_Left, _Right](left: _Left, right: _Right) extends NodeBase

  trait CalculateImpls extends super.CalculateImpls {
    implicit def SubNodeCalculate[_L: Calculate, _R: Calculate]: Calculate[SubNode[_L, _R]] = {
      new Calculate[SubNode[_L, _R]] {
        override def apply(aNode: SubNode[_L, _R]) = calc(aNode.left) - calc(aNode.right)
      }
    }
  }

  implicit def subtracter[_L <: NodeBase](aLeft: _L) = new AnyRef() {
    def --[_R <: NodeBase](aRight: _R) = SubNode(aLeft, aRight)
  }
}