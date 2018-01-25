package SwordOffer;

public class N39_IsBalanced {
  /**
   * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
   * ----------------------算法：后序遍历=左——>右——>根节点！
   * ----------------------------每到一个节点开始比较当前节点的
   * ----------------------------左右高度，如果高度差大于1，则非平衡；
   * ----------------------------否则返回当前较高的高度作为下一个根节点+1
   * ----------------------------的高度。
   */
  private boolean flag = true;

  public boolean IsBalanced_Solution(TreeNode root) {
    isBalanced(root);
    return flag;
  }

  private int isBalanced(TreeNode root) {
    if (root == null)
      return 0;
    int left = isBalanced(root.left);
    int right = isBalanced(root.right);
    if (Math.abs(left - right) > 1)
      flag = false;
    return right > left ? right + 1 : left + 1;//返回当前较高的节点+1作为下一个节点的高度。
  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);

    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);

    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(5);

    root1.left.right.right = new TreeNode(6);
    root1.left.right.right.right = new TreeNode(10);

    root1.right.right = new TreeNode(7);

    boolean flag = new N39_IsBalanced().IsBalanced_Solution(root1);
  }
}
