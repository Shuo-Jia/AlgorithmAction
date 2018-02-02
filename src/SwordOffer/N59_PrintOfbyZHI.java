package SwordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class N59_PrintOfbyZHI {
  /**
   * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
   * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
   * -----------------------------------------------算法：
   * 1、选用两个栈，层序遍历。
   * 2、在n（n初始为1）层时候从左往右push，记stackL2R；进入n+1层，利用stackL2R里pop
   * 出来的n层数据遍历n+1层，从右往左push到stackR2L；然后一个循环结束，继续下一个
   * 循环；
   * 3、每次层序遍历都要利用上一层的pop数据的顺序存本层的数据，当上一层数据pop完，
   * 本层也就遍历完了，就可以进入下一层！。直到两个栈都没有数据说明遍历完成！
   * (运行时间：36ms 占用内存：8812k)
   */

  public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    Stack<TreeNode> stackL2R = new Stack<>();
    Stack<TreeNode> stackR2L = new Stack<>();
    ArrayList<ArrayList<Integer>> arrayListArrayLists = new ArrayList<>();
    int i = 0;
    if (pRoot == null)
      return arrayListArrayLists;
    TreeNode p = null;
    stackL2R.push(pRoot);
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(pRoot.val);
    arrayListArrayLists.add(arrayList);
    while (!stackL2R.isEmpty() || !stackR2L.isEmpty()) {
      ArrayList<Integer> arrayList1 = new ArrayList<>();
      while (!stackL2R.isEmpty()) {
        p = stackL2R.peek();
        if (p.right != null) {
          stackR2L.push(p.right);
          arrayList1.add(p.right.val);
        }
        if (p.left != null) {
          stackR2L.push(p.left);
          arrayList1.add(p.left.val);
        }
        stackL2R.pop();
      }
      if (!arrayList1.isEmpty())
        arrayListArrayLists.add(arrayList1);

      ArrayList<Integer> arrayList2 = new ArrayList<>();
      while (!stackR2L.isEmpty()) {
        p = stackR2L.peek();
        if (p.left != null) {
          stackL2R.push(p.left);
          arrayList2.add(p.left.val);
        }
        if (p.right != null) {
          stackL2R.push(p.right);
          arrayList2.add(p.right.val);
        }
        stackR2L.pop();
      }
      if (!arrayList2.isEmpty())
        arrayListArrayLists.add(arrayList2);
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

    new N59_PrintOfbyZHI().Print(root1);
  }
}
