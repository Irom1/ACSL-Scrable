import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("\nACSL Scrabble Scorer by Mori\n");
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the word (or hit ENTER to use test set): ");
    String word = input.nextLine();
    if (word.equals("")) {
      word = "J, A, V, A";
      Scrabble game = new Scrabble(word);
      System.out.println(game.playPositions("1, H, 11, H, 21, H"));
      System.out.println(game.playPositions("1, V, 2, V, 3, V"));
      System.out.println(game.playPositions("2, H, 12, H, 22, H"));
      System.out.println(game.playPositions("3, V, 4, V, 5, V"));
      System.out.println(game.playPositions("7, H, 6, V, 17, H"));
    } else {
      Scrabble game = new Scrabble(word);
      for (int i = 0; i < 5; i++) {
        System.out.print("Enter the position and orientation: ");
        String positions = input.nextLine();
        System.out.println(game.playPositions(positions));
      }
    }
    input.close();
  }
}
