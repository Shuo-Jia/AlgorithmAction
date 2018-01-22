package SwordOffer;

public class N32_PrintMinNumber {
  /**
   * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
   * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
   * 则打印出这三个数字能排成的最小数字为321323。
   * -------------------------算法：该题其实就是一个排序题，只不过这个“序”并不是数字的大小，
   * -------------------------------而是“自定义‘序’”：即两数拼接哪个结果小就按照哪个结果中
   * -------------------------------的顺序排列！例如22和3，因为223 < 322，所以我们认为“22 < 3”，
   * -------------------------------即22应该放在3的前面。那么有一列数字，每个数字都按照这种规则
   * -------------------------------排序即可！注意：拼接的数字很可能大于int所能表示的数字，
   * -------------------------------所以拼接的时候直接使用字符串拼接，比较的时候也用字符串
   * -------------------------------比较就行了！这里为了快速起见，选用快排！（运行时间：26ms 占用内存：8996k）
   */
  public String PrintMinNumber(int[] numbers) {
    return sortBystringQsort(numbers, 0, numbers.length - 1);
  }

  private String sortBystringQsort(int[] numbers, int low, int high) {
    int privot;
    StringBuilder stringBuilder = new StringBuilder();
    if (low < high) {
      privot = privot(numbers, low, high);
      sortBystringQsort(numbers, low, privot - 1);
      sortBystringQsort(numbers, privot + 1, high);
    }
    for (int i : numbers) {
      stringBuilder.append(i);
    }
    return stringBuilder.toString();
  }


  private int privot(int[] numbers, int low, int high) {
    int privot = numbers[low];
    while (low < high) {
      while (low < high && isSmall(privot, numbers[high]))
        high--;
      swap(numbers, low, high);
      while (low < high && isSmall(numbers[low], privot))
        low++;
      swap(numbers, low, high);
    }
    return low;
  }

  private boolean isSmall(int i, int j) {
    String left = String.valueOf(i) + String.valueOf(j);
    String right = String.valueOf(j) + String.valueOf(i);
    if (left.compareTo(right) <= 0)
      return true;
    return false;
  }

  private void swap(int[] numbers, int i, int j) {
    int temp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = temp;
  }

  public static void main(String[] args) {
    int[] numbers = new int[]{3334, 3, 3333332};
    String string = null;
    string = new N32_PrintMinNumber().PrintMinNumber(numbers);
    System.out.println(string);
  }
}
