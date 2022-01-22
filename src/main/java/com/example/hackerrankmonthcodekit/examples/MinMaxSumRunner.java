package com.example.hackerrankmonthcodekit.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class MinMax {
    public static void miniMaxSum(List<Integer> arr) {
        List<Long> intToLongArray = arr.stream().map(Integer::longValue).collect(Collectors.toList());
        List<Long> uniqueNumbers = intToLongArray.stream().distinct().collect(Collectors.toList());
        if (uniqueNumbers.size() == 1) {
            Long value = uniqueNumbers.get(0) * (intToLongArray.size()-1);
            System.out.println(value + " " + value);
        } else {
            List<Long> sumCollection = uniqueNumbers.stream().map(uniqueNumber -> addNumbers(intToLongArray, uniqueNumber)).collect(Collectors.toList());
            LongSummaryStatistics statistics = sumCollection.stream().mapToLong(Long::longValue).summaryStatistics();
            System.out.println(statistics.getMin() + " " + statistics.getMax());
        }
    }

    private static Long addNumbers(List<Long> arr, Long uniqueNumber) {
        return arr.stream().filter(value -> !Objects.equals(value, uniqueNumber)).mapToLong(Long::longValue).sum();
    }
}

public class MinMaxSumRunner {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

        MinMax.miniMaxSum(arr);

        bufferedReader.close();
    }
}
