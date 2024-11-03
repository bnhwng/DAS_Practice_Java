package algo;
import java.util.Random;
public class arr {
  public arr(){

  } 

  private static int findLowestValue(int[]arr){
    int minVal=arr[0];
    if(arr.length==0){
      return 0;
    } 
    for(int i = 1; i<arr.length;i++){
      if(arr[i]<minVal){
        minVal=arr[i];
      }
    }
    return minVal;
  }

  private static int findHighestValue(int[]arr){
    int maxValue=arr[0];
    if(arr.length==0){
      return 0;
    }
    for(int i = 1; i<arr.length;i++){
      if(arr[i]>maxValue){
        maxValue=arr[i];
      }
    }
    return maxValue;
  }

  public static void bubbleSort(int[]arr){
    boolean swapped = false;
    int temp;
    if(arr.length==0){
      System.out.println("invaidlid array");
    }
    for(int i = 0; i < arr.length-1;i++ ){
      swapped=false;
      for(int j=0; j<arr.length-i-1; j++){
        if(arr[j]>arr[j+1]){
          temp=arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=temp;
          swapped=true;
        }
      }
      if(swapped==false) break;
    }
  }

  public static void printArray(int[]arr){
    if(arr.length==0){
      System.out.println("Invalid array");
    }

    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+", ");
    }

  }
  
  public static void main(String[]args){
    Random rand = new Random();
    int[]arr = new int[10];
    for(int i=0; i<10;i++){
      arr[i]=rand.nextInt(100);
      System.out.print(arr[i]+", ");
    }
    // bubbleSort(arr);
    // printArray(arr);
    System.out.println("\nThe lowest value of the array above is " + findLowestValue(arr));
    System.out.println("The highest value of the array above is " + findHighestValue(arr));
    System.out.print(12/10);
  }
}
