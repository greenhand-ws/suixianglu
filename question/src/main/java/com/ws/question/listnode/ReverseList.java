package com.ws.question.listnode;

/**
 * @description: 反转链表
 * @author: shun.wang
 * @create: 2023-12-19 14:43
 **/
public class ReverseList {
    /**
     * @descriptions：
     * 核心（难点）：就是你处理某个节点的时候，需要知道当前节点的前一个节点，后一个节点
     * 所以代码里面实现了个cur  前一个pre   后一个next
     * 自己实现的时候加了个虚拟头结点
     * @author shun.wang
     * @date 2023/12/19 14:46
     * @param head
     * @return com.ws.question.listnode.ListNode
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next=pre;
            pre=cur;
            cur = next;
        }
        return pre;
    }
}
