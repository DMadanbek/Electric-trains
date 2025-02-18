import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
            Scanner input = new Scanner(System.in);
            System.out.println("Put path to your file:"); // taking path to file
            String path = input.nextLine();
            File obj = new File(path);
            Scanner myReader = new Scanner(obj);
            String line = myReader.nextLine();
            String[] words = line.split(" "); //taking array of words from file
            Random rnd = new Random();
            int randomNumber = rnd.nextInt(100);
            String playerWord = words[randomNumber]; //taking random word from array
            playerWord = playerWord.toLowerCase();
            int score = 0;
            String und = playerWord.replaceAll("[A-Za-z]", "_");
            char[] ch = und.toCharArray(); //taking char array with undersocres
            String man = """
                      _______   
                     |       | 
                     |       O 
                     |      /|\\
                     |      / \\
                     |
                     |___
                    
                    """;
            int imageMan = man.length();
            int partManDead = 11;
            //the length is equal to 66 so i decided to adding 11 every incorrect guesse, hence player have 6 lives


        System.out.println(und);
            while(score<playerWord.length()) {
                System.out.print('\n');
                String guess = input.nextLine();
                char letter = guess.charAt(0);
                //player can guess entire word
                if(guess.length()>1){
                    if(guess.equals(playerWord)){
                        System.out.println("""
                                
                                  ___________
                                 /           \\
                                | I am alive! |
                                 \\___________/
                                   / 
                                  O
                                 /|\\
                                 / \\
                                """);

                        System.out.println("You win!");
                        break;

                    }

                }
                else{
                    // checking that player guessed letter correct
                if(playerWord.contains(String.valueOf(letter))) {

                    for (int i = 0; i < playerWord.length(); i++) {
                        if (letter == playerWord.charAt(i)) {
                            ch[i] = playerWord.charAt(i);
                            score++;
                        }


                    }

                    for (int i = 0; i < ch.length; i++) {

                        System.out.print(" " + ch[i]);
                    }
                }

                else {

                    System.out.println("Wrong answer!");
                    for (int i = 0; i < partManDead; i++) {
                        System.out.print(man.charAt(i));
                    }
                    partManDead = partManDead +11; //drawing part of hangman
                }

                if(partManDead==imageMan) {
                    System.out.println();
                    System.out.println("You loose!");
                    System.out.println("Full word:" + playerWord);
                    break;
                }
                if (score == playerWord.length()) {
                    System.out.println();
                    System.out.println("""
                            
                              ___________
                             /           \\
                            | I am alive! |
                             \\___________/
                               / 
                              O
                             /|\\
                             / \\
                            """);
                    System.out.println("You win!");
                }
                }
            }




    }
}
