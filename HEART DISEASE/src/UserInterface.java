import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class UserInterface extends JFrame implements ActionListener {

    SpinnerModel ageValue = new SpinnerNumberModel(1,1,120,1);
    JSpinner getAge = new JSpinner(ageValue);
    ButtonGroup sx = new ButtonGroup();
    JRadioButton female = new JRadioButton("Female");
    JRadioButton male = new JRadioButton("Male");
    JSlider cptVal = new JSlider();
    JTextField rbpVal = new JTextField("94");
    JTextField scVal = new JTextField("126");
    JTextField fbsVal = new JTextField("120");
    JSlider recgVal = new JSlider();
    JTextField mhrVal = new JTextField("71");
    ButtonGroup yn = new ButtonGroup();
    JRadioButton yes = new JRadioButton("Yes");
    JRadioButton no = new JRadioButton("No");
    JSlider opVal = new JSlider(0, (int) (62), 0);
    JSlider slVal = new JSlider();
    SpinnerModel cvVal = new SpinnerNumberModel(1,0,3,1);
    JSpinner getcv = new JSpinner(cvVal);
    JComboBox thalVal = new JComboBox(new String[]{"Normal", "Fixed Defect", "Reversible Defect"});

    JButton predict = new JButton("Predict");

    public UserInterface() {
        setTitle("Heart Disease Prediction");
        setSize(1250,850);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0x7AE0E3));
        setLayout(null);

        JLabel title = new JLabel("Heart Disease Predictor");
        title.setFont(new Font("Candara",Font.BOLD,60));
        title.setBounds(300,30,800,100);
        title.setForeground(Color.BLUE);
        add(title);


        JLabel age = new JLabel("Age : ");
        age.setFont(new Font("Times New Roman",Font.BOLD,25));
        age.setBounds(50,150,80,50);
        add(age);
        getAge.setFont(new Font("Times New Roman",Font.PLAIN,25));
        getAge.setBounds(120,150,70,50);
        getAge.setValue(50);
        add(getAge);

        JLabel sex= new JLabel("Sex : ");
        sex.setFont(new Font("Times New Roman",Font.BOLD,25));
        sex.setBounds(280,150,80,50);
        add(sex);
        sx.add(female);
        sx.add(male);
        male.setSelected(true);
        male.setBackground(null);
        female.setBackground(null);
        male.setFont(new Font("Times New Roman",Font.PLAIN,25));
        male.setBounds(340,150,80,50);
        add(male);
        female.setFont(new Font("Times New Roman",Font.PLAIN,25));
        female.setBounds(425,150,150,50);
        add(female);

        JLabel pid = new JLabel("Patient ID: ");
        pid.setFont(new Font("Times New Roman",Font.BOLD,25));
        pid.setBounds(650,150,150,50);
        add(pid);
        JTextField pidd = new JTextField();
        pidd.setFont(new Font("Times New Roman",Font.PLAIN,25));
        pidd.setBounds(790,150,130,50);
        add(pidd);

        JLabel cpt = new JLabel("Chest Pain Type : ");
        cpt.setFont(new Font("Times New Roman",Font.BOLD,25));
        cpt.setBounds(50,230,200,50);
        add(cpt);
        cptVal.setMinimum(0);
        cptVal.setMaximum(3);
        cptVal.setPaintTicks(true);
        cptVal.setPaintLabels(true);
        cptVal.setMajorTickSpacing(1);
        cptVal.setBounds(270,235,250,50);
        cptVal.setBackground(null);
        add(cptVal);

        JLabel rbp = new JLabel("Resting Blood Pressure : ");
        rbp.setFont(new Font("Times New Roman",Font.BOLD,25));
        rbp.setBounds(630,230,300,50);
        add(rbp);
        rbpVal.setFont(new Font("Times New Roman",Font.BOLD,25));
        rbpVal.setBounds(900,230,80,50);
        rbpVal.setHorizontalAlignment(SwingConstants.CENTER);
        add(rbpVal);
        JLabel rbpUnit = new JLabel("mm Hg");
        rbpUnit.setFont(new Font("Times New Roman",Font.BOLD,25));
        rbpUnit.setBounds(990,230,300,50);
        add(rbpUnit);

        JLabel sc = new JLabel("Serum Cholestoral : ");
        sc.setFont(new Font("Times New Roman",Font.BOLD,25));
        sc.setBounds(50,320,250,50);
        add(sc);
        scVal.setFont(new Font("Times New Roman",Font.BOLD,25));
        scVal.setBounds(270,320,80,50);
        scVal.setHorizontalAlignment(SwingConstants.CENTER);
        add(scVal);
        JLabel scUnit = new JLabel("mg/dl");
        scUnit.setFont(new Font("Times New Roman",Font.BOLD,25));
        scUnit.setBounds(355,320,100,50);
        add(scUnit);

        JLabel fbs = new JLabel("Fasting Blood Sugar : ");
        fbs.setFont(new Font("Times New Roman",Font.BOLD,25));
        fbs.setBounds(585,320,300,50);
        add(fbs);
        fbsVal.setFont(new Font("Times New Roman",Font.BOLD,25));
        fbsVal.setBounds(820,320,80,50);
        fbsVal.setHorizontalAlignment(SwingConstants.CENTER);
        add(fbsVal);
        JLabel fbUnit = new JLabel("mg/dl");
        fbUnit.setFont(new Font("Times New Roman",Font.BOLD,25));
        fbUnit.setBounds(905,320,250,50);
        add(fbUnit);

        JLabel recg = new JLabel("Resting Electrocardiographic results : ");
        recg.setFont(new Font("Times New Roman",Font.BOLD,25));
        recg.setBounds(50,410,400,50);
        add(recg);
        recgVal.setMinimum(0);
        recgVal.setMaximum(2);
        recgVal.setPaintTicks(true);
        recgVal.setPaintLabels(true);
        recgVal.setMajorTickSpacing(1);
        recgVal.setBounds(460,423,150,50);
        recgVal.setBackground(null);
        add(recgVal);

        JLabel mhr = new JLabel("Maximum Heartrate achieved : ");
        mhr.setFont(new Font("Times New Roman",Font.BOLD,25));
        mhr.setBounds(670,410,350,50);
        add(mhr);
        mhrVal.setFont(new Font("Times New Roman",Font.BOLD,25));
        mhrVal.setBounds(1010,410,80,50);
        mhrVal.setHorizontalAlignment(SwingConstants.CENTER);
        add(mhrVal);
        JLabel mhrUnit = new JLabel("mm Hg");
        mhrUnit.setFont(new Font("Times New Roman",Font.BOLD,25));
        mhrUnit.setBounds(1100,410,300,50);
        add(mhrUnit);

        JLabel eia = new JLabel("Exercise Induced Angina : ");
        eia.setFont(new Font("Times New Roman",Font.BOLD,25));
        eia.setBounds(50,510,300,50);
        add(eia);
        yn.add(yes);
        yn.add(no);
        yes.setSelected(true);
        yes.setBackground(null);
        no.setBackground(null);
        yes.setFont(new Font("Times New Roman",Font.PLAIN,25));
        yes.setBounds(340,510,70,50);
        add(yes);
        no.setFont(new Font("Times New Roman",Font.PLAIN,25));
        no.setBounds(415,510,80,50);
        add(no);

        JLabel op = new JLabel("Oldpeak : ");
        op.setFont(new Font("Times New Roman",Font.BOLD,25));
        op.setBounds(650,510,150,50);
        add(op);
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        for (double i = 0.0; i <= 6.2; i += 1.0) {
            labelTable.put((int) (i * 10), new JLabel(String.format("%.1f", i)));
        }
        opVal.setLabelTable(labelTable);
        opVal.setMajorTickSpacing(10);
        opVal.setMinorTickSpacing(1);
        opVal.setPaintTicks(true);
        opVal.setPaintLabels(true);
        opVal.setBounds(770,520,300,50);
        opVal.setBackground(null);
        opVal.setValue(620);
        add(opVal);

        JLabel sl = new JLabel("Slope : ");
        sl.setFont(new Font("Times New Roman",Font.BOLD,25));
        sl.setBounds(50,610,150,50);
        add(sl);
        slVal.setMinimum(0);
        slVal.setMaximum(2);
        slVal.setPaintTicks(true);
        slVal.setPaintLabels(true);
        slVal.setMajorTickSpacing(1);
        slVal.setBounds(140,620,180,50);
        slVal.setBackground(null);
        add(slVal);

        JLabel cv = new JLabel("Vessels Coloured : ");
        cv.setFont(new Font("Times New Roman",Font.BOLD,25));
        cv.setBounds( 450,610,250,50);
        add(cv);
        getcv.setFont(new Font("Times New Roman",Font.PLAIN,25));
        getcv.setBounds(650,610,70,50);
        getcv.setValue(0);
        add(getcv);

        JLabel thal = new JLabel("Thal : ");
        thal.setFont(new Font("Times New Roman",Font.BOLD,25));
        thal.setBounds(840,610,150,50);
        add(thal);
        thalVal.setFont(new Font("Times New Roman",Font.PLAIN,20));
        thalVal.setBounds(940,610,150,50);
        add(thalVal);

        predict.setFont(new Font("Candara",Font.BOLD,25));
        predict.setFocusable(false);
        predict.setForeground(Color.BLUE);
        predict.setBounds(500,720,150,50);
        predict.addActionListener(this);
        add(predict);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==predict){
            int Age = (int) ageValue.getValue();
            int Sex=0;
            if (male.isSelected())
                Sex=1;
            int cp=cptVal.getValue();
            int restbps= Integer.parseInt(rbpVal.getText());
            int chol = Integer.parseInt(scVal.getText());
            int fastbs= 0;
            if (Integer.parseInt(fbsVal.getText())>120)
                fastbs=1;
            int restecg = recgVal.getValue();
            int thalach = Integer.parseInt(mhrVal.getText());
            int exang=1;
            if (no.isSelected())
                exang=0;
            float oldpeak= (float) opVal.getValue() /10;
            int slope=slVal.getValue();
            int ca= (int) cvVal.getValue();
            int thal=thalVal.getSelectedIndex()+1;

            HeartDiseasePrediction hdp= new HeartDiseasePrediction();
            int result = hdp.PredictDisease(Age,Sex,cp,restbps,chol,fastbs,restecg,thalach,exang,oldpeak,slope,ca,thal);
            if (result==0){
                JOptionPane.showMessageDialog(this,"The person does not have a heart disease!","Prediction Result",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"The person has a heart disease!","Prediction Result",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

}
