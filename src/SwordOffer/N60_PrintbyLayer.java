package SwordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class N60_PrintbyLayer {
  /**
   * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
   * -------------------------算法：
   * 1、队列存入每层的节点；
   * 2、每遍历一层记录该层遍历时起始节点索引位i和count，下一层遍历的时候，通过队列poll的节点位置为i~count，从而得出i~count的孩子节点
   * 3、以此类推！
   * (运行时间：28ms 占用内存：9000k)
   */
  ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    Queue<TreeNode> queue = new LinkedList<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    ArrayList<ArrayList<Integer>> arrayListArrayLists = new ArrayList<>();
    if (pRoot == null)
      return arrayListArrayLists;
    TreeNode p = null;
    int count = 0;
    int countTemp = 0;
    int i = 1;
    queue.offer(pRoot);
    arrayList.add(pRoot.val);
    count++;
    countTemp++;
    arrayListArrayLists.add(arrayList);

    while (!queue.isEmpty()) {
      arrayList = new ArrayList<>();
      for (; i <= count; i++) {
        p = queue.poll();
        if (p.left != null) {
          queue.offer(p.left);
          arrayList.add(p.left.val);
          countTemp++;
        }
        if (p.right != null) {
          queue.offer(p.right);
          arrayList.add(p.right.val);
          countTemp++;
        }
      }
      count = countTemp;
      if (!arrayList.isEmpty())
        arrayListArrayLists.add(arrayList);
    }
    return arrayListArrayLists;
  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);

    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);

    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(5);

    root1.right.left = new TreeNode(6);
    root1.right.right = new TreeNode(7);

    root1.left.left.left = new TreeNode(8);
    root1.left.left.right = new TreeNode(9);

    new N60_PrintbyLayer().Print(root1);
  }
}
