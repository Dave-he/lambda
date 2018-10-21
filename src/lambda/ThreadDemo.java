package lambda;

public class ThreadDemo {
	public static void main(String[] args) {
		Object target = new Runnable() {
			@Override
			public void run() {
				System.out.println("ok");
			}
		};
		new Thread((Runnable) target).start();

		//jdk8 lambda
		Object target1 = (Runnable)() -> System.out.println("ok");
		Runnable target2 = () -> System.out.println("ok");
		new Thread((Runnable) target1).start();
		System.out.println(target1 == target2);
	}
}
