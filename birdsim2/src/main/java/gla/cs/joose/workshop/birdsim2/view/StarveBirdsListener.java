package gla.cs.joose.workshop.birdsim2.view;

import java.awt.event.ActionEvent;

public class StarveBirdsListener extends BoardListener {

	public StarveBirdsListener() {
		super("Starve Birds");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		b.starveBirds();
	}

}
