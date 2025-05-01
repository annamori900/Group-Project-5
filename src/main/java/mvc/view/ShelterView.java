package mvc.view;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mvc.model.Shelter;
import mvc.model.adapter.ExoticAnimalAdapter;
import mvc.model.pets.Cat;
import mvc.model.pets.Dog;
import mvc.model.pets.ExoticAnimal;
import mvc.model.pets.Pet;
import mvc.model.pets.Rabbit;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ShelterView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JPanel panel;
	private JList<Pet> petList;
	private JButton addButton;
	private JButton removeButton;
	private JButton viewDetailsButton;
	private JButton saveButton;
	private JButton adoptButton;
	private JComboBox<String> comboBox;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField typeTextField;
	private JTextField speciesTextField;
	private JTextField ageTextField;
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel typeLabel;
	private JLabel speciesLabel;
	private JLabel ageLabel;
	
	public ShelterView() {
		initialize();
	}
	
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Pet Adoption Center");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 400);
		
		panel = new JPanel();
		frame.setContentPane(panel);
		frame.getContentPane().setLayout(null);
		
		DefaultListModel<Pet> modelList = new DefaultListModel<>();
		petList = new JList<>(modelList);
		petList.setBounds(20, 50, 274, 200);
		panel.add(petList);
		
		addButton = new JButton("Add Pet");
		addButton.setBounds(364, 193, 96, 40);
		panel.add(addButton);
		
		removeButton = new JButton("Remove Pet");
		removeButton.setBounds(162, 310, 132, 40);
		panel.add(removeButton);
		
		viewDetailsButton = new JButton("View Pet Details");
		viewDetailsButton.setBounds(20, 310, 132, 40);
		panel.add(viewDetailsButton);
		
		saveButton = new JButton("Save Pet List");
		saveButton.setBounds(20, 260, 132, 40);
		panel.add(saveButton);
		
		adoptButton = new JButton("Adopt Pet");
		adoptButton.setBounds(162, 260, 132, 40);
		panel.add(adoptButton);
		
		String[] comboBoxOptions = {"","Name", "Age", "Species"};
		comboBox = new JComboBox<>(comboBoxOptions);
		comboBox.setBounds(64, 20, 100, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Sort by:");
		lblNewLabel.setBounds(20, 24, 45, 13);
		panel.add(lblNewLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(364, 48, 96, 19);
		panel.add(idTextField);
		idTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(364, 77, 96, 19);
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		typeTextField = new JTextField();
		typeTextField.setBounds(364, 106, 96, 19);
		panel.add(typeTextField);
		typeTextField.setColumns(10);
		
		speciesTextField = new JTextField();
		speciesTextField.setBounds(364, 135, 96, 19);
		panel.add(speciesTextField);
		speciesTextField.setColumns(10);
		
		ageTextField = new JTextField();
		ageTextField.setBounds(364, 164, 96, 19);
		panel.add(ageTextField);
		ageTextField.setColumns(10);
		
		idLabel = new JLabel("ID:");
		idLabel.setBounds(309, 51, 45, 13);
		panel.add(idLabel);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(309, 80, 45, 13);
		panel.add(nameLabel);
		
		typeLabel = new JLabel("Type:");
		typeLabel.setBounds(309, 109, 45, 13);
		panel.add(typeLabel);
		
		speciesLabel = new JLabel("Species:");
		speciesLabel.setBounds(309, 138, 57, 13);
		panel.add(speciesLabel);
		
		ageLabel = new JLabel("Age:");
		ageLabel.setBounds(309, 167, 45, 13);
		panel.add(ageLabel);
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public DefaultListModel<Pet> getPetList() {
		return (DefaultListModel<Pet>) petList.getModel();
	}
	
	public JComboBox<String> getComboBox() {
		return comboBox;
	}
	
	public Pet getPetFromPetTextFields() {
		Pet pet;
		switch(typeTextField.getText().toLowerCase()) {
		case "dog":
			pet = new Dog(Integer.parseInt(idTextField.getText()),
				      nameTextField.getText(),
				      speciesTextField.getText(),
				      Integer.parseInt(ageTextField.getText()),
				      false);
			break;
		case "cat":
			pet = new Cat(Integer.parseInt(idTextField.getText()),
				      nameTextField.getText(),
				      speciesTextField.getText(),
				      Integer.parseInt(ageTextField.getText()),
				      false);
			break;
		case "rabbit":
			pet = new Rabbit(Integer.parseInt(idTextField.getText()),
				             nameTextField.getText(),
				             speciesTextField.getText(),
				             Integer.parseInt(ageTextField.getText()),
				             false);
			break;
		default:
			ExoticAnimal ea = new ExoticAnimal(idTextField.getText(),
		                                       nameTextField.getText(),
		                                       typeTextField.getText(),
		                                       speciesTextField.getText(),
		                                       Integer.parseInt(ageTextField.getText()));
			pet = new ExoticAnimalAdapter(ea);
			break;
		}
		return pet;
	}
	
	public int getSelectedPet() {
		return petList.getSelectedIndex();
	}
	
	public int[] getMultipleSelectedPets() {
		return petList.getSelectedIndices();
	}
	
	public void showShelterOnList(Shelter<Pet> shelter) {
		for ( Pet p : shelter.getPets()) {
			getPetList().removeElement(p);
		}
		for ( Pet p : shelter.getPets()) {
			addPetToPetList(p);
		}
	}
	
	public void addPetToPetList(Pet pet) {
		getPetList().addElement(pet);
	}
	
	public void addListenerToAddButton(ActionListener l) {
		addButton.addActionListener(l);
	}
	
	public void addListenerToRemoveButton(ActionListener l) {
		removeButton.addActionListener(l);
	}
	
	public void addListenerToViewDetailsButton(ActionListener l) {
		viewDetailsButton.addActionListener(l);
	}
	
	public void addListenerToSaveButton(ActionListener l) {
		saveButton.addActionListener(l);
	}
	
	public void addListenerToAdoptButton(ActionListener l) {
		adoptButton.addActionListener(l);
	}
	
	public void addListenerToComboBox(ActionListener l) {
		comboBox.addActionListener(l);
	}
}
