package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import usantatecla.draughts.controllers.StartController;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class StartViewTest extends SubViewTest {

    private static final String TITTLE = "Draughts";

    @Mock
    private StartController startController;

    @Mock
    private GameView gameView;

    @InjectMocks
    private ViewComplete viewComplete;

    @Before
    public void before() {
        initMocks(this);
        this.viewComplete = spy(this.viewComplete);
    }

    @Test
    public void test1() {

        when(viewComplete.createGameView()).thenReturn(gameView);
        viewComplete.start(startController);

        verify(console).writeln(eq(TITTLE));
        verify(gameView).write(eq(startController));
        verify(startController).start();

    }
}
