package lambda;

@FunctionalInterface
interface Interface1{
	int doubleNum(int i);

	default int add(int x,int y){
		return x + y;
	}
}
public class LambdaDemo {
	public static void main(String[] args) {
		Interface1 i1 = (i) -> i*2;
		Interface1 i2 = i ->i*2;
		Interface1 i3 = (int i) -> i*2;
		Interface1 i4 = (int i) ->{
			System.out.println("-----");
			return i*2;
		};

		System.out.println(i1.doubleNum(20));
		System.out.println(	i1.add(1,3));
		System.out.println(i4.doubleNum(30));

	}
}
