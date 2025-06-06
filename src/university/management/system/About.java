package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {


    About(){

        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/about.png"));
        Image i2 = i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,0,300,200);
        add(img);



        JLabel heading = new JLabel("<html> MARVEL & DC</br>UNIVERSE</html>");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        add(heading);

        JLabel Name = new JLabel("IRONMAN");
        Name.setBounds(60,260,550,40);
        Name.setFont(new Font("Tahoma", Font.BOLD,30));
        add(Name);

        JLabel Contact = new JLabel(" ganeshnalla460@gmail.com // 8499887315 ");
        Contact.setBounds(70,340,550,40);
        Contact.setFont(new Font("Tahoma", Font.BOLD,30));
        add(Contact);


        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(new Color(252,228,210));
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
       new About();
    }
}
