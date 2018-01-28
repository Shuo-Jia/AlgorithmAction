package SwordOffer;

import java.util.Arrays;

public class N45_isContinuous {
  /**
   * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,
   * 想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”
   * 不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,
   * 3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运
   * 气如何。为了方便起见,你可以认为大小王是0。
   * <p>
   * (一开始没读懂，后来看了网上的输入输出才知道就是判断0~13以内的数字（每个数字最多出现4次）组成的5个数是不是顺序的！其中0又可以代表任意数)
   */
  public boolean isContinuous(int[] numbers) {
    if (numbers == null || numbers.length == 0)
      return false;
    int length = numbers.length;
    int countOf_0 = 0;
    int[] temp = new int[2 * length];
    Arrays.sort(numbers);
    for (int i : numbers) {
      if (i == 0)
        countOf_0++;
    }
    temp[countOf_0] = numbers[countOf_0];
    for (int i = countOf_0 + 1, j = countOf_0 + 1; i < length; i++) {
      if (numbers[i] == numbers[i - 1])
        return false;
      else if (numbers[i] - numbers[i - 1] <= 1)
        temp[j++] = numbers[i];
      else {
        int l = numbers[i] - numbers[i - 1];
        countOf_0 = countOf_0 - (l - 1);
        if (countOf_0 < 0)
          return false;
        j = j + (l - 1);
        temp[j] = numbers[i];
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] array = new int[]{0, 3, 2, 4, 6};
    new N45_isContinuous().isContinuous(array);
  }
}
