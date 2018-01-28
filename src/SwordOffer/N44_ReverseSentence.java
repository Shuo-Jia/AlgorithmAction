package SwordOffer;

public class N44_ReverseSentence {
  /**
   * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
   * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
   * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
   * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
   * --------------------------------------算法：遇到最后一个空格的时候开始三次反转,直到反转到第一个空格!
   * 如果你使用辅助空间然后使用空格作为分隔符，再然后倒序取出分割后的单词自然是可以的！思路简单容易想到!
   * 这里就不再赘述。前一题是三次反转的算法，用到这一题就是以最后一个单词前的空格的位置作为反转的k，第一次循环可以把
   * 最后一个单词移到后面,接着再把剩下的单词的最后一个单词移到后面，以此类推！
   * 程序中涉及的一些位置的计算方法，以及添加空格，最后把空格去掉，都是在调试程序的时候
   * 发现的bug，然后才加上去的，主要是为了解决反转后两个单词间没有空格的bug，所以就不要问为什么了，
   * 自己模拟一遍就知道为什么是这样的了。当然应该有其他办法解决。（运行时间：22ms 占用内存：8984k）
   */
  public String ReverseSentence(String str) {
    StringBuffer stringBuffer = new StringBuffer(str);
    stringBuffer.insert(0, " ");
    int indexOffirstSpace = 0;
    int indexOflastSpace = stringBuffer.lastIndexOf(" ");
    while (indexOffirstSpace != indexOflastSpace) {
      stringBuffer = reverse(stringBuffer, indexOffirstSpace, indexOflastSpace - 1);
      stringBuffer = reverse(stringBuffer, indexOflastSpace, stringBuffer.length() - 1);
      stringBuffer = reverse(stringBuffer, indexOffirstSpace, stringBuffer.length() - 1);
      indexOffirstSpace += stringBuffer.length() - indexOflastSpace;
      indexOflastSpace = stringBuffer.lastIndexOf(" ");
    }
    str = stringBuffer.substring(1, stringBuffer.length());
    return str;
  }

  private StringBuffer reverse(StringBuffer stringBuffer, int begin, int end) {
    char temp = 0;
    while (begin < end) {
      temp = stringBuffer.charAt(begin);
      stringBuffer.setCharAt(begin++, stringBuffer.charAt(end));
      stringBuffer.setCharAt(end--, temp);
    }
    return stringBuffer;
  }

  public static void main(String[] args) {
    String str = "I am a student.";
    str = new N44_ReverseSentence().ReverseSentence(str);
  }
}
