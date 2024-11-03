package algo;
public class fib {
  public fib() {
  }

  public int[] fibonacci() {
    int[] result = new int[30];
    result[0] = 0;
    result[1] = 1;
    for (int i = 2; i < 18; i++) {
      result[i] = result[i - 1] + result[i - 2];
    }
    return result;
  }

  public int fibonacciTh(int th){
    if(th <= 1){
      return 1;
    } else {
      return fibonacciTh(th-1)+fibonacciTh(th-2);
    }
  }

  public int[] fibArrUpto(int i){
    int[] result = new int[i];
    if(i <= 1){
      return new int[]{1};
    }

    for(int j = 0; j<i; j++){
      result[j]+=fibonacciTh(j);
    }

    return result;
  }



  public static void main(String[] args) {
    fib das = new fib();
    int[]result=das.fibArrUpto(20);
    int i=0;
    while(i<20){
      System.out.println(result[i]);
      i++;
    }
  }
}
