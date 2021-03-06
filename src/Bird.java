import java.awt.*;
import java.util.Observable;

/**
 * A Bird piece.
 */
public class Bird extends Piece {
	
	public Color color;
	
	@Override
    public void run() {

    }

    @Override
    public void update(Observable o, Object arg) {

    }
	
	/**
     * Hatches a <code>Bird</code>.
     **/
    public Bird(){
        color = Color.green;
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

}
