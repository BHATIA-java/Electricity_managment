package electricity_managment_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {
    JButton createbutton, backbutton;
    JTextField tfusername, tfname, tfpassword;
    Choice cChoose;

    Signup() {
        // Set up the frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Logging in as
        JLabel loginas = new JLabel("Create Account as");
        loginas.setBounds(40, 20, 150, 30);
        loginas.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(loginas);

        cChoose = new Choice();
        cChoose.setBounds(230, 23, 200, 50);
        cChoose.add("Admin");
        cChoose.add("Customer");
        add(cChoose);

        // Username label and text field
        JLabel labelusername = new JLabel("Username:");
        labelusername.setBounds(40, 90, 100, 30);
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelusername);

        tfusername = new JTextField();
        tfusername.setBounds(230, 90, 200, 30);
        add(tfusername);

        // Name label and text field
        JLabel labelname = new JLabel("Name:");
        labelname.setBounds(40, 150, 100, 30);
        labelname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(230, 150, 200, 30);
        add(tfname);

        // Password label and text field
        JLabel labelpassword = new JLabel("Password:");
        labelpassword.setBounds(40, 210, 100, 30);
        labelpassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(230, 210, 200, 30);
        add(tfpassword);

        // Create button
        createbutton = new JButton("CREATE");
        createbutton.setBounds(80, 300, 120, 30);
        createbutton.addActionListener(this);
        createbutton.setBackground(Color.BLACK);
        createbutton.setForeground(Color.WHITE);
        add(createbutton);

        // Back button
        backbutton = new JButton("BACK");
        backbutton.setBounds(300, 300, 120, 30);
        backbutton.addActionListener(this);
        backbutton.setBackground(Color.BLACK);
        backbutton.setForeground(Color.WHITE);
        add(backbutton);

        // Add image icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/signupImage.png"));
        Image iconImage = icon.getImage().getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(iconImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(500, 30, 280, 280);
        add(imageLabel);

        // Set up frame properties
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String Username = tfusername.getText();
        String Name = tfname.getText();
        String Password = tfpassword.getText();

        if (ae.getSource() == createbutton) {
            String role = cChoose.getSelectedItem();
            String query;

            if (role.equals("Admin")) {
                query = "INSERT INTO admin (Usename, Name, Password) VALUES ('" + Username + "', '" + Name + "', '" + Password + "')";
            } else {
                query = "INSERT INTO customer (Usename, Name, Password) VALUES ('" + Username + "', '" + Name + "', '" + Password + "')";
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
