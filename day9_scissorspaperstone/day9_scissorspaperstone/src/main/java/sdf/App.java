package sdf;

import java.util.Scanner;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        String[] choice = {"scissor", "paper", "stone"};
        Integer computerChoice; 
        Integer playerChoice;
        String winner = "";
        Scanner scan = new Scanner(System.in);

        SSP ssp = new SSP();
        computerChoice = ssp.generateComputerChoice();

        while (winner.equals("")) {
            System.out.println("Enter (1) Scissor, (2) Paper, (3) Stone");
            playerChoice = scan.nextInt();

            if (!((playerChoice >=1) && (playerChoice <=3))) {
                System.out.println("Invalid input: Only number between 1 to 3 is allowed");
                continue;
            }

            winner = ssp.checkWinner(playerChoice, computerChoice);
            if (winner.equalsIgnoreCase("")) {
                System.out.println("It's a tie");
            } else {
                System.out.println(winner + " wins");
            }
        }

        scan.close();
    }
}
