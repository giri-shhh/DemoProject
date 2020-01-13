package com.practice.problems.StringManipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SomeProblem {

	public static void main(String[] args) {

		int max = 4500;
		List<Integer> values = Arrays.asList(7, 12, 12, 13, 14, 28, 29, 29, 30, 32, 32, 34, 41, 45, 46, 56, 61, 61, 62,
				63, 65, 68, 76, 77, 77, 92, 93, 94, 97, 103, 113, 114, 114, 120, 135, 145, 145, 149, 156, 157, 160, 169,
				172, 179, 184, 185, 189, 194, 195, 195);
		int n = values.size();
		int val = values.get(0);
		Set<Integer> s = null;
		for (int i = 0; i < (1 << n); i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < n; j++)
				if ((i & (1 << j)) > 0)
					set.add(values.get(j));
			int key = getKey(set);
			System.out.println(i+ " sum = "+ key);
			if (key > val && key <= max) {
				val = key;
				s = set;
				if (key == max)
					break;
			}
		}

		System.out.println(
				"Size = " + val + ", Values = " + s.stream().map(values::indexOf).collect(Collectors.toList()));
		/*
		 * 
		 * Set<Entry<Integer, Set<Integer>>> entrySet = map.entrySet().; for (int i = 0;
		 * i < entrySet.size(); i++) { if (collect.get(i) > max) { Integer key =
		 * collect.get(i - 1); System.out.println("Size = " + map.get(key).size() +
		 * ", Values = " +
		 * map.get(key).stream().map(values::indexOf).collect(Collectors.toList()));
		 * break; } }
		 */ }

	private static int getKey(Set<Integer> set) {
		return set.stream().mapToInt(Integer::intValue).sum();
	}
}
