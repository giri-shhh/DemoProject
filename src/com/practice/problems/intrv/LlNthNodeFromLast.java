package com.practice.problems.intrv;

/*Problem Description:
Write a program to identify Nth node from the end of Linked List.

We have two approaches to identify Nth node from the end.

In First Approach:

First iterate through linked list and identify length.
Then again iterate (lenght-N) nodes from from head node.
The Node after the above iteration is the Nth node from the end.
In Second Approach:

We will define two temp Node references and they will be initially pointed to head node.
The two temp nodes are called as reference node & main node.
First iterate reference node to N nodes.
Then iterate both temp nodes one step at a time, till reference node is null.
Once after the above iteration, the main node represents the Nth node from the end node.
*/

public class LlNthNodeFromLast {

	static class Node {
		int data;
		Node next;

		Node(int tmp) {
			data = tmp;
		}
	}

	static Node findNthNodeFromLastV1(Node head, int n) {

		/**
		 * In this approach, first identify the length of the list. Then do lenght-n
		 * iterations from head to reach nth node from last.
		 */
		int length = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			length++;
		}
		System.out.println("length: " + length);
		for (int i = 0; i < length - n; i++) {
			head = head.next;
		}
		return head;
	}

	static Node findNthNodeFromLastV2(Node head, int n) {

		/**
		 * In this approach, we will use two pointers like refNode & mainNode First we
		 * will traverse refNode by n times. Then we will traverse both nodes one step
		 * at a time till refNode reaches null The mainNode is the one we are looking
		 * for.
		 */
		Node refNode = head;
		Node mainNode = head;
		if (head == null) {
			return null;
		}
		for (int i = 0; i < n; i++) {
			if (refNode == null) {
				System.out.println("The n input size is more than linked list size");
				return null;
			}
			refNode = refNode.next;
		}

		while (refNode != null) {
			mainNode = mainNode.next;
			refNode = refNode.next;
		}

		return mainNode;
	}

	public static void main(String[] a) {

		Node n1 = new Node(23);
		Node n2 = new Node(29);
		Node n3 = new Node(69);
		Node n4 = new Node(85);
		Node n5 = new Node(40);
		Node n6 = new Node(45);
		Node n7 = new Node(54);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		Node nthNode = findNthNodeFromLastV2(n1, 3);
		System.out.println("Nth node value: " + nthNode.data);
	}
}