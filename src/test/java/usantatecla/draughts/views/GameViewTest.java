package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.State;
import usantatecla.draughts.utils.Console;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class GameViewTest {
    @Mock
    Console console;
    @InjectMocks
    GameView gameView;
    @Captor
    ArgumentCaptor<String> strings;

    @Before
    public void before(){
        initMocks(this);
    }

    @Test
    public void gameResultsTest(){
        Game game = new GameBuilder().build();
        PlayController playController = new PlayController(game, new State());
        this.gameView.write(playController);
        verify(console, times(90)).write(strings.capture());
        String[] rowsResult = {
                " 12345678",
                "1 n n n n",
                "2n n n n ",
                "3 n n n n",
                "4        ",
                "5        ",
                "6b b b b ",
                "7 b b b b",
                "8b b b b ",
                " 12345678"
        };
        assertEquals(rowsResult,concatResult(strings));
    }

    public String[] concatResult(ArgumentCaptor<String> strings){
        String string = "";
        String[] arrStrings = new String[10];
        int i = 0;
        for (String s : strings.getAllValues()){
            string += s;
            if(string.length() == 9){
                arrStrings[i] = string;
                i++;
                string = "";
            }
        }
        return arrStrings;
    }
}
