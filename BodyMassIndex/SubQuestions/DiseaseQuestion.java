
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

public class DiseaseQuestion extends JFrame implements ActionListener{
      Connection con;
    Statement stm;
    ResultSet rst;
    
    JLabel Disease1,Title;
    
    JRadioButton dis1, dis2, dis3, dis4;
    
    ButtonGroup radioGroup;
    
    JButton submit;
    public DiseaseQuestion(){
      
        
        Title=new JLabel("Disease related Query");
        Title.setBounds(200,50,400,40);
        Title.setFont(new Font("Serif",Font.BOLD,22));
        
        Disease1 = new JLabel();
        Disease1.setBounds(52,100,300,30);
        Disease1.setFont(new Font("Serif",Font.BOLD,16));
        
         //option1
        dis1 = new JRadioButton();
        dis1.setFont(new Font("Serif",Font.BOLD,16));
        
        //option
        dis2 = new JRadioButton();
        dis2.setBounds(52,180,500,30);
        dis2.setFont(new Font("Serif",Font.BOLD,16));
        

        radioGroup = new ButtonGroup();
        radioGroup.add(dis1);
        radioGroup.add(dis2);
      
        
        submit=new JButton("submit");
         submit.setBounds(52,500,100,30);
        submit.addActionListener(this);
        
        
            
        try{
       
        con=ConnectionProvider.getCon();
       stm=con.createStatement();
       if(con != null){
                System.out.println("Database connection success ...");
                
                //first subquestion
         String subquery="select SubQuestions from bmisubquestions where sqid=5";
        rst=stm.executeQuery(subquery);
        while(rst.next()){
            String subQuestions=rst.getString("SubQuestions");
           Disease1.setText(subQuestions);
        }
        
        String op1="select option1 from options where opid=5";
        rst=stm.executeQuery(op1);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option1");
            dis1.setText(subQuestionsop1);
        }
        
        
            
           String op2="select option2 from options where opid=5";
        rst=stm.executeQuery(op2);
        while(rst.next()){
            String subQuestionsop1=rst.getString("option2");
          dis2.setText(subQuestionsop1);
        }
     
        
 
       
             con.close();
        
            }
        }catch(Exception e){
            System.out.println("Not Connected!(Error Occured)"+e.getMessage());
    
        }
        
        add(Title);
        add(Disease1);
        add(dis1);
        add(dis2);
        
        add(submit);
        setVisible(true);
        setSize(800,800);
        setTitle("DISEASE SUBQUERY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10,1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(submit)) {
       UpdatedWeight();
        if (validateInputs()) {
            
            setVisible(false);
         //  Questions n3= new Questions();
          // n3.y3.setSelected(true);
           //n3.dispose();
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
     
      if(dis1.isSelected()){
           StaticWeight.weight=StaticWeight.weight-4.54; 
      }
  }
}