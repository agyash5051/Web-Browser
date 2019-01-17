package webbrowser;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class body extends JFrame {
    
    private final JTextField addressBar;
    private final JEditorPane display;
    
    //constructor
    public body(){
        super("web browser");
        
        addressBar=new JTextField("enter a URL");
        addressBar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    readhtml(event.getActionCommand());
                }
            }
        );
        add(addressBar,BorderLayout.NORTH);
        display=new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
            new HyperlinkListener(){
                public void hyperlinkUpdate(HyperlinkEvent event){
                    if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
                        readhtml(event.getURL().toString());
                    }
                }
            }
        );
        add(new JScrollPane(display),BorderLayout.CENTER);
        setSize(500,300);
        setVisible(true);
    }
    private void readhtml(String userText){
        try{
            display.setPage(userText);
            addressBar.setText(userText);
        }catch(Exception e){
            System.out.println("error in url");
        }
    }
}
