

class TwoPhaseSet[T](additions: Set[T], removals: Set[T]) extends CRDT[TwoPhaseSet[T], TwoPhaseSetOp[T]]{

  def apply(op: TwoPhaseSetOp[T]) = {
    op match {
      case Add(t) => new TwoPhaseSet[T](additions + t, removals)
      case Remove(t) => new TwoPhaseSet[T](additions, removals + t)
    }
  }

  def view(): Set[T] = additions -- removals

}

object TwoPhaseSet {
  def apply[T]() = new TwoPhaseSet[T](Set(), Set())
}

case class Add[T](t: T) extends TwoPhaseSetOp[T]
case class Remove[T](t: T) extends TwoPhaseSetOp[T]

sealed trait TwoPhaseSetOp[T] extends Op