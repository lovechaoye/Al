package org.example.linkList;

import com.sun.istack.internal.NotNull;

/**
 * ReverseLinkList class
 *
 * @author lichao
 * @date 2020/3/3
 */
public class ReverseLinkList {


    public static void main(String[] args) {
        ListNode list1 = create(10, 19);
        print(list1);
        System.out.println("*********************************************************");
        ListNode list2 = create(15, 1);
        print(list2);
        System.out.println("*********************************************************");
        mergeLinkList(list1,list2);
        print(list1);
    }

    static void test(){
        ListNode node1 = new ListNode();
        node1.value = 1;
        ListNode node2 = new ListNode();
        node2.value = 2;
        ListNode node3 = new ListNode();
        node3.value = 3;
        ListNode node4 = new ListNode();
        node4.value = 4;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head = node1;
        ListNode next = head.next;
        head.next = null;
        ListNode listNode = recursiveReverseList(head, next);
        print(listNode);
        System.out.println("*********************************************************");
        print(reverseList(listNode));


        mergeLinkList(null,null);
    }

    static ListNode create(int size,int randomValue){
        ListNode head = null;
        ListNode tmp = null;
        for (int i = 0; i < size; i++) {
            ListNode node = new ListNode();
            node.value = randomValue++;
            node.next = null;
            if(head == null){
                head = node;
                tmp = head;
                continue;
            }
            tmp.next = node;
            tmp = node;
        }
        return head;
    }

    static void print(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print (tmp.value +" ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    static ListNode reverseList(ListNode head) {
        ListNode first = head;
        ListNode second = first.next;

        if (second == null) {
            return first;
        }
//        ListNode next3 = node2.next;
//        node2.next=node1;
//        if(next3 ==null){
//            return node2;
//        }
//
//        ListNode next4 = next3.next;
//        next3.next = node2;
//        if(next4 ==null){
//            return next3;
//        }
        ListNode ret = null;
        while (true) {
            ListNode third = second.next;
            second.next = first;
            if (third == null) {
                ret = second;
                break;
            }
            first = second;
            second = third;
        }
        head.next = null;
        return ret;
    }

    /**
     *
     * @param left 上一个已经被修改过的节点,主要用于作为下一个未修改的节点的上一个节点
     * @param right 下一个未修改的节点
     * @return 新的数组开头
     */
    static ListNode recursiveReverseList(ListNode left,ListNode right){
        if(right==null){
            return left;
        }
        ListNode next = right.next;
        right.next = left;
        return recursiveReverseList(right,next);
    }

    /**
     * 插空合并两个链表
     * @param head1
     * @param head2
     */
    static void mergeLinkList(@NotNull ListNode head1, @NotNull ListNode head2){
        if(head1 ==null){
            return;
        }
        if(head2 ==null){
            return;
        }
        ListNode next1 = head1.next;
        ListNode next2 = head2.next;
        head1.next =head2;
        if(next1!=null){
            head2.next=next1;
            mergeLinkList(next1,next2);
        }
    }
}
