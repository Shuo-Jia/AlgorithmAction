package SwordOffer;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class N56$_deleteDuplication {
  /**
   * 在一个排序的链表中，存在重复的结点，
   * 请删除该链表中重复的结点，重复的结
   * 点不保留，返回链表头指针。 例如，
   * 链表1->2->3->3->4->4->5 处理后为
   * 1->2->5
   * ------------------------------算法1：辅助空间法，只连接value为1的节点！（此种方法数组无序也可以用）
   * ------------------------------算法2：没有辅助空间，遇到相等的值就遍历，直到不等就可以重新连接了！（只能数组有序）
   */
  private LinkedHashMap<Integer, ListNode> linkedHashMap = new LinkedHashMap<>();

  public ListNode deleteDuplication(ListNode pHead) {
    //return delete(pHead);
    return deletePlus(pHead);
  }

  private ListNode delete(ListNode pHead) {
    if (pHead == null)
      return null;
    ListNode p = pHead;
    linkedHashMap.put(p.val, p);
    int val = p.val;
    p = p.next;
    while (p != null) {
      if (p.val == val) {
        linkedHashMap.remove(val);
      } else {
        val = p.val;
        linkedHashMap.put(p.val, p);
      }
      p = p.next;
    }

    Iterator<ListNode> iterator = linkedHashMap.values().iterator();
    if (!iterator.hasNext())
      return null;

    pHead = iterator.next();
    p = pHead;
    while (iterator.hasNext()) {
      p.next = iterator.next();
      p = p.next;
    }
    p.next = null;
    return pHead;
  }

  private ListNode deletePlus(ListNode pHead) {
    if (pHead == null || pHead.next == null)
      return pHead;
    if (pHead.val == pHead.next.val) {
      ListNode p = pHead.next;
      while (p != null && p.val == pHead.val) {
        p = p.next;
      }
      return deletePlus(p);
    }
    pHead.next = deletePlus(pHead.next);
    return pHead;
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(1);
    listNode.next.next = new ListNode(2);
    listNode.next.next.next = new ListNode(3);
    listNode.next.next.next.next = new ListNode(3);
    listNode.next.next.next.next.next = new ListNode(4);
    listNode.next.next.next.next.next.next = new ListNode(5);
    listNode.next.next.next.next.next.next.next = new ListNode(5);

    ListNode head = new N56$_deleteDuplication().deleteDuplication(listNode);
  }
}
