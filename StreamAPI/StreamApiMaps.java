package comparatorSample;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiMaps {

	public static void main(String[] args) {
		Map<String, Integer> students = new HashMap<String, Integer>();
		students.put("Andrew", 55);
		students.put("Granger", 65);
		students.put("Rahul", 78);
		students.put("Claire", 90);
		students.put("Anna", 34);
		students.put("Emma", 88);
		students.put("Dave", 60);
		students.put("David", 98);
		students.put("Sam", 10);
		students.put("Thomas", 25);

		List<String> sortedList = students.entrySet().stream().filter(e -> e.getValue() > 60)
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).map(e -> e.getKey())
				.collect(Collectors.toList());

		System.out.println(sortedList);
	}

}
