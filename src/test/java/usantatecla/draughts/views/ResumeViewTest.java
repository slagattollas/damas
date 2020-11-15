package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.utils.YesNoDialog;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ResumeViewTest {

    @Mock
    ResumeController resumeController;
    @Mock
    YesNoDialog yesNoDialog;
    @InjectMocks
    ResumeView resumeView;

    @Before
    public void before(){
        initMocks(this);
    }

    @Test
    public void resumeResetTest(){
        when(yesNoDialog.read(anyString())).thenReturn(true);
        resumeView.interact(resumeController);
        verify(resumeController).reset();
    }
    @Test
    public void resumeNextTest(){
        when(yesNoDialog.read(anyString())).thenReturn(false);
        resumeView.interact(resumeController);
        verify(resumeController).next();
    }

}
