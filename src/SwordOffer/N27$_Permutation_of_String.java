package SwordOffer;

import java.util.*;

public class N27$_Permutation_of_String {
  /**
   * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
   * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所
   * 有字符串abc,acb,bac,bca,cab和cba。
   * --------------------------算法：假设有5位abcde，第一次递归1位和剩下的4位，然后把剩下的4位作为输入，
   * --------------------------------再次递归这些剩下的4位，直到递归到第5位，发现本次递归完场输出abcde，
   * --------------------------------然后退栈，这时处于第4位，并且和第5位交换，然后递归到第5位，输出abced
   * --------------------------------然后退栈，这时处于第3位，以此类推！
   */
  public ArrayList<String> Permutation(String str) {
    ArrayList<String> arrayList = new ArrayList<>();
    if (str == null || str.length() == 0)
      return arrayList;
    char[] temp = str.toCharArray();
    TreeSet<String> treeSet = new TreeSet<>();
    permutation(temp, 0, str.length(), treeSet);
    arrayList.addAll(treeSet);
    return arrayList;
  }

  private void permutation(char[] temp, int start, int end, TreeSet<String> treeSet) {
    if (start == temp.length - 1) {
      treeSet.add(new String().valueOf(temp));
      return;
    }
    for (int i = start; i < end; i++) {
      swap(temp, start, i);
      permutation(temp, start + 1, end, treeSet);
      swap(temp, i, start);
    }
  }

  private void swap(char[] temp, int start, int end) {
    char t = 0;
    t = temp[start];
    temp[start] = temp[end];
    temp[end] = t;
  }

  public static void main(String[] args) {
    String str = "aa";
    new N27$_Permutation_of_String().Permutation(str);
  }
}
