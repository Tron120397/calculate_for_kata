import com.calculator.Converter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConverter {
    @Test
    public void testConvertRomanToArabic() {
        assertEquals("2", Converter.romanToArabic("II"));
        assertEquals("34", Converter.romanToArabic("XXXIV"));
    }

    @Test
    public void testConvertArabicToRoman() {
        assertEquals("V", Converter.convertArabicToRoman(5));
    }
}
