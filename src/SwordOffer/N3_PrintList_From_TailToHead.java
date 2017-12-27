package SwordOffer;

import java.util.ArrayList;
import java.util.Iterator;

class ListNode {
  int val;
  public ListNode next = null;

  ListNode(int val) {
    this.val = val;
  }

}

public class N3_PrintList_From_TailToHead {
  /**
   * 输入一个链表，从尾到头打印链表每个节点的值
   */
  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    ArrayList<Integer> arrayList = new ArrayList<>();
    while (listNode != null) {
      arrayList.add(listNode.val);
      listNode = listNode.next;
    }
    int index = arrayList.size() - 1;
    for (int i = index; i >= (index+1)/2; i--) {
      int val = arrayList.get(i);
      int temp = arrayList.get(index-i);
      arrayList.set(index-i, val);
      arrayList.set(i, temp);
    }

    Iterator iterator = arrayList.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    return arrayList;
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(0);
    listNode.next = new ListNode(1);
    listNode.next.next = new ListNode(2);
    listNode.next.next.next = new ListNode(3);
    listNode.next.next.next.next = new ListNode(4);
    new N3_PrintList_From_TailToHead().printListFromTailToHead(listNode);
  }
}
