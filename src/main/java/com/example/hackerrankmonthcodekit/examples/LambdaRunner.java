package com.example.hackerrankmonthcodekit.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return (int num) -> num % 2 != 0;
    }

    public PerformOperation isPrime() {
        return (int num) -> {
            if (num == 1) return true;
            else {
                long count = IntStream.rangeClosed(1, num).filter(value -> num % value == 0).count();
                return count == 2;
            }
        };
    }

    public PerformOperation isPalindrome() {
        return (int num) -> {
            int temp = num;
            int reverseNumber = 0;
            while (temp != 0) {
                int rem = temp % 10;
                temp = temp / 10;
                reverseNumber = (reverseNumber * 10) + rem;
            }
            return num == reverseNumber;
        };

        //Second Way of Converting To String
         /*  return (int num) -> {
            String numToString = Integer.toString(num);
            StringBuilder reverseString = new StringBuilder();
            int len = numToString.length();
            for (int n = len - 1; n >= 0; n--) {
                reverseString.append(numToString.charAt(n));
            }
            return numToString.equals(reverseString.toString());
        };*/
    }
}

public class LambdaRunner {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}
