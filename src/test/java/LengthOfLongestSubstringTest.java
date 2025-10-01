import org.example.LengthOfLongestSubstring;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthOfLongestSubstringTest {

    @Test
    public void positiveSortingCase() {
        String str = "abcabcbb";
        int expected = 3;
        int result = LengthOfLongestSubstring.lengthOfLongestSubstring(str);
        assertEquals(expected, result);
    }
}
