package stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 验证stream运行机制
 *
 * 1.所有操作是链式调用,一个元素只迭代一次
 *
 * 2.每一个中间操作返回一个新的流
 * 流里面有一个属性sourceStage 执行同一个地方，就是Head
 *
 * 3.Head -> nextStage -> nextStage->...->null;
 *
 * 4.有状态操作会把无状态操作阶段，单独处理
 */

public class RunStream {
	public static void main(String[] args) {
		Random random = new Random();
		Stream<Integer> stream = Stream.generate(() -> random.nextInt())
				//产生500个(无限流需要短路操作.)
				.limit(500)
				//第1个无状态操作
				.peek(s -> System.out.println("peek:" + s))
				//第2个无状态操作
				.filter(s -> {
					System.out.println("filter:" + s);
					return s > 1000000;
				})
				.sorted((i1,i2) ->{
					System.out.println("排序:" + i1 + "," +i2);
					return i1.compareTo(i2);
				})
				.peek(s->{
					System.out.println("peek2:" + s);
				}).parallel();

				//终止操作
				stream.count();
	}
}
