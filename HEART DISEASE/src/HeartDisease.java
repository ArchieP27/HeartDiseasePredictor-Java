import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class HeartDisease {

    public static void main(String[] args) {
        // Create a map to store patient data
        HashMap<String, String> patientData = new HashMap<>();
        String[] patientIDs = {
                "P101", "P102", "P103", "P104", "P105", "P106", "P107", "P108", "P109", "P110",
                "P111", "P112", "P113", "P114", "P115", "P116", "P117", "P118", "P119", "P120",
                "P121", "P122", "P123", "P124", "P125", "P126", "P127", "P128", "P129", "P130",
                "P131", "P132", "P133", "P134", "P135", "P136", "P137", "P138", "P139", "P140",
                "P141", "P142", "P143", "P144", "P145", "P146", "P147", "P148", "P149", "P150",
                "P151", "P152", "P153", "P154", "P155", "P156", "P157", "P158", "P159", "P160",
                "P161", "P162", "P163", "P164", "P165", "P166", "P167", "P168", "P169", "P170",
                "P171", "P172", "P173", "P174", "P175", "P176", "P177", "P178", "P179", "P180",
                "P181", "P182", "P183", "P184", "P185", "P186", "P187", "P188", "P189", "P190",
                "P191", "P192"
        };

        String[] predictions = {
                "The patient has a heart disease", "The patient does not have a heart disease",
                "The patient has a heart disease", "The patient has a heart disease",
                "The patient does not have a heart disease", "The patient has a heart disease",
                "The patient has a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient has a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient has a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient has a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient has a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient has a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient has a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient has a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient has a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient does not have a heart disease",
                "The patient does not have a heart disease", "The patient has a heart disease"
        };

        // Ensure arrays have matching lengths
        int length = Math.min(patientIDs.length, predictions.length);

        for (int i = 0; i < length; i++) {
            patientData.put(patientIDs[i], predictions[i]);
        }

        // GUI setup
        JFrame frame = new JFrame("Heart Disease Prediction System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Add background image (Make sure the image is in the project folder)
        JLabel background = new JLabel(new ImageIcon("heart_image.png"));
        background.setLayout(new BorderLayout());
        frame.setContentPane(background);

        // Title
        JLabel titleLabel = new JLabel("HEART DISEASE PREDICTION SYSTEM", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.BLACK);
        background.add(titleLabel, BorderLayout.NORTH);

        // Centered form
        JPanel formPanel = new JPanel();
        formPanel.setOpaque(false);
        formPanel.setLayout(new GridLayout(4, 1, 10, 10));
        JLabel patientIdLabel = new JLabel("Enter Patient ID:", JLabel.CENTER);
        patientIdLabel.setForeground(Color.BLUE);
        JTextField patientIdField = new JTextField();
        JLabel resultLabel = new JLabel("Prediction Result: ", JLabel.CENTER);
        resultLabel.setForeground(Color.BLACK);
        JButton checkButton = new JButton("Check Prediction");
        checkButton.setBackground(new Color(220, 20, 60));
        checkButton.setForeground(Color.BLACK);

        checkButton.addActionListener(e -> {
            String patientId = patientIdField.getText().trim().toUpperCase();
            if (patientData.containsKey(patientId)) {
                resultLabel.setText("Prediction Result: " + patientData.get(patientId));
                resultLabel.setForeground(new Color(0, 128, 0));
            } else {
                resultLabel.setText("Prediction Result: Invalid Patient ID. Please try again.");
                resultLabel.setForeground(Color.RED);
            }
        });

        formPanel.add(patientIdLabel);
        formPanel.add(patientIdField);
        formPanel.add(checkButton);
        formPanel.add(resultLabel);
        background.add(formPanel, BorderLayout.CENTER);

        // Footer
        JLabel footerLabel = new JLabel("Developed for Heart Disease Awareness", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        footerLabel.setForeground(Color.BLUE);
        background.add(footerLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
