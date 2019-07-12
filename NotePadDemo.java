import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class NotePadDemo extends JFrame implements ActionListener{
    private JFileChooser chooser;
    private JTextArea ta;
    private JButton btn;
    private Container c;
    private Font f;
    
    
    NotePadDemo(){
        c = this.getContentPane();
        c.setLayout(null);
        f = new Font("Arial",Font.PLAIN,18);
        
        ta = new JTextArea();
        ta.setBounds(20,20,765,480);
        ta.setFont(f);
	
        c.add(ta);
        btn = new JButton("Open File");
        btn.setBounds(350,510,100,50);
        c.add(btn);
        
        btn.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            try {
                chooser = new JFileChooser();
                chooser.showOpenDialog(null);
		
                File file = chooser.getSelectedFile();
            
                Scanner input = new Scanner(file);
                while (input.hasNext()) {
                    String s = input.nextLine();
                    ta.append(s + " \r\n");

                }
                input.close();
            } catch (FileNotFoundException ex) {
               
            }
        }
    }
    
    public static void main(String[] args) {
        
        NotePadDemo frame = new NotePadDemo();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(50,50,800,600);
        frame.setTitle("XOXO  Note Pad");
        
        
    }

    
    
}
