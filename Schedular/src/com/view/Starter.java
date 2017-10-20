package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JPanel;
import javax.swing.Timer;

public class Starter extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	int timeelspsed=0;
	int inmin=1000;
	Timer t= new Timer(1000, this);
	Timer voiceover = new Timer(inmin*2,this) ;
	Timer audio = new Timer(2000,this);
	Timer ads = new Timer(2000,this);
	public Starter() {
		setLayout(null);

		
		t.start();
	}
	

			
			
	

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	 if(timeelspsed==0){
		 voiceover.start();
		 System.out.println("hello voiceover "+ timeelspsed);
	 }
	 else if(timeelspsed==5){
		 voiceover.stop();
		 audio.start();
		 System.out.println("hello audio "+ timeelspsed);
	 }
	 else if(timeelspsed==8){
		 audio.stop();
		 voiceover.start();
		 System.out.println("hello voiceover "+ timeelspsed);
	 }
	 else if(timeelspsed==13){
		 voiceover.stop();
		 ads.start();
		 System.out.println("hello ads "+ timeelspsed);
	 }
	 else if(timeelspsed==15){
		 ads.stop();
		 audio.start();
		 System.out.println("hello audio "+ timeelspsed);
	 }
	 else if(timeelspsed==18){
		 audio.stop();
		 voiceover.start();
		 System.out.println("hello voiceover "+ timeelspsed);
	 }
	 else if(timeelspsed==23){
		 voiceover.stop();
		 ads.start();
		 System.out.println("hello ads "+ timeelspsed);
	 }
	 else if(timeelspsed==25){
		 ads.stop();
		 audio.start();
		 System.out.println("hello audio "+ timeelspsed);
	 }
	 else if(timeelspsed==28){
		 audio.stop();
		 voiceover.start();
		 System.out.println("hello voiceover "+ timeelspsed);
	 }
	 else if(timeelspsed==33){
		 voiceover.stop();
		 ads.start();
		 System.out.println("hello ads "+ timeelspsed);
	 }
	 else if(timeelspsed==35){
		 ads.stop();
		 audio.start();
		 System.out.println("hello audio "+ timeelspsed);
	 }
	 else if(timeelspsed==38){
		 audio.stop();
		 voiceover.start();
		 System.out.println("hello voiceover "+ timeelspsed);
	 }
	 else if(timeelspsed==43){
		 voiceover.stop();
		 ads.start();
		 System.out.println("hello ads "+ timeelspsed);
	 }
	 else if(timeelspsed==45){
		 ads.stop();
		 
	 }
	 else if(timeelspsed>45){
		 System.out.println("show is over");
		 t.stop();
	 }
	 timeelspsed++;
}
}
