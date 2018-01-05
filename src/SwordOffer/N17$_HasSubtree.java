package SwordOffer;

public class N17$_HasSubtree {
  /**
   * 输入两棵二叉树A，B，判断B是不是A的子结构。
   * （ps：我们约定空树不是任意一个树的子结构）
   * ------------------算法1：递归，原理很简单————————
   * ------------------直到root2遍历完（root2==null），说明前面的节点都是相等的，则就是子树；
   * ------------------否则，一个节点一个节点的扫描：不等则移动root1的左右节点指针在和root1比较，相等则
   * ------------------比较左右孩子节点。（PS：递归还是写不好，虽然明白原理）
   */
  public boolean HasSubtree(TreeNode root1, TreeNode root2) {
    boolean result = false;
    if (root1 != null && root2 != null) {
      if (root1.val == root2.val) {
        result = hassubstree(root1, root2);
      }//如果发现与root1的当前节点完全相等，即result=true，则直接返回；否则换root的节点，继续比较
      if (!result) {
        result = HasSubtree(root1.left, root2);//先左节点遍历
      }
      if (!result) {
        result = HasSubtree(root1.right, root2);//然后又节点遍历
      }
    }
    return result;
  }

  public boolean hassubstree(TreeNode root1, TreeNode root2) {
    if (root2 == null)
      return true;
    else if (root1 == null)
      return false;
    if (root1.val != root2.val)
      return false;
    return hassubstree(root1.left, root2.left) && hassubstree(root1.right, root2.right);
  }

  public static void main(String[] args) {
    /**
     * root1
     *            9
     *     4              5
     *3         8
     *
     * root2
     *            5
     */

    boolean flag;
    TreeNode root1 = new TreeNode(9);
    root1.left = new TreeNode(4);
    root1.right = new TreeNode(5);

    root1.left.left = new TreeNode(3);
    root1.left.right = new TreeNode(8);

    TreeNode root2 = new TreeNode(4);
    root2.left = new TreeNode(3);
    root2.right = new TreeNode(8);

    flag = new N17$_HasSubtree().HasSubtree(root1, root2);
  }
}
