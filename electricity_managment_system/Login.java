package electricity_managment_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, cancel, signup;
    JTextField tfusername;
    JPasswordField tfpassword;
    Choice cChoose;

    Login() {
        setTitle("Login");
        // Set up the frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Username label and text field
        JLabel labelusername = new JLabel("Username:");
        labelusername.setBounds(40, 20, 100, 30);
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 200, 30);
        add(tfusername);

        // Password label and password field
        JLabel labelpassword = new JLabel("Password:");
        labelpassword.setBounds(40, 70, 100, 30);
        labelpassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 200, 30);
        add(tfpassword);

        // Logging in as
        JLabel loginas = new JLabel("Logging in as:");
        loginas.setBounds(40, 120, 100, 30);
        loginas.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(loginas);

        cChoose = new Choice();
        cChoose.setBounds(150, 120, 200, 30);
        cChoose.add("Admin");
        cChoose.add("Customer");
        add(cChoose);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image loginicon =icon1.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icons/cancel.jpg"));
        Image cancelicon =icon2.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image signupicon =icon3.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);

        // Login button
        login = new JButton("Login",new ImageIcon(loginicon));
        login.setBounds(50, 180, 120, 30);
        login.addActionListener(this);
        add(login);

        // Cancel button
        cancel = new JButton("Cancel",new ImageIcon(cancelicon));
        cancel.setBounds(200, 180, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

        // Signup button
        signup = new JButton("Signup",new ImageIcon(signupicon));
        signup.setBounds(120, 225, 120, 30);
        signup.addActionListener(this);
        add(signup);

        // Add image icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image iconImage = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(iconImage));
        imageLabel.setBounds(370, 20, 150, 150);
        add(imageLabel);

        // Set up frame properties
        setSize(550, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = new String(tfpassword.getPassword());
            String role = cChoose.getSelectedItem();

            String query;
            if (role.equals("Admin")) {
                query = "SELECT * FROM admin WHERE Usename = '" + username + "' AND Password = '" + password + "'";
            } else {
                query = "SELECT * FROM customer WHERE Usename = '" + username + "' AND Password = '" + password + "'";
            }

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    // Login successful
                    System.out.println("Login Successful!");
                    setVisible(false); // Close login window

                    if (role.equals("Admin")) {
                        //new Admin(); // Open Admin dashboard
                    } else {
                        new Customer(); // Open Customer dashboard
                    }
                }  else {
                    tfusername.setText("");
                    tfpassword.setText("");

                }
                c.s.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        } else if (ae.getSource() == signup) {
            new Signup();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
