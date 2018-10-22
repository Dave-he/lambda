package stream;

import java.util.Random;
import java.util.stream.Stream;

public class StreamDemo3 {
	public static void main(String[] args) {
		String str = "my name is 007";

		//打印每个单词长度
		Stream.of(str.split(" ")).filter(s -> s.length() > 2)
			.map(s -> s.length()).forEach(System.out::println);

		//flatMap A->B属性(是个集合)，最终得到所有的A元素里面所有B属性集合
		//intStream/longStream 并不是Stream的子类，所以要进行装箱boxed
		Stream.of(str.split(" ")).flatMap(s ->s.chars().boxed())
				.forEach(
				i-> System.out.println((char)i.intValue()));

		new Random().ints().filter(i -> i > 100 && i < 1000).limit(10).forEach(System.out::println);
	}
}
