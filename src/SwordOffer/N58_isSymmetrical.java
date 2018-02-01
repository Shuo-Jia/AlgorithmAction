package SwordOffer;

public class N58_isSymmetrical {
  /**
   * 请实现一个函数，用来判断一颗二叉树是不是对称的。
   * 注意，如果一个二叉树同此二叉树的镜像是同样的，
   * 定义其为对称的。
   * ----------------------------算法：准备两个指针，
   * 前序遍历：一个从左往右遍历，同时另一个从右往左遍
   * 历！每遍历一个节点即判断该节点是否相同，如果相同
   * 则继续遍历，否则返回false；当遍历到null的时候开
   * 始退栈说明前面相等，返回true！
   * （运行时间：17ms 占用内存：8700k）
   */

  boolean isSymmetrical(TreeNode pRoot) {
    TreeNode p = pRoot;
    TreeNode q = pRoot;
    return symmetrical(p, q);
  }

  boolean symmetrical(TreeNode q, TreeNode p) {
    if (p == null && q == null)
      return true;
    if (p != null && q != null && q.val == p.val)
      return symmetrical(q.left, p.right) && symmetrical(q.right, p.left);
    else
      return false;
  }

}
