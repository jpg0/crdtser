import org.scalatest._

class TwoPhaseSetSpec extends FlatSpec with Matchers {

  "2PSet" should "add items" in {
    val tpSet = TwoPhaseSet[String]()

    val Ops: Seq[TwoPhaseSetOp[String]] = Seq(Add("A"))

    val updated: TwoPhaseSet[String] = Feeder.feed[TwoPhaseSet[String], TwoPhaseSetOp[String]](tpSet, Ops)

    updated.view() should contain("A")

  }

  it should "not readd items" in {
    val tpSet = TwoPhaseSet[String]()

    val Ops: Seq[TwoPhaseSetOp[String]] = Seq(Remove("A"), Add("A"))

    val updated: TwoPhaseSet[String] = Feeder.feed[TwoPhaseSet[String], TwoPhaseSetOp[String]](tpSet, Ops)

    updated.view() should not contain "A"

  }

  it should "ignore ordering" in {
    val tpSet = TwoPhaseSet[String]()

    val Ops: Seq[TwoPhaseSetOp[String]] = Seq(Remove("A"), Add("A"))

    val updated: TwoPhaseSet[String] = Feeder.feed[TwoPhaseSet[String], TwoPhaseSetOp[String]](tpSet, Ops)

    updated.view() should not contain "A"

  }

//  it should "throw NoSuchElementException if an empty stack is popped" in {
//    val emptyStack = new Stack[Int]
//    a [NoSuchElementException] should be thrownBy {
//      emptyStack.pop()
//    }
//  }
}