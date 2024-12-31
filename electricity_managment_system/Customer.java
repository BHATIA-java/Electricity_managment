package electricity_managment_system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Customer extends JFrame implements ActionListener {

    Customer() {
        setSize(1500,850);
        setLocation(0,0);
        //setLayout(null);

//        // Get screen dimensions
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setBounds(0, 0, screenSize.width, screenSize.height);
//
//        // Optional: Maximize the window
//        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Add background image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/viewcustomer.jpg"));
        Image icon2 = icon.getImage().getScaledInstance(1550, 900, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel image = new JLabel(icon3);
        add(image);

        // Creating the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Information menu
        JMenu newInformation = new JMenu("Information");
        newInformation.setForeground(Color.blue);
        menuBar.add(newInformation);

        // Menu items
        JMenuItem updateInfo = new JMenuItem("Update Information");
        updateInfo.setBackground(Color.WHITE);
        updateInfo.addActionListener(this);
        newInformation.add(updateInfo);

        JMenuItem viewInfo = new JMenuItem("View Information");
        viewInfo.setBackground(Color.WHITE);
        viewInfo.addActionListener(this);
        newInformation.add(viewInfo);

        // User menu
        JMenu userMenu = new JMenu("User");
        userMenu.setForeground(Color.RED);
        menuBar.add(userMenu);

        JMenuItem payBill = new JMenuItem("Pay Bills");
        payBill.setBackground(Color.WHITE);
        payBill.addActionListener(this);
        userMenu.add(payBill);

        JMenuItem billDetails = new JMenuItem("Bill Details");
        billDetails.setBackground(Color.WHITE);
        billDetails.addActionListener(this);
        userMenu.add(billDetails);

        // Report menu
        JMenu reportMenu = new JMenu("Report");
        reportMenu.setForeground(Color.blue);
        menuBar.add(reportMenu);

        JMenuItem generateBill = new JMenuItem("Generate Bill");
        generateBill.setBackground(Color.WHITE);
        generateBill.addActionListener(this);
        reportMenu.add(generateBill);

        // Utility menu
        JMenu utilityMenu = new JMenu("Utility");
        utilityMenu.setForeground(Color.RED);
        menuBar.add(utilityMenu);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utilityMenu.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utilityMenu.add(calculator);

        // About menu
        JMenu aboutMenu = new JMenu("About");
        aboutMenu.setForeground(Color.blue);
        menuBar.add(aboutMenu);

        JMenuItem about = new JMenuItem("About");
        about.setBackground(Color.WHITE);
        about.addActionListener(this);
        aboutMenu.add(about);

        // Logout menu
        JMenu logoutMenu = new JMenu("Logout");
        logoutMenu.setForeground(Color.RED);
        menuBar.add(logoutMenu);

        JMenuItem logout = new JMenuItem("Logout");
        logout.setBackground(Color.WHITE);
        logout.addActionListener(this);
        logoutMenu.add(logout);

        setJMenuBar(menuBar);

        setVisible(true);  // Make sure this is called at the end
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("Logout")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("View Information")) {
            // new AddTeacher();
        } else if (msg.equals("Update Information")) {
            // new AddStudent();
        } else if (msg.equals("Pay Bill")) {
            // new FacultyDetails();
        } else if (msg.equals("Bill Detail")) {
            // new StudentDetails();
        } else if (msg.equals("Generate Bill")) {
            // new TeacherLeave();
        } else if (msg.equals("About")) {
            // new About();
        }
    }

    public static void main(String[] args) {
        new Customer();
    }
}
