package gla.cs.joose.workshop.birdsim1.view;

import java.awt.event.ActionEvent;

import gla.cs.joose.workshop.birdsim1.Board;

public class FeedBirdsListener extends BoardListener {

	public FeedBirdsListener() {
		super("Starve Birds");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		b.feedBirds();
	}

}
