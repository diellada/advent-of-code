import org.junit.Test;
import static org.junit.Assert.*;

public class SecureContainerTest {
    @Test
    public void main() {

    }

    @Test
    public void numberIsSixDigitNumber() {
        int number = 123257;
        assertEquals(SecureContainer.convertIntoIntegerArray(number).size(), 6);
    }

    @Test
    public void numberIsInTheRange() {
        int number = 123257;
        assertTrue(SecureContainer.withinMaxBounds(number));
    }

    @Test
    public void numberContainsTwoAdjacentNumbersWhichAreTheSame() {
        int number = 113366;
        assertTrue(SecureContainer.twoAdjacentDigitsTheSame(number));
        int number2 = 222888;
        assertFalse(SecureContainer.twoAdjacentDigitsTheSame(number2));
    }

    @Test
    public void numberDoesNotDecrease() {
        int number = 267889;
        assertTrue(SecureContainer.theNumberIncreases(number));
        int number2 = 274932;
        assertFalse(SecureContainer.theNumberIncreases(number2));
    }

    @Test
    public void hasMoreThanTwoDigitsThatAreTheSame() {
        int number = 333579;
        assertTrue(SecureContainer.oddAmountOfDigitsInNumber(number));
        int number2 = 222258;
        assertFalse(SecureContainer.oddAmountOfDigitsInNumber(number2));
        int number3 = 222778;
        assertFalse(SecureContainer.oddAmountOfDigitsInNumber(number3));
    }
}
