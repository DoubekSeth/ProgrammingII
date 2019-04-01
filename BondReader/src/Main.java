import java.util.Scanner;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner getInput = new Scanner(System.in);
		System.out.println("What would you like to look up: ");
		String in = getInput.next();
		try {
			searchInfo(in);
		} catch (FileNotFoundException exception) {
			System.out.println("File wasn't found D:");
		}
		System.out.println("I forgot to transfer all of the interactivites off of the school computer so I'll turn them in once I get back. Sorry about that, hope you have a Merry Christmas!");
		getInput.close();
	}
	
	public static void searchInfo(String toFind) throws FileNotFoundException {
		Scanner txtReader = new Scanner(new File("Info.txt"));
		String name;
		String bondEnergy;
		String bondLength;
		boolean found = false;
		
		while(txtReader.hasNext()) {
			name = txtReader.next();
			bondEnergy = txtReader.next();
			bondLength = txtReader.next();
			if(toFind.equals(name)) {
				System.out.println("Bond Energy: " + bondEnergy);
				System.out.println("Bond Length: " + bondLength);
				found = true;
			} else if(toFind.equals(bondEnergy)) {
				System.out.println("Name: " + name);
				System.out.println("Bond Length: " + bondLength);
				found = true;
			} else if(toFind.equals(bondLength)) {
				System.out.println("Name: " + name);
				System.out.println("Bond Energy: " + bondEnergy);
				found = true;
			}
		}
		if(!found) {
			System.out.println("Something went wrong, perhaps what you inputted wasn't in the data");
		}
		txtReader.close();
	}
}
