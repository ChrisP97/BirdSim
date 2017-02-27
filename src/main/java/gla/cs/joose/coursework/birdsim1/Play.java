package gla.cs.joose.coursework.birdsim1;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import buttonBehaviours.BoardListener;
import buttonBehaviours.HatchEggListener;
import gla.cs.joose.coursework.birdsim1.boards.Board;
import gla.cs.joose.coursework.birdsim1.boards.DisplayBoard;
import gla.cs.joose.coursework.birdsim1.boards.FlockBoard;
import gla.cs.joose.coursework.birdsim1.boards.MovingForageBoard;
import gla.cs.joose.coursework.birdsim1.boards.StaticForageBoard;


/**
 *  @author inah
 *  The main method for bootstrapping BirdSim.
 */
public class Play extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Play play = new Play();
		
//		Board forageBoard = new StaticForageBoard(50,50);
//		forageBoard.initBoard(play);
//		Board forageBoard = new MovingForageBoard(50,50);
//		forageBoard.initBoard(play);
		Board simpleBoard = new FlockBoard(50,50);
		DisplayBoard displayBoard = new DisplayBoard(simpleBoard);
		BoardListener[] buttons = new BoardListener[1];
		buttons[1] = new HatchEggListener();
		displayBoard.addButtons(buttons);
		simpleBoard.initBoard(play);
	}

}
