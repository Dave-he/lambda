package lambda;

import java.util.function.*;

class Dog{
	private String name = "哮天犬";

	private int food =10;

	public Dog(){

	}
	/**
	 * 带参数的构造函数
	 */
	public Dog(String name){
		this.name = name;
	}

	/**
	 * 狗叫，静态方法
	 * @param dog
	 */
	public static void bark(Dog dog){
		System.out.println(dog+"汪汪汪");
	}

	/**
	 * 吃狗粮，静态方法
	 * JDK 默认会把当前实例传入到非静态方法
	 * @return
	 */
	public int eat(int num){
		System.out.println("吃了"+num+"斤狗粮");
		this.food -= num;
		return this.food;
	}

	@Override
	public String toString(){
		return this.name;
	}
}

public class MethodRefrenceDemo {
	public static void main(String[] args) {
		//方法引用
		Consumer<String> consumer = System.out::println;
		consumer.accept("接受数据");

		//静态方法引用
		Consumer<Dog> consumer1 = Dog::bark;
		Dog dog = new Dog();
		consumer1.accept(dog);

		//非静态方法
//		Function<Integer,Integer> function = dog::eat;
//		UnaryOperator<Integer> function = dog::eat;
		IntUnaryOperator function = dog::eat;
		System.out.println("还剩下"+function.applyAsInt(2)+"斤");

		//使用类名引用方法
		//Dog::eat;
		BiFunction<Dog,Integer,Integer> eatFunction = Dog::eat;
		System.out.println("还剩下"+ eatFunction.apply(dog,2) + "斤");

		//构造函数的方法引用
		Supplier<Dog> supplier = Dog::new;
		System.out.println("创建了新对象："+supplier.get());

		//带参数的构造函数的方法引用
		Function<String,Dog> function2 = Dog::new;
		System.out.println("创建了新对象："+function2.apply("旺财"));
	}
}
