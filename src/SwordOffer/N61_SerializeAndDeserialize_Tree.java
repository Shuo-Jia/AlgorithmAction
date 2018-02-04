package SwordOffer;

public class N61_SerializeAndDeserialize_Tree {
  /**
   * 请实现两个函数，分别用来序列化和反序列化二叉树(运行时间：19ms
   * 占用内存：9672k)
   */
  private StringBuilder stringBuilder = new StringBuilder();
  private int i = -1;

  String Serialize(TreeNode root) {
    return sericalize(root).toString();
  }

  private StringBuilder sericalize(TreeNode root) {
    if (root == null)
      return stringBuilder.append("#,");
    stringBuilder.append(root.val + ",");
    stringBuilder = sericalize(root.left);
    stringBuilder = sericalize(root.right);
    return stringBuilder;
  }

  TreeNode Deserialize(String str) {
    String[] strs = str.split(",");
    return deserialize(strs);
  }

  TreeNode deserialize(String[] strs) {
    i++;
    if (i >= strs.length || strs[i].equals("#"))
      return null;
    TreeNode root = new TreeNode(Integer.parseInt(strs[i]));
    root.left = deserialize(strs);
    root.right = deserialize(strs);
    return root;
  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(8);

    root1.left = new TreeNode(6);
    root1.right = new TreeNode(10);

    root1.left.left = new TreeNode(5);
    root1.left.right = new TreeNode(7);

    root1.right.left = new TreeNode(9);
    root1.right.right = new TreeNode(11);

    root1.left.left.left = new TreeNode(8);
    root1.left.left.right = new TreeNode(9);

    String str = new N61_SerializeAndDeserialize_Tree().Serialize(root1);
    TreeNode root = new N61_SerializeAndDeserialize_Tree().Deserialize(str);
  }
}
