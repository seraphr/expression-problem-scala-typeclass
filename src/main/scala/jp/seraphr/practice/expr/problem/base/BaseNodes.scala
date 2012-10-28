package jp.seraphr.practice.expr.problem.base

trait BaseNodes {
  import language.implicitConversions

  trait NodeBase
  case class ValueNode(value: Int) extends NodeBase
  case class AddNode[_Left, _Right](left: _Left, right: _Right) extends NodeBase

  trait Calculate[_N] {
    def apply(aNode: _N): Int
  }

  def calc[_N: Calculate](aNode: _N): Int = {
    implicitly[Calculate[_N]].apply(aNode)
  }

  trait CalculateImpls {
    implicit object CalculateValue extends Calculate[ValueNode] {
      override def apply(aNode: ValueNode): Int = aNode.value
    }

    implicit def CalculateAddNode[_L: Calculate, _R: Calculate]: Calculate[AddNode[_L, _R]] = {
        new Calculate[AddNode[_L, _R]]{
          override def apply(aNode: AddNode[_L, _R]) = calc(aNode.left) + calc(aNode.right)
        }
    }
  }

  implicit def adder[_L <: NodeBase](aLeft: _L) = new AnyRef() {
    def ++[_R <: NodeBase](aRight: _R) = AddNode(aLeft, aRight)
  }
}