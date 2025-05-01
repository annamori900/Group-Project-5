package mvc.view;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mvc.model.Shelter;
import mvc.model.pets.Pet;
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
	
	/**
	 * This is the default constructor to initialize the Swing GUI
	 */
	public ShelterView() {
		initialize();
	}
	
	/**
	 * This method initializes the Swing GUI by setting up the frame, panel, and added elements such as a list, buttons, a combo box, text fields, and labels.
	 */
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
		
		JLabel sortByLabel = new JLabel("Sort by:");
		sortByLabel.setBounds(20, 24, 45, 13);
		panel.add(sortByLabel);
		
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
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(309, 51, 45, 13);
		panel.add(idLabel);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(309, 80, 45, 13);
		panel.add(nameLabel);
		
		JLabel typeLabel = new JLabel("Type:");
		typeLabel.setBounds(309, 109, 45, 13);
		panel.add(typeLabel);
		
		JLabel speciesLabel = new JLabel("Species:");
		speciesLabel.setBounds(309, 138, 57, 13);
		panel.add(speciesLabel);
		
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setBounds(309, 167, 45, 13);
		panel.add(ageLabel);
	}
	
	/**
	 * This method is a getter for the view's frame
	 * @return Returns the JFrame of the view
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * This method is a getter for the view's pet list
	 * @return Returns the DefaultListModel<> of the view's pet list
	 */
	public DefaultListModel<Pet> getPetList() {
		return (DefaultListModel<Pet>) petList.getModel();
	}
	
	/**
	 * This method is a getter for the view's combo box
	 * @return Returns the JComboBox of the view
	 */
	public JComboBox<String> getComboBox() {
		return comboBox;
	}
	
	/**
	 * This method is a getter for the view's ID text field's text
	 * @return Returns a string of the ID text field's text
	 */
	public String getIdFromTextField() {
		return idTextField.getText();
	}
	
	/**
	 * This method is a getter for the view's name text field's text
	 * @return Returns a string of the name text field's text
	 */
	public String getNameFromTextField() {
		return nameTextField.getText();
	}
	
	/**
	 * This method is a getter for the view's type text field's text
	 * @return Returns a string of the type text field's text
	 */
	public String getTypeFromTextField() {
		return typeTextField.getText();
	}
	
	/**
	 * This method is a getter for the view's species text field's text
	 * @return Returns a string of the species text field's text
	 */
	public String getSpeciesFromTextField() {
		return speciesTextField.getText();
	}
	
	/**
	 * This method is a getter for the view's age text field's text
	 * @return Returns a string of the age text field's text
	 */
	public String getAgeFromTextField() {
		return ageTextField.getText();
	}
	
	/**
	 * This method is a getter for the index of the selected pet on the view's pet list
	 * @return Returns a primitive integer of the selected pet's index
	 */
	public int getSelectedPet() {
		return petList.getSelectedIndex();
	}
	
	/**
	 * This method is a getter for the indices of the selected pets on the view's pet list
	 * @return Returns a primitive integer array containing the selected pets' indices
	 */
	public int[] getMultipleSelectedPets() {
		return petList.getSelectedIndices();
	}
	
	/**
	 * This method displays all the pets in the shelter on the view's pet list
	 * @param shelter A Shelter<> object parameter to be displayed on the view's pet list
	 */
	public void showShelterOnList(Shelter<Pet> shelter) {
		for ( Pet p : shelter.getPets()) {
			getPetList().removeElement(p);
		}
		for ( Pet p : shelter.getPets()) {
			addPetToPetList(p);
		}
	}
	
	/**
	 * This method adds a pet to the view's pet list
	 * @param pet A Pet object parameter to be added to the view's pet list
	 */
	public void addPetToPetList(Pet pet) {
		getPetList().addElement(pet);
	}
	
	/**
	 * This method adds an ActionListener to the add button
	 * @param l An ActionListener object to be added to the add button
	 */
	public void addListenerToAddButton(ActionListener l) {
		addButton.addActionListener(l);
	}
	
	/**
	 * This method adds an ActionListener to the remove button
	 * @param l An ActionListener object to be added to the remove button
	 */
	public void addListenerToRemoveButton(ActionListener l) {
		removeButton.addActionListener(l);
	}
	
	/**
	 * This method adds an ActionListener to the view details button
	 * @param l An ActionListener object to be added to the view details button
	 */
	public void addListenerToViewDetailsButton(ActionListener l) {
		viewDetailsButton.addActionListener(l);
	}
	
	/**
	 * This method adds an ActionListener to the save button
	 * @param l An ActionListener object to be added to the save button
	 */
	public void addListenerToSaveButton(ActionListener l) {
		saveButton.addActionListener(l);
	}
	
	/**
	 * This method adds an ActionListener to the adopt button
	 * @param l An ActionListener object to be added to the adopt button
	 */
	public void addListenerToAdoptButton(ActionListener l) {
		adoptButton.addActionListener(l);
	}
	
	/**
	 * This method adds an ActionListener to the combo box
	 * @param l An ActionListener object to be added to the combo box
	 */
	public void addListenerToComboBox(ActionListener l) {
		comboBox.addActionListener(l);
	}
	
}
