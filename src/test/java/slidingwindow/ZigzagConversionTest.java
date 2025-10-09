package slidingwindow;

import org.example.ZigZagPatternString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZigzagConversionTest {

    private final ZigZagPatternString converter = new ZigZagPatternString();

    @Test
    public void exampleCase_numRows3() {
        String input = "PAYPALISHIRING";
        String expected = "PAHNAPLSIIGYIR";
        assertEquals(expected, converter.convert(input, 3));
    }

    @Test
    public void exampleCase_numRows4() {
        String input = "PAYPALISHIRING";
        String expected = "PINALSIGYAHRPI";
        assertEquals(expected, converter.convert(input, 4));
    }

    @Test
    public void singleRow_returnsSameString() {
        String input = "HELLO";
        assertEquals("HELLO", converter.convert(input, 1));
    }

    @Test
    public void numRowsGreaterThanLength_returnsSameString() {
        String input = "ABC";
        assertEquals("ABC", converter.convert(input, 5));
    }

    @Test
    public void twoRowsCase() {
        String input = "ABCDEFG";
        String expected = "ACEGBDF";
        assertEquals(expected, converter.convert(input, 2));
    }

    @Test
    public void emptyString_returnsEmpty() {
        assertEquals("", converter.convert("", 3));
    }

    @Test
    public void singleCharacter_returnsSame() {
        assertEquals("X", converter.convert("X", 2));
    }
    @Test
    public void numberDebugRowsCase() {
        String input = "0123456789";
        String expected = "0481357926";
        assertEquals(expected, converter.convert(input, 3));
    }


    @Test
    public void fourRowsCase() {
        String input = "PAYPALISHIRING";
        String expected = "PINALSIGYAHRPI";
        assertEquals(expected, converter.convert(input, 4));
    }
}
