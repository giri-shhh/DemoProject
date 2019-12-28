package com.practice.problems.intrv;

/*Problem Description:
Write a program to delete last node from the given Linked List.

In order to delete last node, we need to set the second last node's next pointer to NULL value.

Our approach is:

We should consider 3 cases here.
When head node is null, return null.
When the linked list contains only head node, then return null.
In any other case, traverse the linked list and check node.next.next must not null in loop exit condition.
Once after out of loop, set the node next reference to null and return the head node reference.
Output:
Initial linked list : 23 29 29 45 45 45 54 
Linked list after removing last node: 23 29 29 45 45 45 v
*/

public class LlRemoveLastNode {

	static class Node {
		int data;
		Node next;

		Node(int tmp) {
			data = tmp;
		}
	}

	static Node removeLastNode(Node head) {

		if (head == null || head.next == null) {
			return null;
		}
		// Find the second last node
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		// change the second last node next pointer to null
		temp.next = null;

		return head;
	}

	static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] a) {

		Node n1 = new Node(23);
		Node n2 = new Node(29);
		Node n3 = new Node(29);
		Node n4 = new Node(45);
		Node n5 = new Node(45);
		Node n6 = new Node(45);
		Node n7 = new Node(54);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		System.out.print("Initial linked list : ");
		printLinkedList(n1);
		n1 = removeLastNode(n1);
		System.out.println();
		System.out.print("Linked list after removing last node: ");
		printLinkedList(n1);
	}
}