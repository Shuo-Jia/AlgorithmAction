package SwordOffer;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和
 * 中序遍历的结果中都不含重复的数字。例如
 * 输入前序遍历序列{1,2,4,7,3,5,6,8}和中
 * 序遍历序列{4,7,2,1,5,3,8,6}，则重建二
 * 叉树并返回。
 */

public class N4_ReConstruct_BinaryTree {
  public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
    return rebuildTree(pre, in, 0, pre.length-1, 0, in.length-1);
  }

  /*
  * 写递归需要注意一个前提和三个要点：
  * 前提：
  *   通过逻辑分析，发现问题可以用递归实现，一般如果发现有相似的循环逻辑即很可能可以用递归实现，当然这得靠对递归有
  * 要点1：
  *   起始条件——递归调用以什么样的起始条件开始，而这个起始条件又具有复用性，实际起始条件就是逻辑分析中的“输入”条件。
  * 要点2：
  *   n——>n+1的转换——即实际的迭代函数体
  * 要点3：
  *   结束条件——通常迭代过程并不会产生最后的结果，只有跳出的时候才开始发挥迭代过程中做的工作，所以需要计算好跳出的条件
  *
  * */

  private TreeNode rebuildTree(int[] pre, int[] in, int pre_start, int pre_end, int in_start, int in_end){
    if(pre_start>pre_end)
      return null;
    int pre_root = pre[pre_start];
    int in_root_index = 0;
    while(in_root_index <= in_end){
      if(in[in_root_index] == pre_root){
        break;
      }
      in_root_index++;
    }
    int length = in_root_index - in_start;
    TreeNode treeNode = new TreeNode(pre_root);
    /*42-51即实际迭代的函数体：求出当前root节点在前序中序额位置，然后分开，再由下式进行第n此迭代*/
    treeNode.left = rebuildTree(pre, in, pre_start+1, pre_start+length, in_start, in_root_index-1);
    treeNode.right = rebuildTree(pre, in, pre_start+length+1, pre_end, in_root_index+1, in_end);
    return treeNode;
  }

  public static void main(String[] args){
    int[] pre = new int[]{1,2,4,7,3,5,6,8};
    int[] in = new int[]{4,7,2,1,5,3,8,6};
    new N4_ReConstruct_BinaryTree().reConstructBinaryTree(pre, in);
  }
}
