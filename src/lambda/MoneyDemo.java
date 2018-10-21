package lambda;

import java.text.DecimalFormat;
import java.util.function.Function;

class MyMoney{
	private final int money;

	public MyMoney(int money){
		this.money = money;
	}

	public void printMoney(Function<Integer,String> moneyFormat){
		System.out.println("我的存款:" +moneyFormat.apply(this.money));
	}
}

public class MoneyDemo {
	public static void main(String[] args) {
		MyMoney me = new MyMoney(9999999);
		Function<Integer, String> moneyFormat = i -> new DecimalFormat("#,###").format(i);
		me.printMoney(moneyFormat.andThen(s->"人民币"+s));
	}
}
