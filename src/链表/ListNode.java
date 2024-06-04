package 链表;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ListNode {

    int val;
    ListNode next;

    public ListNode(int i) {
        this.val=i;
    }
}
