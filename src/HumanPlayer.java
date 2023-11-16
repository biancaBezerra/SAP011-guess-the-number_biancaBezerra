import java.util.Scanner;

public class HumanPlayer extends Player{

    protected Scanner scanner;

    public HumanPlayer(String name, Scanner scanner) {
        super(name); // Chama o construtor da classe pai (Player) e passa o nome
        this.scanner = scanner;
    }
    @Override
    public int makeGuess() {
        System.out.print(getName() + ": Digite seu palpite: ");
        return scanner.nextInt();
    }
}
