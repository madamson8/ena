import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Calculator extends JFrame implements  ActionListener
{
    Container c ;
    JTextField result ;
    JPanel p = new JPanel();
    JButton b[] = new JButton[16];
    String s[] = {"0","1","2","3","4","5","6","7","8","9","+","-","/","*","=","C"};
    //----------------------Me------------------------
    String Screen="",monitor1="",monitor2="",OperationOnScreen="";
    boolean CommandEmpty=true,switcher=true;
    double R=Integer.MIN_VALUE,L=Integer.MIN_VALUE;
    //------------------------------------------------
    public Calculator ()
    {
        super ("Casio ^_^");

        c=getContentPane();
        result = new JTextField();
        result.setEditable(false);
        result.setBackground(Color.white);

        p.setLayout(new GridLayout(4,4));
        for (int i=0;i<16;i++)
        {
            b[i] = new JButton(s[i]);
            b[i].addActionListener(this);
            p.add(b[i]);
        }
        c.add(result,BorderLayout.NORTH);
        c.add(p);

        setSize(300,300);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }//End Constructor
    public static void main()
    {
        new Calculator();
    }
    //------------------------------------------------
    public void actionPerformed(ActionEvent event)
    {
        for (int i=0; i<=9; i++)//Numbers
        {
            if(event.getSource()==b[i])
            {
                Screen+=i;
                result.setText("");
                result.setText(Screen);
            }
        }

        for (int i=10; i<=14; i++)//Commands
        {
            if(event.getSource()==b[i])
            {
                if(result.getText().lastIndexOf(OperationOnScreen)!=-1)//prevent exception
                    result.setText(result.getText().substring(0,result.getText().lastIndexOf(OperationOnScreen))+s[i]);
                else
                    result.setText(result.getText()+s[i]);
                OperationOnScreen=s[i];

                if(switcher)
                {monitor1=s[i];switcher=false;}
                else {monitor2=s[i];switcher=true;}

                if (monitor1!=monitor2 && monitor2!="")
                {
                    if(switcher) //execute older,send sign newer
                    {Calc(event,monitor1.charAt(0),monitor2); }
                    else {Calc(event,monitor2.charAt(0),monitor1); }
                }
                if(s[i]!="=") //calc returns 0
                    Calc(event,s[i].charAt(0),s[i]);
            }
        }

        if(event.getSource()==b[15]) //Clear
        {
            Screen=""; monitor1=""; monitor2="";
            switcher=true; CommandEmpty=true;
            result.setText("");
        }
    }//end actionPerformed

    public void Calc(ActionEvent event,char OpType,String Operator)
    {		if (Operator=="=")
        Operator="";

        if(CommandEmpty && Screen=="")
        {
            return;
        }

        else if(CommandEmpty && Screen!="")
        {
            R=Integer.parseInt(Screen);
            result.setText(Screen+Operator);
            Screen="";
            CommandEmpty=false;
        }
        else if(!CommandEmpty && Screen!="")
        {
            L=Integer.parseInt(Screen);
            R=Operations(R,L,OpType);//calculate
            Screen="";
            result.setText("");
            result.setText(R+Operator);
        }
    }//End Calc

    public static double  Operations(double R, double L, char op)
    {
        switch (op)
        {
            case '+':
                return R+L;
            case '-':
                return R-L;
            case '*':
                return R*L;
            case '/':
                return R/L;
        }
        return 0;
    }


}//end class


//import java.util.Scanner;
///**
// * Created by Matthew on 3/22/2016.
// * A simple calculator class intended for use in project ENA.
// */
//public class Calculator {
//    public void calculatorPerformed(String aCommand) {
//        Scanner userInput = new Scanner(System.in);
//        if(aCommand.equals("calculator")) {
//            System.out.println("Please type calculator and then whatever calculation you want to peform. \n EX. calculator add");
//        }
//
//        if(aCommand.equals("calculator add")) {
//            System.out.println("First number?: ");
//            double f_num = userInput.nextDouble(); //Snake case used to add readability.
//            System.out.println("Second number?: ");
//            double s_num = userInput.nextDouble();
//            double addAnswer = addition(f_num, s_num);
//            System.out.println("The answer is: " + addAnswer);
//        }
//
//        else if(aCommand.equals("calculator times")) {
//            System.out.println("First number?: ");
//            double f_num = userInput.nextDouble();
//            System.out.println("Second number?: ");
//            double s_num = userInput.nextDouble();
//            double multAnswer = multiplication(f_num, s_num);
//            System.out.println("The answer is: " + multAnswer);
//        }
//
//        else if(aCommand.equals("calculator subtract")) {
//            System.out.println("First number?: ");
//            double f_num = userInput.nextDouble();
//            System.out.println("Second number?: ");
//            double s_num = userInput.nextDouble();
//            double subAnswer = subtraction(f_num, s_num);
//            System.out.println(subAnswer);
//        }
//
//        else if(aCommand.equals("calculator divide")) {
//            System.out.println("First number?: ");
//            double f_num = userInput.nextDouble();
//            System.out.println("Second number?: ");
//            double s_num = userInput.nextDouble();
//            double divAnswer = division(f_num, s_num);
//            System.out.println(divAnswer);
//        }
//    }
//    public double addition(double a, double b) {
//        double answer = a + b;
//        return answer;
//    }
//    public double multiplication(double a, double b) {
//        double answer = (a*b);
//        return answer;
//    }
//    public double subtraction(double a, double b) {
//        double answer = a - b;
//        return answer;
//    }
//    public double division(double a, double b) {
//        double answer = (a/b);
//        return answer;
//    }
//}