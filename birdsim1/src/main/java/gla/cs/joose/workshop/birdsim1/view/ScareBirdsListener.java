package gla.cs.joose.workshop.birdsim1.view;

import java.awt.event.ActionEvent;

import gla.cs.joose.workshop.birdsim1.Board;

public class ScareBirdsListener extends BoardListener {

	public ScareBirdsListener() {
		super("Scare Birds");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		b.scareBirds();
	}

}
