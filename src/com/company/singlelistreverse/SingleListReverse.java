package com.company.singlelistreverse;

/**
 * 单链表反转
 */

public class SingleListReverse {

    public static void main(String[] args) {
        ListNode listNode = initLinkedList(5);
        System.out.println("Before");
        printLinkedList(listNode);
        ListNode listNode1 = listNodeReverse(listNode);
        System.out.println("after");
        printLinkedList(listNode1);
    }

    private static ListNode listNodeReverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**打印链表**/
    private static void printLinkedList(ListNode head) {
        ListNode node = head;
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**初始化链表**/
    private static ListNode initLinkedList(int num) {
        ListNode head = new ListNode(0, null);
        ListNode cur = head;
        for(int i=1; i<num;i++){
            cur.next = new ListNode(i, null);
            cur = cur.next;
        }
        return head;
    }



    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
