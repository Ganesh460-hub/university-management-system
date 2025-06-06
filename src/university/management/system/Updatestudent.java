package university.management.system;

import com.mysql.cj.xdevapi.UpdateStatement;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Updatestudent extends JFrame implements ActionListener {

    JTextField textAddress,textPhone,textemail,textAadharNo,textcourse, textbranch;

    Choice cEMPID;

    JLabel empText;

    JDateChooser cdob;

    JComboBox courseBox,DepartementBox;

    JButton submit,cancel;

    Updatestudent(){


        getContentPane().setBackground(new Color(230,210,252));

        JLabel heading = new JLabel("Udate Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);

        JLabel empID = new JLabel("Select Roll Number");
        empID.setBounds(50,100,200,20);
        empID.setFont(new Font("serif", Font.BOLD,20));
        add(empID);

        cEMPID = new Choice();
        cEMPID.setBounds(250,100,200,20);
        add(cEMPID);

        try {
            conn c = new conn();
            ResultSet rs = c.Statement.executeQuery("select * from student");
            while (rs.next()){
                cEMPID.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name = new JLabel("NAME");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif", Font.BOLD,20));
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(200,150,150,30);
        add(textName);

        JLabel fname = new JLabel("FATHER NAME");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif", Font.BOLD,20));
        add(fname);

        JLabel textfather = new JLabel();
        textfather.setBounds(600,150,150,30);
        add(textfather);

        JLabel EMPIDD = new JLabel("Roll Number");
        EMPIDD.setBounds(50,200,200,30);
        EMPIDD.setFont(new Font("serif", Font.BOLD,20));
        add(EMPIDD);

        empText = new JLabel();
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif", Font.BOLD,20));
        add(empText);

        JLabel dob = new JLabel("DATA OF BIRTH");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif", Font.BOLD,20));
        add(dob);

        JLabel dobdob = new JLabel();
        dobdob.setBounds(600,200,150,30);
        add(dobdob);

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

        JLabel textM10 = new JLabel();
        textM10.setBounds(600,300,150,30);
        add(textM10);

        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif", Font.BOLD,20));
        add(M12);

        JLabel textM12 = new JLabel();
        textM12.setBounds(200,350,150,30);
        add(textM12);

        JLabel AadharNo = new JLabel("AADHAR NUMBER");
        AadharNo.setBounds(400,350,200,30);
        AadharNo.setFont(new Font("serif", Font.BOLD,20));
        add(AadharNo);

        textAadharNo = new JTextField();
        textAadharNo.setBounds(600,350,150,30);
        add(textAadharNo);

        JLabel Qualification = new JLabel("course");
        Qualification.setBounds(50,400,200,30);
        Qualification.setFont(new Font("serif", Font.BOLD,20));
        add(Qualification);

        textcourse = new JTextField();
        textcourse.setBounds(200,400,150,30);
        add(textcourse);

        JLabel Departement = new JLabel("Branch");
        Departement.setBounds(400,400,200,30);
        Departement.setFont(new Font("serif", Font.BOLD,20));
        add(Departement);

        textbranch = new JTextField();
        textbranch.setBounds(600,400,150,30);
        add(textbranch);

        try {
            conn c = new conn();
            String query = "select * from student where rollno = '"+cEMPID.getSelectedItem()+"'";
            ResultSet resultSet =  c.Statement.executeQuery(query);
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textfather.setText(resultSet.getString("fname"));
                dobdob.setText(resultSet.getString("dob"));
                textAddress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));
                textM10.setText(resultSet.getString("class_X"));
                textM12.setText(resultSet.getString("class_XII"));
                textAadharNo.setText(resultSet.getString("aadhar"));
                empText.setText(resultSet.getString("rollno"));
                textcourse.setText(resultSet.getString("course"));
                textbranch.setText(resultSet.getString("branch"));

            }
        }catch (Exception E){
            E.printStackTrace();
        }

        cEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c = new conn();
                    String query = "select * from student where rollno = '"+cEMPID.getSelectedItem()+"'";
                    ResultSet resultSet =  c.Statement.executeQuery(query);
                    while (resultSet.next()){
                        textName.setText(resultSet.getString("name"));
                        textfather.setText(resultSet.getString("fname"));
                        dobdob.setText(resultSet.getString("dob"));
                        textAddress.setText(resultSet.getString("address"));
                        textPhone.setText(resultSet.getString("phone"));
                        textemail.setText(resultSet.getString("email"));
                        textM10.setText(resultSet.getString("class_X"));
                        textM12.setText(resultSet.getString("class_XII"));
                        textAadharNo.setText(resultSet.getString("aadhar"));
                        empText.setText(resultSet.getString("rollno"));
                        textcourse.setText(resultSet.getString("course"));
                        textbranch.setText(resultSet.getString("branch"));

                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
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
            String empID = empText.getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textemail.getText();
            String course = textcourse.getText();
            String branch = textbranch.getText();

            try {
                String Q = "update student set address = '"+address+"',phone='"+phone+"',email = '"+email+"',course = '"+course+"', branch = '"+branch+"' where rollno = '"+empID+"'";
                conn c = new conn();
                c.Statement.executeUpdate(Q);

                JOptionPane.showMessageDialog(null,"Details updated");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Updatestudent();
    }
}
