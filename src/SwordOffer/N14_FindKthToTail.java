package SwordOffer;

public class N14_FindKthToTail {
  /**
   * 输入一个链表，输出该链表中倒数第k个结点
   *————————1、遍历求所有节点数length
   *————————2、遍历求length-k的节点；（运行时间：20ms;占用内存：8888k）
   *
   * 参考方法：
   Java代码，通过校验。代码思路如下：两个指针，先让第一个指针和第二个指针都指向头结点，
   然后再让第一个指正走(k-1)步，到达第k个节点。然后两个指针同时往后移动，当第一个结点
   到达末尾的时候，第二个结点所在位置就是倒数第k个节点了
   ——————————》简直妙！
   */
  public ListNode FindKthToTail(ListNode head, int k) {
    ListNode p = head;
    int j = 0;
    while (p != null) {
      p = p.next;
      j++;
    }
    if(k>j)
      return null;
    p = head;
    int pos = j - k;
    j = 0;
    while (p != null && j < pos) {
      p = p.next;
      j++;
    }
    return p;
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(0);
    listNode.next = new ListNode(1);
    listNode.next.next = new ListNode(2);
    listNode.next.next.next = new ListNode(3);
    listNode.next.next.next.next = new ListNode(4);
    ListNode p = new N14_FindKthToTail().FindKthToTail(listNode, 6);
  }
}
