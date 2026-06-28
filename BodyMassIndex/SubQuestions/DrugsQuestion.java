
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


public class DrugsQuestion extends JFrame implements ActionListener{
    
    Connection con;
    Statement stm;
    ResultSet rst;
    
    JLabel Drug,Title;
    
    JRadioButton drug1, drug2, drug3, drug4;
    
    ButtonGroup radioGroup;
    
    JButton submit;
    
       public DrugsQuestion(){
           
        Title=new JLabel("Drugs related Query");
        Title.setBounds(200,50,400,40);
        Title.setFont(new Font("Serif",Font.BOLD,22));
        
        Drug = new JLabel();
        Drug.setBounds(52,100,300,30);
        Drug.setFont(new Font("Serif",Font.BOLD,16));
        
         //option1
        drug1 = new JRadioButton();
        drug1.setFont(new Font("Serif",Font.BOLD,16));
        
        //option
        drug2 = new JRadioButton();
        drug2.setBounds(52,180,500,30);
        drug2.setFont(new Font("Serif",Font.BOLD,16));
        
        //option3
        drug3 = new JRadioButton();
        drug3.setBounds(52,220,500,30);
        drug3.setFont(new Font("Serif",Font.BOLD,16));

        //option4
        drug4 = new JRadioButton();
        drug4.setBounds(52,260,500,30);
        drug4.setFont(new Font("Serif",Font.BOLD,16));
        

        radioGroup = new ButtonGroup();
        radioGroup.add(drug1);
        radioGroup.add(drug2);
        radioGroup.add(drug3);
        radioGroup.add(drug4);
        
        
           
        submit=new JButton("submit");
         submit.setBounds(52,500,100,30);
        submit.addActionListener(this);
        
        
         try{
     
         con=ConnectionProvider.getCon();
       stm=con.createStatement();
       if(con != null){
                System.out.println("Database connection success ...");
                
                //first subquestion
         String subquery="select SubQuestions from bmisubquestions where sqid=6";
        rst=stm.executeQuery(subquery);
        while(rst.next()){
            String subQuestions=rst.getString("SubQuestions");
            Drug.setText(subQuestions);
        }
        
        String op1="select option1 from options where opid=6";
        rst=stm.executeQuery(op1);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option1");
            drug1.setText(subQuestionsop1);
        }
        
        
            
           String op2="select option2 from options where opid=6";
        rst=stm.executeQuery(op2);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option2");
            drug2.setText(subQuestionsop1);
        }
     
        
           
           String op3="select option3 from options where opid=6";
        rst=stm.executeQuery(op3);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option3");
            drug3.setText(subQuestionsop1);
        }
     
        
            
           String op4="select option4 from options where opid=6";
        rst=stm.executeQuery(op4);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option4");
            drug4.setText(subQuestionsop1);
        }
       }
         }catch(Exception e){
             System.out.println("Not Connected!(Error Occured)"+e.getMessage());
         }
  
       add(Title);
       add(Drug);
       add(drug1);
       add(drug2);
       add(drug3);
       add(drug4);
       add(submit);
       
       
        setLayout(new GridLayout(10,1));
       setVisible(true);
       setSize(800,800);
       setTitle("DRUGS QUERY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

    @Override
 public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(submit)) {
       UpdatedWeight();
        if (validateInputs()) {
            
            setVisible(false);
           //  Questions n4= new Questions();
           //  n4.y4.setSelected(true);
            // n4.dispose();
        } else {
            
            JOptionPane.showMessageDialog(this, "Please select your answers.");
        }
    }
}
  private boolean validateInputs() {
   
    if (radioGroup.getSelection() == null || radioGroup.getSelection() == null) {
        return false;
    }
    

    return true; 
}
  
  public void UpdatedWeight(){
      if(drug1.isSelected()){
           StaticWeight.weight=StaticWeight.weight-0.4;
      }
       if(drug2.isSelected()){
           StaticWeight.weight=StaticWeight.weight-2.5;
      }
        if(drug3.isSelected()){
           StaticWeight.weight=StaticWeight.weight-4.5;
      }
         if(drug4.isSelected()){
           StaticWeight.weight=StaticWeight.weight-7.7;
      }
         System.out.println("weight33"+StaticWeight.weight);
  }
}

