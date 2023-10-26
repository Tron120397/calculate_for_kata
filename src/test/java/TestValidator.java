import com.calculator.Validator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestValidator {

    @Test
    public void testCheckingRomanOrArabic() {
        /*This test tests the Validator class and its methods*/
        assertThrows(NumberFormatException.class, () ->
                Validator.checkingRomanOrArabic(new String[]{"II", "+", "2"}));

        assertThrows(NumberFormatException.class, () ->
                Validator.checkingRomanOrArabic(new String[]{"3", "+", "IX"}));

        assertTrue(Validator.checkingRomanOrArabic(new String[]{"II", "-", "VI"}));
    }

    @Test
    public void testCheckingNumbersArguments() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                Validator.checkingNumbersArguments(new String[] {"23"}));
        assertEquals("Строка не является математической операцией", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                Validator.checkingNumbersArguments(new String[] {"4", "+", "2", "*", "4"}));
        assertEquals("Формат математической операции не удовлетворяет заданию", exception.getMessage());

    }

    @Test
    public void testCheckingForInteger() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                Validator.checkingForInteger(new String[] {"23", "-", "34"}));
        assertEquals("Аргументы вне допустимом диапозоне", exception.getMessage());

        exception = assertThrows(NumberFormatException.class, () ->
                Validator.checkingForInteger(new String[] {"we", "-", "w"}));
        assertEquals("Агрументы должны быть числами", exception.getMessage());
    }
}
