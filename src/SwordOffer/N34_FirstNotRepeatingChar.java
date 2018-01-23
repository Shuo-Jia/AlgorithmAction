package SwordOffer;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class N34_FirstNotRepeatingChar {
  /**
   * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)
   * 中找到第一个只出现一次的字符,并返回它的位置
   */
  public int FirstNotRepeatingChar(String str) {
    HashMap<Character, Integer> hashMap = new LinkedHashMap<>();
    Character firstChar = 0;
    int index = 100001;
    for (int i = 0; i < str.length(); i++) {
      if (!hashMap.containsKey(str.charAt(i)))
        hashMap.put(str.charAt(i), 1);
      else
        hashMap.put(str.charAt(i), (hashMap.get(str.charAt(i)) + 1));
    }
    for (Character c : hashMap.keySet()) {
      if (hashMap.get(c) == 1) {
        firstChar = c;
        break;
      }
    }
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == firstChar)
        index = i;
    }
    return index;
  }

  public static void main(String[] args) {
    String str = "google";
    int index = new N34_FirstNotRepeatingChar().FirstNotRepeatingChar(str);
  }
}
