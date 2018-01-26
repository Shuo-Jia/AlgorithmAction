package SwordOffer;

import java.util.ArrayList;

public class N41_FindContinuousSequence {
  /**
   * 输入一个正数s,打印出所有和为s的连续正数序列（至少含有两个数）。
   * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15；所以打印出三个连续序
   * 列1~5,4~6,7~8；
   */
  public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
    int begin = 1;
    int end = 2;
    int curSum = 3;
    int mid = (1 + sum) / 2;
    ArrayList<ArrayList<Integer>> arrayListArrayLists = new ArrayList<>();
    while (begin < mid) {
      curSum = curSum(begin, end);
      if (curSum == sum) {
        arrayListArrayLists.add(curSequence(begin, end));
        begin++;
      } else if (curSum < sum)
        end++;
      else if (curSum > sum)
        begin++;
    }
    return arrayListArrayLists;
  }

  private int curSum(int begin, int end) {
    int curSum = 0;
    while (begin <= end)
      curSum += begin++;
    return curSum;
  }

  private ArrayList<Integer> curSequence(int begin, int end) {
    ArrayList<Integer> arrayList = new ArrayList<>();
    while (begin <= end)
      arrayList.add(begin++);
    return arrayList;
  }

  public static void main(String[] args) {
    new N41_FindContinuousSequence().FindContinuousSequence(15);
  }
}
