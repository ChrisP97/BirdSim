package gla.cs.joose.workshop.birdsim1.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import gla.cs.joose.workshop.birdsim1.view.BoardListener;
import gla.cs.joose.workshop.birdsim1.Bird;
import gla.cs.joose.workshop.birdsim1.Piece;
import gla.cs.joose.workshop.birdsim1.Board;

public class DisplayBoard extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public Board board;
	ArrayList<BoardListener> buttons;
	
	public DisplayBoard(){
//		this.board = b;
//		b.addObserver(this);
		createBoard();
	}
	
	
	public void addButtons(ArrayList<BoardListener> buttons){
		for (BoardListener bl: buttons){
				JButton button = new JButton(bl.getText());
				bl.setBoard(board);
				button.addActionListener(bl);
				this.add(button);
				
		}
	}
	
	public void addButton(BoardListener button){
		buttons.add(button);
	}
	public void createBoard(){
		
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
        synchronized (b.getAllPieces()) {
            for (Iterator<Piece> iter = board.getAllPieces().iterator(); iter.hasNext();) {
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
