// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ReverseLinkList.java

package org.example.linkList;

import java.io.PrintStream;

// Referenced classes of package org.example.linkList:
//			ListNode

public class ReverseLinkList
{

	public ReverseLinkList()
	{
	}

	public static void main(String args[])
	{
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
		mergeLinkList(null, null);
	}

	static void print(ListNode head)
	{
		for (ListNode tmp = head; tmp != null; tmp = tmp.next)
			System.out.println(tmp.value);

	}

	static ListNode reverseList(ListNode head)
	{
		ListNode first = head;
		ListNode second = first.next;
		if (second == null)
			return first;
		ListNode ret = null;
		do
		{
			ListNode third = second.next;
			second.next = first;
			if (third == null)
			{
				ret = second;
				break;
			}
			first = second;
			second = third;
		} while (true);
		head.next = null;
		return ret;
	}

	static ListNode recursiveReverseList(ListNode left, ListNode right)
	{
		if (right == null)
		{
			return left;
		} else
		{
			ListNode next = right.next;
			right.next = left;
			return recursiveReverseList(right, next);
		}
	}

	static void mergeLinkList(ListNode head1, ListNode head2)
	{
		ListNode next1 = head1.next;
		ListNode next2 = head2.next;
		head1.next = head2;
		head2.next = next1;
		mergeLinkList(next1, next2);
	}
}
