package SwordOffer;

import java.util.Stack;

public class N21$_IsPopOrder {
  /**
   * 输入两个整数序列，第一个序列表示栈的压入顺序，
   * 请判断第二个序列是否为该栈的弹出顺序。假设压
   * 入栈的所有数字均不相等。例如序列1,2,3,4,5是
   * 某栈的压入顺序，序列4,5,3,2,1是该压栈序列对
   * 应的一个弹出序列，但4,3,5,1,2就不可能是该压
   * 栈序列的弹出序列。（注意：这两个序列的长度是相等的）
   * -------------------算法（参考网上的！(运行时间：19ms 占用内存：8612k)）：判断的重点是，数据在一个出栈周期是哪一个数据先出栈的，并且以这个出栈点其实知道下一个出栈点，之间的顺序是否合法？
   * ------------------假设出栈顺序是1,2,3,4,5，我们看到出栈0位1=入栈0位1，我们
   * ------------------就说，1入栈后就出栈了，即出栈数据是1；这个当然很简单，我们同时
   * ------------------可以看到，2入栈后也出栈了，3入栈后也出栈了.........
   * ------------------但是更为普遍的算法是什么呢？
   * ------------------1、我们选取辅助栈stack，同时定义入栈序列pushA，出栈序列popA；
   * ------------------2、比较pushA[0]?=popA[0]，不等pushA[0]入栈stack，然后pushA后移一位比较，即pushA[1]?=popA[0]；
   * ------------------   相等则说明[0]位是出栈点，也入stack栈，入栈入stack后，判断当前stack是否为空，如果不空则持续出栈，然后和popA
   * ------------------   当前索引位i比较，如果相等，则i++，否则直接跳出！直到空了，pushA和popA同时后移下一位开始比较！
   * ------------------PS:因为当不等的时候，Stack积累（push）了若干数据（只有找到相等点时才作Stack出栈操作，所以积累了数据），直到再次找到相等点，
   * ------------------即原始数据的出栈点，才开始出栈！这些积累的数据就是两次出栈间隔的累积数据。而后如果Stack出栈数据和原始数据出栈顺序一致，那么不会跳出，Stack最后必然为空栈，
   * ------------------如果发现不一致，即以当前出栈点作为起始出栈，后续不会出现原始出栈点的顺序，则不合法！因为必会直接跳出，Stack不会是空栈，从而判断！
   */
  public boolean IsPopOrder(int[] pushA, int[] popA) {
    java.util.Stack<Integer> stack = new Stack<>();
    int i = 0;
    int j = 0;
    while (i < pushA.length) {
      if (pushA[i] != popA[j]) {
        stack.push(pushA[i]);
        i++;
      } else {
        stack.push(pushA[i]);
        while (!stack.empty()) {
          if (stack.peek() == popA[j]) {
            stack.pop();
            j++;
          } else {
            j--;
            break;
          }
        }
        i++;
        j++;
      }
    }
    return stack.empty();
  }

  public static void main(String[] args) {
    boolean flag;
    int[] inStack = new int[]{1, 2, 3, 4, 5};
    int[] outStack = new int[]{4, 5, 3, 2, 1};
    flag = new N21$_IsPopOrder().IsPopOrder(inStack, outStack);
  }
}
