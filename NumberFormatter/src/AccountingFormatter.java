
public class AccountingFormatter implements NumberFormatter{
	public String format(int n) {
		String ans = "";
		if(n < 0) {
			ans += "(";
			ans += n;
			ans += ")";
		} else {
			ans += n;
		}
		return ans;
	}
}
