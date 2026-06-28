
package Question;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import SubQuestion.AlcholSubQuery;
import SubQuestion.DiseaseQuestion;
import SubQuestion.DrugsQuestion;
import SubQuestion.ExerciseSubQuery;
import BmiReportDisplay.JustCheck;
import SubQuestion.SmokingSubQuery;
import projectdb.ConnectionProvider;
import Stored.StaticWeight;
public class Questions extends JFrame implements ActionListener{
    
    Connection con;
    Statement stm;
    ResultSet rst;
    ButtonGroup radioGroup,radioGroup1,radioGroup2,radioGroup3,radioGroup4;
    JLabel Query,Question1,Question2,Question3,Question4,Question5;
    JRadioButton y1,n1,y2,n2,y3,n3,y4,n4,y5,n5;
    JButton submit;
    JPanel p1;
    double height;
    public Questions(double height,double weight) {
        
        //height from information frame
        this.height=height;
        StaticWeight.weight=weight;
        p1=new JPanel();
        
        Query=new JLabel("Answer the following questions:");
       Query.setFont(new Font("Serif",Font.BOLD,22));
       Query.setBounds(200,50,400,40);
       
       //for first survey question
       Question1=new JLabel();
       Question1.setBounds(50,100,150,30);
       Question1.setFont(new Font("Serif",Font.BOLD,16));
       
       y1=new JRadioButton("Yes");
       y1.addActionListener(this);
       n1=new JRadioButton("No"); 
       
       radioGroup = new ButtonGroup();
      
       radioGroup.add(y1);
       radioGroup.add(n1);
       
       y1.setBounds(52,140,70,30);
      
       n1.setBounds(160,140,70,30);
       
       //for second survey question
       
       Question2=new JLabel();
       Question2.setBounds(50,180,300,30);
       Question2.setFont(new Font("Serif",Font.BOLD,16));
       
       radioGroup1 = new ButtonGroup();
      
       y2=new JRadioButton("Yes");
       n2=new JRadioButton("No");
       
       radioGroup1.add(y2);
       radioGroup1.add(n2);
       
       y2.setBounds(52,210,70,30);
       y2.addActionListener(this);
       n2.setBounds(160,210,70,30);
       
       //for third survey question
        Question3=new JLabel();
       Question3.setBounds(50,250,300,30);
       Question3.setFont(new Font("Serif",Font.BOLD,16));
       
       radioGroup2 = new ButtonGroup();
      
       y3=new JRadioButton("Yes");
       y3.addActionListener(this);
       n3=new JRadioButton("No");
       
       radioGroup2.add(y3);
       radioGroup2.add(n3);
       
       y3.setBounds(52,290,70,30);
       n3.setBounds(160,290,70,30);
       
       
       //for fourth survey question
        Question4=new JLabel();
       Question4.setBounds(50,330,300,30);
       Question4.setFont(new Font("Serif",Font.BOLD,16));
       
       radioGroup3 = new ButtonGroup();
      
       y4=new JRadioButton("Yes");
        y4.addActionListener(this);
       n4=new JRadioButton("No");
       
       radioGroup3.add(y4);
       radioGroup3.add(n4);
       
       y4.setBounds(52,370,70,30);
       n4.setBounds(160,370,70,30);
       
       //for fifth survey question
        Question5=new JLabel();
       Question5.setBounds(50,410,300,30);
       Question5.setFont(new Font("Serif",Font.BOLD,16));
       
       radioGroup4 = new ButtonGroup();
      
       y5=new JRadioButton("Yes");
       y5.addActionListener(this);
       n5=new JRadioButton("No");
       
       radioGroup4.add(y5);
       radioGroup4.add(n5);
       
       y5.setBounds(52,450,70,30);
       n5.setBounds(160,450,70,30);
       
       
       //for submit button
       submit=new JButton("Submit");
       submit.setBounds(52,490,100,50);
       submit.addActionListener(this);
       
       p1.add(Query);
       
       p1.add(Question1);
       p1.add(y1);
       p1.add(n1);
       
       
       p1.add(Question2);
       p1.add(y2);
       p1.add(n2);
        
       p1.add(Question3);
       p1.add(y3);
       p1.add(n3);
        
       p1.add(Question4);
       p1.add(y4);
       p1.add(n4);
       
       p1.add(Question5);
       p1.add(y5);
       p1.add(n5);
       
       p1.add(submit);
        
       p1.setLayout(null);
       //p1.setBackground(Color.cyan);
       add(p1);
       
       
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
 
       try{
        
        con=ConnectionProvider.getCon();
        stm=con.createStatement();
       if(con != null){
                System.out.println("Database connection success ...");
            }
       
       
         String query="select Questions from bmiquestion where sid=1";
        rst=stm.executeQuery(query);
        while(rst.next()){
            String Questions=rst.getString("Questions");
          Question1.setText(Questions);
        }
          
          
         String query1="select Questions from bmiquestion where sid=2";
        rst=stm.executeQuery(query1);
        while(rst.next()){
            String Questions=rst.getString("Questions");
          Question2.setText(Questions);
        }
     
            String query2="select Questions from bmiquestion where sid=3";
        rst=stm.executeQuery(query2);
        while(rst.next()){
            String Questions=rst.getString("Questions");
          Question3.setText(Questions);
        }
     
           String query3="select Questions from bmiquestion where sid=4";
        rst=stm.executeQuery(query3);
        while(rst.next()){
            String Questions=rst.getString("Questions");
          Question4.setText(Questions);
        }
        
           String query4="select Questions from bmiquestion where sid=5";
        rst=stm.executeQuery(query4);
        while(rst.next()){
            String Questions=rst.getString("Questions");
          Question5.setText(Questions);
        }
     
     
        con.close();
        
    }catch(Exception e){
        System.out.println("Not Connected!(Error Occured)"+e.getMessage());
    }
  
     
        setVisible(true);
        setSize(800,800);
        
        setTitle("SURVEY QUESTIONS");
        
    
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
        
       if(e.getSource().equals(y1)){
          
            new SmokingSubQuery();
       }
       if(e.getSource()==y2){
        
          new AlcholSubQuery();
       }
       if(e.getSource().equals(y3)){
          
           new DiseaseQuestion();
        
       }
       
       if(e.getSource().equals(y4)){
           
           new DrugsQuestion();
       }
       if(e.getSource().equals(y5)){
           
           new ExerciseSubQuery();
       }
      if(e.getSource().equals(submit)){
        
        if (validateInputs()) {
            
            setVisible(false);   
           
            System.out.println("I am ready to run....");
          
            new JustCheck(height);
            
        } else {
  
            JOptionPane.showMessageDialog(this, "Please answer all questions.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
   

private boolean validateInputs() {
  
    boolean allQuestionsAnswered = y1.isSelected()||n1.isSelected()&& y2.isSelected()||n2.isSelected() && y3.isSelected()||n3.isSelected() && y4.isSelected()||n4.isSelected()&& y5.isSelected()||n5.isSelected();
    return allQuestionsAnswered;
}

}





   
