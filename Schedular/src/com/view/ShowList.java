package com.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.dao.ClipDaoImpl;
import com.dao.ShowDaoImpl;
import com.model.Clip;
import com.model.Show;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowList extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ShowList(List<Show> showlist) {
		setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 11, 353, 263);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);		
		Object header[]={"S.N","Show Name","Duration","Genre"};
		DefaultTableModel model= new DefaultTableModel(header,4);
		
		model.setRowCount(0);
		for(Show showObj:showlist){			
			model.addRow(new Object[]{showObj.getId(),showObj.getShowName(),showObj.getDuration(),showObj.getGenre()});
		}
		table.setModel(model);
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Starter s= new Starter();
				List<Clip> clist;
				int row= table.getSelectedRow();				
				if(row>=0){
				int a=(Integer) table.getModel().getValueAt(row, 0);
				ShowDaoImpl obj= new ShowDaoImpl();
				Show showObj=obj.getShowById(a);
	
				ClipDaoImpl cliobj= new ClipDaoImpl();
				if(showObj.getType()==1){
				 clist=cliobj.getClipByLength(showObj.getMin_audio(), showObj.getType(), showObj.getGenre());
				System.out.println("start1:audio: "+clist.size());
				}else if(showObj.getType()==2){
					 clist=cliobj.getClipByLength(showObj.getMin_video(), showObj.getType(), showObj.getGenre());	
					System.out.println("start1:video: "+clist.size());
				}
				}else{
					JOptionPane.showMessageDialog(null, "Please select one row");
					}	
			
			}
		});
		btnStart.setBounds(397, 11, 89, 23);
		add(btnStart);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(397, 45, 89, 23);
		add(btnEdit);
		
	
	}
}
