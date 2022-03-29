import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;


/**
 * 
 */

/**
 * @author salt
 *
 */
public class DemoMDI {

	
	   final static String LOOKANDFEEL = "Metal";

	    // If you choose the Metal L&F, you can also choose a theme.
	    // Specify the theme to use by defining the THEME constant
	    // Valid values are: "DefaultMetal", "Ocean",  and "Test"
	    final static String THEME = "Ocean";

	
	 private static void initLookAndFeel() {
	        String lookAndFeel = null;
	       
	        if (LOOKANDFEEL != null) {
	            if (LOOKANDFEEL.equals("Metal")) {
	                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
	              //  an alternative way to set the Metal L&F is to replace the 
	              // previous line with:
	              // lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
	                
	            }
	            
	            else if (LOOKANDFEEL.equals("System")) {
	                lookAndFeel = UIManager.getSystemLookAndFeelClassName();
	            } 
	            
	            else if (LOOKANDFEEL.equals("Motif")) {
	                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	            } 
	            
	            else if (LOOKANDFEEL.equals("GTK")) { 
	                lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	            } 
	            
	            else {
	                System.err.println("Unexpected value of LOOKANDFEEL specified: "
	                                   + LOOKANDFEEL);
	                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
	            }

	            try {
	            	
	            	
	                UIManager.setLookAndFeel(lookAndFeel);
	                
	                // If L&F = "Metal", set the theme
	                
	                if (LOOKANDFEEL.equals("Metal")) {
	                  if (THEME.equals("DefaultMetal"))
	                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
	                  else if (THEME.equals("Ocean"))
	                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());

	                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
	                }	
	                
	            } 
	            
	            catch (ClassNotFoundException e) {
	                System.err.println("Couldn't find class for specified look and feel:"
	                                   + lookAndFeel);
	                System.err.println("Did you include the L&F library in the class path?");
	                System.err.println("Using the default look and feel.");
	            } 
	            
	            catch (UnsupportedLookAndFeelException e) {
	                System.err.println("Can't use the specified look and feel ("
	                                   + lookAndFeel
	                                   + ") on this platform.");
	                System.err.println("Using the default look and feel.");
	            } 
	            
	            catch (Exception e) {
	                System.err.println("Couldn't get specified look and feel ("
	                                   + lookAndFeel
	                                   + "), for some reason.");
	                System.err.println("Using the default look and feel.");
	                e.printStackTrace();
	            }
	        }
	    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });	

	}
	
	public  static void createAndShowGUI()
	{
	
try {
			
	        initLookAndFeel();
	        JFrame.setDefaultLookAndFeelDecorated(true);

			
			//URL url = new URL("file://www.salt11.com.ar/iSalt/img/photos/9.jpg");
			//File file = new File("ImagenFondo.jpg");
			System.out.println("Init");
			//BufferedImage image = ImageIO.read(file);
			JDesktopPane pane = new JDesktopPane();
			//pane.setBorder(new ImagenFondo(image));
			
			JInternalFrame internal = new JInternalFrame("internal",true,true,true,true);
			internal.setBounds(100, 100, 200, 300);
			internal.setVisible(true);
			pane.add(internal);
			
			JInternalFrame internal2 = new JInternalFrame("internal2",true,true,true,true);
			internal2.setBounds(10, 10, 200, 300);
			internal2.setVisible(true);
			pane.add(internal2);
			
			JFrame f = new JFrame("mdi app"); 
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setContentPane(pane);
			f.setVisible(true);
			f.setSize(800,600);
			
			
		//} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
