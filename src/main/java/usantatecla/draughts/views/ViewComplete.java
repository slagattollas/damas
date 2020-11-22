package usantatecla.draughts.views;

import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.controllers.InteractorControllersVisitor;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.controllers.StartController;

public class ViewComplete extends SubView implements InteractorControllersVisitor {
    private String string;
    public ViewComplete(){
        super();
    }
    public void interact(InteractorController controller) {
        assert controller != null;
        controller.accept(this);
    }
    @Override
    public void visit(StartController startController) {
        assert startController != null;
        this.start(startController);
    }

    @Override
    public void visit(PlayController playController) {
        assert playController != null;
        this.play(playController);
    }

    @Override
    public void visit(ResumeController resumeController) {
        assert resumeController != null;
        this.resume(resumeController);
    }

    void start(StartController startController) {
        assert startController != null;
        this.console.writeln(TITTLE);
        createGameView().write(startController);
        startController.start();
    }

    void play(PlayController playController) {
        assert playController != null;
        Error error;
        do {
            error = null;
            this.string = this.read(playController.getColor());
            if (this.isCanceledFormat())
                playController.cancel();
            else if (!this.isMoveFormat()) {
                error = Error.BAD_FORMAT;
                this.writeError();
            } else {
                error = playController.move(this.getCoordinates());
                new GameView().write(playController);
                if (error == null && playController.isBlocked())
                    this.writeLost();
            }
        } while (error != null);
    }
    void resume(ResumeController resumeController) {
        assert resumeController != null;
        if (this.yesNoDialog.read(MESSAGE))
            resumeController.reset();
        else
            resumeController.next();
    }



    private String read(Color color) {
        final String titleColor = PROMPT.replace(COLOR_PARAM ,COLOR_VALUES[color.ordinal()]);
        return this.console.readString(titleColor);
    }

    private boolean isCanceledFormat() {
        return string.equals(CANCEL_FORMAT);
    }

    private boolean isMoveFormat() {
        return Pattern.compile(MOVEMENT_FORMAT).matcher(string).find();
    }

    private void writeError(){
        this.console.writeln(ERROR_MESSAGE);
    }

    private Coordinate[] getCoordinates() {
        assert this.isMoveFormat();
        List<Coordinate> coordinateList = new ArrayList<Coordinate>();
        while (string.length() > 0){
            coordinateList.add(Coordinate.getInstance(string.substring(0, 2)));
            string = string.substring(2, string.length());
            if (string.length() > 0 && string.charAt(0) == '.')
                string = string.substring(1, string.length());
        }
        Coordinate[] coordinates = new Coordinate[coordinateList.size()];
        for(int i=0; i< coordinates.length; i++){
            coordinates[i] = coordinateList.get(i);
        }
        return coordinates;
    }

    private void writeLost() {
        this.console.writeln(LOST_MESSAGE);
    }
    GameView createGameView() {
        return new GameView();
    }

}
