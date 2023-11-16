import java.util.Random;

public class ComputerPlayer extends Player{

    protected Random random;

    public ComputerPlayer(String name, Random random) {
        super(name);
        this.random = random;
    }

    @Override
    public int makeGuess() {
        //sortear um numero aleatorio usando Random
        //armazenar esse numero
        //e por fim retornar esse numero no lugar do zero
        return random.nextInt(100)+1;
    }
}
