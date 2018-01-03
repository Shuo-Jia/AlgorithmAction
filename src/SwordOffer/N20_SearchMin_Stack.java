package SwordOffer;

import java.util.Stack;

public class N20_SearchMin_Stack {
  /**
   * 定义栈的数据结构，请在该类型中实现一个能够
   * 得到栈最小元素的min函数(保证栈内数据没有任何变动)(运行时间：14ms 占用内存：8684k)
   */

  Stack<Integer> stack = new Stack<>();
  Stack<Integer> tempstack = new Stack<>();

  public void push(int node) {
    stack.push(node);
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public boolean empty() {
    return stack.empty();
  }

  public int min() {
    int min = top();
    pop();
    tempstack.push(min);
    while (!empty()) {
      if (top() < min) {
        min = top();
        tempstack.push(min);
        pop();
      } else {
        tempstack.push(top());
        pop();
      }
    }
    while (!tempstack.empty()) {
      push(tempstack.pop());
    }
    return min;
  }

  public static void main(String[] args) {
    int[] min = new int[20];
    N20_SearchMin_Stack searchMin_stack = new N20_SearchMin_Stack();
    searchMin_stack.push(3);
    min[0] = searchMin_stack.min();
    searchMin_stack.push(4);
    min[1] = searchMin_stack.min();
    searchMin_stack.push(2);
    min[2] = searchMin_stack.min();
    searchMin_stack.push(3);
    min[3] = searchMin_stack.min();
    searchMin_stack.pop();
    min[4] = searchMin_stack.min();
    searchMin_stack.pop();
    min[5] = searchMin_stack.min();
    searchMin_stack.pop();
    min[6] = searchMin_stack.min();
    searchMin_stack.push(0);
    min[7] = searchMin_stack.min();
  }
}
