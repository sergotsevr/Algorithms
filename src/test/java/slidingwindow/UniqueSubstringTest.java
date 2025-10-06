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
        int uniqueSubstringsCount = 7;
        assertEquals(uniqueSubstringCount, uniqueSubstringsCount);
    }

    @Test
    public void givenStringAndNewSlidingWindowSize_whenSubstringsSize_thenReturnUniqueSubstringsCount() {
        int uniqueSubstringCount = Substrings.findUniqueSubstring(STRING_TO_TEST, 4);
        assertEquals(uniqueSubstringCount, 2);
    }
}
