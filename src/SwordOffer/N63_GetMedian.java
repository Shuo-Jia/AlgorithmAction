package SwordOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class N63_GetMedian {
  /**
   * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
   * 那么中位数就是所有数值排序之后位于中间的数值。
   * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
   */
  int count = 0;
  private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      return o2 - o1;
    }
  });

  public void Insert(Integer num) {
    if (count % 2 == 0) {
      maxHeap.offer(num);
      minHeap.offer(maxHeap.poll());
    } else {
      minHeap.offer(num);
      maxHeap.offer(minHeap.poll());
    }
    count++;
  }

  public Double GetMedian() {
    if (count % 2 == 0) {
      return new Double(minHeap.peek() + maxHeap.peek()) / 2;
    } else {
      return new Double(minHeap.peek());
    }
  }
}
