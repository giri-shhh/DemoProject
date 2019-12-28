package com.practice.problems.intrv;

/*Write a program to identify given linked list contains loop or not. If loop exists, then remove the loop.

The below diagram illustrates linked list loop/cycle:
In our last example, we have used Floyd’s Cycle detection algorithm to terminate when fast and slow pointers meet at a common point. We will use same approach to identify loop. Here is our approach.

We will use Floyd’s Cycle detection algorithm to identify loop and get the pointer to loop node.
Count number of nodes in the loop. Let the count be k.
Fix one pointer to the head node and another pointer to Kth node from the head.
Move both pointers at the same pace, they will meet at loop starting node.
Get the pointer to the last node of the loop and assign NULL to next value of it.
*/

public class DeleteLinkedListLoop {

	static class Node {
		int data;
		Node next;

		Node(int tmp) {
			data = tmp;
		}
	}

	public static void main(String[] a) {

		Node n1 = new Node(34);
		Node n2 = new Node(25);
		Node n3 = new Node(31);
		Node n4 = new Node(56);
		Node n5 = new Node(45);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;

		System.out.println("Loop detected: " + identifyAndDeleteLoop(n1));
		printLinkedList(n1);
	}

	static boolean identifyAndDeleteLoop(Node head) {

		/**
		 * In this method, we will keep track of two pointers. One pointer moves one
		 * step at a time and second one two steps. If both pointers are same at any
		 * iteration, then the loop exists. Then call the method to break the loop.
		 */
		Node slowMv = head;
		Node fastMv = head;
		while (slowMv != null && fastMv != null && fastMv.next != null) {
			slowMv = slowMv.next;
			fastMv = fastMv.next.next;
			if (slowMv == fastMv) {
				breakLoop(slowMv, head);
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	static void breakLoop(Node loop, Node head) {

		Node p1 = loop;
		Node p2 = loop;
		int count = 1;
		// count number of nodes on the loop
		while (p1.next != p2) {
			p1 = p1.next;
			count++;
		}
		// fix the pointer to head
		p1 = head;
		// another point is K nodes after head
		p2 = head;
		for (int i = 0; i < count; i++) {
			p2 = p2.next;
		}
		// move both pointers at same pace so that they meet at loop starting node
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		// get pointer to the last node
		while (p2.next != p1) {
			p2 = p2.next;
		}
		// set the last node next value to null
		p2.next = null;
	}

	static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}