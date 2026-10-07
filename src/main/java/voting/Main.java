package voting;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VotingSystem system = new VotingSystem();
            if (!system.initDatabase()) {
                javax.swing.JOptionPane.showMessageDialog(
                        null,
                        "The database could not be initialized.",
                        "Digital Voting System",
                        javax.swing.JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            new LoginFrame(system);
        });
    }
}
