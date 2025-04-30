package mvc.view;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mvc.model.pets.Pet;

import javax.swing.JList;

@SuppressWarnings("deprecation")
public class ShelterView extends JFrame implements Observer {
	
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
		petList.setBounds(150, 20, 314, 200);
		panel.add(petList);
		
		addButton = new JButton("Add");
		addButton.setBounds(20, 20, 100, 40);
		panel.add(addButton);
		
		removeButton = new JButton("Remove");
		removeButton.setBounds(20, 60, 100, 40);
		panel.add(removeButton);
		
		viewDetailsButton = new JButton("Details");
		viewDetailsButton.setBounds(20, 100, 100, 40);
		panel.add(viewDetailsButton);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(20, 140, 100, 40);
		panel.add(saveButton);
		
		adoptButton = new JButton("Adopt");
		adoptButton.setBounds(20, 180, 100, 40);
		panel.add(adoptButton);
		
		
	}
	
	public void addListenerToRemoveButton(ActionListener l) {
		removeButton.addActionListener(l);
	}
	
	public DefaultListModel<Pet> getPetList() {
		return (DefaultListModel<Pet>) petList.getModel();
	}
	
	public int getSelectedPet() {
		return petList.getSelectedIndex();
	}
	
	public int[] getMultipleSelectedPets() {
		return petList.getSelectedIndices();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}
