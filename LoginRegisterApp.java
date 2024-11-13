import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginRegisterApp {
    private JFrame frame;
    private JPanel loginPanel, registerPanel;

    public LoginRegisterApp() {
        frame = new JFrame("Login dan Register");
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new CardLayout());

        initLoginPanel();
        initRegisterPanel();

        frame.add(loginPanel, "login");
        frame.add(registerPanel, "register");

        frame.setVisible(true);
    }

    // Method untuk membuat panel login
    private void initLoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblLogin = new JLabel("Login", JLabel.CENTER);
        lblLogin.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(lblLogin, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        loginPanel.add(new JLabel("Email:"), gbc);

        JTextField emailField = new JTextField();
        gbc.gridx = 1;
        loginPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        loginPanel.add(new JLabel("Password:"), gbc);

        JPasswordField passwordField = new JPasswordField();
        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton btnLogin = new JButton("Submit Login");
        btnLogin.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            if (email.equals("user@example.com") && password.equals("password")) {
                JOptionPane.showMessageDialog(frame, "Login berhasil!");
            } else {
                JOptionPane.showMessageDialog(frame, "Email atau password salah.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        loginPanel.add(btnLogin, gbc);

        gbc.gridy++;
        JButton btnGoToRegister = new JButton("Register");
        btnGoToRegister.addActionListener(e -> switchPanel("register"));
        loginPanel.add(btnGoToRegister, gbc);
    }

    // Method untuk membuat panel register
    private void initRegisterPanel() {
        registerPanel = new JPanel();
        registerPanel.setLayout(new GridBagLayout());
        registerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblRegister = new JLabel("Register", JLabel.CENTER);
        lblRegister.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        registerPanel.add(lblRegister, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        registerPanel.add(new JLabel("Nama:"), gbc);

        JTextField nameField = new JTextField();
        gbc.gridx = 1;
        registerPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        registerPanel.add(new JLabel("Email:"), gbc);

        JTextField emailField = new JTextField();
        gbc.gridx = 1;
        registerPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        registerPanel.add(new JLabel("Password:"), gbc);

        JPasswordField passwordField = new JPasswordField();
        gbc.gridx = 1;
        registerPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton btnRegister = new JButton("Submit Register");
        btnRegister.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Registrasi berhasil!");
            } else {
                JOptionPane.showMessageDialog(frame, "Mohon isi semua kolom.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        registerPanel.add(btnRegister, gbc);

        gbc.gridy++;
        JButton btnGoToLogin = new JButton("Login");
        btnGoToLogin.addActionListener(e -> switchPanel("login"));
        registerPanel.add(btnGoToLogin, gbc);
    }

    private void switchPanel(String panelName) {
        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
        cl.show(frame.getContentPane(), panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginRegisterApp::new);
    }
}