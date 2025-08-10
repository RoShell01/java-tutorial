import java.util.Scanner;
class SumEven{
      public static void main(String[] args)
      {
      int[]arr=new int[10];
      Scanner sc=new Scanner(System.in);

      for(int i=0;i<10;i++)
      {
      System.out.println("Enter a number");
      arr[i]=sc.nextInt();
      } 
      
      System.out.println("the array is:");
      int Sum=0;

      for(int i=0;i<10;i++)
     { 
      if(arr[i]%2==0)
      {
      Sum=Sum+arr[i];
      }
       }
    
      System.out.println("Sum:"+Sum);
    }
  }
      
