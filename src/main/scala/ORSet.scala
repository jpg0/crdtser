

class ORSet[T](additions: Set[T] = Set(), removals: Set[T] = Set()) extends CRDT[ORSet[T], ORSetOp[T]]{

  def apply(op: ORSetOp[T]) = {
    op match {
      case Add(t) => new ORSet[T](additions + t, removals)
      case Remove(t) => new ORSet[T](additions, removals + t)
    }
  }

  def view(): Set[T] = additions -- removals

}

object ORSet {
  def apply[T]() = new ORSet[T](Set(), Set())
}

case class Add[T](t: T) extends ORSetOp[T]
case class Remove[T](t: T) extends ORSetOp[T]

sealed trait ORSetOp[T]