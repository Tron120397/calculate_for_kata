import com.calculator.Converter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConverter {
    @Test
    public void testConvertRomanToArabic() {
        assertEquals("2", Converter.convertRomanToArabic("II"));
        assertEquals("34", Converter.convertRomanToArabic("XXXIV"));
        assertEquals("9", Converter.convertRomanToArabic("IX"));
        assertEquals("544", Converter.convertRomanToArabic("DXLIV"));
    }

    @Test
    public void testConvertArabicToRoman() {
        assertEquals("V", Converter.convertArabicToRoman(5));
        assertEquals("XXIV", Converter.convertArabicToRoman(24));
    }
}
