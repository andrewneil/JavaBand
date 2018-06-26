import java.awt.*;
import java.awt.event.*; 
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class JavaBand extends JFrame implements ActionListener 
{

	// BUTTONS AND TEXTAREA //
	JButton rwdBtn   = new JButton("Previous");		
	JButton playBtn  = new JButton("Play");
	JButton pauseBtn = new JButton("Pause");
	JButton fwdBtn   = new JButton("Next");			
	JButton saveBtn  = new JButton("Save");
	JButton loadBtn  = new JButton("Load");
	JButton newBtn  =  new JButton("New");
	
	// DRUM SET BUTTONS //
	Dimension size = new Dimension(40,40);
	JButton snare = new JButton("Snare" );
	//snare.setAlignmentY(BOTTOM_ALIGNMENT);
	JButton bass = new JButton("Bass");
	JButton hihat = new JButton("Hi-Hat");
	JButton crash = new JButton("Crash");
	JButton ride = new JButton("Ride");
	JButton highTom = new JButton("H-Tom");
	JButton midTom = new JButton("M-Tom");
	JButton floorTom = new JButton("L-Tom");
	
	// MAIN //
	public static void main(String[] args) 
	{
		new JavaBand();		
	    //new playSound();
		//new stopSound(); ????
	} // end of main 

		public JavaBand() {
			
			super("Java Band");
			Container pnlMain = this.getContentPane();
			Panel pnlButtons = new Panel();					// buttons for controls (play,pause,record)
			JPanel drumPanel = new JPanel(); 				// buttons to play drums 
			JTabbedPane drumPane = new JTabbedPane();	// to create a pane
			drumPane.addTab("Drum", drumPanel);			// add drum pane
			add(drumPane, BorderLayout.CENTER);			// add pane with center border
			
			
			//	JPANEL SETTINGS //
			pnlMain.setLayout(new BorderLayout());
			pnlMain.add(drumPanel, BorderLayout.CENTER);
	    	pnlMain.add(pnlButtons, BorderLayout.SOUTH);
	    	
	     	// ADDING THE BUTTONS TO THE PANEL - ADD BUTTONS HERE //
	    	pnlButtons.setLayout(new FlowLayout());
	    	pnlButtons.add(rwdBtn);				// goes back to previous frame
	    	pnlButtons.add(playBtn);			// goes through all frames
	    	pnlButtons.add(pauseBtn);			// stops at a frame
	    	pnlButtons.add(fwdBtn);				// advances 1 frame
	    	pnlButtons.add(saveBtn);			// saves a frame
	    	pnlButtons.add(loadBtn); 			// loads a frame
	    	pnlButtons.add(newBtn);				// adds a new frame
	    	
	    	// DRUM BUTTON LAYOUT //
	    	drumPanel.setLayout(new GridLayout(3,0));
	    	drumPanel.add(snare);				// snare drum
	    	snare.setAlignmentY(CENTER_ALIGNMENT);
	    	drumPanel.add(bass);				// bass drum
	    	drumPanel.add(hihat);				// hihat drum
	    	drumPanel.add(crash);				// crash drum
	    	drumPanel.add(ride);				// ride drum
	    	drumPanel.add(highTom);				// highTom drum
	    	drumPanel.add(midTom);				// midTom drum
	    	drumPanel.add(floorTom);			// floorTom drum
	    	
	    	// DRUM BUTTON ACTION-LISTENERS //
	    	snare.addActionListener(this);
	    	bass.addActionListener(this);
	    	hihat.addActionListener(this);
	    	crash.addActionListener(this);
	    	ride.addActionListener(this);
	    	highTom.addActionListener(this);
	    	midTom.addActionListener(this);
	    	floorTom.addActionListener(this);
	    	
	    	// GIVING EACH BUTTON AN ACTION-LISTENER //
	    	rwdBtn.addActionListener(this);
	    	playBtn.addActionListener(this);
	    	pauseBtn.addActionListener(this);
	    	fwdBtn.addActionListener(this);
	    	saveBtn.addActionListener(this);
	    	loadBtn.addActionListener(this);
	    	newBtn.addActionListener(this);

	    	// WINDOW SETTINGS (JFRAME) //
	    	this.setDefaultCloseOperation(JavaBand.EXIT_ON_CLOSE);
	    	this.pack();
	    	this.setSize(640, 480);		// SIZE OF WINDOW (WIDTH,HEIGHT)
	    	this.setVisible(true);
	    	
			}
		
		// THE ACTION THE BUTTONS WILL PERFORM SETTINGS HERE 
	    public void actionPerformed(ActionEvent e){
	    
	    	//String output = "";
	    	
	    	if (e.getSource() == rwdBtn){
	    	  
	    		
	    	  rwdBtn.setBackground(Color.ORANGE);
	    	  playBtn.setBackground(null);
	    	  pauseBtn.setBackground(null);
	          fwdBtn.setBackground(null);
	          saveBtn.setBackground(null);
	          loadBtn.setBackground(null);
	    	} else if (e.getSource() == playBtn){
	    	 // output = "Playing!";
	    	  rwdBtn.setBackground(null);
	    	  playBtn.setBackground(Color.GREEN);
	    	  pauseBtn.setBackground(null);
	          fwdBtn.setBackground(null);
	          saveBtn.setBackground(null);
	          loadBtn.setBackground(null);

	        } else if (e.getSource() == pauseBtn){
	  	      //output = "Pausing!";
	  	      rwdBtn.setBackground(null);
	  	      playBtn.setBackground(null);
	  	      pauseBtn.setBackground(Color.RED);
	          fwdBtn.setBackground(null);
	          saveBtn.setBackground(null);
	          loadBtn.setBackground(null);
	        } else if (e.getSource() == fwdBtn){
		     
	        	//output = "Forwarding!";
		      rwdBtn.setBackground(null);
	    	  playBtn.setBackground(null);
	    	  pauseBtn.setBackground(null);
	          fwdBtn.setBackground(Color.ORANGE);
	          saveBtn.setBackground(null);
	          loadBtn.setBackground(null);
	        } else if (e.getSource() == saveBtn){
	          //textArea.setText(text);  
	        	//output = "Frame Saved!";
	          rwdBtn.setBackground(null);
	    	  playBtn.setBackground(null);
	    	  pauseBtn.setBackground(null);
	          fwdBtn.setBackground(null);
	          saveBtn.setBackground(Color.CYAN);
	          loadBtn.setBackground(null);
	        } else if (e.getSource() == loadBtn){
	          //textArea.setText(text);
	        	//System.out.println(text);
	          //textArea.getText(text); 
	          rwdBtn.setBackground(null);
	          playBtn.setBackground(null);
	          pauseBtn.setBackground(null);
	          fwdBtn.setBackground(null);
	          saveBtn.setBackground(null);
	          loadBtn.setBackground(Color.YELLOW);
	        	//textArea.setText(text);
	        } else {
		      //output = "ERROR! CHECK CODE!";
		      System.out.println(e.getActionCommand());
		    } // end if
	    } // end actionPerformed
	   
}