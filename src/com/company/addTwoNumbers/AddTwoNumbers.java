package com.company.addTwoNumbers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

public class AddTwoNumbers {


    //https://leetcode-cn.com/problems/add-two-numbers/
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(9);
        list1.add(9);
        list1.add(9);
        list1.add(9);
        list1.add(9);
        list1.add(9);
        list1.add(9);
        List<Integer> list2 = new ArrayList<>();
        list2.add(9);
        list2.add(9);
        list2.add(9);
        list2.add(9);
        addTwoNumbers(buildListNode(list1), buildListNode(list2));
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;//两数相加以后的进位
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }

    /**
     * 自己实现的，在数字很大的时候会在transform2Number方法出现数据解析问题。数据溢出
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        List<Integer> list2 = new ArrayList<>();
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        if (list2.size() != list1.size()) {
            int size = Math.max(list2.size(),list1.size());
            for (int i = 0; i < size; i++) {
                try {
                    list1.get(i);
                }catch (IndexOutOfBoundsException e) {
                    list1.add(i,0);
                }

                try {
                    list2.get(i);
                }catch (IndexOutOfBoundsException e) {
                    list2.add(i,0);
                }
            }
        }
        Collections.reverse(list1);
        Collections.reverse(list2);
        long n1 = transform2Number(list1);
        long n2 = transform2Number(list2);
        long n3 = n2 + n1;
        String strN = n3 + "";
        List<Long> list4 = new ArrayList<>();
        if (n3 == 0) {
            list4.add(0l);
        }else {
            while (n3 > 0) {
                list4.add(n3%10);
                n3 = n3/10;
            }
        }
        //Collections.reverse(list4);
        List<Integer> list3 = new ArrayList<>();
        for (char c : strN.toCharArray()) {
            list3.add(Integer.parseInt(c + ""));
        }
        ListNode tmp = buildListNode(list3);
        return tmp;
    }

    private static long transform2Number(List<Integer> list) {
        StringBuilder sb = new StringBuilder(list.size());
        for (Integer integer : list) {
            sb.append(integer);
        }
        return Long.parseLong(sb.toString());
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public String toStringNode(ListNode listNode) {
            StringBuilder sb = new StringBuilder();
            while (listNode != null) {
                sb.append(listNode.val);
                listNode = listNode.next;
            }
            return "{"+ sb.toString()+"}";
        }
    }

    /**
     *  final Node<E> l = last;
     *         final Node<E> newNode = new Node<>(l, e, null);
     *         last = newNode;
     *         if (l == null)
     *             first = newNode;
     *         else
     *             l.next = newNode;
     *
     * @param list
     * @return
     */
  private static ListNode buildListNode(List<Integer> list) {
      ListNode head = null;
      ListNode nextNode = null;
      for (Integer integer : list) {
          final ListNode newNode = new ListNode(integer);
          if (head == null){
              head = nextNode = newNode;
          }else {
              nextNode.next = newNode;
              nextNode = newNode;
          }
      }
      nextNode = head;
      String s = nextNode.toStringNode(nextNode);
      return head;
  }

}
