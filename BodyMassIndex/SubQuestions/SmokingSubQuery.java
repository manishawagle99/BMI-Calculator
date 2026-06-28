
package SubQuestion;

import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JRadioButton;
import projectdb.ConnectionProvider;
import Stored.StaticWeight;

public class SmokingSubQuery extends JFrame implements ActionListener{
    
    Connection con;
    Statement stm;
    ResultSet rst;
    
    JLabel Smoking1, Smoking2,Title;
    
    JRadioButton smk1, smk2, smk3, smk4, smkh1, smkh2, smkh3, smkh4;
    
    ButtonGroup radioGroup,radioGroups;
    
    JButton submit;
   
  
    public SmokingSubQuery(){
       
        
        
        Title=new JLabel("Smoking related Query");
        Title.setBounds(200,50,400,40);
        Title.setFont(new Font("Serif",Font.BOLD,22));
        
        //first subquestion
        Smoking1 = new JLabel();
        Smoking1.setBounds(52,100,300,30);
        Smoking1.setFont(new Font("Serif",Font.BOLD,16));
       
        //option1
        smk1 = new JRadioButton();
       
        smk1.setBounds(52,140,500,30);
        smk1.setFont(new Font("Serif",Font.BOLD,16));
        smk1.addActionListener(this);
        
        //option
        smk2 = new JRadioButton();
        smk2.setBounds(52,180,500,30);
        smk2.setFont(new Font("Serif",Font.BOLD,16));
        
        //option3
        smk3 = new JRadioButton();
        smk3.setBounds(52,220,500,30);
        smk3.setFont(new Font("Serif",Font.BOLD,16));

        //option4
        smk4 = new JRadioButton();
        smk4.setBounds(52,260,500,30);
        smk4.setFont(new Font("Serif",Font.BOLD,16));
        

        radioGroup = new ButtonGroup();
        radioGroup.add(smk1);
        radioGroup.add(smk2);
        radioGroup.add(smk3);
        radioGroup.add(smk4);
        
        
        //second subquestion
        Smoking2 = new JLabel();
        Smoking2.setBounds(52,300,300,30);
        Smoking2.setFont(new Font("Serif",Font.BOLD,16));
        
        
        smkh1 = new JRadioButton();
        smkh1.setBounds(52,340,500,30);
        smkh1.setFont(new Font("Serif",Font.BOLD,16));
        smkh1.addActionListener(this);
        
        smkh2 = new JRadioButton();
        smkh2.setBounds(52,380,500,30);
        smkh2.setFont(new Font("Serif",Font.BOLD,16));
        
        
        smkh3 = new JRadioButton();
        smkh3.setBounds(52,420,500,30);
        smkh3.setFont(new Font("Serif",Font.BOLD,16));
        
        smkh4 = new JRadioButton();
        smkh4.setBounds(52,460,700,30);
        smkh4.setFont(new Font("Serif",Font.BOLD,16));

        radioGroups=new ButtonGroup();
        radioGroups.add(smkh1);
        radioGroups.add(smkh2);
        radioGroups.add(smkh3);
        radioGroups.add(smkh4);
        
        
        submit=new JButton("submit");
        submit.setBounds(52,500,100,30);
        submit.addActionListener(this);
        

        
       
        
        //fetching smoking subquestion from database and adding to labels
        try{
        
         con=ConnectionProvider.getCon();
       stm=con.createStatement();
       if(con != null){
                System.out.println("Database connection success ...");
            }
       
       //first subquestion
         String subquery="select SubQuestions from bmisubquestions where sqid=1";
        rst=stm.executeQuery(subquery);
        while(rst.next()){
            String subQuestions=rst.getString("SubQuestions");
            Smoking1.setText(subQuestions);
        }
          
          
           String op1="select option1 from options where opid=1";
        rst=stm.executeQuery(op1);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option1");
            smk1.setText(subQuestionsop1);
        }
     
        
            
           String op2="select option2 from options where opid=1";
        rst=stm.executeQuery(op2);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option2");
            smk2.setText(subQuestionsop1);
        }
     
        
           
           String op3="select option3 from options where opid=1";
        rst=stm.executeQuery(op3);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option3");
            smk3.setText(subQuestionsop1);
        }
     
        
            
           String op4="select option4 from options where opid=1";
        rst=stm.executeQuery(op4);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option4");
            smk4.setText(subQuestionsop1);
        }
      
        //second subquestion
        
          String subquery1="select SubQuestions from bmisubquestions where sqid=2";
        rst=stm.executeQuery(subquery1);
        while(rst.next()){
            String subQuestions=rst.getString("SubQuestions");
            Smoking2.setText(subQuestions);
        }
        
        
           String op11="select option1 from options where opid=2";
        rst=stm.executeQuery(op11);
        while(rst.next()){
            String subQuestionsop2=rst.getString("option1");
            smkh1.setText(subQuestionsop2);
        }
     
        
            
           String op22="select option2 from options where opid=2";
        rst=stm.executeQuery(op22);
        while(rst.next()){
            String subQuestionsop2=rst.getString("option2");
            smkh2.setText(subQuestionsop2);
        }
     
        
           
           String op33="select option3 from options where opid=2";
        rst=stm.executeQuery(op33);
        while(rst.next()){
            String subQuestionsop2=rst.getString("option3");
            smkh3.setText(subQuestionsop2);
        }
     
        
            
           String op44="select option4 from options where opid=2";
        rst=stm.executeQuery(op44);
        while(rst.next()){
            String subQuestionsop2=rst.getString("option4");
            smkh4.setText(subQuestionsop2);
        }
     
      
     
        con.close();
        
    }catch(Exception e){
        System.out.println("Not Connected!(Error Occured)"+e.getMessage());
    }
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      
        add(Title);
        
        add(Smoking1);
        add(smk1);
        add(smk2);
        add(smk3);
        add(smk4);
        
        add(Smoking2);
        add(smkh1);
        add(smkh2);
        add(smkh3);
        add(smkh4);
       
        add(submit);
        setVisible(true);
        setSize(800,800);
        setLayout(new GridLayout(13,1));
        setTitle("SMOKING SUBQUESTIONS");
    } 
    @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(submit)) {
       UpdatedWeight();
       
        if (validateInputs()) {
            
            setVisible(false);
           
            
      
        } else {
            
            JOptionPane.showMessageDialog(this, "Please select your answers.");
        }
    }
 
  
}
  private boolean validateInputs() {
   
    if (radioGroup.getSelection() == null || radioGroups.getSelection() == null) {
        return false;
    }
    return true; 
}
  

   public void UpdatedWeight(){
       //first options
         if(smk1.isSelected()&&smkh1.isSelected()){
             StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.005;
   
          }
         if(smk1.isSelected()&&smkh2.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.007;
         }
         if(smk1.isSelected()&&smkh3.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.009;
         }
         if(smk1.isSelected()&&smkh4.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.01;
         }
         //second options 
         if(smk2.isSelected()&&smkh1.isSelected()){
       
           StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.011;
          }
         if(smk2.isSelected()&&smkh2.isSelected()){
             StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.012;
         }
         if(smk2.isSelected()&&smkh3.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.013;
         }
         if(smk2.isSelected()&&smkh4.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.014;
         }
         //third options
         if(smk3.isSelected()&&smkh1.isSelected()){
            StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.016;
   
          }
         if(smk3.isSelected()&&smkh2.isSelected()){
            StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.017;
         }
         if(smk3.isSelected()&&smkh3.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.018;
         }
         if(smk3.isSelected()&&smkh4.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.019;
         }
         //fourth options
        if(smk4.isSelected()&&smkh1.isSelected()){
       
            StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.02;
          }
         if(smk4.isSelected()&&smkh2.isSelected()){
           StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.021;
         }
         if(smk4.isSelected()&&smkh3.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.023;
         }
         if(smk4.isSelected()&&smkh4.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.024;
         }
         System.out.println("weight"+StaticWeight.weight);
   }
    

}