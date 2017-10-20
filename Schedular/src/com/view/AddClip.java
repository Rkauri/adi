package com.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.dao.ClipDaoImpl;
import com.model.Clip;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class AddClip extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public AddClip() {
		setLayout(null);
		String checkAds=null;
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Add Clip", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 5, 430, 342);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("File Name");
		lblNewLabel.setBounds(10, 22, 90, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(184, 19, 187, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFileType = new JLabel("File Type");
		lblFileType.setBounds(10, 84, 65, 14);
		panel.add(lblFileType);
		
		JLabel lblFileDuration = new JLabel("File Duration");
		lblFileDuration.setBounds(10, 53, 100, 14);
		panel.add(lblFileDuration);
		
		JLabel lblAds = new JLabel("Ads");
		lblAds.setBounds(10, 118, 46, 14);
		panel.add(lblAds);
		
		JLabel lblNoOfTime = new JLabel("No of time played");
		lblNoOfTime.setBounds(10, 149, 124, 14);
		panel.add(lblNoOfTime);
		
		JLabel lblMaximum = new JLabel("Maximum ");
		lblMaximum.setBounds(10, 180, 100, 14);
		panel.add(lblMaximum);
		
		JLabel lblMinimum = new JLabel("Minimum");
		lblMinimum.setBounds(10, 211, 124, 14);
		panel.add(lblMinimum);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(10, 241, 90, 14);
		panel.add(lblGenre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 50, 187, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(184, 146, 187, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(184, 177, 187, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(184, 208, 187, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(184, 238, 187, 20);
		panel.add(textField_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Audio\t", "Video"}));
		comboBox.setBounds(184, 81, 187, 20);
		panel.add(comboBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");	
		rdbtnNewRadioButton.setActionCommand("Yes");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(184, 108, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1.setActionCommand("No");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(295, 108, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clip clipObj= new Clip();
				clipObj.setFilename(textField.getText());
				clipObj.setFile_duration(Long.parseLong(textField_1.getText()));
				String filetypevalue=comboBox.getSelectedItem().toString();
				
				if(filetypevalue.equals("Audio")){
					clipObj.setFile_type(1);
				}else{
					clipObj.setFile_type(0);
				}
				String checkAds= buttonGroup.getSelection().getActionCommand();
				System.out.println(checkAds);	
				if(checkAds.equals("Yes")){
				clipObj.setCheck_ads(true);
				}else{
					clipObj.setCheck_ads(false);
				}
				clipObj.setNo_of_times_played(Integer.parseInt(textField_2.getText()));
				clipObj.setMax(Integer.parseInt(textField_3.getText()));
				clipObj.setMin(Integer.parseInt(textField_4.getText()));
				clipObj.setGenre(textField_5.getText());
				ClipDaoImpl addClipobj= new ClipDaoImpl();
				addClipobj.addClip(clipObj);
			}
		});
		btnSubmit.setBounds(65, 279, 89, 23);
		panel.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(206, 279, 89, 23);
		panel.add(btnCancel);

	}
}
