import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    public void testPlus() {
        //Arrange
        int x = 1, y = 2, expected = 3;

        //Act
        int actual = calc.plus.apply(x,y);

        //Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "5, 1",
            "0, 4",
            "4, 0"
    })
    public void testMinus(int x, int y) {
        //Arrange
        int expected = x - y;

        //Act
        int actual = calc.minus.apply(x,y);

        //Assert
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "5, 1",
            "0, 4",
            "4, 0"
    })
    public void testMultiplyint (int x, int y) {
        //Arrange
        int expected = x * y;

        //Act
        int actual = calc.multiply.apply(x,y);

        //Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "8, 2",
            "2, 4",
            "0, 4"
    })
    public void testDevide (int x, int y) {
        //Arrange
        int expected = x / y;

        //Act
        int actual = calc.devide.apply(x,y);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testDevideOnZero() {
        //Arrange
        int x = 4, y = 0, expected = 0;

        //Act
        int actual = calc.devide.apply(x,y);

        //Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 0, 22})
    public void testPow (int x) {
        //Arrange
        int expected = x * x;

        //Act
        int actual = calc.pow.apply(x);

        //Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, -2, 0, -22, 5})
    public void testAbs (int x) {
        //Arrange
        int expected;
        if (x < 0) expected = x * -1;
        else expected = x;

        //Act
        int actual = calc.abs.apply(x);

        //Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, -2, 0, -22, 5})
    public void testIsPositive(int x) {
        //Arrange
        boolean expected;
        if(x > 0) expected = true;
        else expected = false;
        //Act
        boolean actual = calc.isPositive.test(x);
        //Assert
        assertEquals(expected, actual);
    }
}
