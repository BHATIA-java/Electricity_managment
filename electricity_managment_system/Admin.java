package electricity_managment_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame implements ActionListener {

    Admin(){
        setLayout(null);
        // Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);

        // Optional: Maximize the window
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Add background image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/viewcustomer.jpg"));
        Image image = icon.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_DEFAULT);
        ImageIcon imageicon = new ImageIcon(image);
        JLabel labelimage = new JLabel(imageicon);
        add(labelimage);

        // Adding menu bar
        JMenuBar menuBar = new JMenuBar(); // Creating a menu bar

        // Master menu
        JMenu master = new JMenu("Master"); // Creating the menu that will show on the menu bar
        master.setForeground(Color.blue); // Setting the color of the menu
        menuBar.add(master); // Adding menu to the menu bar

        // New Customer menu item
        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setBackground(Color.WHITE);
        newcustomer.addActionListener(this);
        newcustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon0 = new ImageIcon(ClassLoader.getSystemResource("icons/icon1.png"));
        Image image0 = icon0.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image0));
        newcustomer.setMnemonic('D');
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        master.add(newcustomer);

        // Customer Details menu item
        JMenuItem customerDetails = new JMenuItem("Customer Details");
        customerDetails.setBackground(Color.WHITE);
        customerDetails.addActionListener(this);
        customerDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon2.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(image1));
        customerDetails.setMnemonic('M');
        customerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        master.add(customerDetails);

        // Deposit Details menu item
        JMenuItem depositeDetails = new JMenuItem("Deposit Details");
        depositeDetails.setBackground(Color.WHITE);
        depositeDetails.addActionListener(this);
        depositeDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icons/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositeDetails.setIcon(new ImageIcon(image3));
        depositeDetails.setMnemonic('N');
        depositeDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        master.add(depositeDetails);

        // Calculate Bill menu item
        JMenuItem calculateBills = new JMenuItem("Calculate Bills");
        calculateBills.setBackground(Color.WHITE);
        calculateBills.addActionListener(this);
        calculateBills.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icons/icon4.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculateBills.setIcon(new ImageIcon(image4));
        calculateBills.setMnemonic('C');
        calculateBills.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        master.add(calculateBills);

        // Information menu
        JMenu info = new JMenu("Information");
        info.setForeground(Color.RED);
        menuBar.add(info);

        //update information menu item
        JMenuItem updateInformation = new JMenuItem("Update Information");
        updateInformation.setBackground(Color.WHITE);
        updateInformation.addActionListener(this);
        updateInformation.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icons/icon5.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateInformation.setIcon(new ImageIcon(image5));
        updateInformation.setMnemonic('P');
        updateInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        info.add(updateInformation);

        //View information menu item
        JMenuItem viewInformation = new JMenuItem("View Information");
        viewInformation.setBackground(Color.WHITE);
        viewInformation.addActionListener(this);
        viewInformation.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icons/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewInformation.setIcon(new ImageIcon(image6));
        viewInformation.setMnemonic('L');
        viewInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        info.add(viewInformation);


        // user menu
        JMenu user = new JMenu("User");
        user.setForeground(Color.blue);
        menuBar.add(user);

        //update information menu item
        JMenuItem payBill = new JMenuItem("Pay Bill");
        payBill.setBackground(Color.WHITE);
        payBill.addActionListener(this);
        payBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icons/icon4.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        payBill.setIcon(new ImageIcon(image7));
        payBill.setMnemonic('R');
        payBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        user.add(payBill);

        //View information menu item
        JMenuItem billDetails = new JMenuItem("Bill Details");
        billDetails.setBackground(Color.WHITE);
        billDetails.addActionListener(this);
        billDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icons/icon6.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billDetails.setIcon(new ImageIcon(image8));
        billDetails.setMnemonic('B');
        billDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        user.add(billDetails);

        // report menu
        JMenu report = new JMenu("Report");
        report.setForeground(Color.red);
        menuBar.add(report);

        //Generate bill menu item
        JMenuItem generateBill = new JMenuItem("Generate Bill");
        generateBill.setBackground(Color.WHITE);
        generateBill.addActionListener(this);
        generateBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icons/icon4.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generateBill.setIcon(new ImageIcon(image9));
        generateBill.setMnemonic('G');
        generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        report.add(generateBill);

        // Utility menu
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.blue);
        menuBar.add(utility);

        // Notepad menu item
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icons/icon12.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('N');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        utility.add(notepad);

        // Calculator menu item
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        calculator.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icons/icon9.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image11));
        calculator.setMnemonic('S');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        utility.add(calculator);

        // About menu
        JMenu about = new JMenu("About");
        about.setForeground(Color.blue);
        menuBar.add(about);

        // About menu item
        JMenuItem abt = new JMenuItem("About");
        abt.setBackground(Color.WHITE);
        abt.addActionListener(this);
        abt.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icons/icon5.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        abt.setIcon(new ImageIcon(image12));
        abt.setMnemonic('A');
        abt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        about.add(abt);

        // Logout menu
        JMenu exit = new JMenu("Logout");
        exit.setForeground(Color.red);
        menuBar.add(exit);

        JMenuItem logout = new JMenuItem("Logout");
        logout.setBackground(Color.WHITE);
        logout.addActionListener(this);
        logout.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon13 = new ImageIcon(ClassLoader.getSystemResource("icons/icon11.png"));
        Image image13 = icon13.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        logout.setIcon(new ImageIcon(image13));
        logout.setMnemonic('W');
        logout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        exit.add(logout);

        setJMenuBar(menuBar); // Setting the menu bar on the frame

        setVisible(true); // Use to make the frame visible
    }

    // Adding the ActionListener
    @SuppressWarnings("deprecation") // Using outdated code
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand(); // Compare the click based on string comparison
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
        } else if (msg.equals("Pay Bill")) {
            // Implement Pay Bill functionality
        } else if (msg.equals("Bill Details")) {
            // Implement Bill Details functionality
        } else if (msg.equals("Generate Bill")) {
            // Implement Generate Bill functionality
        } else if (msg.equals("About")) {
            // Implement About functionality
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
