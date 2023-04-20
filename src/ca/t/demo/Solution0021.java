package ca.t.demo;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * <p>Merge the two lists in a one sorted list.
 */
class Solution0021v1 {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
    if (list1.val > list2.val) {
      ListNode temp = list1;
      list1 = list2;
      list2 = temp;
    }
    list1.next = mergeTwoLists(list1.next, list2);
    return list1;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
