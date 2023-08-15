import org.example.ListNode;
import org.example.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testSortedList() {
        Solution solution = new Solution();

        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode sorted1 = solution.sortList(head1);
        assertEquals(1, sorted1.val);
        assertEquals(2, sorted1.next.val);
        assertEquals(3, sorted1.next.next.val);
        assertNull(sorted1.next.next.next);


        ListNode head2 = new ListNode(3, new ListNode(1, new ListNode(2, null)));
        ListNode sorted2 = solution.sortList(head2);
        assertEquals(1, sorted2.val);
        assertEquals(2, sorted2.next.val);
        assertEquals(3, sorted2.next.next.val);
        assertNull(sorted2.next.next.next);


        ListNode head3 = null;
        ListNode sorted3 = solution.sortList(head3);
        assertNull(sorted3);


        ListNode head4 = new ListNode(5, null);
        ListNode sorted4 = solution.sortList(head4);
        assertEquals(5, sorted4.val);
        assertNull(sorted4.next);

        ListNode head5 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, null))));
        ListNode sorted5 = solution.sortList(head5);
        assertEquals(1, sorted5.val);
        assertEquals(2, sorted5.next.val);
        assertEquals(3, sorted5.next.next.val);
        assertEquals(4, sorted5.next.next.next.val);
        assertNull(sorted5.next.next.next.next);

        ListNode head6 = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0, null)))));
        ListNode sorted6 = solution.sortList(head6);
        assertEquals(-1, sorted6.val);
        assertEquals(0, sorted6.next.val);
        assertEquals(3, sorted6.next.next.val);
        assertEquals(4, sorted6.next.next.next.val);
        assertEquals(5, sorted6.next.next.next.next.val);
        assertNull(sorted6.next.next.next.next.next);

        System.out.println("All test cases passed.");

    }

}
