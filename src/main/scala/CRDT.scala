

//trait CRDT[Op] {
//  def apply[B >: CRDT[Op]](o: Op): B
//}

trait CRDT[T <: CRDT[T, Op], Op] { self: T =>
  def apply(op: Op): T
}