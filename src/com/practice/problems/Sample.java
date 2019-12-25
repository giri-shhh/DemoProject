package com.practice.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sample {

    public static void main(String[] args) {

        List<String> words1 = Arrays.asList("House", "Sector", "Block", "Tower", "Apartment");

        Map<String, Value> map = new HashMap<>();

        List<String> words = Arrays.asList("University", "College", "Class", "Student");

        /*map.put(words.get(0), new Value(8, words.get(1)));
        map.put(words.get(1), new Value(10, words.get(2)));
        map.put(words.get(2), new Value(24, words.get(3)));
        map.put(words.get(3), new Value(300, words.get(4)));
        map.put(words.get(4), new Value(0, words.get(0)));
*/
        map.put(words.get(0), new Value(6000, words.get(3)));
        map.put(words.get(1), new Value(600, words.get(3)));
        map.put(words.get(2), new Value(60, words.get(3)));
        map.put(words.get(3), new Value(6, words.get(3)));

        for (int i = 0; i < words.size() - 1; i++) {
            String word = words.get(i);
            if (i == 0) {
                System.out.print("1 " + word + " = " + map.get(word).getValue() + " " + map.get(word).getRelation());
            } else {
                Value value = map.get(word);
                Integer value1 = value.getValue();
                value1 *= map.get(words.get(i - 1)).getValue();
                System.out.print(" = " + value1 + " " + value.getRelation());
            }
        }
    }
}

class Value {
    private Integer value;
    private String relation;

    Value(Integer value, String relation) {
        this.value = value;
        this.relation = relation;
    }

    public Integer getValue() {
        return value;
    }

    public String getRelation() {
        return relation;
    }

    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                ", relation='" + relation + '\'' +
                '}';
    }
}
