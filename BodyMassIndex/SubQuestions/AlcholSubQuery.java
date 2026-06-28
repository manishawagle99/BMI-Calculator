
package SubQuestion;


import Stored.StaticWeight;
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

public class AlcholSubQuery extends JFrame implements ActionListener{
    Connection con;
    Statement stm;
    ResultSet rst;
    
    JLabel Alchol1, Alchol2,Title;
    
    JRadioButton alc1, alc2, alc3, alc4, alch1, alch2,alch3, alch4;
    
    ButtonGroup radioGroup,radioGroups;
    
    JButton submit;
    
     public AlcholSubQuery(){
    
      
        Title=new JLabel("Alchol related Query");
        Title.setBounds(200,50,400,40);
        Title.setFont(new Font("Serif",Font.BOLD,22));
        
        Alchol1 = new JLabel();
        Alchol1.setBounds(52,100,300,30);
        Alchol1.setFont(new Font("Serif",Font.BOLD,16));
        
         //option1
        alc1 = new JRadioButton();
        alc1.setFont(new Font("Serif",Font.BOLD,16));
        
        //option
        alc2 = new JRadioButton();
        alc2.setBounds(52,180,500,30);
        alc2.setFont(new Font("Serif",Font.BOLD,16));
        
        //option3
        alc3 = new JRadioButton();
        alc3.setBounds(52,220,500,30);
        alc3.setFont(new Font("Serif",Font.BOLD,16));

        //option4
       alc4 = new JRadioButton();
        alc4.setBounds(52,260,500,30);
        alc4.setFont(new Font("Serif",Font.BOLD,16));
        

        radioGroup = new ButtonGroup();
        radioGroup.add(alc1);
        radioGroup.add(alc2);
        radioGroup.add(alc3);
        radioGroup.add(alc4);
        
        
        //second subquestion
        Alchol2 = new JLabel();
        Alchol2.setBounds(52,300,300,30);
        Alchol2.setFont(new Font("Serif",Font.BOLD,16));
        
        
        alch1 = new JRadioButton();
        alch1.setBounds(52,340,500,30);
        alch1.setFont(new Font("Serif",Font.BOLD,16));
        
        alch2 = new JRadioButton();
        alch2.setBounds(52,380,500,30);
        alch2.setFont(new Font("Serif",Font.BOLD,16));
        
        
        alch3 = new JRadioButton();
        alch3.setBounds(52,420,500,30);
        alch3.setFont(new Font("Serif",Font.BOLD,16));
        
        alch4 = new JRadioButton();
        alch4.setBounds(52,460,700,30);
        alch4.setFont(new Font("Serif",Font.BOLD,16));

        radioGroups=new ButtonGroup();
        radioGroups.add(alch1);
        radioGroups.add(alch2);
        radioGroups.add(alch3);
        radioGroups.add(alch4);
        
           
        submit=new JButton("submit");
        submit.setBounds(52,500,100,30);
        submit.addActionListener(this);
        

        
        
         
        try{
       
        con=ConnectionProvider.getCon();
       stm=con.createStatement();
       if(con != null){
                System.out.println("Database connection success ...");
                
                //first subquestion
         String subquery="select SubQuestions from bmisubquestions where sqid=3";
        rst=stm.executeQuery(subquery);
        while(rst.next()){
            String subQuestions=rst.getString("SubQuestions");
            Alchol1.setText(subQuestions);
        }
        
        String op1="select option1 from options where opid=3";
        rst=stm.executeQuery(op1);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option1");
            alc1.setText(subQuestionsop1);
        }
        
        
            
           String op2="select option2 from options where opid=3";
        rst=stm.executeQuery(op2);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option2");
            alc2.setText(subQuestionsop1);
        }
     
        
           
           String op3="select option3 from options where opid=3";
        rst=stm.executeQuery(op3);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option3");
            alc3.setText(subQuestionsop1);
        }
     
        
            
           String op4="select option4 from options where opid=3";
        rst=stm.executeQuery(op4);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option4");
            alc4.setText(subQuestionsop1);
        }
        
        
        //second subquestion
        
          String subquery1="select SubQuestions from bmisubquestions where sqid=4";
        rst=stm.executeQuery(subquery1);
        while(rst.next()){
            String subQuestions=rst.getString("SubQuestions");
            Alchol2.setText(subQuestions);
        }
        
        
           String op11="select option1 from options where opid=4";
        rst=stm.executeQuery(op11);
        while(rst.next()){
            String subQuestionsop2=rst.getString("option1");
           alch1.setText(subQuestionsop2);
        }
     
        
            
           String op22="select option2 from options where opid=4";
        rst=stm.executeQuery(op22);
        while(rst.next()){
            String subQuestionsop2=rst.getString("option2");
            alch2.setText(subQuestionsop2);
        }
     
        
           
           String op33="select option3 from options where opid=4";
        rst=stm.executeQuery(op33);
        while(rst.next()){
            String subQuestionsop2=rst.getString("option3");
            alch3.setText(subQuestionsop2);
        }
     
        
            
           String op44="select option4 from options where opid=4";
        rst=stm.executeQuery(op44);
        while(rst.next()){
          String subQuestionsop2=rst.getString("option4");
            alch4.setText(subQuestionsop2);
        }
     
             con.close();
        
            }
        }catch(Exception e){
            System.out.println("Not Connected!(Error Occured)"+e.getMessage());
    
        }
        
        add(Title);
        add(Alchol1);
        add(alc1);
        add(alc2);
        add(alc3);
        add(alc4);
        
        add(Alchol2);
        add(alch1);
        add(alch2);
        add(alch3);
        add(alch4);
        add(submit);
        
        setVisible(true);
        setSize(800,800);
        setTitle("ALCHOL SUBQUERY");
        setLayout(new GridLayout(13,1));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

    @Override
   public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(submit)) {
        UpdatedWeight();
        if (validateInputs()) {
            
              setVisible(false);
               
            //  Questions n2=new Questions();
             // n2.y2.setSelected(true);
             // n2.dispose();
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
         if(alc1.isSelected()&&alch1.isSelected()){
       
           StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.003;
          }
         if(alc1.isSelected()&&alch2.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.004;
         }
         if(alc1.isSelected()&&alch3.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.005;
         }
         if(alc1.isSelected()&&alch4.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.006;
         }
         //second options 
         if(alc2.isSelected()&&alch1.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.01;
   
          }
         if(alc2.isSelected()&&alch2.isSelected()){
             StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.012;
         }
         if(alc2.isSelected()&&alch3.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.014;
         }
         if(alc2.isSelected()&&alch4.isSelected()){
             StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.016; 
         }
         //third options
         if(alc3.isSelected()&&alch1.isSelected()){
             StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.018;
   
          }
         if(alc3.isSelected()&&alch2.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.02;
         }
         if(alc3.isSelected()&&alch3.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.022;
         }
         if(alc3.isSelected()&&alch4.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.024;
         }
         //fourth options
        if(alc4.isSelected()&&alch1.isSelected()){
       
           StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.03;
          }
         if(alc4.isSelected()&&alch2.isSelected()){
             StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.031;
         }
         if(alc4.isSelected()&&alch3.isSelected()){
             StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.032; 
         }
         if(alc4.isSelected()&&alch4.isSelected()){
              StaticWeight.weight=StaticWeight.weight+StaticWeight.weight*0.034;
         }
         System.out.println("weight"+StaticWeight.weight);
   }
}