package gla.cs.joose.workshop.birdsim2.view;

import java.awt.event.ActionEvent;

import gla.cs.joose.workshop.birdsim2.Board;

public class FeedBirdsListener extends BoardListener {

	public FeedBirdsListener() {
		super("Feed Birds");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		b.feedBirds();
	}

}
