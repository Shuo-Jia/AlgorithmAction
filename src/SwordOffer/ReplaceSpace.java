package SwordOffer;

public class ReplaceSpace {
  /**
   * 请实现一个函数，将一个字符串中的空格替换成“%20”。
   * 例如，当字符串为We Are Happy.则经过替换之后的字
   * 符串为We%20Are%20Happy
   */
  public String replaceSpace(StringBuffer str) {
    int strlen = str.length();
    for(int i = 0;i < strlen;i++){
      if(str.charAt(i)==' '){
        str.replace(i,i+1,"%20");
        strlen = str.length();
      }
    }
    String string =  str.toString();
    System.out.println(string);
    return string;
  }

  public static void main(String[] args){
    new ReplaceSpace().replaceSpace(new StringBuffer("We Are Happy "));
  }
}
