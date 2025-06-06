package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class FeeForm extends JFrame implements ActionListener {

    Choice Crollnumber1;

    JComboBox courseBox, DepartementBox ,semesterBox;

    JLabel TotalAmount;

    JButton pay, update, back;

    FeeForm(){

        getContentPane().setBackground(new Color(210,252,251));
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.png"));
         Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel img = new JLabel(i3);
         img.setBounds(400,50,500,300);
         add(img);

         JLabel rollnumber = new JLabel("Seleect ROLL NUMBER");
         rollnumber.setBounds(40,60,150,20);
         rollnumber.setFont(new Font("Tahoma", Font.BOLD,12));
         add(rollnumber);

         Crollnumber1 = new Choice();
         Crollnumber1.setBounds(200,60,150,20);
         add(Crollnumber1);

         try{
             conn c =new conn();
             ResultSet rs = c.Statement.executeQuery("select * from student");
             while (rs.next()){
                 Crollnumber1.add(rs.getString("rollno"));
             }
         }catch (Exception e){
             e.printStackTrace();
         }

         JLabel name = new JLabel("NAME");
         name.setBounds(40,100,150,20);
         add(name);

         JLabel textname = new JLabel();
         textname.setBounds(200,100,150,20);
         add(textname);

        JLabel fname = new JLabel("FATHER NAME");
        fname.setBounds(40,140,150,20);
        add(fname);

        JLabel textfname = new JLabel();
        textfname.setBounds(200,140,150,20);
        add(textfname);

        try {
            conn c = new conn();
            String Q = "select * from student where rollno='"+Crollnumber1.getSelectedItem()+"'";
            ResultSet resultSet = c.Statement.executeQuery(Q);
            while (resultSet.next()){
                textname.setText(resultSet.getString("name"));
                textfname.setText(resultSet.getString("fname"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        Crollnumber1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    conn c = new conn();
                    String Q = "select * from student where rollno='"+Crollnumber1.getSelectedItem()+"'";
                    ResultSet resultSet = c.Statement.executeQuery(Q);
                    while (resultSet.next()){
                        textname.setText(resultSet.getString("name"));
                        textfname.setText(resultSet.getString("fname"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JLabel Qualification = new JLabel("Course");
        Qualification.setBounds(40,180,150,20);
//        Qualification.setFont(new Font("Tahoma", Font.BOLD,16));
        add(Qualification);

        String course[]= {"BTech","BBA","BCA","BSC","MSC","MBA","MCA","MCom","MA","BA"};
        courseBox = new JComboBox<>(course);
        courseBox.setBounds(200,180,150,20);
        courseBox.setBackground(Color.white);
        add(courseBox);

        JLabel Departement = new JLabel("Branch");
        Departement.setBounds(40,220,150,20);
//        Departement.setFont(new Font("serif", Font.BOLD,10));
        add(Departement);

        String departement[]= {"Computer Science","Electronics","Mechanical","CIVIL","IT"};
        DepartementBox = new JComboBox<>(departement);
        DepartementBox.setBounds(200,220,150,20);
        DepartementBox.setBackground(Color.white);
        add(DepartementBox);

        JLabel textsemester = new JLabel("Semester");
        textsemester.setBounds(40,260,150,20);
        add(textsemester);

        String semester[] = {"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        semesterBox = new JComboBox(semester);
        semesterBox.setBounds(200,260,150,20);
        add(semesterBox);

        JLabel total = new JLabel("Total Payable");
        total.setBounds(40,300,150,20);
        add(total);

        TotalAmount = new JLabel();
        TotalAmount.setBounds(200,300,150,20);
        add(TotalAmount);

        update = new JButton("Update");
        update.setBounds(30,380,100,25);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay");
        pay.setBounds(150,380,100,25);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(270,380,100,25);
        back.addActionListener(this);
        add(back);

        setSize(900,500);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==update){
           String course = (String) courseBox.getSelectedItem();
           String semester = (String) semesterBox.getSelectedItem();
           try {
               conn c = new conn();
               ResultSet resultSet = c.Statement.executeQuery("select * from fee where course = '"+course+"'");
               while (resultSet.next()){
                   TotalAmount.setText(resultSet.getString(semester));

               }
           }catch (Exception E){
               E.printStackTrace();

           }
       }else if (e.getSource()==pay){
           String rollno = Crollnumber1.getSelectedItem();
           String course = (String) courseBox.getSelectedItem();
           String semester = (String) semesterBox.getSelectedItem();
           String branch = (String) DepartementBox.getSelectedItem();
           String total = TotalAmount.getText();

           try {
             conn c = new conn();
             String Q = "insert into feecollege values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
             c.Statement.executeUpdate(Q);
             JOptionPane.showMessageDialog(null,"Fee Submitted Successfully");
           } catch (Exception E) {
               E.printStackTrace();
           }

       }else {
           setVisible(false);
       }
    }

    public static void main(String[] args) {
        new FeeForm();    }
}
