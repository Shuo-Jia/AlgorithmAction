package SwordOffer;

public class N15_ReverseList {
  /**
   * 输入一个链表，反转链表后，输出链表的所有元素。
   * ——————————算法1：存入栈中，在push出来，就反转了；(运行时间：19ms;占用内存：8772k)
   * ——————————算法2（参考算法）：用两个指针，一个指向当前节点cur，一个指向当前节点的上一个节点pre，一旦
   *            指针跳到下一个节点，即当前节点变成cur+1，就“过河拆桥”，把当前节点cur+1上个节点cur指向的
   *            下一节点（也就是当前的节点cur+1）变成上一个cur的上一个节点，注意cur一定要先跳到下一个节点，
   *            然后处理cur节点，不然先改变cur的指向，那么cur就跳不到cur+1了，即一定要过河拆桥！（运行时间：19ms，占用内存：8988k）
   */
  public ListNode ReverseList(ListNode head) {
    java.util.Stack<ListNode> stack = new java.util.Stack<>();
    ListNode p = head;
    while (p != null) {
      stack.push(p);
      p = p.next;
    }
    if (stack.empty()) {
      return null;
    } else {
      ListNode listNode = new ListNode(stack.pop().val);
      p = listNode;
      while (!stack.empty()) {
        p.next = stack.pop();
        p = p.next;
      }
      p.next = null;
      return listNode;
    }
  }

  public ListNode ReverseListPlus(ListNode head){
    ListNode cur = head;
    ListNode pre = null;
    ListNode reverselistNode = null;
    if(cur == null)
      return null;
    while(cur != null){
      pre = cur;
      cur = cur.next;
      pre.next = reverselistNode;
      reverselistNode = pre;
    }
    return reverselistNode;
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(0);
    listNode.next = new ListNode(1);
    listNode.next.next = new ListNode(2);
    listNode.next.next.next = new ListNode(3);
    listNode.next.next.next.next = new ListNode(4);
    //listNode = new N15_ReverseList().ReverseList(listNode);
    listNode = new N15_ReverseList().ReverseListPlus(listNode);
  }
}
