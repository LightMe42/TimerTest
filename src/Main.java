import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean isMatched = false;
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello! I'll try to guess any your number \n" +
                            "During the guessing process I'll count seconds for you");
        System.out.println("Please, input any number from 0 to 1000000000");
        int yourNumber = 0;
        try {
            yourNumber = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        //int randomNumber =(int) (Math.random() * 1_000_000_000);
        //System.out.println("I guess number: " + randomNumber);
        Thread timer = new Thread(() -> {
            int i = 0;
            try {
                while (!isMatched) {
                    System.out.println("timer: " + i + " seconds");
                    i++;
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        timer.start();
        int finalYourNumber = yourNumber;
        Thread guess = new Thread(new Runnable() {
            int guessNumber;
            @Override
            public void run() {
                while (!isMatched) { 
                   guessNumber = (int) (Math.random() * 1_000_000_000);
                   if (guessNumber == finalYourNumber) {
                       isMatched = true;
                       System.out.println("I'm Done! Your number is: " + guessNumber);
                   }
                }
            }
        });
        guess.start();
    }
}
