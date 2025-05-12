import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Disease{
    // Create maps to store different types of patient data
    private static HashMap<String, String[]> patientPersonalData = new HashMap<>();
    private static HashMap<String, String[]> patientMedicalData = new HashMap<>();
    private static HashMap<String, String> predictions = new HashMap<>();

    public static void main(String[] args) {
        initializeData();
        createAndShowGUI();
    }

    private static void initializeData() {
        // Sample data initialization (you should load this from your actual data source)
        String[][] personalData = {
                // PatientID, Name, Sex, Address, Contact
                {"P101", "Nirmala", "34", "Female", "45/1, Gali No. 3, Ram Nagar, New Delhi - 110015", "9876543210"},
                {"P102", "Ajay", "50", "Male", "9, Jain Colony, Near Market, Mumbai - 400070", "9908765432"},
                {"P103", "Latha", "60", "Female", "22/2, C-Block, Vikas Nagar, Kolkata - 700091", "9912345678"},
                {"P104", "Guresh", "54", "Male", "3, Shivaji Nagar, Behind Bus Stand, Ahmedabad - 380014", "9988776655"},
                {"P105", "Rajini", "49", "Female", "56, Sardar Patel Marg, Sadar Bazar, Jaipur - 302017", "9678901234"},
                {"P106", "Raju", "56", "Male", "12, A-Block, Near Metro Station, Bangalore - 560098", "9898989898"},
                {"P107", "Harini", "50", "Female", "34/3, 5th Main, Malleswaram, Chennai - 600080", "9776655443"},
                {"P108", "Hari", "41", "Male", "78, Park Street, B-Block, Kolkata - 700017", "9384750192"},
                {"P109", "Rishitha", "43", "Female", "90/6, Rajput Colony, Near Hanuman Mandir, Lucknow - 226001", "9567890123"},
                {"P110", "Roshan", "38", "Male", "11, Green Avenue, NTR Nagar, Hyderabad - 500019", "9794561234"},
                {"P111", "Varshitha", "63", "Female", "45/7, Keshav Nagar, Sector 15, Gurgaon - 122018", "9876123456"},
                {"P112", "Gagan", "50", "Male", "24/3, 7th Cross, Banjara Hills, Hyderabad - 500034", "9987654321"},
                {"P113", "Teju", "46", "Female", "56, Blue Moon Complex, Shastri Nagar, Bhopal - 462001", "9456789012"},
                {"P114", "Sriram", "55", "Male", "3, Jain Mandir Road, Near Mangal Market, Patna - 800001", "9876534321"},
                {"P115", "Eshu", "48", "Female", "89, Main Road, Near Anand Talkies, Pune - 411030", "9901234567"},
                {"P116", "Bhairav", "52", "Male", "12, Ajanta Apartments, Sector 8, Noida - 201301", "9632145789"},
                {"P117", "Dedeepya", "59", "Female", "77/4, Ganga Vihar, Madurai - 625001", "9834509876"},
                {"P118", "Roop", "44", "Male", "56, West End Road, Koramangala, Bangalore - 560034", "9208476123"},
                {"P119", "Poojitha", "50", "Female", "1, Anand Bhawan, Main Market, Ranchi - 834001", "9812345670"},
                {"P120", "Salar", "39", "Male", "34/2, Saraswati Colony, Sec 10, Chandigarh - 160019", "9735648210"},
                {"P121", "Salima", "42", "Female", "25, Patel Nagar, Opp. Ashok Talkies, Surat - 395007", "9098765432"},
                {"P122", "Hamza", "58", "Male", "89, Harsh Nagar, Near Gurdwara, Amritsar - 143001", "9988887777"},
                {"P123", "Hala", "45", "Female", "11, Shankar Lane, Kanpur - 208001", "9922334455"},
                {"P124", "Aditya", "51", "Male", "6/1, Shanti Nagar, Kolhapur - 416001", "9765432109"},
                {"P125", "Aditi", "49", "Female", "32, Park Avenue, Shivaji Park, Delhi - 110026", "9901122334"},
                {"P126", "Suman", "30", "Female", "13, Main Road, Sector 5, Faridabad - 121001", "9998765432"},


        {"P127", "Vikram", "56", "Male", "56, Kalpana Complex, Patiala - 147001", "9876543210"},
        {"P128", "Sumit", "34", "Male", "32, Model Town, Ludhiana - 141001", "9712345678"},
        {"P129", "Rajesh", "59", "Male", "78, Nirmal Bagh, Dehradun - 248001", "9765432109"},
        {"P130", "Geeta", "50", "Female", "4/2, M.G. Road, Indore - 452001", "9834567890"},
        {"P131", "Anita", "42", "Female", "22/6, A-Block, Moti Nagar, Delhi - 110015", "9901234567"},
        {"P132", "Manoj", "48", "Male", "56, Block B, Noida - 201301", "9785632140"},
        {"P133", "Sunita", "55", "Female", "3/1, Hari Nagar, Delhi - 110023", "9612345678"},
        {"P134", "Ravindra", "43", "Male", "12, Satyam Vihar, Agra - 282001", "9887654321"},
        {"P135", "Suman", "49", "Female", "78, Harish Nagar, Jammu - 180001", "9408765432"},
        {"P136", "Devendra", "60", "Male", "6/3, Ganga Vihar, Udaipur - 313001", "9786543210"},
        {"P137", "Priyanka", "35", "Female", "43, Sadar Bazar, Ajmer - 305001", "9234567890"},
        {"P138", "Sandeep", "53", "Male", "2/1, Kesar Bagh, Ludhiana - 141002", "9912345678"},
        {"P139", "Chandni", "45", "Female", "12/7, Rajendra Nagar, Meerut - 250001", "9765432109"},
        {"P140", "Ravi", "55", "Male", "7/5, Gokul Bagh, Patna - 800002", "9612345670"},
        {"P141", "Anjali", "47", "Female", "24/3, City Road, Pune - 411001", "9334567890"},
        {"P142", "Kishore", "59", "Male", "19, Ashoka Vihar, Gandhinagar - 382015", "9723456789"},
        {"P143", "Sakshi", "50", "Female", "3/4, Basant Vihar, Bhopal - 462002", "9536789012"},
        {"P144", "Vinay", "38", "Male", "5/3, Chhatri Road, Jabalpur - 482001", "9632145789"},
        {"P145", "Meena", "52", "Female", "67, Ram Nagar, Gwalior - 474001", "9098765432"},
        {"P146", "Ajay", "60", "Male", "9/8, Bhagat Singh Colony, Surat - 395001", "9823456789"},
        {"P147", "Shweta", "46", "Female", "1/2, Sushant Lok, Gurgaon - 122018", "9798765432"},
        {"P148", "Rajeev", "43", "Male", "34/2, Indira Nagar, Raipur - 492001", "9901234567"},
    };

    // Add more patients here


    String[][] medicalData = {
            // PatientID, ChestPainType, BP, Cholesterol, Sugar, ECG, HeartRate, Angina, Oldpeak, Slope, Vessels, Thal
            {"P101", "1", "118", "210", "100", "1", "192", "No", "1", "2", "0", "Fixed Defect"},
            {"P102", "3", "94", "126", "120", "3", "71", "Yes", "6", "2", "0", "Normal"},
            {"P103", "3", "140", "250", "110", "2", "150", "Yes", "2.3", "1", "3", "Fixed Defect"},
            {"P104", "1", "135", "240", "115", "1", "175", "Yes", "2.7", "2", "1", "Normal"},
            {"P105", "2", "120", "220", "105", "0", "165", "No", "1.2", "0", "0", "Normal"},
            {"P106", "1", "148", "260", "125", "1", "170", "Yes", "3.1", "2", "2", "Fixed Defect"},
            {"P107", "2", "128", "215", "105", "1", "180", "Yes", "1.6", "1", "0", "Normal"},
            {"P108", "3", "125", "210", "95", "2", "165", "No", "1.1", "2", "0", "Normal"},
            {"P109", "1", "120", "200", "100", "0", "155", "No", "0.8", "1", "1", "Fixed Defect"},
            {"P110", "2", "138", "230", "110", "1", "170", "No", "1", "2", "0", "Normal"},
            {"P111", "1", "135", "240", "120", "1", "145", "Yes", "2.5", "2", "2", "Fixed Defect"},
            {"P112", "2", "110", "220", "105", "0", "160", "No", "0.9", "0", "1", "Normal"},
            {"P113", "3", "128", "210", "98", "2", "155", "No", "1.3", "1", "0", "Normal"},
            {"P114", "1", "145", "250", "130", "1", "180", "Yes", "3", "2", "3", "Fixed Defect"},
            {"P115", "2", "120", "225", "115", "0", "170", "No", "1", "1", "1", "Normal"},
            {"P116", "2", "135", "220", "110", "1", "160", "No", "1.2", "1", "1", "Normal"},
            {"P117", "1", "125", "210", "95", "0", "150", "No", "1.0", "0", "1", "Normal"},
            {"P118", "3", "140", "230", "120", "1", "170", "Yes", "2.3", "2", "1", "Fixed Defect"},
            {"P119", "2", "130", "215", "105", "0", "155", "No", "1.1", "1", "0", "Normal"},
            {"P120", "1", "138", "240", "130", "2", "175", "Yes", "3.0", "2", "2", "Fixed Defect"},
            {"P121", "3", "145", "245", "125", "2", "160", "No", "2.5", "1", "0", "Normal"},
            {"P122", "1", "128", "210", "100", "0", "155", "No", "0.9", "0", "1", "Normal"},
            {"P123", "2", "135", "220", "110", "1", "165", "Yes", "1.8", "1", "1", "Fixed Defect"},
            {"P124", "3", "145", "250", "135", "1", "180", "Yes", "2.8", "2", "3", "Fixed Defect"},

            {"P125", "2", "130", "220", "110", "0", "170", "No", "1.1", "1", "0", "Normal"},
            {"P126", "1", "135", "230", "115", "1", "160", "Yes", "2.0", "2", "1", "Fixed Defect"},
            {"P127", "3", "140", "240", "120", "2", "150", "Yes", "2.5", "2", "1", "Normal"},
            {"P128", "1", "120", "215", "105", "0", "175", "No", "1.2", "0", "0", "Normal"},
            {"P129", "3", "145", "250", "130", "1", "180", "Yes", "3.0", "2", "3", "Fixed Defect"},
            {"P130", "2", "125", "220", "110", "0", "168", "No", "1.3", "1", "0", "Normal"},
            {"P131", "1", "118", "210", "105", "0", "155", "No", "0.9", "1", "1", "Normal"},
            {"P132", "2", "140", "245", "125", "1", "175", "Yes", "2.7", "2", "2", "Fixed Defect"},
            {"P133", "3", "130", "230", "110", "2", "160", "No", "1.0", "1", "0", "Normal"},
            {"P134", "1", "120", "210", "95", "0", "150", "No", "0.8", "0", "1", "Normal"},
            {"P135", "2", "135", "235", "120", "1", "165", "Yes", "2.4", "1", "1", "Fixed Defect"},
            {"P136", "3", "140", "250", "115", "2", "160", "No", "2.1", "2", "0", "Normal"},
            {"P137", "1", "125", "220", "105", "0", "170", "No", "1.0", "1", "0", "Normal"},
            {"P138", "2", "128", "230", "110", "1", "162", "Yes", "2.2", "1", "2", "Fixed Defect"},
            {"P139", "1", "120", "215", "105", "0", "155", "No", "0.9", "0", "1", "Normal"},
            {"P140", "3", "145", "240", "130", "1", "180", "Yes", "3.2", "2", "2", "Fixed Defect"},
            {"P141", "2", "130", "225", "120", "1", "172", "No", "1.1", "1", "1", "Normal"},
            {"P142", "1", "135", "240", "115", "0", "160", "Yes", "2.3", "2", "0", "Fixed Defect"},
            {"P143", "3", "140", "250", "125", "2", "155", "No", "2.0", "1", "1", "Normal"},
            {"P144", "2", "125", "220", "110", "1", "165", "Yes", "1.7", "2", "1", "Fixed Defect"},
            {"P145", "1", "130", "230", "120", "0", "170", "No", "1.2", "0", "0", "Normal"},
            {"P146", "3", "140", "240", "115", "1", "175", "Yes", "2.4", "2", "1", "Fixed Defect"},
            {"P147", "2", "120", "210", "105", "0", "150", "No", "1.0", "1", "1", "Normal"},
            {"P148", "1", "130", "225", "115", "0", "165", "No", "1.1", "1", "0", "Normal"},

            // Add more patients here
    };

    // Initialize predictions
        predictions.put("P101", "The patient has a heart disease");

        predictions.put("P102", "The patient does not have a heart disease");
        predictions.put("P103", "The patient has a heart disease");
        predictions.put("P104", "The patient has a heart disease");
        predictions.put("P105", "The patient does not have a heart disease");
        predictions.put("P106", "The patient has a heart disease");
        predictions.put("P107", "The patient has a heart disease");
        predictions.put("P108", "The patient does not have a heart disease");
        predictions.put("P109", "The patient does not have a heart disease");
        predictions.put("P110", "The patient does not have a heart disease");
        predictions.put("P111", "The patient has a heart disease");
        predictions.put("P112", "The patient does not have a heart disease");
        predictions.put("P113", "The patient does not have a heart disease");
        predictions.put("P114", "The patient has a heart disease");
        predictions.put("P115", "The patient does not have a heart disease");
        predictions.put("P116", "The patient does not have a heart disease");
        predictions.put("P117", "The patient does not have a heart disease");
        predictions.put("P118", "The patient does not have a heart disease");
        predictions.put("P119", "The patient does not have a heart disease");
        predictions.put("P120", "The patient does not have a heart disease");
        predictions.put("P121", "The patient does not have a heart disease");
        predictions.put("P122", "The patient has a heart disease");
        predictions.put("P123", "The patient does not have a heart disease");
        predictions.put("P124", "The patient does not have a heart disease");
        predictions.put("P125", "The patient does not have a heart disease");
        predictions.put("P126", "The patient has a heart disease");
        predictions.put("P127", "The patient does not have a heart disease");
        predictions.put("P128", "The patient does not have a heart disease");
        predictions.put("P129", "The patient does not have a heart disease");
        predictions.put("P130", "The patient does not have a heart disease");
        predictions.put("P131", "The patient does not have a heart disease");
        predictions.put("P132", "The patient does not have a heart disease");
        predictions.put("P133", "The patient does not have a heart disease");
        predictions.put("P134", "The patient does not have a heart disease");
        predictions.put("P135", "The patient does not have a heart disease");
        predictions.put("P136", "The patient does not have a heart disease");
        predictions.put("P137", "The patient does not have a heart disease");
        predictions.put("P138", "The patient does not have a heart disease");
        predictions.put("P139", "The patient does not have a heart disease");
        predictions.put("P140", "The patient does not have a heart disease");
        predictions.put("P141", "The patient does not have a heart disease");
        predictions.put("P142", "The patient has a heart disease");
        predictions.put("P143", "The patient does not have a heart disease");
        predictions.put("P144", "The patient does not have a heart disease");
        predictions.put("P145", "The patient does not have a heart disease");
        predictions.put("P146", "The patient does not have a heart disease");
        predictions.put("P147", "The patient does not have a heart disease");
        predictions.put("P148", "The patient does not have a heart disease");
        predictions.put("P149", "The patient does not have a heart disease");
        predictions.put("P150", "The patient does not have a heart disease");

        // Add more predictions

    // Populate the HashMaps
        for (String[] data : personalData) {
        patientPersonalData.put(data[0], new String[]{data[1], data[2], data[3], data[4]});
    }

        for (String[] data : medicalData) {
        patientMedicalData.put(data[0], new String[]{data[1], data[2], data[3], data[4], data[5],
                data[6], data[7], data[8], data[9], data[10], data[11]});
    }
}

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Heart Disease Prediction System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);

        // Main panel with gradient background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(240, 248, 255),
                        0, getHeight(), new Color(230, 230, 250));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(new BorderLayout(20, 20));

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        JLabel titleLabel = new JLabel("HEART DISEASE PREDICTION SYSTEM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(new Color(0, 51, 102));
        titlePanel.add(titleLabel);

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setOpaque(false);
        JLabel patientIdLabel = new JLabel("Enter Patient ID:");
        patientIdLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField patientIdField = new JTextField(10);
        patientIdField.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton checkButton = new JButton("Check Details");
        checkButton.setFont(new Font("Arial", Font.BOLD, 16));
        checkButton.setBackground(new Color(51, 122, 183));
        checkButton.setForeground(Color.WHITE);
        inputPanel.add(patientIdLabel);
        inputPanel.add(patientIdField);
        inputPanel.add(checkButton);

        // Results Panel (using JTextPane for rich text formatting)
        JTextPane resultPane = new JTextPane();
        resultPane.setEditable(false);
        resultPane.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(resultPane);
        scrollPane.setPreferredSize(new Dimension(900, 500));

        checkButton.addActionListener(e -> {
            String patientId = patientIdField.getText().trim().toUpperCase();
            if (patientPersonalData.containsKey(patientId) && patientMedicalData.containsKey(patientId)) {
                String[] personalInfo = patientPersonalData.get(patientId);
                String[] medicalInfo = patientMedicalData.get(patientId);

                // Create styled document
                StringBuilder html = new StringBuilder();
                html.append("<html><body style='width: 800px; font-family: Arial;'>");
                html.append("<div style='background-color: #f8f9fa; padding: 20px; border-radius: 10px;'>");

                // Personal Information Section
                html.append("<h2 style='color: #004085;'>Personal Information</h2>");
                html.append("<p style='font-size: 16px;'>");
                html.append("<b>Patient ID:</b> ").append(patientId).append("<br>");
                html.append("<b>Name:</b> ").append(personalInfo[0]).append("<br>");
                html.append("<b>Sex:</b> ").append(personalInfo[1]).append("<br>");
                html.append("<b>Address:</b> ").append(personalInfo[2]).append("<br>");
                html.append("<b>Contact:</b> ").append(personalInfo[3]).append("</p>");

                // Medical Information Section
                html.append("<h2 style='color: #004085;'>Medical Information</h2>");
                html.append("<p style='font-size: 16px;'>");
                html.append("<b>Chest Pain Type:</b> ").append(medicalInfo[0]).append("<br>");
                html.append("<b>Resting Blood Pressure:</b> ").append(medicalInfo[1]).append(" mm Hg<br>");
                html.append("<b>Serum Cholesterol:</b> ").append(medicalInfo[2]).append(" mg/dl<br>");
                html.append("<b>Fasting Blood Sugar:</b> ").append(medicalInfo[3]).append(" mg/dl<br>");
                html.append("<b>Resting ECG Results:</b> ").append(medicalInfo[4]).append("<br>");
                html.append("<b>Maximum Heart Rate:</b> ").append(medicalInfo[5]).append(" bpm<br>");
                html.append("<b>Exercise Induced Angina:</b> ").append(medicalInfo[6]).append("<br>");
                html.append("<b>Oldpeak:</b> ").append(medicalInfo[7]).append("<br>");
                html.append("<b>Slope:</b> ").append(medicalInfo[8]).append("<br>");
                html.append("<b>Vessels Colored:</b> ").append(medicalInfo[9]).append("<br>");
                html.append("<b>Thal:</b> ").append(medicalInfo[10]).append("</p>");

                // Prediction Section
                html.append("<h2 style='color: #721c24;'>Prediction Result</h2>");
                html.append("<p style='font-size: 20px; font-weight: bold;'>");
                html.append(predictions.get(patientId)).append("</p>");

                html.append("</div></body></html>");

                resultPane.setContentType("text/html");
                resultPane.setText(html.toString());
            } else {
                resultPane.setContentType("text/html");
                resultPane.setText("<html><body style='font-size: 18px; color: red;'>Invalid Patient ID. Please try again.</body></html>");
            }
        });

        // Add components to main panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        // Add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}