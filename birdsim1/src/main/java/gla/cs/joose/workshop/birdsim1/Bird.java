package gla.cs.joose.workshop.birdsim1;

import java.awt.*;
import java.util.Observable;

/**
 * A Bird piece.
 */
public class Bird extends Piece {
	
//	public Board board;
    
    public Color color;
    
    
    /**
     * Hatches a <code>Bird</code>.
     **/
    public Bird(Board board) {
    	color = Color.green;
    	this.board = board;
//    	this.board = board;
    }
    
    /**
     * Hatches a <code>Bird</code> of the given color.
     * 
     * @param color The <code>Color</code> of the new piece.
     **/
     Bird(Color color) {
        this.color = color;
    }
    
    /**
     * Draws this <code>Bird</code> on the given <code>Graphics</code>.
     * Drawing should be limited to the provided <code>java.awt.Rectangle</code>.
     * 
     * @param g The graphics on which to draw.
     * @param r The rectangle in which to draw.
     */
    public void paint(Graphics g, Rectangle r) {
        g.setColor(color);
        g.fillArc(r.x, r.y, r.width, r.height, 50, 270);
    }



	public void update(Observable o, Object arg) {
		redraw();
	}
	public void scareBird(){
		behave.setScareBirds(true);
	}

	@Override
	public void run() {
		behave.move();
	}

	@Override
	public void starveBirds() {
	}
}