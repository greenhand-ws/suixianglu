package com.ws.question.listnode;

/**
 * @author shun.wang
 * @description 链表相交
 * 核心：
 * 对于a来说，遍历完ListNodeA之后，从B的开头继续遍历
 * 对于b来说，遍历完ListNodeB之后，从A的开头继续遍历
 * a,b按照上述走的话，当a==b时只会有两种情况
 * 若两链表 有 公共尾部 (即 c>0c > 0c>0 ) ：指针 A , B 同时指向「第一个公共节点」node。
 * 若两链表 无 公共尾部 (即 c=0c = 0c=0 ) ：指针 A , B 同时指向 null。
 * @date 2023-12-19 17:18
 **/
public class IntersectionListNode {

    /**
     * @description
     * @author shun.wang
     * @date 2023/12/19 17:41
     * @param headA 头结点a
     * @param headB 头结点b
     * @return com.ws.question.listnode.ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        // 要么相遇即节点相等，要么都为空即无缘无分，最终都能跳出感情的死循环。
        while(curA != curB){
            // 两人以相同的速度（一次一步）沿着各自的路径走，当走完各自的路时，再“跳”至对方的路上。（起点平齐速度相同，终点即为相遇点）
            curA = (curA == null? headB:curA.next);
            curB = (curB == null? headA:curB.next);
        }
        return curA;
    }

    /**
     * @description 遍历两次找出长度差，然后让长的往后移动n位，判断是否有两个节点完全相同，第一个完全相同的就是相交节点
     * @author shun.wang
     * @date 2023/12/20 10:33
     * @param headA
     * @param headB
     * @return com.ws.question.listnode.ListNode
     */
    public ListNode getIntersectionNodeSelf(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        int lengA = 0;
        ListNode curB = headB;
        int lengB = 0;
        //找到两个长度
        while (curA != null) {
            lengA++;
            curA = curA.next;
        }
        while (curB != null) {
            lengB++;
            curB = curB.next;
        }
        //重新赋值long,short
        ListNode longNode = lengA >= lengB ? headA : headB;
        ListNode shortNode = longNode == headA ? headB : headA;
        //long后移
        int diff = Math.abs(lengA - lengB);
        while (diff > 0) {
            longNode = longNode.next;
            diff--;
        }
        //long,short同时后移
        while (longNode != null && shortNode != null) {
            if (longNode == shortNode) {
                return longNode;
            } else {
                longNode = longNode.next;
                shortNode = shortNode.next;
            }
        }
        return null;
    }
}
