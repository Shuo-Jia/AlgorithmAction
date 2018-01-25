package SwordOffer;

import java.util.HashMap;

public class N36_FindFirstCommonNode {
  /**
   * 输入两个链表，找出它们的第一个公共结点。(运行时间：22ms
   * 占用内存：8836k)
   */
  public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    HashMap<ListNode, Integer> hashMap = new HashMap<>();
    if (pHead1 == null || pHead2 == null)
      return null;
    while (pHead1 != null) {
      hashMap.put(pHead1, 1);
      pHead1 = pHead1.next;
    }

    while (pHead2 != null) {
      if (hashMap.containsKey(pHead2))
        return pHead2;
      pHead2 = pHead2.next;
    }
    return null;
  }
}
