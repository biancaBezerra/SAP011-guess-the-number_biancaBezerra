import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lógica do jogo
        do {
            Random random = new Random();
            Player playing;
            Player computer;
            int targetNumber = random.nextInt(100) + 1;
            int round = 0;

            System.out.println("Vamos Jogar!");

            System.out.print("\nJogador humano, por favor, digite seu nome: ");
            String playerName = scanner.nextLine();
            System.out.println("\nTente adivinhar o número entre 1 e 100!");

            //sortear quem começa primeiro, o pc ou o humano
            if (random.nextBoolean()) {
                playing = new HumanPlayer(playerName, scanner);
                computer = new ComputerPlayer("Computador", random);
                System.out.println("\nJogador sorteado para o primeiro palpite: " + playerName);
            } else {
                playing = new ComputerPlayer("Computador", random);
                computer= new HumanPlayer(playerName, scanner);
                System.out.println("\nJogador sorteado para o primeiro palpite: Computador");
            }

            System.out.print("O jogo começará em: ");
            for (int i = 5; i >= 1; i--) {
                System.out.print(i);
                if (i > 1) {
                    System.out.print(", ");
                } else {
                    System.out.println("...");
                }
                try {
                    Thread.sleep(1000);  // Atraso de 1 segundo
                } catch (InterruptedException e) {
                    // Lidar com a exceção, se necessário
                    System.err.println("Ocorreu uma exceção: " + e.getMessage());
                }
            }

            System.out.println("\nComeçou!");

            while (true) {
                round++;
                System.out.println("\n------------ Round " + round + " - Vez de " + playing.getName() + " ------------");
                String resultado = checkGuess(playing, targetNumber);
                System.out.println(resultado);

                if (playing.hasGuessed(targetNumber)) {
                    endGame(playing);
                    break;
                }

                round++;
                System.out.println("\n------------ Round " + round + " - Vez de " + computer.getName() + " ------------");
                String resultado2 = checkGuess(computer, targetNumber);
                System.out.println(resultado2);
                if (computer.hasGuessed(targetNumber)) {
                    endGame(computer);
                    break;
                }
            }

            System.out.print("\nDeseja jogar novamente? (s/n): ");
            scanner.nextLine();
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("s")) {
                break; // Encerra o loop se a resposta não for "s"
            }

        } while (true);

        System.out.println("Obrigado por jogar! Até mais.");
        scanner.close();
    }

    public static String checkGuess(Player player, int targetNumber) {
        int guess = player.makeGuess();
        player.addGuess(guess);

        System.out.println(player.getName() + " fez uma suposição: " + guess);

        if (guess <targetNumber) {
            return "Tente um número maior";
        } else if (guess > targetNumber) {
            return "Tente um número menor";
        }
        return "\nDeu Match!" ;
    }

    public static void endGame(Player player) {
        System.out.println("\nParabéns, " + player.getName() + "! Você acertou o número em " + player.getGuesses().size() + " tentativas.");
        System.out.println("\nTentativas feitas por " + player.getName() + ": " + player.getGuesses());
    }
}
