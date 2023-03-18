import easy.TwoSum;
import medium.AddTwoNumbers;
import medium.ListNode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        System.out.println(addTwoNumbers.addTwoNumbers(l1, l2));
    }

}