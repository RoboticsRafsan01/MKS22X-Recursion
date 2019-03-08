import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class recursion{

  /*Recursively find the sqrt using Newton's approximation
       *tolerance is the allowed percent error the squared answer is away from n.
       *precondition: n is non-negative

      */
public static double sqrt(double n, double tolerance){
  if(n == 0.0){return n;}
  return sqrtH(n,1.0,tolerance);
}

public static double sqrtH(double n, double guess, double tolerance){
  double num = guess * guess;
  if(Math.abs((n/num) - 1) < tolerance){return guess;}
  guess = ((n/guess) + guess) / 2.0;
  return sqrtH(n,guess,tolerance);
}

/*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
public static int fib(int n){
  if(n == 0){return 1;}
  return fibH(1,1,0,n);
}

public static int fibH(int first, int last, int pos, int end){
  if(end <= 1){return first;}
  int nfirst = first + last;
  int nlast = first;
  return fibH(nfirst,nlast,pos,end-1);
}

public static ArrayList<Integer> makeAllSums(int nums){
  ArrayList<Integer> result = new ArrayList<Integer>();
  result.add(0);
  result.add(nums);
  return makeAllSumsH(nums-1,result);
}

public static ArrayList<Integer> makeAllSumsH(int nums, ArrayList<Integer> data){
  if(nums == 0){return data;}
  int length = data.size();
  while(length > 0){
    int num = data.get(length-1);
    if(!data.contains(num+nums)){data.add(num+nums);}
    length--;
  }
  return makeAllSumsH(nums-1,data);
}
}
