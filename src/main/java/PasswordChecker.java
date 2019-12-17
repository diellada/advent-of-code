public class PasswordChecker {
    public static boolean checkPassword(int number) {
        return (SecureContainer.withinMaxBounds(number)
                & SecureContainer.convertIntoIntegerArray(number).size() == 6
                & SecureContainer.twoAdjacentDigitsTheSame(number)
                & !SecureContainer.oddAmountOfDigitsInNumber(number)
                & SecureContainer.theNumberIncreases(number));
    }
}
