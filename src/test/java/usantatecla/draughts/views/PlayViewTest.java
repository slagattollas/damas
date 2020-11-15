package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.*;
import usantatecla.draughts.utils.Console;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class PlayViewTest {
    @Mock
    private PlayController playController;
    @Mock
    private Console console;
    @Mock
    private GameView gameView;
    @InjectMocks
    private PlayView playView;

    @Before
    public void before() {
        initMocks(this);
    }

    @Test
    public void playCancelTest(){
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(console.readString("Mueven las blancas: " )).thenReturn("-1");
        playView.interact(playController);
        verify(playController).cancel();
    }
    @Test
    public void playBadFormatTest() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString("Mueven las negras: ")).thenReturn("3.42").thenReturn("-1");
        playView.interact(playController);
        verify(console).writeln("Error!!! Formato incorrecto");
        verify(playController).cancel();
    }
    @Test
    public void playCorrectMoveTest() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString("Mueven las negras: ")).thenReturn("38.47");
        playView.interact(playController);
        verify(playController).move(new Coordinate(2, 7), new Coordinate(3, 6));
    }
    @Test
    public void playCorrectMoveDoubleTest() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString("Mueven las negras: ")).thenReturn("38.47.56");
        playView.interact(playController);
        verify(playController).move(new Coordinate(2, 7), new Coordinate(3, 6), new Coordinate(4,5));
    }
    @Test
    public void playCorrectMoveLostMessage(){
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(playController.isBlocked()).thenReturn(true);
        when(console.readString("Mueven las blancas: ")).thenReturn("54.43");
        playView.interact(playController);
        verify(playController).move(new Coordinate(4,3), new Coordinate(3,2));
        verify(console).writeln("Derrota!!! No puedes mover tus fichas!!!");
    }
}
