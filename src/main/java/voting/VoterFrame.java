package voting;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VoterFrame extends JFrame {

    private final VotingSystem system;
    private final User user;

    public VoterFrame(VotingSystem system, User user) {
        this.system = system;
        this.user = user;

        setTitle("Digital Voting System - Voter");
        setSize(620, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel(
                "VOTER DASHBOARD - " + user.getName(),
                SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        if (system.hasVoted(user.getId())) {
            JLabel done = new JLabel("You have already voted.");
            done.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(done);
        } else {
            List<Candidate> candidates = system.getCandidates();
            ButtonGroup group = new ButtonGroup();
            JRadioButton[] choices = new JRadioButton[candidates.size()];

            for (int i = 0; i < candidates.size(); i++) {
                Candidate c = candidates.get(i);

                choices[i] = new JRadioButton(
                        c.getName() + " - " + c.getParty()
                );
                choices[i].setAlignmentX(Component.LEFT_ALIGNMENT);
                choices[i].putClientProperty("candidateId", c.getId());

                group.add(choices[i]);
                panel.add(choices[i]);
            }

            JButton vote = new JButton("CAST VOTE");
            vote.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createVerticalStrut(12));
            panel.add(vote);

            vote.addActionListener(e -> castVote(choices));
        }

        JButton logout = new JButton("Logout");
        logout.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(12));
        panel.add(logout);

        logout.addActionListener(e -> {
            dispose();
            new LoginFrame(system);
        });

        add(title, BorderLayout.NORTH);
        add(new JScrollPane(panel), BorderLayout.CENTER);

        setVisible(true);
    }

    private void castVote(JRadioButton[] choices) {
        int selectedId = -1;

        for (JRadioButton choice : choices) {
            if (choice.isSelected()) {
                selectedId = (int) choice.getClientProperty("candidateId");
                break;
            }
        }

        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a candidate.");
            return;
        }

        int answer = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to cast your vote?",
                "Confirm Vote",
                JOptionPane.YES_NO_OPTION
        );

        if (answer == JOptionPane.YES_OPTION) {
            if (system.vote(user.getId(), selectedId)) {
                JOptionPane.showMessageDialog(this, "Vote recorded successfully.");
                dispose();
                new LoginFrame(system);
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Vote could not be recorded. You may have already voted."
                );
            }
        }
    }
}
