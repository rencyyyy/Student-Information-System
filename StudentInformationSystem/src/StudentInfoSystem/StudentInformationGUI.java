package StudentInfoSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class StudentInformationGUI {

	private JFrame frame;
	private JTextField idNum;
	private JTextField studGender;
	private JTextField studName;
	private JTextField studProgram;
	private JTable table;
	private JScrollPane scrollPane;
	DefaultTableModel model;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInformationGUI window = new StudentInformationGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentInformationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 237, 204));
		frame.getContentPane().setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		frame.setBounds(100, 100, 602, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT INFORMATION SYSTEM");
		lblNewLabel.setForeground(new Color(63, 63, 63));
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 586, 83);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID NUMBER:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(47, 116, 122, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("GENDER:");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(282, 147, 85, 18);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("NAME:");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(282, 116, 64, 20);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("PROGRAM:");
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(47, 147, 122, 18);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		idNum = new JTextField();
		idNum.setBounds(137, 115, 135, 20);
		frame.getContentPane().add(idNum);
		idNum.setColumns(10);
		
		studGender = new JTextField();
		studGender.setColumns(10);
		studGender.setBounds(356, 145, 185, 20);
		frame.getContentPane().add(studGender);
		
		studName = new JTextField();
		studName.setColumns(10);
		studName.setBounds(356, 114, 185, 20);
		frame.getContentPane().add(studName);
		
		studProgram = new JTextField();
		studProgram.setColumns(10);
		studProgram.setBounds(137, 147, 135, 20);
		frame.getContentPane().add(studProgram);
		
		JButton addBTN = new JButton("ADD");
		addBTN.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (idNum.getText() .equals("") || studName.getText() .equals("") || studGender.getText() .equals("") || studProgram.getText().equals(("")))
				{
					JOptionPane.showMessageDialog(null, " We need some additional details to proceed. Please complete the form.");
				}else {
					
					String[] row = new String [4];
					row[0]=idNum.getText();
					row[1]=studName.getText();
					row[2]=studGender.getText();
					row[3]=studProgram.getText();
					model.addRow(row);
					
					idNum.setText(null);
					studName.setText(null);
					studGender.setText(null);
					studProgram.setText(null);
					JOptionPane.showMessageDialog(null, " Information saved successfully.");
				}
			}
		});
		
		
		addBTN.setBounds(56, 239, 89, 23);
		frame.getContentPane().add(addBTN);
		
		JButton delBTN = new JButton("DELETE");
		delBTN.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				int i = table.getSelectedRow();
				if (i>=0)
				{
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, " Successfully Deleted");
				} else {
					JOptionPane.showMessageDialog(null, " Select row first");
				}
			}
		});
		delBTN.setBounds(257, 239, 89, 23);
		frame.getContentPane().add(delBTN);
		
		JButton clearBTN = new JButton("CLEAR");
		clearBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idNum.setText(null);
				studName.setText(null);
				studGender.setText(null);
				studProgram.setText(null);
			}
		});
		JButton updBTN = new JButton("UPDATE");
		updBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				model.setValueAt(idNum.getText(), i , 0);
				model.setValueAt(studName.getText(), i , 1);
				model.setValueAt(studGender.getText(), i , 2);
				model.setValueAt(studProgram.getText(), i , 3);
			}
		});
		updBTN.setBounds(157, 239, 89, 23);
		frame.getContentPane().add(updBTN);
		clearBTN.setBounds(353, 239, 89, 23);
		frame.getContentPane().add(clearBTN);
		
		JButton exitBTN = new JButton("EXIT");
		exitBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitBTN.setBounds(452, 239, 89, 23);
		frame.getContentPane().add(exitBTN);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ASUS_LCL\\Desktop\\red.jpg.crdownload"));
		lblNewLabel_2.setBounds(0, 0, 586, 83);
		frame.getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 294, 531, 165);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(185, 0, 0));
		model=new DefaultTableModel();
		Object[] column = {"ID", "Name", "Gender", "Program"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		table.setBackground(new Color(245, 245, 245));
		scrollPane.setViewportView(table);
	}
}
