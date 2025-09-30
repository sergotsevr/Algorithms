import org.example.ListNode;
import org.example.Solution;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SolutionTest {

    public static void printList(ListNode result) {
        if (result == null) {
            System.out.println("null");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (result != null) {
            sb.append(result.val);
            if (result.next != null) {
                sb.append(" -> ");
            }
            result = result.next;
        }
        System.out.println("Result: " + sb);
    }

    // Вспомогательный метод для создания списка из массива
    private ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Вспомогательный метод для сравнения двух списков
    private boolean areListsEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    @Test
    public void testBasicAddition() {
        Solution solution = new Solution();

        // 123 + 456 = 579
        ListNode l1 = createList(new int[]{3, 2, 1}); // 123
        ListNode l2 = createList(new int[]{6, 5, 4}); // 456
        ListNode expected = createList(new int[]{9, 7, 5}); // 579

        ListNode result = solution.addTwoNumbers(l1, l2);
        assertTrue(areListsEqual(expected, result));
    }

    @Test
    public void testDifferentLength() {
        Solution solution = new Solution();

        // 999 + 1 = 1000
        ListNode l1 = createList(new int[]{9, 9, 9}); // 999
        ListNode l2 = createList(new int[]{1}); // 1
        ListNode expected = createList(new int[]{0, 0, 0, 1}); // 1000

        ListNode result = solution.addTwoNumbers(l1, l2);
        assertTrue(areListsEqual(expected, result));
    }

    @Test
    public void testWithCarry() {
        Solution solution = new Solution();

        // 85 + 15 = 100
        ListNode l1 = createList(new int[]{5, 8}); // 85
        ListNode l2 = createList(new int[]{5, 1}); // 15
        ListNode expected = createList(new int[]{0, 0, 1}); // 100

        ListNode result = solution.addTwoNumbers(l1, l2);
        assertTrue(areListsEqual(expected, result));
    }

    @Test
    public void testZeros() {
        Solution solution = new Solution();

        // 0 + 0 = 0
        ListNode l1 = createList(new int[]{0});
        ListNode l2 = createList(new int[]{0});
        ListNode expected = createList(new int[]{0});

        ListNode result = solution.addTwoNumbers(l1, l2);
        assertTrue(areListsEqual(expected, result));
    }

    @Test
    public void testSingleDigitWithCarry() {
        Solution solution = new Solution();

        // 5 + 7 = 12
        ListNode l1 = createList(new int[]{5});
        ListNode l2 = createList(new int[]{7});
        ListNode expected = createList(new int[]{2, 1}); // 12

        ListNode result = solution.addTwoNumbers(l1, l2);
        assertTrue(areListsEqual(expected, result));
    }

    @Test
    public void testLargeNumbers() {
        Solution solution = new Solution();

        // 9999999 + 9999 = 10009998
        ListNode l1 = createList(new int[]{9, 9, 9, 9, 9, 9, 9}); // 9999999
        ListNode l2 = createList(new int[]{9, 9, 9, 9}); // 9999
        ListNode expected = createList(new int[]{8, 9, 9, 9, 0, 0, 0, 1}); // 10009998

        ListNode result = solution.addTwoNumbers(l1, l2);
        assertTrue(areListsEqual(expected, result));
    }

    @Test
    public void testOneEmptyList() {
        Solution solution = new Solution();

        // 123 + 0 = 123
        ListNode l1 = createList(new int[]{3, 2, 1}); // 123
        ListNode l2 = null;
        ListNode expected = createList(new int[]{3, 2, 1}); // 123

        ListNode result = solution.addTwoNumbers(l1, l2);
        assertTrue(areListsEqual(expected, result));
    }

    @Test
    public void testBothEmptyLists() {
        Solution solution = new Solution();

        ListNode l1 = null;
        ListNode l2 = null;
        ListNode expected = null;

        ListNode result = solution.addTwoNumbers(l1, l2);
        assertTrue(areListsEqual(expected, result));
    }

    @Test
    public void testDifferentLengthWithMultipleCarries() {
        Solution solution = new Solution();

        // 999 + 1 = 1000 (уже был, но добавим другой)
        // 789 + 321 = 1110
        ListNode l1 = createList(new int[]{9, 8, 7}); // 789
        ListNode l2 = createList(new int[]{1, 2, 3}); // 321
        ListNode expected = createList(new int[]{0, 1, 1, 1}); // 1110

        ListNode result = solution.addTwoNumbers(l1, l2);
        printList(result);
        assertTrue(areListsEqual(expected, result));
    }

    @Test
    public void testVeryDifferentLength() {
        Solution solution = new Solution();

        // 1000000000 + 1 = 1000000001
        ListNode l1 = createList(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1}); // 1000000000
        ListNode l2 = createList(new int[]{1}); // 1
        ListNode expected = createList(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 1}); // 1000000001

        ListNode result = solution.addTwoNumbers(l1, l2);
        assertTrue(areListsEqual(expected, result));
    }
}
