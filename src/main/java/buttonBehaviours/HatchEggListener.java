package buttonBehaviours;

import java.awt.event.ActionEvent;
import gla.cs.joose.coursework.birdsim1.boards.Board;
import gla.cs.joose.coursework.birdsim1.pieces.Bird;

public class HatchEggListener extends BoardListener{
	
	HatchEggListener(Board b) {
		super(b, "Hatch Egg");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Bird b = new Bird();
//		Thread thread = new Thread(b);
//		thread.start();   
		b.hatchEgg();
	}
}
		


	
