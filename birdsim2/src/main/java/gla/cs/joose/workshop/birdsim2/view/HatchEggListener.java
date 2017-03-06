package gla.cs.joose.workshop.birdsim2.view;

import java.awt.event.ActionEvent;

public class HatchEggListener extends BoardListener {

	public HatchEggListener() {
		super("Hatch Egg");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		b.hatchEgg();
	}
}
