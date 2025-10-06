package slidingwindow;

import org.example.slidingwindow.Substrings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniqueSubstringTest {

    private final String STRING_TO_TEST = "abracadabra";

    @Test
    public void givenStringAndSlidingWindowSize_whenSubstringsSize_thenReturnUniqueSubstringsCount() {
        int slidingWindowSize = 3;
        int uniqueSubstringCount = Substrings.findUniqueSubstring(STRING_TO_TEST, slidingWindowSize);
        int expected = 7;
        assertEquals(expected, uniqueSubstringCount);
    }

    @Test
    public void givenStringAndNewSlidingWindowSize_whenSubstringsSize_thenReturnUniqueSubstringsCount() {
        int uniqueSubstringCount = Substrings.findUniqueSubstring(STRING_TO_TEST, 4);
        assertEquals(2, uniqueSubstringCount);
    }

    @Test
    public void givenString_whenMaxWindowSize_thenReturnMaxWindowSize() {
        int longestWindowWithUniqueSubstrings = Substrings.longestWindowWithUniqueSubstrings(STRING_TO_TEST);
        assertEquals(4, longestWindowWithUniqueSubstrings);
    }

    @Test
    public void givenString_whenMaxWindowSizeAlt_thenReturnMaxWindowSize() {
        int longestWindowWithUniqueSubstrings = Substrings.longestWindowWithUniqueSubstringsAlt(STRING_TO_TEST);
        assertEquals(4, longestWindowWithUniqueSubstrings);
    }


    @Test
    public void givenString_whenLongestWindowWithUniqueSubstringsMaxTwoCharAlt_thenReturnMaxWindowSize() {
        String test = "avvaaababajk";
        int longestWindowWithUniqueSubstrings = Substrings.longestWindowWithUniqueSubstringsMaxTwoCharAlt(test);
        assertEquals(7, longestWindowWithUniqueSubstrings);
    }
}
