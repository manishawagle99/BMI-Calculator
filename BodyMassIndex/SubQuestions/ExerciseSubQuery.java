
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


public class ExerciseSubQuery extends JFrame implements ActionListener{
    
    Connection con;
    Statement stm;
    ResultSet rst;
    
    JLabel Exercise,Title;
    
    JRadioButton Exercise1, Exercise2, Exercise3, Exercise4;
    
    ButtonGroup radioGroup;
    
    JButton submit;
    
       public ExerciseSubQuery(){
           
        Title=new JLabel("Exercise related Query");
        Title.setBounds(200,50,400,40);
        Title.setFont(new Font("Serif",Font.BOLD,22));
        
        Exercise = new JLabel();
         Exercise.setBounds(52,100,300,30);
        Exercise.setFont(new Font("Serif",Font.BOLD,16));
        
         //option1
         Exercise1 = new JRadioButton();
         Exercise1.setFont(new Font("Serif",Font.BOLD,16));
        
        //option
        Exercise2 = new JRadioButton();
         Exercise2.setBounds(52,180,500,30);
         Exercise2.setFont(new Font("Serif",Font.BOLD,16));
        
        //option3
        Exercise3 = new JRadioButton();
        Exercise3.setBounds(52,220,500,30);
         Exercise3.setFont(new Font("Serif",Font.BOLD,16));

        //option4
         Exercise4 = new JRadioButton();
        Exercise4 .setBounds(52,260,500,30);
        Exercise4 .setFont(new Font("Serif",Font.BOLD,16));
        

        radioGroup = new ButtonGroup();
        radioGroup.add(Exercise1 );
        radioGroup.add(Exercise2);
        radioGroup.add(Exercise3 );
        radioGroup.add(Exercise4 );
        
        
           
        submit=new JButton("submit");
         submit.setBounds(52,500,100,30);
        submit.addActionListener(this);
        
        
         try{
         con=ConnectionProvider.getCon();
       stm=con.createStatement();
       if(con != null){
                System.out.println("Database connection success ...");
                
                //first subquestion
         String subquery="select SubQuestions from bmisubquestions where sqid=7";
        rst=stm.executeQuery(subquery);
        while(rst.next()){
            String subQuestions=rst.getString("SubQuestions");
            Exercise.setText(subQuestions);
        }
        
        String op1="select option1 from options where opid=7";
        rst=stm.executeQuery(op1);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option1");
            Exercise1.setText(subQuestionsop1);
        }
        
        
            
           String op2="select option2 from options where opid=7";
        rst=stm.executeQuery(op2);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option2");
          Exercise2.setText(subQuestionsop1);
        }
     
        
           
           String op3="select option3 from options where opid=7";
        rst=stm.executeQuery(op3);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option3");
            Exercise3.setText(subQuestionsop1);
        }
     
        
            
           String op4="select option4 from options where opid=7";
        rst=stm.executeQuery(op4);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option4");
           Exercise4.setText(subQuestionsop1);
        }
       }
         }catch(Exception e){
             System.out.println("Not Connected!(Error Occured)"+e.getMessage());
         }
  
       add(Title);
       add(Exercise);
       add(Exercise1);
       add(Exercise2);
       add(Exercise3);
       add(Exercise4 );
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
             dispose();
            setVisible(false);
       //    Questions n5= new Questions();
        //   n5.y5.setSelected(true);
        //   n5.dispose();
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
      if(Exercise1.isSelected()){
           StaticWeight.weight=StaticWeight.weight-0.01944;
      }
       if(Exercise2.isSelected()){
           StaticWeight.weight=StaticWeight.weight-0.038879;
      }
        if(Exercise3.isSelected()){
           StaticWeight.weight=StaticWeight.weight-0.058319;
      }
         if(Exercise4.isSelected()){
           StaticWeight.weight=StaticWeight.weight-0.07759;
      }
         System.out.println("weight33"+StaticWeight.weight);
  }
}
