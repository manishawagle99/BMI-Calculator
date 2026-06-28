
package BmiReportDisplay;

import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import projectdb.ConnectionProvider;
import Stored.StaticWeight;
public class JustCheck extends JFrame{
    double weight,height,bmi;
    ResultSet rst;
    JTextField bmiresult,healthtipstext,healthtipstext1,healthtipstext2,healthtipstext3,healthtipstext4;
    JLabel bmilabel,bmicalculated,healthtips,thankyou;
    JPanel p1,p2;
    
    
    public JustCheck(double height){
         weight=StaticWeight.weight;
        this.height=height;
        
       p1=new JPanel();
       p2=new JPanel();
        System.out.println("weight22"+weight);
       bmi=weight/(this.height*this.height);
       System.out.println("your bmi is"+bmi);
        System.out.println("weight"+weight);
       bmicalculated=new JLabel("YOUR BODY MASS INDEX REPORT");
       bmicalculated.setBounds(20,30,600,50);
       bmicalculated.setFont(new Font("Serif",Font.BOLD,22));
       p1.add(bmicalculated);
        
       bmilabel=new JLabel ("Your Body Mass Index is:");
       bmilabel.setBounds(30,90,200,40);
       bmilabel.setFont(new Font("Serif",Font.BOLD,20));
       p1.add(bmilabel);
       
       bmiresult=new JTextField();
       bmiresult.setBounds(240,90,200,40);
       bmiresult.setText(String.valueOf(bmi));
       p1.add(bmiresult);
       
       
       healthtips=new JLabel("Healthtips");
       healthtips.setBounds(30, 150,100,40);
       healthtips.setFont(new Font("Serif",Font.BOLD,20));
       p1.add(healthtips);
       
       healthtipstext=new JTextField();
       //healthtipstext.setBounds(30,200,100,40);
       p2.add(healthtipstext);
       
       healthtipstext1=new JTextField();
       p2.add(healthtipstext1);
       
        healthtipstext2=new JTextField();
       p2.add(healthtipstext2);
       
       
          healthtipstext3=new JTextField();
       p2.add(healthtipstext3);
       
          healthtipstext4=new JTextField();
       p2.add(healthtipstext4);
       
       thankyou=new JLabel("Thank you,have a good day <3");
       thankyou.setFont(new Font("Serif",Font.BOLD,22));
       p2.add(thankyou);
       
       p1.setLayout(new GridLayout(4,1));
       p2.setLayout(new GridLayout(6,1));
      
       add(p1);

       add(p2);
     
          try{
              
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            
       if(con != null){
                System.out.println("Database connection success ...");
            }
       if(bmi<18.5){
             String query="select* from healthtips where hid=2";
              rst = stm.executeQuery(query);
                while(rst.next()){
                                                               
                                String result = rst.getString("result");
                                String tips1 = rst.getString("tips1");
                               String tips2 = rst.getString("tips2");
                                String tips3 = rst.getString("tips3");
                                String tips4 = rst.getString("tips4");
                                 healthtipstext.setText(result);
                                  healthtipstext1.setText(tips1);
                                  healthtipstext2.setText(tips2);
                                  healthtipstext3.setText(tips3);
                                  healthtipstext4.setText(tips4);
                                  
                                System.out.println(result+"\n"+tips1+"\n"+tips2+"\n"+tips3+"\n"+tips4);
        }
            
       }
        if(18.5<=bmi&&bmi<25){
             String query1="select* from healthtips where hid=1";
              rst = stm.executeQuery(query1);
                while(rst.next()){
                                                               
                                String result = rst.getString("result");
                                String tips1 = rst.getString("tips1");
                               String tips2 = rst.getString("tips2");
                                String tips3 = rst.getString("tips3");
                                String tips4 = rst.getString("tips4");
                                 healthtipstext.setText(result);
                                  healthtipstext1.setText(tips1);
                                  healthtipstext2.setText(tips2);
                                  healthtipstext3.setText(tips3);
                                  healthtipstext4.setText(tips4);
                                  
                                System.out.println(result+"\n"+tips1+"\n"+tips2+"\n"+tips3+"\n"+tips4);
        }
       }
              if(25<=bmi&&bmi<30){
             String query1="select* from healthtips where hid=3";
              rst = stm.executeQuery(query1);
                while(rst.next()){
                                                               
                                String result = rst.getString("result");
                                String tips1 = rst.getString("tips1");
                               String tips2 = rst.getString("tips2");
                                String tips3 = rst.getString("tips3");
                                String tips4 = rst.getString("tips4");
                                healthtipstext.setText(result);
                                  healthtipstext1.setText(tips1);
                                  healthtipstext2.setText(tips2);
                                  healthtipstext3.setText(tips3);
                                  healthtipstext4.setText(tips4);
                                  
                               
                                System.out.println(result+"\n"+tips1+"\n"+tips2+"\n"+tips3+"\n"+tips4);
        }
       }
                if(30<=bmi&&bmi<35){
             String query1="select* from healthtips where hid=4";
              rst = stm.executeQuery(query1);
                while(rst.next()){
                                                               
                                String result = rst.getString("result");
                                String tips1 = rst.getString("tips1");
                               String tips2 = rst.getString("tips2");
                                String tips3 = rst.getString("tips3");
                                String tips4 = rst.getString("tips4");
                                
                                System.out.println(result+"\n"+tips1+"\n"+tips2+"\n"+tips3+"\n"+tips4);
                                  healthtipstext.setText(result);
                                  healthtipstext1.setText(tips1);
                                  healthtipstext2.setText(tips2);
                                  healthtipstext3.setText(tips3);
                                  healthtipstext4.setText(tips4);
                                  
                                  
                                  
                                  
        }
       }
        }catch(Exception e){
             System.out.println("Not Connected!(Error Occured)"+e.getMessage());
        }
          
      
     
        
        setVisible(true);
        setSize(800,800);
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
