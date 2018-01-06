package com.lk.leetcode;

/**
 * leetcode 2
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * 1. 自己第一次给出的方案没有考虑值超过long型,有case不通过
 *
 * @author 陆昆
 * @create 2018-01-06 下午3:43
 **/
public class AddTwo {
    public static void main(String[] args) {
        System.out.println(addTwoNumbers(geneNode(1),geneNode(99)));
        //System.out.println(geneNum(geneNode(123)));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int count = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = (val1 + val2 + count) % 10;
            count = (val1 + val2 + count) / 10;
            temp.next = new ListNode(val);
            temp = temp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (count > 0) {
            temp.next = new ListNode(count);
        }
        return result.next;
    }

    public static void  addNode(ListNode result, int val) {
        if (result == null) {
            result = new ListNode(val);
        } else {
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.setNext(new ListNode(val));
        }
    }

    public static long geneNum(ListNode l) {
        long result = 0L;
        int i = 1;
        while (l != null) {
            result += l.val * i;
            i *= 10;
            l = l.next;
        }
        return result;
    }

    public static ListNode geneNode(long num) {
        ListNode result = null;
        ListNode temp = null;
        if (num == 0) {
            return new ListNode(0);
        }
        while (num > 0) {
            ListNode node = new ListNode((int)(num % 10));
            if (result == null) {
                result = node;
                temp = result;
            } else {
                temp.setNext(node);
                temp = temp.next;
            }
            num /= 10;
        }
        return result;
    }


}

class ListNode {
    int val;

    ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        while (next != null) {
            sb.append("-> ");
            sb.append(next.val);
            next = next.next;
        }
        return sb.toString();
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }
}
