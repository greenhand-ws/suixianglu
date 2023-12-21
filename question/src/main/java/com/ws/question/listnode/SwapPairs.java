package com.ws.question.listnode;

/**
 * @description 两两交换链表中的节点
 * @author shun.wang
 * @date 2023-12-19 15:19
 **/
public class SwapPairs {
    /**
     * @description
     * @author shun.wang
     * @date 2023/12/19 15:20
     * @param head
     * @return com.ws.question.listnode.ListNode
     */
    public ListNode swapPairs(ListNode head) {
        //虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode cur = dummyNode;
        ListNode tmp;//第三个节点
        ListNode firstNode;//第一个节点
        ListNode secondNode;//第二个节点

        //第一次遍历：cur为dummyNode  然后firstNode secondNode tem分别为第一，第二，第三个节点
        while (cur.next != null && cur.next.next != null) {
            tmp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = tmp;
            firstNode.next = tmp;
            cur = firstNode;
        }
        return dummyNode.next;
    }
}
