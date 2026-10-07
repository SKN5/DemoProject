package voting;

import javax.swing.*;
import java.awt.*;

public class CandidateFrame extends JFrame {

    public CandidateFrame(VotingSystem system, User user) {
        setTitle("Digital Voting System - Candidate");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel(
                "CANDIDATE DASHBOARD - " + user.getName(),
                SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JTextArea results = new JTextArea();
        results.setEditable(false);

        StringBuilder text = new StringBuilder("CURRENT RESULTS

");
        int rank = 1;

        for (Candidate c : system.getCandidates()) {
            text.append(rank++).append(". ")
                    .append(c.getName()).append(" - ")
                    .append(c.getParty()).append(" - ")
                    .append(c.getVotes()).append(" votes
");
        }

        results.setText(text.toString());

        JButton refresh = new JButton("Refresh");
        JButton logout = new JButton("Logout");

        refresh.addActionListener(e -> refreshResults(results, system));

        logout.addActionListener(e -> {
            dispose();
            new LoginFrame(system);
        });

        JPanel bottom = new JPanel();
        bottom.add(refresh);
        bottom.add(logout);

        add(title, BorderLayout.NORTH);
        add(new JScrollPane(results), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void refreshResults(JTextArea results, VotingSystem system) {
        StringBuilder text = new StringBuilder("CURRENT RESULTS

");
        int rank = 1;

        for (Candidate c : system.getCandidates()) {
            text.append(rank++).append(". ")
                    .append(c.getName()).append(" - ")
                    .append(c.getParty()).append(" - ")
                    .append(c.getVotes()).append(" votes
");
        }

        results.setText(text.toString());
    }
}
