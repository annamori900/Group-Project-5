package mvc.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import mvc.model.Shelter;
import mvc.model.pets.Pet;

import java.awt.BorderLayout;
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
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // make so it doesnt close shelterview too
		frame.setBounds(100, 100, 500, 400);
		
		panel = new JPanel();
		frame.setContentPane(panel);
		frame.getContentPane().setLayout(null);
		
		idLabel = new JLabel("ID:");
		idLabel.setBounds(100,20,300,100);
		panel.add(idLabel);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(100, 40,300,100);
		panel.add(nameLabel);
		
		typeLabel = new JLabel("Type:");
		typeLabel.setBounds(100, 60,300,100);
		panel.add(typeLabel);
		
		speciesLabel = new JLabel("Species:");
		speciesLabel.setBounds(100,80,300,100);
		panel.add(speciesLabel);
		
		ageLabel = new JLabel("Age:");
		ageLabel.setBounds(100,100,300,100);
		panel.add(ageLabel);
		
		adoptedLabel = new JLabel("Adopted:");
		adoptedLabel.setBounds(100,120,300,100);
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
