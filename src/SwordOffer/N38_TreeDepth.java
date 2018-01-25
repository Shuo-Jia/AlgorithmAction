package SwordOffer;

import java.util.*;

public class N38_TreeDepth {
  /**
   * 输入一棵二叉树，求该树的深度。
   * 从根结点到叶结点依次经过的结点（含根、叶结点）
   * 形成树的一条路径，最长路径的长度为树的深度。
   */
  public int TreeDepth(TreeNode root) {
    Set<Integer> set = new HashSet<>();
    int count = 1;
    if (root == null)
      return 0;
    treeCount(root, count, set);
    Integer[] array = set.toArray(new Integer[]{});
    return array[array.length - 1];
  }

  private void treeCount(TreeNode root, int count, Set<Integer> set) {
    if (root == null)
      return;
    if (root.right == null && root.left == null) {
      set.add(count);
      return;
    }
    count++;
    System.out.println(root.val);
    treeCount(root.left, count, set);
    treeCount(root.right, count, set);
  }


  private void test() {
    //Set<Integer> set = new LinkedHashSet<>();//结论：hashset自动排序！
    ArrayList<Integer> set = new ArrayList<>();
    set.add(1);
    set.add(5);
    set.add(2);
    System.out.println(set);
  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);

    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);

    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(5);

    root1.left.right.right = new TreeNode(6);

    root1.right.right = new TreeNode(7);

    int count = new N38_TreeDepth().TreeDepth(root1);
  }
}
