package 链表;


public class 两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // 哨兵节点
        ListNode cur = dummy;
        int carry = 0; // 进位
        while (l1 != null || l2 != null || carry != 0) { // 有一个不是空节点，或者还有进位，就继续迭代
            if (l1 != null) carry += l1.val; // 节点值和进位加在一起
            if (l2 != null) carry += l2.val; // 节点值和进位加在一起
            cur = cur.next = new ListNode(carry % 10); // 每个节点保存一个数位
            carry /= 10; // 新的进位
            if (l1 != null) l1 = l1.next; // 下一个节点
            if (l2 != null) l2 = l2.next; // 下一个节点
        }
        return dummy.next; // 哨兵节点的下一个节点就是头节点
    }
}
