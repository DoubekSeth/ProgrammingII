
public class DecimalSeparatorFormatter implements NumberFormatter {
	public String format(int n) {
		String reverseAns = "";
		String ans = "";
		int count = 1;
		for(int i = Integer.toString(n).length()-1; i > -1; i--) {
			reverseAns += Integer.toString(n).charAt(i);
			if(count%3 == 0 && i != 0) {
				reverseAns += ",";
			}
			count++;
		}
		
		for(int i = reverseAns.length()-1; i > -1; i--) {
			ans += reverseAns.charAt(i);
		}
		return ans;
	}
}
