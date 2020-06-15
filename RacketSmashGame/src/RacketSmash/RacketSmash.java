package RacketSmash;

import java.awt.Dimension;

import javax.swing.JFrame;



public class RacketSmash {
	
	JFrame frame;
	
	TennisGamePanel tgp;
	
	final static int width = 1000;
	
	final static int height = 950;
	
	public RacketSmash() {
		
		frame = new JFrame();
		
		tgp = new TennisGamePanel();
		
		
		
	}

	public static void main(String[] args) {
		
		RacketSmash rs = new RacketSmash();
		rs.setupWindow();
		
	}
	
	void setupWindow () {
		
		frame.setSize(width , height);
		
		frame.add(tgp);
		frame.addKeyListener(tgp);

		frame.getContentPane().setPreferredSize(new Dimension(width,height));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		

		
		
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

}
