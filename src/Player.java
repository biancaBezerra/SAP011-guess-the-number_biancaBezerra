import java.util.ArrayList;

public abstract class Player {
    protected String name;
    protected ArrayList<Integer> guesses;

    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public abstract int makeGuess();

    public ArrayList<Integer> getGuesses() {
        return guesses;
    }

    public void addGuess(int guess) {
        guesses.add(guess);
    }

    public boolean hasGuessed(int targetNumber) {
        return guesses.contains(targetNumber);
    }
}
