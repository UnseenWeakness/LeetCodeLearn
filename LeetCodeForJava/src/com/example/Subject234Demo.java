package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断链表是否是回文
 */
public class Subject234Demo {
    public static void main(String[] args) {

    }

    // 双指针:先将链表数据拷贝到数组再比较
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        List<Integer> valList = new ArrayList<>();
        ListNode tempNode = head;

        while (tempNode != null) {
            valList.add(tempNode.val);
            tempNode = tempNode.next;
        }

        int p = 0, q = valList.size() - 1;
        while (p < q) {
            if (valList.get(p) != valList.get(q)) {
                return false;
            }
            p++;
            q--;
        }
        return true;
    }

    private ListNode frontPointer;

    // 通过递归栈指针
    public boolean isPalindrome2(ListNode head) {
        frontPointer = head;
       return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;

        }
        return true;

    }
}