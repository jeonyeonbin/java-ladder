package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

	public static long countWords() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
			.get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
		return Arrays.stream(contents.split("[\\P{L}]+"))
			.filter(word -> word.length() > 12)
			.count();
	}

	public static List<String> printLongestWordTop100() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
			.get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		// TODO 이 부분에 구현한다.
		return words.stream()
			.filter(word -> word.length() > 12)
			.sorted(Comparator.comparingInt(String::length))
			.distinct()
			.limit(100)
			.map(String::toLowerCase)
			.collect(Collectors.toList());
	}

	public static List<Integer> doubleNumbers(List<Integer> numbers) {
		return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
	}

	public static long sumAll(List<Integer> numbers) {
		return numbers.stream().reduce(0, (x, y) -> x + y);
	}

	public static long sumOverThreeAndDouble(List<Integer> numbers) {
		return numbers.stream()
			.filter(number -> number > 3)
			.map(number -> number * 2)
			.reduce(0, (acc, cur) -> acc + cur);
	}
}