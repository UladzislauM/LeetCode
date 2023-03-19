package medium.addTwoNumbers;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode0 = new ListNode(0);
        ListNode sumNode = sumNode0;
        int ten = 0;
        while (l1 != null || l2 != null || ten != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = ten + x + y;
            ten = sum / 10;
            sumNode.next = new ListNode(sum % 10);
            sumNode = sumNode.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return sumNode0.next;
    }
}
