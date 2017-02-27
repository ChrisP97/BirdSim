package buttonBehaviours;

import java.awt.event.ActionEvent;

import gla.cs.joose.coursework.birdsim1.boards.Board;

public class ScareBirdsListener extends BoardListener {

	ScareBirdsListener(Board b) {
		super(b, "Scare Birds");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		b.scareBirds();
	}

}
