package gla.cs.joose.workshop.birdsim1.view;

import java.awt.event.ActionEvent;
import gla.cs.joose.workshop.birdsim1.Board;
import gla.cs.joose.workshop.birdsim1.Bird;

public class HatchEggListener extends BoardListener{
	
	public HatchEggListener() {
		super("Hatch Egg");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Bird b = new Bird();
//		Thread thread = new Thread(b);
//		thread.start();   
		b.hatchEgg();
	}
}
		


	
