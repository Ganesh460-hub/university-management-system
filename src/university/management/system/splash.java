package university.management.system;

import javax.swing.*;
import java.awt.*;

public class splash extends JFrame implements Runnable {
    Thread t;
    splash(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.png"));
        Image i2 = i1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img =  new JLabel(i3);
        add(img);

        t=new Thread(this);
        t.start();
      setVisible(true);

      int x =1;
      for(int  i =2; i<=600; i+=4, x+=2 ){
          setLocation(600-((i + x)/2), 350-(i/2));
          setSize(i+3*x,i+x/2);
          try{
              Thread.sleep(10);

          } catch (Exception e) {

              e.printStackTrace();
          }
        }
    }
    public void run(){
        try{
         Thread.sleep(7000);
                 setVisible(false);
         new login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new splash();
    }
}
