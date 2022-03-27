package de.telran.work;

import java.util.NoSuchElementException;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Solution {

    public static void main(String[] args) {

        Solution solution=new Solution();
        System.out.println(solution.isPrime(2));

    }



    public  boolean isPrime(int number){
        if(number==1)
            return false;
        else
            return IntStream.rangeClosed(2,(int)Math.sqrt(number)).noneMatch(n->number%n==0);
    }

   public IntStream combiStream(IntStream stream1, IntStream stream2){

       IntPredicate divisibleBy3=(f)->f%3==0;
       IntPredicate divisibleBy5=(s)->s%5==0;
       IntPredicate divisibleBy3And5= divisibleBy3.and(divisibleBy5);

       return IntStream.concat(stream1,stream2)
               .filter(divisibleBy3And5)
               .sorted()
               .skip(2);
   }

       public long factorial(int f ){
        return LongStream.rangeClosed(1,f)
                .reduce(1, (result,number) -> result*number);
       }





       public long summOddNumbers(int a,int b){
           return LongStream.rangeClosed(a,b)
                    .filter(number->number%2==1)
                    .reduce((res,number)->(res+number))
                    .orElseThrow(()-> new NoSuchElementException());
       }
}
