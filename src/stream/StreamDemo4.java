package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 终止操作-Stream流编程--终止操作
 * 非短路操作 forEach/forEachOrdered
 *            collect/toArray
 *            reduce
 *            min/max/count
 * 短路操作
 *          findFirst/findAny
 *          allMatch/anyMatch/noneMatch
 */
public class StreamDemo4 {
	public static void main(String[] args) {
		String str = "my name is 007";

		//使用并行流
		str.chars().parallel().forEach(i -> System.out.print((char)i));
		System.out.println();
		//使用 forEachOrdered 保证顺序
		str.chars().parallel().forEach(i -> System.out.println((char)i));
		//收集到list
		List<String> list =  Stream.of(str.split(" ")).collect(Collectors.toList());
		System.out.println(list);

		//使用reduce拼接字符串
		Optional<String> letters =  Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);
		System.out.println(letters.orElse(""));

		//带初始化值的reduce
		String reduce = Stream.of(str.split(" ")).reduce("",(s1,s2) -> s1 + "|" + s2);
		System.out.println();

		//计算所有单词的长度
		Integer length = Stream.of(str.split(" ")).map(s -> s.length()).reduce(0, (s1,s2)->s1 + s2);
		System.out.println(length);

		//非短路操作 max使用
		Optional<String> max =  Stream.of(str.split(" ")).max((s1,s2) -> s1.length() - s2.length());
		System.out.println(max.get());

		//使用findFirst 短路操作
		OptionalInt findFirst =  new Random().ints().findFirst();
		System.out.println(findFirst.getAsInt());
	}


}
