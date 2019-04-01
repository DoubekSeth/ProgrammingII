import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

class Main {
  public static void main(String[] args) {
    Random gen = new Random();
    Scanner in = new Scanner(System.in);
    int first = gen.nextInt(2);
    int smart = gen.nextInt(2);
    boolean player = false;
    boolean intel = false;
    boolean canStick = false;
    int takeaway = 0;

    if(first == 1){
      System.out.println("You go first");
      player = true;
    }

    if (smart == 1){
      System.out.println("You are screwed");
      intel = true;
    }

    int sticks = gen.nextInt(91) + 10;
    System.out.println("Sticks left: " + sticks);

    while (sticks > 1){
      int half = (int)(sticks/2);
      if(player){
        System.out.print("How many sticks do you want to remove(up to " + half +" sticks): ");
        sticks -= in.nextInt();
        player = false;
      } else if(intel){
        for(int i = 1; i <= half; i++){
          if(sticks == 3) {
            takeaway = 1;
          } else if (sticks - i == 3 || sticks - i == 7 ||      sticks - i == 15 || sticks - i == 31 || sticks - i == 63) {
            takeaway = i;
            canStick = true;
          } else if(sticks == 2) {
            takeaway = 1;
          } else {
            if(!canStick){
              takeaway = gen.nextInt(half) + 1;
            }
          }
        }
        sticks -= takeaway;
        System.out.println("Sticks left: " + sticks);
        player = true;
      } else {
        sticks -= gen.nextInt(half) + 1;
        player = true;
        System.out.println("Sticks left: " + sticks);
      }
    }
    in.close();
    if(player == false) {
      System.out.println("You win!");
    } else {
      System.out.println("You lose D:");
    }
  }
}