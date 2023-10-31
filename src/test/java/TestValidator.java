import com.calculator.Validator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class TestValidator {
    /*This test tests the Validator class and its methods*/
    Validator validator = new Validator();

    @Test
    public void testCheckingRomanOrArabic() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        assertThrows(NumberFormatException.class, () ->
                validator.setExpression(new String[]{"II", "+", "2"}));

        assertThrows(NumberFormatException.class, () ->
                validator.setExpression(new String[]{"3", "+", "IX"}));
    }

    @Test
    public void testCheckingNumbersArguments() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                validator.setExpression(new String[] {"23"}));
        assertEquals("Строка не является математической операцией", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                validator.setExpression(new String[] {"4", "+", "2", "*", "4"}));
        assertEquals("Формат математической операции не удовлетворяет заданию", exception.getMessage());

        exception = assertThrows(IndexOutOfBoundsException.class, () ->
                validator.setExpression(new String[] {}));
        assertEquals("Вы передали пустое выражение", exception.getMessage());

    }

    @Test
    public void testCheckingForInteger() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                validator.setExpression(new String[] {"23", "-", "34"}));
        assertEquals("Аргументы вне допустимом диапозоне", exception.getMessage());

        exception = assertThrows(NumberFormatException.class, () ->
                validator.setExpression(new String[] {"we", "-", "w"}));
        assertEquals("Агрументы должны быть числами", exception.getMessage());
    }
}
