

object Feeder {
  def feed[T <: CRDT[T, TOp], TOp <: Op](crdt: CRDT[T, TOp], ops:Seq[TOp]): T = ops match {
    case op :: Nil => crdt.apply(op)
    case op :: tail => feed(crdt.apply(op), tail)
  }
}
