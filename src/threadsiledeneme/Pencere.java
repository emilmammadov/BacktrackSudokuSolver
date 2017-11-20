package threadsiledeneme;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.TextComponent;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.javafx.scene.layout.region.Margins.Converter;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import javax.swing.JTable;
import java.awt.Font;

public class Pencere implements InterfaceThread{

	static int dizi1[][] = new int[9][9];
	static int dizi2[][] = new int[9][9];
	static int dizi3[][] = new int[9][9];
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Pencere pencere = new Pencere();
					pencere.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pencere() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 670, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 19));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(10, 11, 300, 340);
		
		JMenu dosya = new JMenu("Dosya");
		menuBar.add(dosya);
		
		JMenuItem acMenuItem = new JMenuItem("A\u00E7");
		acMenuItem.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==acMenuItem) {
					JFileChooser ac = new JFileChooser(new File("C:\\Users\\EMIL MAMMADOV\\Desktop"));
					ac.setDialogTitle("Açmak için dosya seç");
					ac.setFileFilter(new FileTypeFilter(".txt", "Text Dosyası"));
					
					if(ac.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
						File file = ac.getSelectedFile();
						try {
							BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
							String strSatir = "";
							String s = "";
							char[] ch;
							String yazi = "";
							
							while ((strSatir = br.readLine() ) != null) 
							{
								s += strSatir;
							}
							s = s.replace("*", "0");
							ch = s.toCharArray();
							int a=0;
							for(int i=0;i<9;i++) 
							{
								//System.out.println("ilk for");
								for(int j=0;j<9;j++)
								{
									dizi1[i][j] = Character.getNumericValue(ch[a]);
									dizi2[i][j] = Character.getNumericValue(ch[a]);
									dizi3[i][j] = Character.getNumericValue(ch[a]);
									//System.out.println(dizi[i][j]+"  "+ch[a]);
									a++;
								}
							}
							
							for (int c = 0; c < 9; ++c) {
							    if (c % 3 == 0)
								yazi += " -----------------------\n";
							    for (int d = 0; d < 9; ++d) {
								if (d % 3 == 0) yazi+= "| ";
								yazi += "" + dizi1[c][d] + "";
								
								yazi += ' ';
							    }
							    yazi += "|\n";
							}
							yazi += " -----------------------\n";
							
							
							
							textArea.setText(yazi);
							if(br != null) {
								br.close();
								
							}
						} 
						catch (IOException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
							}
						
					}
			}
				
				
				
				
			}
		});
		
		dosya.add(acMenuItem);
		frame.getContentPane().setLayout(null);
		
		JButton cozButton = new JButton("\u00C7\u00F6z");
		cozButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				thread1.start();
				thread2.start();
		        thread3.start();   
		        
			}
		});
		cozButton.setBounds(400, 154, 186, 70);
		frame.getContentPane().add(cozButton);
		
		frame.getContentPane().add(textArea);
		 
	}
	
}
