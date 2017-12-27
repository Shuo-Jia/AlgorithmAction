package SwordOffer;

public class N7_Fibonaci {
  /**
   * 大家都知道斐波那契数列，现在要求输入一个整数n，
   * 请你输出斐波那契数列的第n项。n<=39
   */
  public int Fibonacci(int n) {
    int[] F = new int[n+1];
    if(n == 0 ){
      F[0] = 0;
      return F[0];
    }else if(n == 1){
      F[1] = 1;
      return F[1];
    }else{
      F[0] = 0;
      F[1] = 1;
      for(int i = 2; i <= n; i++){
        F[i] = F[i-1] + F[i-2];
      }
      return F[n];
    }
  }

  public int Fibrecursive(int n){
    if(n == 0)
      return 0;
    if(n == 1)
      return 1;
    return Fibonacci(n-1)+Fibonacci(n-2);
  }

  public static void main(String[] args){
    int f = new N7_Fibonaci().Fibonacci(10);
    int fPlus = new N7_Fibonaci().Fibrecursive(10);
  }
}
