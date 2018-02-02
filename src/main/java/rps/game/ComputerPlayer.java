package rps.game;

import java.util.Random;

public class ComputerPlayer {
    private String computerName;
    private String quantity;

    public ComputerPlayer(String computerName) {
        this.computerName = computerName;
    }

    public String getComputerName() {
        return computerName;
    }

    public String setQuantity(RandomChoice rpsQuantity) {
        Random random = new Random();
        quantity = rpsQuantity.randomChoice(random.nextInt(3) + 1);
        return quantity;
    }

    public String getQuantity() {
        return quantity;
    }
}
