package SwordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class N22_PrintFromTop_ToBottom {
  /**
   * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
   * ----------------------算法：这不就是层序遍历吗？(运行时间：15ms 占用内存：8736k)
   */
  public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    queue.offer(root);
    TreeNode temp = queue.poll();
    for (;temp != null;temp = queue.poll()) {
      arrayList.add(temp.val);
      if (temp.left != null) queue.offer(temp.left);
      if (temp.right != null) queue.offer(temp.right);
    }
    return arrayList;
  }

  public static void main(String[] args){
    TreeNode root1 = new TreeNode(9);
    root1.left = new TreeNode(4);
    root1.right = new TreeNode(5);

    root1.left.left = new TreeNode(3);
    root1.left.right = new TreeNode(8);

    TreeNode root2 =null;
    new N22_PrintFromTop_ToBottom().PrintFromTopToBottom(root2);
  }
}
