package SwordOffer;

import java.util.LinkedList;
import java.util.Queue;

public class N26_Convert_TreeTo_list {
  /**
   * 输入一棵二叉搜索树，将该二叉搜索树转换
   * 成一个排序的双向链表。要求不能创建任何新的结点，
   * 只能调整树中结点指针的指向。
   * ------------------算法：二叉搜索数按顺序遍历就是中序遍历！
   * ------------------所以这里添加了一个辅助空间：队列！把遍
   * ------------------历出来的节点存进去，遍历完之后按照双链
   * ------------------表的规则连接起来就好了！此种方法思路比
   * ------------------较清晰，没有那么多的绕弯，但是是以空间
   * ------------------复杂度换取的！
   * 运行时间：21ms 占用内存：8816k
   * <p>
   * 后记：后来发现这个辅助空间队列是没有必要的！直接两个指针：
   * if (node == null) return;
   *         helper(node.left);
   *         if (head == null) {
   *             head = node;
   *             p = node;
   *         } else {
   *             p.right = node;
   *             node.left = p;
   *             p = node;
   *         }
   */
  private Queue<TreeNode> queue = new LinkedList<>();

  public TreeNode Convert(TreeNode pRootOfTree) {
    TreeNode list = null;
    TreeNode p = null;
    if (pRootOfTree == null)
      return pRootOfTree;
    convert(pRootOfTree);
    p = queue.poll();
    list = p;
    while (!queue.isEmpty()) {
      p.right = queue.poll();
      p.right.left = p;
      p = p.right;
    }
    p.right = null;
    return list;
  }

  private void convert(TreeNode pRootOfTree) {
    if (pRootOfTree == null)
      return;
    convert(pRootOfTree.left);
    queue.offer(pRootOfTree);
    convert(pRootOfTree.right);
  }

  public static void main(String[] args) {
    TreeNode list = null;
    TreeNode root1 = new TreeNode(10);

    root1.left = new TreeNode(5);
    root1.right = new TreeNode(15);

    root1.left.left = new TreeNode(2);
    root1.left.right = new TreeNode(7);

    root1.right.right = new TreeNode(17);

    list = new N26_Convert_TreeTo_list().Convert(root1);
  }
}
