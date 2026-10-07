package voting;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private final VotingSystem system;
    private final JTextField username = new JTextField();
    private final JPasswordField password = new JPasswordField();
    private final JComboBox<String> role =
            new JComboBox<>(new String[]{"ADMIN", "CANDIDATE", "VOTER"});

    public LoginFrame(VotingSystem system) {
        this.system = system;

        setTitle("Digital Voting System");
        setSize(480, 390);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel box = new JPanel(new GridLayout(0, 1, 8, 8));
        box.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel title = new JLabel("DIGITAL VOTING SYSTEM", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel info = new JLabel(
                "Standalone desktop application - no administrator rights required",
                SwingConstants.CENTER
        );
        info.setForeground(new Color(0, 110, 95));

        JButton login = new JButton("LOGIN");

        box.add(title);
        box.add(info);
        box.add(new JLabel("Username"));
        box.add(username);
        box.add(new JLabel("Password"));
        box.add(password);
        box.add(new JLabel("Role"));
        box.add(role);
        box.add(login);

        add(box, BorderLayout.CENTER);

        login.addActionListener(e -> login());
        getRootPane().setDefaultButton(login);
        setVisible(true);
    }

    private void login() {
        User user = system.auth(
                username.getText().trim(),
                new String(password.getPassword()),
                role.getSelectedItem().toString()
        );

        if (user == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid login details.",
                    "Login failed",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        dispose();

        switch (user.getRole()) {
            case "ADMIN":
                new AdminFrame(system);
                break;
            case "CANDIDATE":
                new CandidateFrame(system, user);
                break;
            default:
                new VoterFrame(system, user);
                break;
        }
    }
}
