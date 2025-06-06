package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {

    JTextField textName,textfather,textAddress,textPhone,textemail,textM10,textM12,textAadharNo;

    JLabel empText;

    JDateChooser cdob;

    JComboBox courseBox,DepartementBox;

    JButton submit,cancel;

    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent(){
        getContentPane().setBackground(new Color(128,176,255));

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("NAME");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif", Font.BOLD,20));
        add(name);

        textName = new JTextField();
        textName.setBounds(200,150,150,30);
        add(textName);

        JLabel fname = new JLabel("FATHER NAME");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif", Font.BOLD,20));
        add(fname);

        textfather = new JTextField();
        textfather.setBounds(600,150,150,30);
        add(textfather);

        JLabel empID = new JLabel("ROLL NUMBER");
        empID.setBounds(50,200,200,30);
        empID.setFont(new Font("serif", Font.BOLD,20));
        add(empID);

        empText = new JLabel("1409"+f4);
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif", Font.BOLD,20));
        add(empText);

        JLabel dob = new JLabel("DATA OF BIRTH");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif", Font.BOLD,20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600,200,150,30);
        add(cdob);

        JLabel address = new JLabel("ADDRESS");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif", Font.BOLD,20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200,250,150,30);
        add(textAddress);

        JLabel phone = new JLabel("PHONE");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("serif", Font.BOLD,20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600,250,150,30);
        add(textPhone);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif", Font.BOLD,20));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(200,300,150,30);
        add(textemail);


        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(400,300,200,30);
        M10.setFont(new Font("serif", Font.BOLD,20));
        add(M10);

        textM10 = new JTextField();
        textM10.setBounds(600,300,150,30);
        add(textM10);

        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif", Font.BOLD,20));
        add(M12);

        textM12 = new JTextField();
        textM12.setBounds(200,350,150,30);
        add(textM12);

        JLabel AadharNo = new JLabel("AADHAR NUMBER");
        AadharNo.setBounds(400,350,200,30);
        AadharNo.setFont(new Font("serif", Font.BOLD,20));
        add(AadharNo);

        textAadharNo = new JTextField();
        textAadharNo.setBounds(600,350,150,30);
        add(textAadharNo);

        JLabel Qualification = new JLabel("Course");
        Qualification.setBounds(50,400,200,30);
        Qualification.setFont(new Font("serif", Font.BOLD,20));
        add(Qualification);

        String course[]= {"B.Tech","BBA","BCA","BSC","MSC","MBA","MCA","MCom","MA","BA"};
        courseBox = new JComboBox<>(course);
        courseBox.setBounds(200,400,150,30);
        courseBox.setBackground(Color.white);
        add(courseBox);

        JLabel Departement = new JLabel("Branch");
        Departement.setBounds(400,400,200,30);
        Departement.setFont(new Font("serif", Font.BOLD,20));
        add(Departement);

        String departement[]= {"Computer Science","Electronics","Mechanical","CIVIL","IT"};
        DepartementBox = new JComboBox<>(departement);
        DepartementBox.setBounds(600,400,150,30);
        DepartementBox.setBackground(Color.white);
        add(DepartementBox);

        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String name = textName.getText();
            String fname = textfather.getText();
            String empid = empText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textemail.getText();
            String X = textM10.getText();
            String XII = textM12.getText();
            String aadhar = textAadharNo.getText();
            String course = (String) courseBox.getSelectedItem();
            String departement = (String)  DepartementBox.getSelectedItem();
            try{
                String q = "insert into student values('"+name +"','"+fname+"','"+empid +"','"+dob +"','"+address +"','"+phone +"','"+email +"','"+ X+"','"+XII +"','"+aadhar +"','"+course +"','"+departement +"')" ;
                conn c = new conn();
                c.Statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Deatials inserted");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
          new AddStudent();
    }
}
