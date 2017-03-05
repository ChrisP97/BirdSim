package gla.cs.joose.workshop.birdsim1.view;

import java.awt.event.ActionEvent;

import gla.cs.joose.workshop.birdsim1.Board;

public class StarveBirdsListener extends BoardListener {

	public StarveBirdsListener() {
		super("Starve Birds");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		b.starveBirds();
	}

}
