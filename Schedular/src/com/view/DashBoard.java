package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.ShowDaoImpl;

import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.CardLayout;

public class DashBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard();
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
	public DashBoard() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 449);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
				
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnShow = new JMenu("Show");
		menuBar.add(mnShow);
		
		
		JMenuItem mntmAddShow = new JMenuItem("Add Show");
		
		mnShow.add(mntmAddShow);
		
		JMenuItem mntmViewShow = new JMenuItem("View Show");
		mntmViewShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		ShowDaoImpl obj= new ShowDaoImpl();
				ShowList viewalllist= new ShowList(obj.getAllShow());
				makeVisible(viewalllist);
			}
		});
		mnShow.add(mntmViewShow);
		
		JMenu mnClip = new JMenu("Clip");
		menuBar.add(mnClip);
		
		JMenuItem mntmAddClip = new JMenuItem("Add Clip");
		mntmAddClip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddClip c = new AddClip();
				makeVisible(c);
//				contentPane.add(c);
//				
//				//panel.setVisible(false);
//				c.setVisible(true);
//				contentPane.revalidate();
			}
		});
		mnClip.add(mntmAddClip);
		mntmAddShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddShow add123 = new AddShow();
			
			makeVisible(add123);
			
//			//panel.setVisible(false);
//			add123.setVisible(true);
//			contentPane.revalidate();
//			
			}
		});
		
	
	}
	public void makeVisible(JPanel panel){
		contentPane.removeAll();
		contentPane.repaint();
		contentPane.add(panel);
		panel.setVisible(true);
		contentPane.revalidate();
	}
}
