package gla.cs.joose.workshop.birdsim1;

import java.awt.*;
import java.util.Observable;

/**
 * A grain piece.
 */
public class Grain extends Piece {
    
    double perches =0; //the number of perches on the grain by birds
    float remaining = 1.0f; //fraction of the grain remaining
    boolean starveBirds = false;

   
    /**
     * Constructs a <code>RoundPiece</code>.
     **/
    public Grain(Board board) {
    	this.board = board;
    }
    
    public void deplete(){
    	perches = perches +1;
    	remaining -= 0.05f;
    }
    
        
    public float getRemaining() {
		return remaining;
	}

	/**
     * Draws this <code>RoundPiece</code> on the given <code>Graphics</code>.
     * Drawing should be limited to the provided <code>java.awt.Rectangle</code>.
     * 
     * @param g The graphics on which to draw.
     * @param r The rectangle in which to draw.
     */
    public void paint(Graphics g, Rectangle r) {
    	int color = Color.HSBtoRGB(1, remaining, 1);
        g.setColor(new Color(color));
        g.fillOval(r.x, r.y, r.width, r.height);
    }

	public void update(Observable arg0, Object arg1) {
		redraw();
	}
	public MoveBehaviour getBehaviour(){
		return behave;
	}
	public void starveBirds(){
		starveBirds = true;
	}

	@Override
	public void run() {
		while(!starveBirds){
			behave.move();
		}
		board.deleteObserver(this);
		remove();
		
	}

	@Override
	public void scareBird() {
		
	}
}