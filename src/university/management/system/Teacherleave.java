package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Teacherleave extends JFrame implements ActionListener {

    Choice choiceRollNo , choTime;

    JDateChooser selDate;

    JButton Submit ,Cancel;


    Teacherleave(){

        getContentPane().setBackground(new Color(210,232,252));

        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("tahoma",Font.BOLD,20));
        add(heading);

        JLabel RolNoSE = new JLabel("Search by EMPLOYEE ID");
        RolNoSE .setBounds(60,100,200,20);
        RolNoSE .setFont(new Font("tahoma",Font.PLAIN,18));
        add(RolNoSE);

        choiceRollNo = new Choice();
        choiceRollNo.setBounds(60,130,200,20);
        add(choiceRollNo);

        try{
            conn c = new conn();
            ResultSet resultSet = c.Statement.executeQuery("select * from teacher");
            while (resultSet.next()){
                choiceRollNo.add(resultSet.getString("empID"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lbldate);

        selDate = new JDateChooser();
        selDate.setBounds(60,210,200,25);
        add(selDate);

        JLabel time = new JLabel("Time Duration");
        time.setBounds(60,260,200,20);
        time.setFont(new Font("tahoma",Font.PLAIN,18));
        add(time);

        choTime = new Choice();
        choTime.setBounds(60,290,200,20);
        choTime.add("FULL DAY");
        choTime.add("HALF DAY");
        add(choTime);

        Submit = new JButton("Submit");
        Submit.setBounds(60,350,100,25);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(200,350,100,25);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.addActionListener(this);
        add(Cancel);

        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Submit){
            String rollno = choiceRollNo.getSelectedItem();
            String date = ((JTextField) selDate.getDateEditor()).getText();
            String time = choTime.getSelectedItem();

            String Q = "insert into Teacherleave values('"+rollno+"','"+date+"','"+time+"')";
            try{
                conn c = new conn();
                c.Statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Leave Conirmed");
                setVisible(false);



            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Teacherleave();
    }
}
