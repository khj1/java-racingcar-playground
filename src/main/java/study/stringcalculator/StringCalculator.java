package study.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int splitAndSum(String value) {
        if (value == null || value.equals("")) {
            return 0;
        }
        if (isInteger(value)) {
            return Integer.parseInt(value);
        }
        if (isNegative(value)) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }
        return sum(value);
    }

    private static int sum(String value) {
        List<Integer> integers = converToIntArr(split(value));
        return integers.stream().reduce(0, Integer::sum);
    }

    private static boolean isNegative(String value) {
        return value.contains("-");
    }

    private static List<Integer> converToIntArr(String[] strArr) {
        return Arrays.stream(strArr)
                .filter(StringCalculator::isInteger)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] split(String value) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return value.split(",|:");
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
