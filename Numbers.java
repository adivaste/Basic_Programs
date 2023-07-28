package com;

import java.util.ArrayList;
import java.util.List;

public class Numbers{

    // ==== Q.1) Find divisors ====
    
    // == App. 1 : Bruforce                             || TC : O(n) -- SC : O(1)
    public void find_divisors1(int num){
        List<Integer> divisors = new ArrayList<>();
        for(int i=1; i<=num; i++){
            if(num%i == 0) divisors.add(i);
        }

        System.out.println(divisors);
    }

    // == App. 2 : Brutforce optimized                  || TC : O(sqrt(n)) -- SC : O(1)
    public void find_divisors2(int num){
        List<Integer> divisors = new ArrayList<>();
        for(int divisor=1; divisor<=Math.sqrt(num); divisor++){
            if(num%divisor == 0){
                divisors.add(divisor);
                
                // If the divisor is not a perfect square, add its corresponding quotient
                if (divisor != num/divisor) divisors.add(num/divisor);
            }

        }

        System.out.println(divisors);
    }

    // ==== Q.2) Find Multiples ====

    public void find_multiples(int num){
        List<Integer> multiples = new ArrayList<>();
        for(int i=1; i<=10; i++){
            multiples.add(num*i);
        }
        System.out.println(multiples);
    }
        
    // ==== Q.3) Perfect number ====

    // App. 01 :: 
    public void perfect_number1(int num) {
        boolean isPerfect = false;
        int perfectSum = 0;

        for (int i = 1; i < num; i++) {         // Check codition properly
            if (num % i == 0) {
                perfectSum += i;
            }
        }

        if (perfectSum == num) isPerfect = true;
        System.out.println(isPerfect);
    }

    // App. 02 :: 
    public void perfect_number2(int num) {
        boolean isPerfect = false;
        int perfectSum = 0;

        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                perfectSum += i;

                if (i * i != num && i != 1) {    // Most important condition
                    perfectSum += num / i;
                }
            }
        }

        if (perfectSum == num) isPerfect = true;
        System.out.println(isPerfect);
    }

    // App. 02 :: Just modified one-two lines
    public void perfect_number3(int num) {
        boolean isPerfect = false;
        int perfectSum = 1;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                perfectSum += i;

                if (i * i != num ) {    // Most important condition
                    perfectSum += num / i;
                }
            }
        }

        if (perfectSum == num) isPerfect = true;
        System.out.println(isPerfect);
    }


    public static void main(String[] args){

        Numbers n = new Numbers();
        n.find_divisors1(90);
        n.find_divisors2(81);
        n.find_multiples(10);
        n.perfect_number1(6);
    }
}