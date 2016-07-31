

//trait CRDT[Op] {
//  def apply[B >: CRDT[Op]](o: Op): B
//}

trait CRDT[T <: CRDT[T, TOp], TOp <: Op] { self: T =>
  def apply(op: TOp): T
}

trait Op