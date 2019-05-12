<<<<<<< HEAD
package com.zlh.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName GraphicalInterface
 * @Description 制作计算器图形界面类
 * @Author ZhouLinHu
 * @Date 2018/12/19 11:36
 * @Version 1.0
 */
public class GraphicalInterface implements ActionListener {
    private JFrame jframe;
    private Container contentPane;
    private JPanel jPanel1,jPanel2;
    private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17;
    private JTextField textField;

    private String text="", charindex="";

    public GraphicalInterface(){
        jframe=new JFrame("Calculator");
        contentPane=jframe.getContentPane();
        jframe.setBounds(600,300,300,300);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void go(){
        btn17=new JButton("Clear");
        btn17.setActionCommand("Clear");
        btn17.addActionListener(this);
        textField=new JTextField("",15);
        jPanel1=new JPanel();
        jPanel1.add(textField);
        jPanel1.add(btn17);
        jPanel2=new JPanel();
        jPanel2.setLayout(new GridLayout(4,4));
        newButton();
        contentPane.add(jPanel1, BorderLayout.NORTH);
        contentPane.add(jPanel2, BorderLayout.SOUTH);
        jframe.pack();
        jframe.setVisible(true);
    }
    /**
     * @Author: ZhouLinHu
     * @Date: 2018/12/19 20:41
     * @Description: 初始化按钮位置
     * @return: void
     */
    private void newButton(){
        btn1=new JButton("1");
        btn1.setActionCommand("1");
        btn1.addActionListener(this);
        btn2=new JButton("2");
        btn2.setActionCommand("2");
        btn2.addActionListener(this);
        btn3=new JButton("3");
        btn3.setActionCommand("3");
        btn3.addActionListener(this);
        btn4=new JButton("4");
        btn4.setActionCommand("4");
        btn4.addActionListener(this);
        btn5=new JButton("5");
        btn5.setActionCommand("5");
        btn5.addActionListener(this);
        btn6=new JButton("6");
        btn6.setActionCommand("6");
        btn6.addActionListener(this);
        btn7=new JButton("7");
        btn7.setActionCommand("7");
        btn7.addActionListener(this);
        btn8=new JButton("8");
        btn8.setActionCommand("8");
        btn8.addActionListener(this);
        btn9=new JButton("9");
        btn9.setActionCommand("9");
        btn9.addActionListener(this);
        btn10=new JButton("0");
        btn10.setActionCommand("0");
        btn10.addActionListener(this);
        btn11=new JButton("+");
        btn11.setActionCommand("+");
        btn11.addActionListener(this);
        btn12=new JButton("-");
        btn12.setActionCommand("-");
        btn12.addActionListener(this);
        btn13=new JButton("*");
        btn13.setActionCommand("*");
        btn13.addActionListener(this);
        btn14=new JButton("/");
        btn14.setActionCommand("/");
        btn14.addActionListener(this);
        btn15=new JButton("=");
        btn15.setActionCommand("=");
        btn15.addActionListener(this);
        btn16=new JButton(".");
        btn16.setActionCommand(".");
        btn16.addActionListener(this);
        jPanel2.add(btn7);
        jPanel2.add(btn8);
        jPanel2.add(btn9);
        jPanel2.add(btn14);
        jPanel2.add(btn4);
        jPanel2.add(btn5);
        jPanel2.add(btn6);
        jPanel2.add(btn13);
        jPanel2.add(btn1);
        jPanel2.add(btn2);
        jPanel2.add(btn3);
        jPanel2.add(btn12);
        jPanel2.add(btn10);
        jPanel2.add(btn16);
        jPanel2.add(btn15);
        jPanel2.add(btn11);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        text=textField.getText();
        if(e.getActionCommand()=="Clear"){
            textField.setText("");
            text="";
        }
        if(e.getActionCommand()=="+"||e.getActionCommand()=="-"||e.getActionCommand()=="*"||e.getActionCommand()=="/"){
            charindex=e.getActionCommand();
            text+=charindex;
            textField.setText(text);
        }
        if(e.getActionCommand()=="="){
            MathOperation addition=(int a, int b) -> a + b;
            MathOperation subtraction=(int a, int b) -> a - b;
            MathOperation multiplication=(int a, int b) -> a * b;
            MathOperation division=(int a, int b) -> a / b;
            String[] strs;
            if (charindex=="+"){
                strs=text.split("\\+");
                textField.setText(strs[0]+charindex+strs[1]+"="+operate(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), addition));
            }else if (charindex=="*") {
                strs = text.split("\\*");
                int num1=operate(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), multiplication);
                System.out.println(num1);
                textField.setText(strs[0]+charindex+strs[1]+"="+operate(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), multiplication));
            }else if (charindex=="/"){
                strs=text.split("\\/");
                textField.setText(strs[0]+charindex+strs[1]+"="+operate(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), division));
            }else{
                strs=text.split("-");
                textField.setText(strs[0]+charindex+strs[1]+"="+operate(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), subtraction));
            }
        }
        switch (e.getActionCommand()){
            case "1":
                text+="1";
                textField.setText(text);
                break;
            case "2":
                text+="2";
                textField.setText(text);
                break;
            case "3":
                text+="3";
                textField.setText(text);;
                break;
            case "4":
                text+="4";
                textField.setText(text);
                break;
            case "5":
                text+="5";
                textField.setText(text);
                break;
            case "6":
                text+="6";
                textField.setText(text);
                break;
            case "7":
                text+="7";
                textField.setText(text);
                break;
            case "8":
                text+="8";
                textField.setText(text);
                break;
            case "9":
                text+="9";
                textField.setText(text);
                break;
            case "0":
                text+="0";
                textField.setText(text);
                break;
        }
    }
    interface MathOperation{
        int operation(int a, int b);
    }
    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
=======
package com.zlh.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName GraphicalInterface
 * @Description 制作计算器图形界面类
 * @Author ZhouLinHu
 * @Date 2018/12/19 11:36
 * @Version 1.0
 */
public class GraphicalInterface implements ActionListener {
    private JFrame jframe;
    private Container contentPane;
    private JPanel jPanel1,jPanel2;
    private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17;
    private JTextField textField;

    private String text="", charindex="";

    public GraphicalInterface(){
        jframe=new JFrame("Calculator");
        contentPane=jframe.getContentPane();
        jframe.setBounds(600,300,300,300);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void go(){
        btn17=new JButton("Clear");
        btn17.setActionCommand("Clear");
        btn17.addActionListener(this);
        textField=new JTextField("",15);
        jPanel1=new JPanel();
        jPanel1.add(textField);
        jPanel1.add(btn17);
        jPanel2=new JPanel();
        jPanel2.setLayout(new GridLayout(4,4));
        newButton();
        contentPane.add(jPanel1, BorderLayout.NORTH);
        contentPane.add(jPanel2, BorderLayout.SOUTH);
        jframe.pack();
        jframe.setVisible(true);
    }
    /**
     * @Author: ZhouLinHu
     * @Date: 2018/12/19 20:41
     * @Description: 初始化按钮位置
     * @return: void
     */
    private void newButton(){
        btn1=new JButton("1");
        btn1.setActionCommand("1");
        btn1.addActionListener(this);
        btn2=new JButton("2");
        btn2.setActionCommand("2");
        btn2.addActionListener(this);
        btn3=new JButton("3");
        btn3.setActionCommand("3");
        btn3.addActionListener(this);
        btn4=new JButton("4");
        btn4.setActionCommand("4");
        btn4.addActionListener(this);
        btn5=new JButton("5");
        btn5.setActionCommand("5");
        btn5.addActionListener(this);
        btn6=new JButton("6");
        btn6.setActionCommand("6");
        btn6.addActionListener(this);
        btn7=new JButton("7");
        btn7.setActionCommand("7");
        btn7.addActionListener(this);
        btn8=new JButton("8");
        btn8.setActionCommand("8");
        btn8.addActionListener(this);
        btn9=new JButton("9");
        btn9.setActionCommand("9");
        btn9.addActionListener(this);
        btn10=new JButton("0");
        btn10.setActionCommand("0");
        btn10.addActionListener(this);
        btn11=new JButton("+");
        btn11.setActionCommand("+");
        btn11.addActionListener(this);
        btn12=new JButton("-");
        btn12.setActionCommand("-");
        btn12.addActionListener(this);
        btn13=new JButton("*");
        btn13.setActionCommand("*");
        btn13.addActionListener(this);
        btn14=new JButton("/");
        btn14.setActionCommand("/");
        btn14.addActionListener(this);
        btn15=new JButton("=");
        btn15.setActionCommand("=");
        btn15.addActionListener(this);
        btn16=new JButton(".");
        btn16.setActionCommand(".");
        btn16.addActionListener(this);
        jPanel2.add(btn7);
        jPanel2.add(btn8);
        jPanel2.add(btn9);
        jPanel2.add(btn14);
        jPanel2.add(btn4);
        jPanel2.add(btn5);
        jPanel2.add(btn6);
        jPanel2.add(btn13);
        jPanel2.add(btn1);
        jPanel2.add(btn2);
        jPanel2.add(btn3);
        jPanel2.add(btn12);
        jPanel2.add(btn10);
        jPanel2.add(btn16);
        jPanel2.add(btn15);
        jPanel2.add(btn11);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        text=textField.getText();
        if(e.getActionCommand()=="Clear"){
            textField.setText("");
            text="";
        }
        if(e.getActionCommand()=="+"||e.getActionCommand()=="-"||e.getActionCommand()=="*"||e.getActionCommand()=="/"){
            charindex=e.getActionCommand();
            text+=charindex;
            textField.setText(text);
        }
        if(e.getActionCommand()=="="){
            MathOperation addition=(int a, int b) -> a + b;
            MathOperation subtraction=(int a, int b) -> a - b;
            MathOperation multiplication=(int a, int b) -> a * b;
            MathOperation division=(int a, int b) -> a / b;
            String[] strs;
            if (charindex=="+"){
                strs=text.split("\\+");
                textField.setText(strs[0]+charindex+strs[1]+"="+operate(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), addition));
            }else if (charindex=="*") {
                strs = text.split("\\*");
                int num1=operate(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), multiplication);
                System.out.println(num1);
                textField.setText(strs[0]+charindex+strs[1]+"="+operate(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), multiplication));
            }else if (charindex=="/"){
                strs=text.split("\\/");
                textField.setText(strs[0]+charindex+strs[1]+"="+operate(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), division));
            }else{
                strs=text.split("-");
                textField.setText(strs[0]+charindex+strs[1]+"="+operate(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), subtraction));
            }
        }
        switch (e.getActionCommand()){
            case "1":
                text+="1";
                textField.setText(text);
                break;
            case "2":
                text+="2";
                textField.setText(text);
                break;
            case "3":
                text+="3";
                textField.setText(text);;
                break;
            case "4":
                text+="4";
                textField.setText(text);
                break;
            case "5":
                text+="5";
                textField.setText(text);
                break;
            case "6":
                text+="6";
                textField.setText(text);
                break;
            case "7":
                text+="7";
                textField.setText(text);
                break;
            case "8":
                text+="8";
                textField.setText(text);
                break;
            case "9":
                text+="9";
                textField.setText(text);
                break;
            case "0":
                text+="0";
                textField.setText(text);
                break;
        }
    }
    interface MathOperation{
        int operation(int a, int b);
    }
    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
>>>>>>> second commit
