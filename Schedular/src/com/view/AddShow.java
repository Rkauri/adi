package com.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import com.dao.ShowDaoImpl;
import com.model.Show;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddShow extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public AddShow() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Add Show", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 430, 381);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblShowName = new JLabel("Show Name");
		lblShowName.setBounds(10, 24, 115, 14);
		panel.add(lblShowName);
		
		textField = new JTextField();
		textField.setBounds(171, 21, 224, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(10, 63, 46, 14);
		panel.add(lblDuration);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 60, 224, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAudionDuration = new JLabel("Audion Duration");
		lblAudionDuration.setBounds(10, 143, 115, 14);
		panel.add(lblAudionDuration);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 140, 225, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblVideoDuration = new JLabel("Video Duration");
		lblVideoDuration.setBounds(10, 180, 115, 14);
		panel.add(lblVideoDuration);
		
		textField_3 = new JTextField();
		textField_3.setBounds(169, 171, 226, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAdsDuration = new JLabel("Ads Duration");
		lblAdsDuration.setBounds(10, 210, 115, 14);
		panel.add(lblAdsDuration);
		
		textField_4 = new JTextField();
		textField_4.setBounds(170, 202, 225, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblVoiceDuration = new JLabel("Voice Duration");
		lblVoiceDuration.setBounds(10, 236, 115, 14);
		panel.add(lblVoiceDuration);
		
		textField_5 = new JTextField();
		textField_5.setBounds(171, 233, 224, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(10, 109, 46, 14);
		panel.add(lblType);
		
		textField_6 = new JTextField();
		textField_6.setBounds(170, 264, 225, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(10, 270, 46, 14);
		panel.add(lblGenre);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().equals("Audio")){
					textField_3.setText("0");
					textField_3.setEditable(false);
					textField_2.setEnabled(true);
				}else if(comboBox.getSelectedItem().equals("Multimedia")){
					textField_2.setText("0");
					textField_2.setEditable(false);
					textField_3.setEnabled(true);
				}
			}
		});
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choose Type", "Audio", "Multimedia"}));
		comboBox.setBounds(171, 103, 224, 20);
		panel.add(comboBox);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Show showObj= new Show();
				showObj.setShowName(textField.getText());
				showObj.setDuration(Long.parseLong(textField_1.getText()));
					
				showObj.setMin_audio(Long.parseLong(textField_2.getText()));
				showObj.setMin_video(Long.parseLong(textField_3.getText()));
					
				showObj.setMin_adds(Long.parseLong(textField_4.getText()));
				showObj.setMin_voice(Long.parseLong(textField_5.getText()));
				showObj.setGenre(textField_6.getText());
				showObj.setNo_of_times_played(Integer.parseInt(textField_7.getText()));
				String typeStringValue=comboBox.getSelectedItem().toString();
				int typeInt=0;
				if(typeStringValue.equals("Audio")){
					typeInt=1;
				}
				else if(typeStringValue.equals("Multimedia")){
					typeInt=2;
				}
				showObj.setType(typeInt);
				ShowDaoImpl  s= new ShowDaoImpl();
				if(s.addShow(showObj)){
					JOptionPane.showMessageDialog(null, "Insert is successful");
				}		
			}
		});
		btnSubmit.setBounds(40, 347, 100, 23);
		panel.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(207, 347, 100, 23);
		panel.add(btnCancel);
		
		JLabel lblNoOfTime = new JLabel("No of Time Played");
		lblNoOfTime.setBounds(10, 307, 130, 14);
		panel.add(lblNoOfTime);
		
		textField_7 = new JTextField();
		textField_7.setBounds(171, 304, 224, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);

	}
}
