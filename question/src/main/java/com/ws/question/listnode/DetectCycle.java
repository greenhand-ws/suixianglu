package com.ws.question.listnode;

/**
 * @author shun.wang
 * @description 环形链表
 * @date 2023-12-20 11:05
 **/
public class DetectCycle {
    /**
     * @description
     * @author shun.wang
     * @date 2023/12/20 11:06
     * @param head 头结点
     * @return com.ws.question.listnode.ListNode
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            //相遇的时候
            if (fastNode == slowNode) {
                ListNode cur = head;
                ListNode meet = fastNode;
                while (cur != meet) {
                    cur = cur.next;
                    meet = meet.next;
                }
                return meet;
            }
        }
        return null;
    }
}
