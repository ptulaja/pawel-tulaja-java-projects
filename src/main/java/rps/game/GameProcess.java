package rps.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameProcess {
    public static void process() {

        boolean end = false;

        while (!end) {
            Scanner sc = new Scanner(System.in);
            RandomChoice randomChoice = new RandomChoice();
            GeneralScore generalScore = new GeneralScore();

            System.out.println("Podaj swoje imie:");
            UserPlayer userPlayer = new UserPlayer(sc.next());
            ComputerPlayer computerPlayer = new ComputerPlayer("Komputer");

            System.out.println("\nDo ilu wygranych gier gramy ?");

            try {
                generalScore.setNumberOfRounds(sc.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Uważaj ! wpisujemy tylko liczby :)");
                GameProcess.process();
            }

            System.out.println("\nTabela komend: \n\n" + new RpsCommand().getCommand());
            System.out.println("Rozpoczynamy grę. Wybierz (klawisz 1, 2 lub 3)" + " i nacisnij ENTER!");

            while ((generalScore.getUserScore() < generalScore.getNumberOfRounds()) && generalScore.getComputerScore() < generalScore.getNumberOfRounds()) {

                userPlayer.setQuantity(randomChoice, sc);
                computerPlayer.setQuantity(randomChoice);

                generalScore.generalScore(userPlayer, computerPlayer);

                System.out.println("\n" + userPlayer.getUserName() + " - " + userPlayer.getQuantity());
                System.out.println(computerPlayer.getComputerName() + " - " + computerPlayer.getQuantity());
                System.out.println("\n-> " + userPlayer.getUserName() + ": " + generalScore.getUserScore() + " : " + generalScore.getComputerScore() + " :Komputer <-");
            }

            System.out.println("\nWygrywa " + generalScore.generalScoreTheGame(userPlayer, computerPlayer) + ", wynikiem: " + generalScore.getUserScore() + ":" + generalScore.getComputerScore() + "\n\nChcesz zagrac jeszcze raz ? nacisnij: (n). " + "Jzeli chcesz zakonczyc gre nacisnij (x)");

            try {
                String decision = new Scanner(System.in).next();

                if (decision.equals("x")) {
                    end = true;
                }

            } catch (InputMismatchException e){
                GameProcess.process();
            }
        }
    }
}
