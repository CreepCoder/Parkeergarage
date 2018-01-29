package com.mvc.view;
/**
 * @author Groep C: Sander, Marc, Lorenzo, Iris, Danielle
 * @version 1.5
 */
// Importeren van Swing package 
import javax.swing.JPanel;

import com.mvc.model.Model;

// Door het extenden van AbstractView met JPanel kunnen de velden en methodes uit JPanel worden gebruikt in deze klasse
public abstract class AbstractView extends JPanel {
	
// SerialVersionUID zorgt ervoor dat je bytes en objecten ergens worden opgeslagen  
	private static final long serialVersionUID = -2767764579227738552L;
	protected Model model;

// Voegt views toe aan de simulatie.
	public AbstractView(Model model) {
		this.model=model;
		model.addView(this);
	}
	
// Teruggeven van het juiste model.
	public Model getModel() {
		return model;
	}

// Zorgt ervoor dat met elke seconde die er voorbij gaat het scherm geupdate wordt en de kleuren veranderen.
	public void updateView() {
		repaint();
	}
}
