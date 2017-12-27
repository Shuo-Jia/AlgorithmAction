package SwordOffer;

public class N8_JumpFloor {
  /**
   * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
   * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
   */
  public int jumpFloor(int target) {
    if(target == 0)
      return 0;
    if(target == 1)
      return 1;
    if(target == 2)
      return 2;
    return jumpFloor(target-1)+jumpFloor(target-2);
  }

  public static void main(String[] args){
    int count = new N8_JumpFloor().jumpFloor(4);
  }
}
