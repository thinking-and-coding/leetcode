package solution;

public class Solution2 {
    /*
    本题的关键在于每步对链表的操作都是重复的
    因此用while循环来进行，另一个问题是开始状态和结束条件的判断问题
    使用虚拟头结点作为开始的状态，结束条件需要注意进位为1的情况，
    另一个需要注意的问题是原来两个链表的指针需要移动到next
    */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode node1 = new ListNode(0);
        ListNode curNode = node1;
        while (l1 != null || l2 != null || carry != 0) {
            int i1 = 0;
            int i2 = 0;
            if (l1 != null) {
                i1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                i2 = l2.val;
                l2 = l2.next;
            }
            int temp = i1 + i2 + carry;
            if (temp > 9) {
                carry = 1;
                curNode.next = new ListNode(temp - 10);
            } else {
                carry = 0;
                curNode.next = new ListNode(temp);
            }
            curNode = curNode.next;
        }
        return node1.next;
    }

}
