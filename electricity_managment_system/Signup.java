package electricity_managment_system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Signup extends JFrame implements ActionListener {
    JButton createbutton, backbutton;
    JTextField tfusername, tfname, tfpassword,tfmeter;
    Choice cChoose;
    JLabel meterno;
    Random random=new Random();//to generate random number
    long first4= Math.abs((random.nextLong() % 9000L) +1000L);//to create a four digit roll no

    Signup() {
        setBounds(450,150,700,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel =new JPanel();
        panel.setBounds(30,30,650,300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230), 2), "Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(176,216,230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);
        panel.setForeground(new Color(34,139,34));

        // Main heading
        JLabel heading = new JLabel("Create Account");
        heading.setBounds(100, 20, 140, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);

        // Logging in as
        JLabel loginas = new JLabel("Create Account as");
        loginas.setBounds(100, 50, 140, 20);
        loginas.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(loginas);

        cChoose = new Choice();
        cChoose.setBounds(260, 50, 150, 30);
        cChoose.add("Admin");
        cChoose.add("Customer");
        panel.add(cChoose);

        // Username label and text field
        JLabel lablemeter = new JLabel("Meter Number");
        lablemeter.setBounds(100, 90, 140, 20);
        lablemeter.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lablemeter);
        meterno = new JLabel("IND"+first4);
        meterno.setBounds(260, 90, 150, 20);
        panel.add(meterno);

        // Username label and text field
        JLabel labelusername = new JLabel("Username:");
        labelusername.setBounds(100, 130, 140, 20);
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelusername);
        tfusername = new JTextField();
        tfusername.setBounds(260, 130, 150, 20);
        panel.add(tfusername);

        // Name label and text field
        JLabel labelname = new JLabel("Name:");
        labelname.setBounds(100, 170, 150, 20);
        labelname.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelname);
        tfname = new JTextField();
        tfname.setBounds(260, 170, 150, 20);
        panel.add(tfname);

        // Password label and text field
        JLabel labelpassword = new JLabel("Password:");
        labelpassword.setBounds(100, 210, 140, 20);
        labelpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelpassword);
        tfpassword = new JTextField();
        tfpassword.setBounds(260, 210, 150, 20);
        panel.add(tfpassword);

        // Create button
        createbutton = new JButton("CREATE");
        createbutton.setBounds(150, 250, 100, 20);
        createbutton.addActionListener(this);
        createbutton.setBackground(Color.BLACK);
        createbutton.setForeground(Color.WHITE);
        panel.add(createbutton);

        // Back button
        backbutton = new JButton("BACK");
        backbutton.setBounds(300, 250, 100, 20);
        backbutton.addActionListener(this);
        backbutton.setBackground(Color.BLACK);
        backbutton.setForeground(Color.WHITE);
        panel.add(backbutton);

        // Add image icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/signupImage.png"));
        Image iconImage = icon.getImage().getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(iconImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(410, 30, 250, 250);
        panel.add(imageLabel);

        try{
        if(cChoose.getSelectedItem()=="Customer"){
            tfname.setEditable(false);
        }else if (cChoose.getSelectedItem()=="Admin") {
            tfmeter.setVisible(false);
            lablemeter.setVisible(false);
            tfname.setEditable(true);
        }} catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        // Set up frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String atype = cChoose.getSelectedItem();
        String meter = meterno.getText();
        String Username = tfusername.getText();
        String Name = tfname.getText();
        String Password = tfpassword.getText();


        if (ae.getSource() == createbutton) {
            String role = cChoose.getSelectedItem();
            String query;


            if (role.equals("Admin")) {
                query = "INSERT INTO admin (Username, Name, Password) VALUES ('" + Username + "', '" + Name + "', '" + Password + "')";
            } else {
                query = "INSERT INTO customer (meter_no,Username, Name, Password) VALUES ('" +meter+"','" +Username + "', '" + Name + "', '" + Password + "')";
            }

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                    setVisible(false);
                    new Login(); // Move to the next window

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == backbutton) {
            setVisible(false);
            new Login(); // Navigate to login window
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
