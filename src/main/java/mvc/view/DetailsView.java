package mvc.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import mvc.model.pets.Pet;

import javax.swing.JLabel;

public class DetailsView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JPanel panel;
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel typeLabel;
	private JLabel speciesLabel;
	private JLabel ageLabel;
	private JLabel adoptedLabel;
	
	public DetailsView() {
		initialize();
	}
	
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Pet Details");
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		frame.setBounds(100, 100, 250, 150);
		
		panel = new JPanel();
		frame.setContentPane(panel);
		frame.getContentPane().setLayout(null);
		
		idLabel = new JLabel("ID:");
		idLabel.setBounds(10,10,200,13);
		panel.add(idLabel);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(10,25,200,13);
		panel.add(nameLabel);
		
		typeLabel = new JLabel("Type:");
		typeLabel.setBounds(10,40,200,13);
		panel.add(typeLabel);
		
		speciesLabel = new JLabel("Species:");
		speciesLabel.setBounds(10,55,200,13);
		panel.add(speciesLabel);
		
		ageLabel = new JLabel("Age:");
		ageLabel.setBounds(10,70,200,13);
		panel.add(ageLabel);
		
		adoptedLabel = new JLabel("Adopted:");
		adoptedLabel.setBounds(10,85,200,13);
		panel.add(adoptedLabel);
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void updateDetails(Pet pet) {
		idLabel.setText("ID:                 " +  pet.getId());
		nameLabel.setText("Name:           " + pet.getName());
		typeLabel.setText("Type:            " + pet.getType());
		speciesLabel.setText("Species:      " + pet.getSpecies());
		ageLabel.setText("Age:              " + pet.getAge());
		if (pet.isAdopted()) { adoptedLabel.setText("Adopted:      Yes"); }
		else { adoptedLabel.setText("Adopted:      No"); }
	}

}
