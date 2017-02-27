package gla.cs.joose.coursework.birdsim1.boards;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

import buttonBehaviours.BoardListener;
import gla.cs.joose.coursework.birdsim1.pieces.Bird;
import gla.cs.joose.coursework.birdsim1.pieces.Piece;

public class DisplayBoard extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public Board board;
	ArrayList<BoardListener> buttons;
	
	public DisplayBoard(Board b){
		this.board = b;
	}
	
	public void addButtons(ArrayList<BoardListener> buttons){
		for (BoardListener bl: buttons){
				JButton button = new JButton(bl.getText());
				this.add(button);
				button.addActionListener(bl);
		}
	}
	
	public void addButton(BoardListener button){
		buttons.add(button);
	}
	public void createBoard()
	{
		addButtons(b.buttons)
	}
		
	/**
     * Repaints this Board and everything on it.
     * 
     * @param g
     *        The Graphics context on which this board is painted.
     */
    public void update(Board b,Graphics g) {
        paint(b,g);
    }

    /**
     * Repaints this Board and everything on it.
     * 
     * @param g
     *        The Graphics context on which this board is painted.
     */
    public void paint(Board b,Graphics g) {
        // Paint the board
    	board.paint(g);
        // Paint the pieces
        synchronized (b.allPieces) {
            for (Iterator<Piece> iter = board.allPieces.iterator(); iter.hasNext();) {
                Piece piece = iter.next();
                piece.paint(g, piece.getRectangle());
            }
        }
    }
    
    
} //--------end of class

//-------------------------------------------------- inner class DisplayPanel

/*class DisplayPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
     * Repaints this Board and everything on it.
     * 
     * @param g
     *        The Graphics context on which this board is painted.
     
    public void update(Graphics g) {
        paint(g);
    }

    /**
     * Repaints this Board and everything on it.
     * 
     * @param g
     *        The Graphics context on which this board is painted.
     
    public void paint(Graphics g) {
        // Paint the board
        thisBoard.paint(g);
        // Paint the pieces
        synchronized (allPieces) {
            for (Iterator<Piece> iter = allPieces.iterator(); iter.hasNext();) {
                Piece piece = iter.next();
                piece.paint(g, piece.getRectangle());
            }
        }
    }
} // end inner class DisplayPanel
*/
