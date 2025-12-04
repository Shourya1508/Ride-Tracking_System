import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
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
	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(314, 118, 233, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(314, 157, 233, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(314, 196, 233, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(314, 236, 233, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(314, 275, 233, 28);
		contentPane.add(textField_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(314, 320, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(438, 320, 109, 23);
		contentPane.add(rdbtnFemale);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(243, 121, 61, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateOfBirth.setBounds(195, 164, 109, 21);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setBounds(249, 203, 55, 21);
		contentPane.add(lblAge);
		
		JLabel lblCurrentAddress = new JLabel("Current Address");
		lblCurrentAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCurrentAddress.setBounds(175, 243, 129, 21);
		contentPane.add(lblCurrentAddress);
		
		JLabel lblPermanentAddress = new JLabel("Permanent Address");
		lblPermanentAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPermanentAddress.setBounds(154, 282, 150, 21);
		contentPane.add(lblPermanentAddress);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(231, 324, 73, 21);
		contentPane.add(lblGender);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(314, 361, 233, 28);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(314, 400, 233, 28);
		contentPane.add(textField_6);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblState.setBounds(236, 368, 68, 21);
		contentPane.add(lblState);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCountry.setBounds(221, 407, 83, 21);
		contentPane.add(lblCountry);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(361, 453, 129, 28);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Registration Form");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(333, 25, 245, 40);
		contentPane.add(lblNewLabel_1);
	}
}
