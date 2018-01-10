package SwordOffer;

public class N25_RandomListNode_Clone {
  /**
   * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
   * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
   * 返回结果为复制后复杂链表的head。（注意，输出结果中
   * 请不要返回参数中的节点引用，否则判题程序会直接返回空）
   * -----------------------算法：1、在原始链表中每个节点后面直接复制该节点；
   * -----------------------------2、在复制好的节点中的随机节点指向原节点随机节点的下一个节点
   * -----------------------------3、分离！注意，一定要分离！否则直接只是把复制好的节点连接在一块，但是原节点依然和复制节点连接，那么系统判定为空（也就是题目中说的：注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）换句话说就是原链表要保持原样，即把原链表的每个节点的下一个节点变化为原来的指向而不是复制节点！
   * 运行时间：31ms占用内存：8776k
   */
  public RandomListNode Clone(RandomListNode pHead) {
    RandomListNode p = pHead;
    RandomListNode temp;
    if (pHead == null)
      return pHead;
    //第一步：复制节点
    while (p != null) {
      temp = p.next;
      p.next = new RandomListNode(p.label);
      p.next.next = temp;
      p = temp;
    }

    //第二步：链接随机节点
    p = pHead;
    while (p != null) {
      if (p.random != null)
        p.next.random = p.random.next;
      else
        p.next.random = p.random;
      p = p.next.next;
    }

    //第三步：分离！
    p = pHead;
    RandomListNode q = pHead.next;
    RandomListNode clone = q;
    while (p != null) {
      p.next = q.next;//把原节点指向原来的节点
      p = p.next;
      if (p != null)
        q.next = p.next;//把复制的节点指向原节点的下一个节点的复制节点（即原节点的下一个节点的下一个节点）
      else
        q.next = p;
      q = q.next;
    }
    return clone;
  }

  public static void main(String[] args) {
    RandomListNode randomListNode = new RandomListNode(0);
    RandomListNode p1 = new RandomListNode(1);
    RandomListNode p2 = new RandomListNode(2);
    RandomListNode p3 = new RandomListNode(3);
    RandomListNode p4 = new RandomListNode(4);
    RandomListNode p5 = new RandomListNode(5);

    randomListNode.next = p1;
    randomListNode.random = p2;
    p1.next = p2;
    p1.random = p3;
    p2.next = p3;
    p2.random = p4;
    p3.next = p4;
    p3.random = p5;
    p4.next = p5;
    p4.random = p1;
    p5.next = null;
    p5.random = null;

    RandomListNode clone = new N25_RandomListNode_Clone().Clone(randomListNode);
  }
}

class RandomListNode {
  int label;
  RandomListNode next = null;
  RandomListNode random = null;

  RandomListNode(int label) {
    this.label = label;
  }
}
