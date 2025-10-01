import org.example.LengthOfLongestSubstring;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthOfLongestSubstringWindowTest {

    @Test
    public void positiveSortingCase() {
        String str = "abcabcbb";
        int expected = 3;
        int result = LengthOfLongestSubstring.lengthOfLongestSubstringV3(str);
        assertEquals(expected, result);
    }

    @Test
    public void positiveSortingCase2() {
        String str = "dvdf";
        int expected = 3;
        int result = LengthOfLongestSubstring.lengthOfLongestSubstringV3(str);
        assertEquals(expected, result);
    }
}
