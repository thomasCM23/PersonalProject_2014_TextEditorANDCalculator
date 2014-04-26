import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LightText extends JFrame{
	
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private JMenuBar jMenuBar1;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenu font;
	private JMenuItem arial;
	private Font arial1;
	private JMenuItem verdana;
	private Font verdana1;
	private JMenuItem cantarell;
	private Font cantarell1;
	private JMenuItem open;
	private JMenuItem save;
	private JFileChooser file;
	private File fOpen;
	private Scanner fRead = null;
	private PrintWriter fWrite = null;
	private String readFile = "";
	private String path= null;
	private boolean isOpen = false;
	
	public LightText(){
		super("Light Text");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		init();
	}

	private void init() {
		jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        file = new JFileChooser();
        open = new JMenuItem();
        save = new JMenuItem();
        font = new JMenu();
        arial = new JMenuItem();
        arial1 = new Font("Arail", 15, 15);
        verdana = new JMenuItem();
        verdana1 = new Font("Verdana", 15, 15);
        cantarell = new JMenuItem();
        cantarell1 = new Font("Cantarell", 15, 15);
        

     

        jTextArea1.setSize(getWidth(), getHeight());
        
        jScrollPane1.setViewportView(jTextArea1);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, getWidth(), Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, getHeight(), Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        open.setText("Open");
        jMenu1.add(open);
        open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				int returnVal = file.showOpenDialog(LightText.this);
					if(returnVal == JFileChooser.APPROVE_OPTION){
						fOpen = file.getSelectedFile();
						path = fOpen.getAbsolutePath();
						try {
							fRead = new Scanner(new FileReader(fOpen));
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						while(fRead.hasNextLine()){
							
							readFile = readFile +'\n'+ fRead.nextLine();
						}
					}
				jTextArea1.setText(readFile);
				isOpen = true;
				fRead.close();
			}
			
        	
        });
        jMenu1.add(save);
        save.setText("Save");
        save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(isOpen){
					try {
						fWrite = new PrintWriter(path);
						fWrite.println(jTextArea1.getText());
						fWrite.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
				}
				else{
					file = new JFileChooser();
					int returnv = file.showSaveDialog(LightText.this);
					if( returnv == file.APPROVE_OPTION){
						fOpen = file.getSelectedFile();
						path = fOpen.getAbsolutePath();
						try {
							fWrite = new PrintWriter(path);
							fWrite.println(jTextArea1.getText());
							fWrite.close();
							isOpen = true;
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						System.out.println(fOpen.getName());
					}
				}
				
			}
        	
        });
        jMenuBar1.add(jMenu1);
        
        jMenu2.setText("Edit");
        font.setText("Font");
        cantarell.setText("Cantarell");
        font.add(cantarell);
        cantarell.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				jTextArea1.setFont(cantarell1);
				
			}
        	
        });
        arial.setText("Arial");
        font.add(arial);
        arial.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				jTextArea1.setFont(arial1);
				
			}
        	
        });
        verdana.setText("Verdana");
        font.add(verdana);
        verdana.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				jTextArea1.setFont(verdana1);
				
			}
        	
        });
        jMenu2.add(font);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
		
	}
	
	public static void main(String[] args){
		LightText lt = new LightText();
		lt.setVisible(true);
	}

}
