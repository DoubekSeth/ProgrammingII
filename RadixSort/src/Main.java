import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> sampleArray = new ArrayList<>();
		int[] addToSample = {100, 2, 512, 92, 999, 15, 49, 613};
		sampleArray = addToArray(addToSample);
		System.out.println(radixSort(sampleArray).toString());
	}
	
	//Takes in an arrayList and sorts it, to do numbers over 999 change largest.
	public static ArrayList<Integer> radixSort(ArrayList<Integer> arrayIn) {
		int largest = 3;
		int digit = 1;
		ArrayList<Integer> tempArray = new ArrayList<>();
		
		while(digit <= largest) {
			
			for(int i = 0; i < arrayIn.size(); i++) {
				int currentNum = digitGet(arrayIn.get(i), digit);				
				boolean finalAdd = true;
				for(int j = 0; j < tempArray.size(); j++) {
					if(digitGet(tempArray.get(j), digit) > currentNum) {
						tempArray.add(j, arrayIn.get(i));
						finalAdd = false;
						break;
					}
				}
				if(finalAdd) {
					tempArray.add(arrayIn.get(i));
				}
			}
			
			arrayIn = tempArray;
			tempArray = new ArrayList<>();
			digit++;
		}
		return arrayIn;
	}
	
	//Takes in a number n and gets what the number is at a certain digit
	public static int digitGet(int n, int digit) {
		return (int) ((n %  (Math.pow(10, digit)))/(Math.pow(10, digit-1)));
	}
	
	//Me being garbage at arraylists
	public static ArrayList<Integer> addToArray(int[] input) {
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i = 0; i < input.length; i++) {
			answer.add(input[i]);
		}
		return answer;
	}
}
