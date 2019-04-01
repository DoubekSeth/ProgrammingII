
public class BaseFormatter implements NumberFormatter{
	private int base = 1;
	BaseFormatter(int n) {
		base = n;
	}
	public String format(int n) {
		int counter = 0;
		while(n / base > 0) {
			n /= base;
			counter++;
		}
		return (base + "^" + (counter));
	}
}
