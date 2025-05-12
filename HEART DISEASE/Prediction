import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class HeartDiseasePredictionSystem {
    public static void main(String[] args) {
        // Create a map to store patient data
        HashMap<String, String> patientData = new HashMap<>();
        patientData.put("P101", "The patient has a heart disease");
        patientData.put("P102", "The patient does not have a heart disease");
        patientData.put("P103", "The patient has a heart disease");
        patientData.put("P104", "The patient has a heart disease");
        // (Add all other patient data here)
        patientData.put("P200", "The patient has a heart disease");

        // Create the main frame
        JFrame frame = new JFrame("Heart Disease Prediction System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        // Create heading
        JLabel heading = new JLabel("Heart Disease Prediction System", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));

        // Create input label and field
        JLabel patientIdLabel = new JLabel("Enter Patient ID:");
        JTextField patientIdField = new JTextField(15);

        // Create output label
        JLabel outputLabel = new JLabel("", JLabel.CENTER);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        outputLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create button
        JButton checkButton = new JButton("Check Prediction");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientId = patientIdField.getText().trim().toUpperCase();
                if (patientData.containsKey(patientId)) {
                    outputLabel.setText(patientData.get(patientId));
                } else {
                    outputLabel.setText("Invalid Patient ID. Please try again.");
                }
            }
        });

        // Layout the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(patientIdLabel, gbc);

        gbc.gridx = 1;
        panel.add(patientIdField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(checkButton, gbc);

        frame.add(heading, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(outputLabel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}
