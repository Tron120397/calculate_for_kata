import com.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalculator {
    @Test
    public void testCalculate() {
        Calculator calculator = new Calculator(new String[] {"2", "&", "4"});

        Throwable exception = assertThrows(ArithmeticException.class, calculator::calculate);
        assertEquals("Не сущесвтующий операнд", exception.getMessage());

        calculator.setExpression(new String[] {"5", "+", "9"});
        assertEquals("14", calculator.calculate());

        calculator.setExpression(new String[] {"5", "*", "9"});
        assertEquals("45", calculator.calculate());

        calculator.setExpression(new String[] {"9", "/", "3"});
        assertEquals("3", calculator.calculate());

        calculator.setExpression(new String[] {"I", "-", "V"});
        exception = assertThrows(NumberFormatException.class, calculator::calculate);
        assertEquals("В риммской системе нет отрицательных чисел", exception.getMessage());
    }
}
