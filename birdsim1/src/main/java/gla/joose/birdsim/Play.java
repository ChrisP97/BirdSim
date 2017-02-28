package gla.joose.birdsim;

import javax.swing.JFrame;

import gla.joose.birdsim.boards.Board;

/**
 *  The main method for bootstrapping BirdSim.
 */
public class Play extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		Board board = new Board(50,50);
		board.setBirdBehaviour();
		}

}
