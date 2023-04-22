/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only
 * once. Return the linked list sorted as well.
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      while (curr.next != null && curr.val == curr.next.val) curr.next = curr.next.next;
      curr = curr.next;
    }
    return head;
  }
}
