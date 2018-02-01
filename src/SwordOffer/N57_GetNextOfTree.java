package SwordOffer;

public class N57_GetNextOfTree {
  /**
   * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
   * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针.（节点中next即父节点）
   * -----------------------------------算法：（注意：程序中节点的next变量就是题目中所说的父节点指针）
   * 1、有右子树，则遍历右子树的左节点直到出现该节点的左子树为null，则该节点为下一个节点；
   * 2、没有右子树
   * 2.1、该节点是父节点的左节点，则下一节点是该节点的父节点；
   * 2.2、该节点不是父节点的左节点，遍历该点的父节点，若某个(父节点X)是该(父节点X)的(父节点Y)的左节点，则下一节点就是(父节点Y)；
   * 2.3、无论上述两种情况哪一种遍历父节点的时候出现null，则下一节点就是null；
   * （运行时间：31ms 占用内存：9032k）
   */
  public TreeLinkNode GetNext(TreeLinkNode pNode) {
    if (pNode == null)
      return null;
    if (pNode.right != null) {
      pNode = pNode.right;
      while (pNode.left != null) {
        pNode = pNode.left;
      }
    } else {
      TreeLinkNode pParent = pNode.next;
      if (pParent == null || pParent.left == pNode) {
        pNode = pParent;
      } else {
        TreeLinkNode pParent_parent = null;
        while (pParent != null) {
          pParent_parent = pParent.next;
          if (pParent_parent == null || pParent_parent.left == pParent)
            return pParent_parent;
          pParent = pParent_parent;
        }
      }
    }
    return pNode;
  }
}

class TreeLinkNode {

  int val;
  TreeLinkNode left = null;
  TreeLinkNode right = null;
  TreeLinkNode next = null;

  TreeLinkNode(int val) {
    this.val = val;
  }

  public static void main(String[] args) {
    int count = 15;
    TreeLinkNode[] Node = new TreeLinkNode[16];
    while (count > 0)
      Node[count] = new TreeLinkNode(count--);

    int i = 1;
    int n = 1;
    while (n <= 15) {
      for (; i <= n; i++) {
        if (i * 2 < 16) {
          Node[i].left = Node[i * 2];
          Node[i].right = Node[i * 2 + 1];
          Node[i].next = Node[i / 2];
        } else {
          Node[i].left = Node[0];
          Node[i].right = Node[0];
          Node[i].next = Node[i / 2];
        }
      }
      n = 2 * i - 1;
    }

    TreeLinkNode next = new N57_GetNextOfTree().GetNext(Node[15]);
  }
}
