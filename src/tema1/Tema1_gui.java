package tema1;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Tema1_gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField display;
	
	private boolean shouldClear = false;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tema1_gui frame = new Tema1_gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tema1_gui() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 550);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		
		display = new JTextField();
		display.setBounds(10, 10, 365, 100);
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 32));
		display.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 10, 10, 10)); 
		
		contentPane.add(display);

		
		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(10, 120, 365, 370);
		panelButtons.setLayout(new GridLayout(4, 4, 5, 5));

		String[] buttons = {
			"1", "2", "3", "+",
			"4", "5", "6", "-",
			"7", "8", "9", "x",
			"0", "=", "C", "/"
		};

		for (String text : buttons) {
			JButton button = new JButton(text);
			
			button.addActionListener(e -> handleButtonClick(text));

			
			panelButtons.add(button);
		}

		contentPane.add(panelButtons);
	}
	
	
	 private void handleButtonClick(String text) 
	 {
	        if (text.equals("C")) 
	        {
	            display.setText("");
	        } 
	        else if (text.equals("=")) 
	        {
	            try {
	                String expr = display.getText();
	                double result = Tema1_cod.eval(expr);
	                display.setText(String.valueOf(result));
	                //shouldClear = true;
	            } catch (Exception e) {
	                display.setText("Eroare!");
	                shouldClear = true;
	            }
	        }
	        else 
	        {
	            if (shouldClear) {
	                display.setText("");
	                shouldClear = false;
	            }
	            display.setText(display.getText() + text);
	        }
	    }
}
