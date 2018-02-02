package rps.game;

public class GeneralScore {
    private int userScore = 0;
    private int computerScore = 0;
    private int numberOfRounds;

    public int getUserScore() {
        return userScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }


    public void generalScore(UserPlayer user, ComputerPlayer computer) {
        if ((user.getQuantity().equals("kamień") && computer.getQuantity().equals("nożyce")) ||
                (user.getQuantity().equals("nożyce") && computer.getQuantity().equals("papier")) ||
                (user.getQuantity().equals("papier") && computer.getQuantity().equals("kamień"))) {
            userScore++;
            System.out.println("Runde wygral: " + user.getUserName());
        } else if (user.getQuantity().equals(computer.getQuantity())) {
            userScore = userScore;
            computerScore = computerScore;
            System.out.println("RWMIS");
        } else {
            computerScore++;
            System.out.println("Runde wygral: " + computer.getComputerName());
        }
    }

    public String generalScoreTheGame(UserPlayer userPlayer, ComputerPlayer computerPlayer) {
        if (getUserScore() > getComputerScore()) {
            return userPlayer.getUserName();
        } else {
            return computerPlayer.getComputerName();
        }
    }
}
