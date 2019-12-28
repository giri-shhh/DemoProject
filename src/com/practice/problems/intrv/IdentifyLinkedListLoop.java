package com.practice.problems.intrv;

/*Write a simple code to identify loop or cycle in a linked list.

In general, the last node is null in a Linked list. A loop/cycle exists in a LinkedList when no null is reached as we traverse throughout the LinkedList.

There are various ways to identify loop/cycle in a linked list.

The below diagram illustrates linked list loop/cycle:
Approach 1: Using Hashing

Traverse the linked list nodes and keep adding the node addresses in a Hash Table.
At any point, if NULL is reached then the loop/cycle doesnot exist, return false.
If next of current node points to any of the previously stored nodes in Hash Table, then return true.
The disadvantage with above approach is it requires extra storage to keep track of hashes.

Approach 2: Floyd’s Cycle-Finding Algorithm

Traverse linked list nodes using two pointers.
Move first pointer by one step and second pointer by two step.
If the pointers meet at the same node then there is a loop.
At any point, if NULL is reached then the loop/cycle doesnot exist, return false.


*/


import java.util.HashSet;
import java.util.Set;

public class IdentifyLinkedListLoop {

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

		System.out.println("Is loop detected: " + identifyLoopV2(n1));
	}

	static boolean identifyLoopV1(Node head) {
		/**
		 * In this method, we will keep track of traversed node hash and check with each
		 * traversing node. If any match found, then we noticed Loop. If we get hash as
		 * null, then we didnt find loop.
		 */
		Set<Node> hash = new HashSet<>();
		while (head != null) {
			if (hash.contains(head)) {
				return Boolean.TRUE;
			}
			hash.add(head);
			head = head.next;
		}
		return Boolean.FALSE;
	}

	static boolean identifyLoopV2(Node head) {

		/**
		 * In this method, we will keep track of two pointers. One pointer moves one
		 * step at a time and second one two steps. If both pointers are same at any
		 * iteration, then the loop exists.
		 */
		Node slowMv = head;
		Node fastMv = head;
		while (slowMv != null && fastMv != null && fastMv.next != null) {
			slowMv = slowMv.next;
			fastMv = fastMv.next.next;
			if (slowMv == fastMv) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
}