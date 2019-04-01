
public class Main {

	public static void main(String[] args) {
		//Array
		int[] numArray = {10, 20, 30, 40, 50, 100000};
		//All the classes
		DefaultFormatter defaultformat = new DefaultFormatter();
		AccountingFormatter accountingformat = new AccountingFormatter();
		DecimalSeparatorFormatter decimalsep = new DecimalSeparatorFormatter();
		BaseFormatter baseformat = new BaseFormatter(3);
		
		//All the method calls
		System.out.println(defaultformat.format(200));
		System.out.println(accountingformat.format(200));
		System.out.println(decimalsep.format(1));
		//Only works for perfect ones, otherwise returns lowest value
		System.out.println(baseformat.format(27));
		
		arrayPrinter(numArray, decimalsep);
	}
	
	static void arrayPrinter(int[] n, NumberFormatter k) {
		for(int i : n) {
			System.out.println(k.format(i));
		}
	}

}
