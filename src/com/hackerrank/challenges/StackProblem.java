package com.hackerrank.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StackProblem {
	private static final Map<Character, Character> map = new HashMap<>();

	static {
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag;
		while (sc.hasNext()) {
			flag = true;
			Stack<Character> stack = new Stack<>();
			String input = sc.next();
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (map.containsValue(c)) {
					stack.push(c);
				} else if (map.containsKey(c)) {
					if (stack.isEmpty() || !map.get(c).equals(stack.pop()))
						flag = false;
				}
			}
			System.out.println(flag && stack.isEmpty());
		}
	}
}
