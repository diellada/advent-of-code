import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecureContainer {



    public static List<Integer> convertIntoIntegerArray(int num) {
        List<String> numArray = Arrays.asList(Integer.toString(num).split(""));
        List<Integer> realNumArray = numArray.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return realNumArray;
    }

    public static boolean withinMaxBounds(int num) {
        return (num <= 647015 | num >= 123257);
    }

    public static boolean twoAdjacentDigitsTheSame(int num) {
        List<Integer> numArray = convertIntoIntegerArray(num);
        boolean found = false;
        for(int n = 1; n < numArray.size(); n++) {
            if (numArray.get(n-1) == numArray.get(n)) {
                found = true;
                break;
            } else found = false;
        }
        return found;
    }

    public static boolean pairsOfAdjacentDigitsWhichAreTheSame(int num) {
        List<Integer> numArray = convertIntoIntegerArray(num);
        boolean found = false;
//        for(int n = 1; n < numArray.size(); n += 2) {
//            if (numArray.get(n-1) == numArray.get(n) ) {
//                found = true;
//            } else {
//                found = false;
//            }
            List<Integer> pair = numArray.subList(0,2);
            List<Integer> pair2 = numArray.subList(2,4);
            List<Integer> pair3 = numArray.subList(4,6);

            //numArray.stream().distinct().count()

        return found;
    }

    public static boolean theNumberIncreases(int num) {
        List<Integer> numArray = convertIntoIntegerArray(num);
        boolean doesIncrease = false;

        for (int i = 1; i < numArray.size(); i++) {
            if (numArray.get(i) >= numArray.get(i-1)) {
                doesIncrease = true;
            } else {
                doesIncrease = false;
                break;
            }
        }
        return doesIncrease;
    }

    public static boolean oddAmountOfDigitsInNumber(int num) {
        List<Integer> numArray = convertIntoIntegerArray(num);
        Map<Integer, Long> countMap = numArray.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        boolean oddDigits = false;

        for (Long vals: countMap.values()) {
            if (vals != 2) {
                for (Long value: countMap.values()) {
                    if (value % 2 == 0 && value > 2) {
                        oddDigits = true;
                        break;
                    }
                }
            }
        }

        return oddDigits;
    }
}
