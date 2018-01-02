package SwordOffer;

public class N16_MergeListNode {
  /**
   * 输入两个单调递增的链表，输出两个链表合成后的链表，
   * 当然我们需要合成后的链表满足单调不减规则。
   * -----------算法1：连接后重新排序
   * -----------算法2：貌似归并排序(运行时间：20ms 占用内存：8824k)
   * 假设有链表A，B。由于都是递增函数，所以每次拿出当前最A，B靠前（最小）
   * 的元素比较，如果链表A较小则拿出去作为重组链表的元素，然后指针+1，
   * 继续拿+1后的A元素和链表B比，较小的还是拿出去重组，然后+1指针（相当于
   * “车轮战”）；最后一定会有先遍历完的（即=null），则结束遍历，把当前重组
   * 后的链表最后的指针指向还没有遍历完的链表的当前元素就行了！
   * ------------算法3：同样是归并，但是用递归————如果较小，则继续下一个比较，直到比较完
   * 则退栈时，直接将当前栈的（注意是当前栈）较小节点连接到较大节点就行了！
   */
  public ListNode Merge(ListNode list1, ListNode list2) {
    //算法2 (0 2 5)(3 8)
    ListNode listNode = new ListNode(0);
    ListNode m = listNode;
    ListNode p = list1;
    ListNode q = list2;
    if (list1 == null) {
      return list2;
    } else if (list2 == null)
      return list1;
    else {
      while (p != null && q != null) {
        if (p.val < q.val) {//(0 2 5)(0 2 5)
          m.val = p.val;
          p = p.next;
        } else {
          m.val = q.val;
          q = q.next;
        }
        m.next = new ListNode(0);
        m = m.next;
      }
      if (p == null) {
        m.val = q.val;
        m.next = q.next;
      } else if (q == null) {
        m.val = p.val;
        m.next = p.next;
      }
      return listNode;
    }
  }

  /**
   *  算法3：递归，需要好好理解一下递归原理！
   *  A(025)B(0269)
   *  则递归实现过程是这样的————
   *  （A0B0）A2              （A2B2）A5              （A5B6）A5.next=null ==>出栈返回B6，即A5.next = B6；继续退栈-
   *              （A2B0）B0             （A5B2）B6<-------------------------------------------------------------+
   *                                       (B2指向A5，继续向前推进)
   **/
  public ListNode MergePlus(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }
    if (list1.val <= list2.val) {//
      list1.next = MergePlus(list1.next, list2);
      return list1;
    } else {
      list2.next = MergePlus(list1, list2.next);
      return list2;
    }
  }

  public static void main(String[] args) {
    ListNode MergelistNode = null;

    ListNode listNode1 = new ListNode(0);
    listNode1.next = new ListNode(2);
    listNode1.next.next = new ListNode(5);

    ListNode listNode2 = new ListNode(3);
    listNode2.next = new ListNode(8);

    ListNode listNode3 = null;

    ListNode listNode4 = new ListNode(0);
    listNode4.next = new ListNode(2);
    listNode4.next.next = new ListNode(6);
    listNode4.next.next.next = new ListNode(9);

    //MergelistNode = new N16_MergeListNode().Merge(listNode1, listNode4);
    MergelistNode = new N16_MergeListNode().MergePlus(listNode1, listNode4);
  }
}
