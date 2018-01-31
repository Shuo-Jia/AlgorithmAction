package SwordOffer;

public class N55_EntryNodeOfLoop {
  /**
   * 一个链表中包含环，请找出该链表的环的入口结点。
   * ----------------------------------算法1：使用一个集合存储遍历的节点，当第二次存储某个节点的时候，这个节点就是入口
   * ----------------------------------算法2：快慢指针，相遇再相遇！
   */

  public ListNode EntryNodeOfLoop(ListNode pHead) {
    int length = getLengthofLoop(pHead);
    if (pHead == null || length == -1)
      return null;
    return getEntryNodeOfLoop(pHead, length);
  }

  private ListNode getEntryNodeOfLoop(ListNode pHead, int length) {
    ListNode p1 = pHead;
    ListNode p2 = pHead;
    while (length > 0) {
      p2 = p2.next;
      length--;
    }
    while (p1 != p2) {
      p1 = p1.next;
      p2 = p2.next;
    }
    return p1;
  }

  private int getLengthofLoop(ListNode pHead) {
    ListNode p1 = pHead;
    ListNode p2 = pHead;
    while (p1 != null && p2 != null && p2.next != null) {
      p2 = p2.next;
      if (p2 == p1)
        return length(p1);
      p2 = p2.next;
      if (p2 == p1)
        return length(p1);
      p1 = p1.next;
    }
    return -1;
  }

  private int length(ListNode p) {
    ListNode temp = null;
    int count = 0;
    while (p != temp) {
      if (temp == null)
        temp = p;
      p = p.next;
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(0);
    listNode.next = new ListNode(1);
    listNode.next.next = new ListNode(2);
    listNode.next.next.next = new ListNode(3);
    listNode.next.next.next.next = new ListNode(4);
    listNode.next.next.next.next.next = new ListNode(5);
    listNode.next.next.next.next.next.next = new ListNode(6);
    listNode.next.next.next.next.next.next.next = listNode.next.next.next;

    int val = new N55_EntryNodeOfLoop().EntryNodeOfLoop(listNode).val;
  }
}
