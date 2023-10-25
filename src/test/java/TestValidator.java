import com.calculator.Validator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestValidator {

    @Test
    public void testValidator() {
        /*This test tests the Validator class and its methods*/
        assertThrows(NumberFormatException.class, () ->
                Validator.checkingRomanOrArabic(new String[]{"II", "+", "2"}));

        assertThrows(NumberFormatException.class, () ->
                Validator.checkingRomanOrArabic(new String[]{"3", "+", "IX"}));

        assertTrue(Validator.checkingRomanOrArabic(new String[]{"II", "-", "VI"}));

        assertThrows(IllegalArgumentException.class, () ->
                Validator.checkingNumbersArguments(new String[] {"23"}));

        assertThrows(IllegalArgumentException.class, () ->
                Validator.checkingNumbersArguments(new String[] {"4", "+", "2", "*", "4"}));

    }
}
