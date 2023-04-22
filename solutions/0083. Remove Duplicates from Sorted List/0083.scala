import scala.annotation.tailrec

object Solution0083s {

  def main(args: Array[String]): Unit = {
    val seq = (1 to 10000).map(_ => scala.util.Random.nextInt(20000)).sorted
    val node: ListNode = new ListNode();
    seq.foldLeft(node)((n, i) => {
      val next = new ListNode(i)
      n.next = next
      next
    })
    measureExecutionTime("aaabramov", "Apr 10, 2023", {
      Solution1.deleteDuplicates(node)
    })
    measureExecutionTime("Svetozorg", "Jan 24, 2023", {
      Solution1.deleteDuplicates(node)
    })
    measureExecutionTime("Andrea_Detommaso", "Dec 07, 2022", {
      Solution1.deleteDuplicates(node)
    })
    measureExecutionTime("ruslanlbogun", "Nov 10, 2021", {
      Solution1.deleteDuplicates(node)
    })
    measureExecutionTime("WayneAK", "Feb 11, 2022", {
      Solution1.deleteDuplicates(node)
    })
    measureExecutionTime("maxmtmn", "Aug 01, 2022", {
      Solution1.deleteDuplicates(node)
    })
    measureExecutionTime("l33tcoder31415", "Jun 04, 2022", {
      Solution1.deleteDuplicates(node)
    })
    measureExecutionTime("GeneralLee200", "Apr 28, 2022", {
      Solution1.deleteDuplicates(node)
    })

  }

  /**
   * "Scala: beats (100% / 100%)"
   *
   * @author aaabramov
   * @date Apr 10, 2023
   */
  object Solution1 {
    def deleteDuplicates(head: ListNode): ListNode = {
      if (head == null) {
        return head
      }
      var prev = head
      var curr = head.next
      while (curr != null) {
        if (prev.x == curr.x) {
          prev.next = curr.next
        } else {
          prev = curr
        }
        curr = curr.next
      }
      head
    }
  }

  /**
   * "Scala solution 🪱"
   *
   * @author Svetozorg
   * @date Jan 24, 2023
   */
  object Solution2 {
    def deleteDuplicates(head: ListNode): ListNode = {
      if (head == null || head.next == null) head
      else {
        var curr = head
        val node = new ListNode()
        node.next = head

        while (curr != null && curr.next != null) {
          if (curr.x == curr.next.x) curr.next = curr.next.next
          else curr = curr.next
        }
        node.next
      }
    }
  }

  /**
   * "SCALA | TailRec | Pattern matching"
   *
   * @author Andrea_Detommaso
   * @date Dec 07, 2022
   */
  object Solution3 {
    def deleteDuplicates(head: ListNode): ListNode = {

      @tailrec
      def loop(slow: ListNode, fast: ListNode): ListNode =

        (slow, fast) match {

          case (_, null) => head
          case (slow, fast) if (slow.x == fast.x) => loop({
            slow.next = slow.next.next;
            slow
          }, fast.next)
          case _ => loop(slow.next, fast.next)
        }

      Option(head).fold(head) { h => loop(h, h.next) }
    }
  }

  /**
   * "Scala Solution"
   *
   * @author ruslanlbogun
   * @date Nov 10, 2021
   */
  object Solution4 {
    def deleteDuplicates(head: ListNode): ListNode = {
      head match {
        case h if h == null => h
        case h if h.next == null => h
        case h if h.next.x == h.x => deleteDuplicates(h.next)
        case h => new ListNode(h.x, deleteDuplicates(h.next))
      }
    }
  }

  /**
   * "Scala solution - clean recursion"
   *
   * @author WayneAK
   * @date Feb 11, 2022
   */
  object Solution5 {
    def deleteDuplicates(head: ListNode): ListNode = {
      if (head == null || head.next == null) return head
      val next = head.next

      if (next.x == head.x) deleteDuplicates(next)
      else new ListNode(head.x, deleteDuplicates(next))
    }
  }

  import scala.util.chaining._

  /**
   * "Scala functional"
   *
   * @author maxmtmn
   * @date Aug 01, 2022
   */
  object Solution6 {
    def deleteDuplicates(head: ListNode): ListNode = {
      Option(head).map(_.tap(checkAndDelete)).getOrElse(head)
    }

    // apply side effects
    def checkAndDelete(node: ListNode): Unit = {
      Option(node.next) match {
        case Some(next) if next.x == node.x =>
          node
            .tap(n => n.next = next.next)
            .tap(checkAndDelete)
        case Some(next) =>
          next.tap(checkAndDelete)
        case _ =>
      }
    }
  }

  /**
   * "Scala Extension Method Solution"
   *
   * @author l33tcoder31415
   * @date Jun 04, 2022
   */
  object Solution7 {
    implicit class EnhancedListNode(val node: ListNode) extends AnyVal {
      def hasNext(): Boolean = (node != null) && (node.next != null)

      def shouldSkip(): Boolean = (node.x == node.next.x)

      def skip(): Unit = node.next = node.next.next
    }


    def deleteDuplicates(head: ListNode): ListNode = {
      var curr = head

      while (curr.hasNext) {
        if (curr.shouldSkip) curr.skip
        else curr = curr.next
      }

      head
    }
  }

  /**
   * "Scala/Java easy to understand solution"
   *
   * @author GeneralLee200
   * @date Apr 28, 2022
   */
  def deleteDuplicates(head: ListNode): ListNode = {
    var buf = head
    while (buf != null && buf.next != null) {
      if (buf.x == buf.next.x) buf.next = buf.next.next
      else buf = buf.next
    }
    head
  }

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }


  /**
   * Executes some code block and prints to stdout the time taken to execute the block. This is
   * available in Scala only and is used primarily for interactive testing and debugging.
   */
  def measureExecutionTime[T](author: String = "unknown", date: String, f: => Unit): Unit = {

    /**
     * JIT compiles bytecode to native machine code to optimize efficiency.
     * JVM interprets the same sequence of bytecode repeatedly and incurs a longer execution time.
     * The hardware executes the native code of repeated method calls.
     */
    1 to 10000 foreach { _ => f }

    val start = System.nanoTime()
    1 to 1000 foreach { _ => f }
    val end = System.nanoTime()

    println(s"Average time taken: ${(end - start) / 1000} nanoseconds, submitted by $author on $date")

  }
}

