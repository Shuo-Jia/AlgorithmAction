package SwordOffer;

import java.util.Stack;

public class N5_QueuebyStack {

  /**
   * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
   */
  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  public void push(int node) {
    stack1.push(node);
  }

  public int pop() {
    int val;
    int res;
    while (!stack1.empty()) {
      val = stack1.pop();
      stack2.push(val);
    }
    res = stack2.pop();
    while(!stack2.empty()){
      val = stack2.pop();
      stack1.push(val);
    }
    return res;
  }

  public static void main(String[] args) {
    N5_QueuebyStack queuebyStack = new N5_QueuebyStack();
    queuebyStack.push(0);
    queuebyStack.push(1);
    queuebyStack.push(2);
    queuebyStack.push(3);
    queuebyStack.push(4);
    queuebyStack.push(5);

    int res = queuebyStack.pop();
    res = queuebyStack.pop();
    res = queuebyStack.pop();
    res = queuebyStack.pop();
    res = queuebyStack.pop();
    queuebyStack.push(6);
    queuebyStack.push(7);
    res = queuebyStack.pop();
  }
}
