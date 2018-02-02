package rps.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserPlayer {
    private String userName;
    private String quantity;

    public UserPlayer(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String setQuantity(RandomChoice rpsQuantity, Scanner scanner) {
        try {
            quantity = rpsQuantity.randomChoice(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Dozwolone klawisze podczas wyboru znaku: 1, 2, 3. Spróbuj jeszcze raz !");
            GameProcess.process();
        }
        return quantity;
    }

    public String getQuantity() {
        return quantity;
    }
}
