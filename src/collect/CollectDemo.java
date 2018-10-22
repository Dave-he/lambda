package collect;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 性别
 */
enum Gender {
	MALE,FEMALE
}

/**
 * 班级
 */
enum Grade {
	ONE,TWO,THREE,FOUR
}

class Student{
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 性别
	 */
	private Gender gender;
	/**
	 * 班级
	 */
	private Grade grade;

	public Student(String name, int age, Gender gender, Grade grade) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "[name=" + name +",age="+ age + ",gender=" +gender + ",grade=" + grade +"]";
	}
}

public class CollectDemo {
	public static void main(String[] args) {
		//测试数据
		List<Student> students = Arrays.asList(
				new Student("小明",10,Gender.MALE,Grade.ONE),
				new Student("大明",9,Gender.MALE,Grade.THREE),
				new Student("阿猫",3,Gender.FEMALE,Grade.TWO),
				new Student("阿狗",2,Gender.FEMALE,Grade.ONE),
				new Student("大熊",1,Gender.FEMALE,Grade.TWO),
				new Student("静香",9,Gender.MALE,Grade.THREE),
				new Student("野比",5,Gender.MALE,Grade.TWO),
				new Student("丘吉尔",9,Gender.MALE,Grade.THREE),
				new Student("马克思",6,Gender.FEMALE,Grade.THREE),
				new Student("张三",7,Gender.MALE,Grade.TWO),
				new Student("克里斯",8,Gender.MALE,Grade.THREE));

		//得到所有学生的年龄列表
		//s-> s.getAge() --> Student::getAge,不会多生成一个类似lambda$0这样的函数
		//list - set去重 默认hashset
		Set<Integer> ages = students.stream().map(Student::getAge)
				.collect(Collectors.toSet());
		System.out.println("所有学生的年龄："+ages);

		//统计汇总信息
		IntSummaryStatistics agesSummaryStatistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));
		System.out.println("年龄汇总信息："+agesSummaryStatistics);

		//分块
		Map<Boolean,List<Student>> genders = students.stream().
				collect(Collectors.partitioningBy(s -> s.getGender() == Gender.MALE));
		System.out.println("男女学生列表：" + genders);

		//分组
		Map<Grade,List<Student>> grades = students.stream().collect(Collectors.groupingBy(Student::getGrade));
		System.out.println("学生班级列表：" + grades);

		//得到所有班级学生的个数
		Map<Grade,Long> gradesCount = students.stream().collect(Collectors.groupingBy(Student::getGrade,Collectors.counting()));
		System.err.println("班级学生个数列表" + gradesCount);
	}

}
