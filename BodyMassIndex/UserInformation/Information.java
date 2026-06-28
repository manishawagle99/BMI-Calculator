
package UserInformation;

import Question.Questions;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Information extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JPanel p1=new JPanel();
    JLabel MainTitle, heightL1, WeightL2, GenderL3, AgeL4,text;

    JTextField heightT1, WeightT2, AgeT4;

    ButtonGroup radioGroup;

    JRadioButton male, female, others;

    Choice chc, chc2;
    
    JButton insert;
   
    public Information() {
        
        //label for body mass index
        MainTitle = new JLabel("BODY MASS INDEX");
        MainTitle.setBounds(400, 5, 600, 30);
        MainTitle.setFont(new Font("Serif",Font.BOLD,22));
        
        // Added to panel panel
        panel.add(MainTitle);

        //Label for Enter your height
        heightL1 = new JLabel("Enter your height:");
        heightL1.setBounds(70, 50, 300, 30);
        heightL1.setFont(new Font("Serif",Font.BOLD,16));
        panel.add(heightL1);//added to panel
        
        heightT1 = new JTextField();
        heightT1.setBounds(200, 50, 200, 30);
        panel.add(heightT1);
        
        chc = new Choice();

        chc.setBounds(400, 50, 50, 30);
        chc.add("m");
        chc.add("cm");
        chc.add("feet");
        chc.add("inch");
      
        
      
        chc.addItemListener(new ItemListener() {
            @Override
             public void itemStateChanged(ItemEvent e) {

                 String selectedOption = (String) chc.getSelectedItem();
                 String num = heightT1.getText();
                double h1 = Double.parseDouble(num);
                 switch (selectedOption) {
                     case "m":

                         heightT1.setText(String.valueOf(h1));
                         break;
                     case "cm":
                         heightT1.setText(String.valueOf(h1/100));
                         break;
                         case"inches":
                             heightT1.setText(String.valueOf(h1/39.37));
                             break;
                     // Add more cases for other options if needed
                     case "feet":
                         heightT1.setText(String.valueOf(h1/3.2808));
                         break;
                     default:
                         // Default case if none of the options match
                         break;
                 }
             }
        });
        
        
        
        
        
        panel.add(chc);

        WeightL2 = new JLabel("Enter your weight:");
        WeightL2.setBounds(70, 90, 300, 30);
       WeightL2.setFont(new Font("Serif",Font.BOLD,16));
        WeightT2 = new JTextField();
        WeightT2.setBounds(200, 90, 200, 30);

        chc2 = new Choice();
        chc2.setBounds(400, 90, 50, 30);
        chc2.add("kg");
        chc2.add("pounds");
        
        
       chc2.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
        String selectedOption = (String) chc2.getSelectedItem();
        String num = WeightT2.getText();
        double w1 = Double.parseDouble(num);
                System.out.println("Received From Textfield:"+w1);
        switch (selectedOption) {
            case"kg":
                WeightT2.setText(String.valueOf(w1));
                break;
                case"pounds":
                    WeightT2.setText(String.valueOf(w1/0.45359237));
                    break;
                default:
                    break;
       }
       }
               });
        panel.add(WeightL2);
        panel.add(WeightT2);
        panel.add(chc2);

        GenderL3 = new JLabel("Select your gender:");
        GenderL3.setFont(new Font("Serif",Font.BOLD,16));
        GenderL3.setBounds(70, 130, 300, 30);

        panel.add(GenderL3);

        female = new JRadioButton("female");
        female.setFont(new Font("Serif",Font.ITALIC,12));
        female.setBounds(200, 130, 100, 30);

        panel.add(female);

        male = new JRadioButton("male");
        male.setBounds(300, 130, 100, 30);
        male.setFont(new Font("Serif",Font.ITALIC,12));

        panel.add(male);

        others = new JRadioButton("others");
        others.setBounds(400, 130, 100, 30);
        others.setFont(new Font("Serif",Font.ITALIC,12));
        panel.add(others);

        radioGroup = new ButtonGroup();
        radioGroup.add(female);
        radioGroup.add(male);
        radioGroup.add(others);
        
        AgeL4 = new JLabel("Enter your age:");
        AgeL4.setFont(new Font("Serif",Font.BOLD,16));
        AgeL4.setBounds(70, 170, 300, 30);

        AgeT4 = new JTextField();
        AgeT4.setBounds(200, 170, 200, 30);

        panel.add(AgeL4);
        panel.add(AgeT4);
        
        insert=new JButton("Enter");
        insert.setFont(new Font("Serif",Font.BOLD,22));
        insert.setBounds(200,210,100,50);
        panel.add(insert);
        insert.addActionListener(this);
     
         
        text=new JLabel("CHECK YOUR BMI <3");
        text.setFont(new Font("Serif",Font.BOLD,50));
        
       
        p1.setBackground(Color.CYAN);
        p1.add(text);
       
        
        add(p1);
        panel.setLayout(null);
        add(panel);
        
        panel.setSize(500,400);
        panel.setBackground(Color.WHITE);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(800,800);
        setVisible(true);
        setLayout(new GridLayout(2,1));
      
        setTitle("USER INFORMATION");
        
    }

    @Override
  
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == insert) {
        // Get user input from text fields
        String heightStr = heightT1.getText().trim();
        String weightStr = WeightT2.getText().trim();
        String ageStr = AgeT4.getText().trim();

        // Check if height, weight, and age fields are empty
        if (heightStr.isEmpty() || weightStr.isEmpty() || ageStr.isEmpty()) {
            // Display an error message or dialog indicating that all fields are required.
            JOptionPane.showMessageDialog(this, "All fields are required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Attempt to parse numeric values
            try {
                double height = Double.parseDouble(heightStr);
                double weight = Double.parseDouble(weightStr);
                System.out.println("This is weight :"+weight);
                int age = Integer.parseInt(ageStr);

                // Validate height, weight, and age (add your own validation rules)
                if (height <= 0 || weight <= 0 || age <= 0) {
                    // Display an error message or dialog indicating invalid input.
                    JOptionPane.showMessageDialog(this, "Invalid input values.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    
                    new Questions(height,weight);
                    
                    setVisible(false);
                }
            } catch (NumberFormatException ex) {
                // Display an error message or dialog for invalid numeric input.
                JOptionPane.showMessageDialog(this, "Invalid numeric input.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
  
}
}






      
