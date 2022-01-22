package com.example.hackerrankmonthcodekit.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    public static void plusMinus(List<Integer> arr) {
        double positiveCount = 0, negativeCount = 0, zeroCount = 0;
        int arraySize = arr.size();
        for (int value : arr) {
            if (value > 0) {
                positiveCount++;
            } else if (value < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }
        System.out.printf("%.6f%n", positiveCount / arraySize);
        System.out.printf("%.6f%n", negativeCount / arraySize);
        System.out.printf("%.6f%n", zeroCount / arraySize);
    }
}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());
        Result.plusMinus(arr);
        bufferedReader.close();
    }
}
