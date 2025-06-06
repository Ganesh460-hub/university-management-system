package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();

        //next information

        JMenu newInfo = new JMenu("NEW INFORMATION");
        newInfo.setForeground(Color.black);
        mb.add(newInfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        //details

        JMenu details = new JMenu("View Details");
        details.setForeground(Color.black);
        details.addActionListener(this);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.white);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.white);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        //leave

        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.black);
        leave.addActionListener(this);
        mb.add(leave);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.white);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.white);
        studentleave.addActionListener(this);
        leave.add(studentleave);

        //leavedetails

        JMenu leavedetails = new JMenu(" Leave Details");
        leavedetails.setForeground(Color.black);
        leavedetails.addActionListener(this);
        mb.add(leavedetails);

        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.white);
        facultyleavedetails.addActionListener(this);
        leavedetails.add(facultyleavedetails);

        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.white);
        studentleavedetails.addActionListener(this);
        leavedetails.add(studentleavedetails);

        //exams

        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.black);
        exam.addActionListener(this);
        mb.add(exam);

        JMenuItem examinationdetails = new JMenuItem("Examination Results");
        examinationdetails.setBackground(Color.white);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.white);
        entermarks.addActionListener(this);
        exam.add(entermarks);

        //updateinfo

        JMenu updateinfo = new JMenu("Update Details");
        updateinfo.setForeground(Color.black);
        updateinfo.addActionListener(this);
        mb.add(updateinfo);

        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.white);
        updatefacultyinfo.addActionListener(this);
        updateinfo.add(updatefacultyinfo);

        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.white);
        updatestudentinfo.addActionListener(this);
        updateinfo.add(updatestudentinfo);

        //fee

        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.black);
        fee.addActionListener(this);
        mb.add(fee);

        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.white);
        feestructure.addActionListener(this);
        fee.add(feestructure);

        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.white);
        feeform.addActionListener(this);
        fee.add(feeform);

        //utility

        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.black);
        mb.add(utility);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.white);
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);

        //about

        JMenu about = new JMenu("About");
        about.setForeground(Color.black);
        about.addActionListener(this);
        mb.add(about);

        JMenuItem About = new JMenuItem("About");
        About.setBackground(Color.white);
        About.addActionListener(this);
        about.add(About);

        //exit

        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.black);
        mb.add(exit);

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.white);
        Exit.addActionListener(this);
        exit.add(Exit);



        setJMenuBar(mb);


        setSize(1540,850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
        if(sm.equals("Exit")){
            System.exit(15);
        } else if (sm.equals("Calculator")) {
            try {
              Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (sm.equals("Notepad")) {
             try{
                Runtime.getRuntime().exec("notepad.exe");
             } catch (Exception E){
                 E.printStackTrace();
             }
        } else if (sm.equals("New Faculty Information")) {
            new Addfaculty();
        } else if (sm.equals("New Student Information")) {
            new AddStudent();
        } else if (sm.equals("View Faculty Details")) {
          new Teachersdetails();
        } else if (sm.equals("View Student Details")) {
           new Studentdetails();   
        } else if (sm.equals("Faculty Leave Details")) {
            new Teacherleavedetails();
        } else if (sm.equals("Student Leave Details")) {
           new Studentleavedetails();
        } else if (sm.equals("Update Faculty Details")) {
         new Updateteacher();
        } else if ((sm.equals("Update Student Details"))) {
            new Updatestudent();
        } else if (sm.equals("Enter Marks")) {
            new Entermarks();
        } else if (sm.equals("Examination Results")) {
            new Examinationdetails();
        } else if (sm.equals("Fee Structure")) {
            new FeeStructure();
        } else if (sm.equals("Student Fee Form")) {
            new FeeForm();
        } else if (sm.equals("About")) {
            new About();
        } else if (sm.equals("Faculty Leave")) {
            new Teacherleave();
        } else if (sm.equals("Student Leave")){
            new Studentleave();
        }
    }

    public static void main(String[] args) {
        new main_class();
    }
}
