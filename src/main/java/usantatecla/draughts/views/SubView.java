package usantatecla.draughts.views;

import usantatecla.draughts.utils.Console;
import usantatecla.draughts.utils.YesNoDialog;

class SubView {
    
    protected Console console;
    protected YesNoDialog yesNoDialog;
    protected static final String COLOR_PARAM = "#color";
    protected static final String[] COLOR_VALUES = { "blancas", "negras" };
    protected static final String PROMPT = "Mueven las " + COLOR_PARAM + ": ";
    protected static final String CANCEL_FORMAT = "-1";
    protected static final String MOVEMENT_FORMAT = "[1-8]{2}(\\.[1-8]{2}){1,2}";
    protected static final String ERROR_MESSAGE = "Error!!! Formato incorrecto";
    protected static final String LOST_MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";
    protected static final String TITTLE = "Draughts";
    protected static final String MESSAGE = "¿Queréis jugar otra";
    public SubView(){
        this.console = new Console();
        this.yesNoDialog = new YesNoDialog();
    }
    
}