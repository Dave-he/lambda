package lambda;

import java.io.InputStream;
import java.util.stream.IntStream;

public class MinDemo {
	public static void main(String[] args) {
		int[] nums = {33,55,-55,90,-666,90};

		long startTime1=System.currentTimeMillis();
		int min = Integer.MAX_VALUE;
		for (int i: nums) {
			if (i< min){
				min = i;
			}
		}
		long endTime1=System.currentTimeMillis();
		long Time1=endTime1-startTime1;
		System.out.println(min);
		System.out.println(Time1);

		long starTime=System.currentTimeMillis();
		int min2 = IntStream.of(nums).parallel().min().getAsInt();
		long endTime=System.currentTimeMillis();
		long Time=endTime-starTime;
		System.out.println(min2);
		System.out.println(Time);


	}
}
