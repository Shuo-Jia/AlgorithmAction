package SwordOffer;

public class N9_JumpFloorPlus {
  /**
   * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……
   * 它也可以跳上n级。求该青蛙跳上一个n级的台阶总
   * 共有多少种跳法。
   */
  public int jumpFloorPlus(int target) {
    if(target == 0)
      return 0;
    if(target == 1)
      return 1;
    return 2*jumpFloorPlus(target-1);
  }

  public static void main(String[] args){
    int count = new N9_JumpFloorPlus().jumpFloorPlus(5);
  }
}
