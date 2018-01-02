package SwordOffer;

import java.util.Stack;

public class N18_MirrorTree {
  /**
   * 操作给定的二叉树，将其变换为源二叉树的镜像。
   * -------------------算法1：其实就是层序遍历的倒置，所以选择栈作辅助空间——错！不能进空栈！
   * -------------------算法2：还是二叉树的前序遍历，遍历到哪一点，交换左右子树！(运行时间：21ms 占用内存：15588k)
   */
  //java.util.Stack<TreeNode> stack = new Stack<>();
  public void Mirror(TreeNode root) {
    TreeNode temp;
    if (root == null)
      return;

    temp = root.left;
    root.left = root.right;
    root.right = temp;

    Mirror(root.left);
    Mirror(root.right);
  }

  public static void main(String[] args) {
    /**
     * root
     *            9
     *     4              5
     *3         8
     */
    TreeNode root = new TreeNode(9);
    root.left = new TreeNode(4);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(8);

    new N18_MirrorTree().Mirror(root);

    TreeNode root2 = new TreeNode(4);
    root2.left = new TreeNode(3);
    root2.right = new TreeNode(8);
  }
}
