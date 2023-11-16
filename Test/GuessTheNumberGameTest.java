import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

public class GuessTheNumberGameTest {

    Random random = Mockito.mock(Random.class);

    @DisplayName("Deve pedir para tentar um numero menor")
    @Test
    void retornarTenteNumeroMenor(){
        Mockito.when(random.nextInt(100)).thenReturn(98); //quando chamar nextInt com valor 100 vc vai retornar 99
        Player player = new ComputerPlayer("Computador", random);
        int targetNumber = 90;

        String checkGuessResult = GuessTheNumberGame.checkGuess(player, targetNumber);

        Assertions.assertEquals("Tente um número menor", checkGuessResult);
    }

    @DisplayName("Deve pedir para tentar um numero maior")
    @Test
    void retornarTenteNumeroMaior() {
        Mockito.when(random.nextInt(100)).thenReturn(50);//quando chamar nextInt com valor 100 vc vai retornar 51
        Player player = new ComputerPlayer("Computador", random);
        int targetNumber = 52;

        String checkGuessResult = GuessTheNumberGame.checkGuess(player, targetNumber);

        Assertions.assertEquals("Tente um número maior", checkGuessResult);
    }

    @DisplayName("Deve retornar Deu Match para o vencedor!")
    @Test
    void retornarDeuMatch() {
        int targetNumber = 42;
        Mockito.when(random.nextInt(100)).thenReturn(targetNumber - 1); // quando chamar nextInt com valor 100, retorna targetNumber
        Player player = new ComputerPlayer("Computador", random);

        String checkGuessResult = GuessTheNumberGame.checkGuess(player, targetNumber);

        Assertions.assertEquals("\nDeu Match!", checkGuessResult);
    }
}
