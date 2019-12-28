package com.practice.problems.intrv;

/*
Problem Description:
Write a simple code to identify middle element from given linked list.

Our approach is:

We can identify the middle element based on the lenght of the Linked list. But we cannot find the middle index until we traverse through Linked list and count the length. There are two ways to solve this problem.

First Approach:

We will traverse twice over linked list in this approach.
In first traversal, we will count the length.
Identify middle index from the length.
In the second traversal, go to the number of nodes based on middle index and get the node data.
Second Approach:

We will manage two temp nodes and traverse through Linked list once.
We will increment first temp node once and second temp node twice until we reach end of the linked list.
At the end of the traversal, the first temp node represents middle index.
*/

public class LinkedListMiddleElement {

	static class Node {
		int data;
		Node next;

		Node(int tmp) {
			data = tmp;
		}
	}

	static void findMiddleElementV1(Node head) {
		/**
		 * In this method, first we get the element count by traversing through the
		 * linked list. Then we identify middle element index by count. Then traverse
		 * through linked list nodes based on count.
		 */

		int count = 0;
		Node countNode = head;
		while (countNode != null) {
			countNode = countNode.next;
			count++;
		}
		count = count / 2;
		while (head != null) {
			head = head.next;
			count--;
			if (count == 0) {
				System.out.println("Middle Element: " + head.data);
				return;
			}
		}
	}

	static void findMiddleElementV2(Node head) {

		/**
		 * In this approach, we will have two node references. First node, we increment
		 * by two steps Second node, we increment ny one step. At the end we get the
		 * middle element ny second node.
		 */
		Node singIncNode = head;
		Node doubIncNode = head;
		if (head == null) {
			System.out.println("The haed node is null, no elements in the linked list");
		}

		while (doubIncNode != null && doubIncNode.next != null) {
			doubIncNode = doubIncNode.next.next;
			singIncNode = singIncNode.next;
		}
		System.out.println("Middle Element: " + singIncNode.data);
	}

	public static void main(String a[]) {

		Node n1 = new Node(10);
		Node n2 = new Node(29);
		Node n3 = new Node(20);
		Node n4 = new Node(25);
		Node n5 = new Node(10);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		findMiddleElementV2(n1);
	}
}