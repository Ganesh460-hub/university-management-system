package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Studentleavedetails extends JFrame implements ActionListener {

    Choice choiceEmpID ;

    JTable table;

    JButton search ,cancel ,print;


    Studentleavedetails(){

        getContentPane().setBackground(new Color(250,172,202));
        JLabel heading = new JLabel("Search By ROLL NUMBER");
        heading.setBounds(20,20,150,20);
        add(heading);

        choiceEmpID = new Choice();
        choiceEmpID.setBounds(180,20,150,20);
        add(choiceEmpID);

        try {
            conn c = new conn();
            ResultSet resultSet = c.Statement.executeQuery("select * from student");
            while (resultSet.next()){
                choiceEmpID.add(resultSet.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        table = new JTable();
        try{
            conn c = new conn();
            ResultSet resultSet = c.Statement.executeQuery("select * from Studentleave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception E){
            E.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,900,600);
        add(scrollPane);

        search = new JButton("search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        cancel = new JButton("cancel");
        cancel.setBounds(120,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        print = new JButton("print");
        print.setBounds(220,70,80,20);
        print.addActionListener(this);
        add(print);

        setSize(900,700);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== search){
            String q = "select * from Studentleave where rollno = '"+choiceEmpID.getSelectedItem()+"'";
            try{
                conn c = new conn();
                ResultSet resultSet = c.Statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();

            }

        } else if (e.getSource() == print) {
            try{
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
         new Studentleavedetails();
    }
}
