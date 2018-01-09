package SwordOffer;

import java.util.ArrayList;
import java.util.Stack;

public class N24$_FindPath_OfZero {
  /**
   * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和
   * 为输入整数的所有路径。路径定义为从树的根结点开始往
   * 下一直到叶结点所经过的结点形成一条路径。
   * -------题目解析：找二叉树的n条路径，这个路径的节点和为整数m。
   */
  private static ArrayList<Integer> arrayList = new ArrayList<>();
  private static ArrayList<ArrayList<Integer>> arrayListArrayLists = new ArrayList<>();
  private static int count = 0;

  public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
    Stack<Integer> stack = new Stack<>();
    if (root == null)
      return arrayListArrayLists;
    //pathOfstack(root, target, arrayListArrayLists, stack);
    path(root, target, count, arrayListArrayLists);
    return arrayListArrayLists;
  }

  private void pathOfstack(TreeNode root, int target,
                           ArrayList<ArrayList<Integer>> arrayListArrayList, Stack<Integer> stack) {
    if (root == null)
      return;
    if (root.left == null && root.right == null) {
      if (root.val == target) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int x : stack)
          arrayList.add(x);
        arrayList.add(root.val);
        arrayListArrayList.add(arrayList);
      }
      return;
    }
    stack.push(root.val);
    pathOfstack(root.left, target - root.val, arrayListArrayList, stack);
    pathOfstack(root.right, target - root.val, arrayListArrayList, stack);
    stack.pop();
  }

  private void path(TreeNode root, int target, int count, ArrayList<ArrayList<Integer>> arrayListArrayLists) {
    if (root == null)
      return;
    arrayList.add(root.val);
    count = count + root.val;
    if (root.left == null && root.right == null) {
      if (count == target)
        arrayListArrayLists.add(new ArrayList<Integer>(arrayList));
      //起初，我在这里（54行）写了return，因为我认为此时已经到叶节点了，应该返回，然后到下一个节点了
      //然后就是各种不对，因为此时返回就以为意味着当前叶节点要在list里删除，即返回后在63行以下删除——
      //也即arrayList.remove(arrayList.size()-1);但是最后调试各种不对！所以确定当前节点无效应该用左
      // 右节点遍历来看，在最后跳出的时候执行就行了！
    }
    path(root.left, target, count, arrayListArrayLists);
    path(root.right, target, count, arrayListArrayLists);
    arrayList.remove(arrayList.size() - 1);
  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(10);

    root1.left = new TreeNode(5);
    root1.right = new TreeNode(7);

    root1.left.left = new TreeNode(12);
    root1.left.right = new TreeNode(4);
    //root1.right.right = new TreeNode(85);
    new N24$_FindPath_OfZero().FindPath(root1, 15);
  }
}