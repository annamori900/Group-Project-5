package mvc.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShelterView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JPanel panel;
	
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
		
		//
	}

}
