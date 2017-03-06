package gla.cs.joose.workshop.birdsim2.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gla.cs.joose.workshop.birdsim2.Board;

public abstract class BoardListener implements ActionListener{
	Board b;
	String text;
	public BoardListener(String text){
		this.text = text;
	}
	
	public void setBoard(Board b){
		this.b = b;
	}
	
	public String getText() {
		return text;
	}
	public abstract void actionPerformed(ActionEvent arg0);
}

//board Methods:
//hatchEgg
//feedBird
//scareBirds
//starveBirds