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
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 400);
		
		panel = new JPanel();
		frame.setContentPane(panel);
		frame.getContentPane().setLayout(null);
		
		idLabel = new JLabel("ID:");
		idLabel.setBounds(100,20,100,100);
		panel.add(idLabel);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(100, 40,100,100);
		panel.add(nameLabel);
		
		typeLabel = new JLabel("Type:");
		typeLabel.setBounds(100, 60,100,100);
		panel.add(typeLabel);
		
		speciesLabel = new JLabel("Species:");
		speciesLabel.setBounds(100,80,100,100);
		panel.add(speciesLabel);
		
		ageLabel = new JLabel("Age:");
		ageLabel.setBounds(100,100,100,100);
		panel.add(ageLabel);
		
		adoptedLabel = new JLabel("Adopted:");
		adoptedLabel.setBounds(100,120,100,100);
		panel.add(adoptedLabel);
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void updateDetails(Pet pet) {
		idLabel.setText("ID: \t" +  pet.getId());
		nameLabel.setText("Name: \t" + pet.getName());
		typeLabel.setText("Type: \t" + pet.getType());
		speciesLabel.setText("Species: \t" + pet.getSpecies());
		ageLabel.setText("Age: \t" + pet.getAge());
		if (pet.isAdopted()) { adoptedLabel.setText("Adopted: \tYes"); }
		else { adoptedLabel.setText("Adopted: \tNo"); }
	}

}
