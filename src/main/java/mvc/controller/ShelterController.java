package mvc.controller;

import mvc.model.Shelter;
import mvc.view.ShelterView;

public class ShelterController {
	
	private Shelter<?> model;
	private ShelterView view;
	
	public ShelterController(Shelter<?> model, ShelterView view) {
		this.model = model;
		this.view = view;
		
	}
	
	public void initiate() {
		view.setVisible(true);
	}
	
	

}
