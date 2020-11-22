package usantatecla.draughts;

import usantatecla.draughts.controllers.Logic;
import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.views.ViewComplete;

class Draughts {
    
    private ViewComplete view;
    private Logic logic;

    private Draughts(){
        this.view = new ViewComplete();
        this.logic = new Logic();
    }

    private void play() {
        InteractorController controller;
		do {
			controller = this.logic.getController();
			if (controller != null)
				this.view.interact(controller);
		} while (controller != null); 
    }

    public static void main(String[] args){
        new Draughts().play();
    }
    
}