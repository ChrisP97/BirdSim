package buttonBehaviours;

import java.awt.event.ActionListener;

import gla.cs.joose.coursework.birdsim1.boards.Board;

public abstract class BoardListener implements ActionListener{
	Board b;
	String text;
	BoardListener(Board b, String text){
		this.b = b;
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}

//board Methods:
//hatchEgg
//feedBird
//scareBirds
//starveBirds