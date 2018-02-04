package SwordOffer;

import java.util.LinkedList;
import java.util.Queue;

public class N62_KthNode {
  /**
   * 给定一颗二叉搜索树，请找出其中的第k大的结点。
   * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数
   * 值大小顺序第三个结点的值为4。(运行时间：33ms 占用内存：8824k)
   */
  private TreeNode p = null;

  TreeNode KthNode(TreeNode pRoot, int k) {
    int[] i = new int[]{0};
    kthNode(pRoot, i, k);
    return p;
  }

  private void kthNode(TreeNode pRoot, int[] i, int k) {
    if (pRoot == null || i[0] >= k)
      return;
    kthNode(pRoot.left, i, k);
    i[0] = i[0] + 1;
    System.out.println(pRoot.val);
    if (i[0] == k) {
      p = pRoot;
    }
    kthNode(pRoot.right, i, k);
  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(5);

    root1.left = new TreeNode(3);
    root1.right = new TreeNode(7);

    root1.left.left = new TreeNode(2);
    root1.left.right = new TreeNode(4);

    root1.right.left = new TreeNode(6);
    root1.right.right = new TreeNode(8);

    //root1.left.left.left = new TreeNode(8);
    //root1.left.left.right = new TreeNode(9);

    TreeNode root = new N62_KthNode().KthNode(root1, 1);
  }
}
