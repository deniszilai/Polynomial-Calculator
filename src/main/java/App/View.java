package App;

import javax.swing.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View extends JFrame{
    private JButton button1 = new JButton("+");
    private JButton button2 = new JButton("-");
    private JButton button3 = new JButton("*");
    private JButton button4 = new JButton("'");
    private JButton button5 = new JButton("I");

    private JLabel label1 = new JLabel ("p1");
    private JLabel label2 = new JLabel ("p2");
    private JLabel label3 = new JLabel ("rez");

    private JTextField textfield1 = new JTextField(17);
    private JTextField textfield2 = new JTextField(17);
    private JTextField textfield3 = new JTextField(50);

    public View(String name){
        super(name);
        setTitle("Polynomial Calculator");
        setSize(450, 320);
        setLocation(new Point(450, 320));
        initComponent();
        initEvent();
    }

    private void initComponent() {
        getContentPane().setLayout(null);
        button1.setBounds(240, 6, 41, 22);
        getContentPane().add(button1);
        button2.setBounds(240, 34, 40, 22);
        getContentPane().add(button2);
        button3.setBounds(290, 6, 40, 22);
        getContentPane().add(button3);
        button4.setBounds(290, 34, 40, 22);
        getContentPane().add(button4);
        button5.setBounds(340, 20, 40, 22);
        getContentPane().add(button5);

        textfield1.setBounds(80, 6, 152, 22);
        getContentPane().add(textfield1);
        textfield2.setBounds(80, 35, 152, 22);
        getContentPane().add(textfield2);
        textfield3.setBounds(80, 80, 461, 22);
        getContentPane().add(textfield3);

        label1.setBounds(52, 5, 17, 22);
        getContentPane().add(label1);
        label2.setBounds(52, 35, 17, 22);
        getContentPane().add(label2);
        label3.setBounds(35, 80, 40, 22);
        getContentPane().add(label3);
    }

    private void initEvent() {

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1Plus(e);
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2Minus(e);
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button3Multiplication(e);
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button4Deriv(e);
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button5Integr(e);
            }
        });
    }

    private void button1Plus(ActionEvent evt) {
        Conversion xy = new Conversion();
        Polynomial x = new Polynomial();
        x = xy.conv(textfield1.getText());
        Polynomial y = new Polynomial();
        y = xy.conv(textfield2.getText());
        textfield3.setText(x.addition(y).toString());
    }
    private void button2Minus(ActionEvent evt){
        Conversion xy = new Conversion();
        Polynomial x = new Polynomial();
        x = xy.conv(textfield1.getText());
        Polynomial y = new Polynomial();
        y = xy.conv(textfield2.getText());
        textfield3.setText(x.dif(y).toString());
    }
    private void button3Multiplication(ActionEvent evt) {
        Conversion xy = new Conversion();
        Polynomial x = new Polynomial();
        x = xy.conv(textfield1.getText());
        Polynomial y = new Polynomial();
        y = xy.conv(textfield2.getText());
        textfield3.setText(x.multiplication(y).toString());
    }
    private void button4Deriv(ActionEvent evt) {
        Conversion xy = new Conversion();
        Polynomial x = new Polynomial();
        x = xy.conv(textfield1.getText());
        Polynomial y = new Polynomial();
        y = xy.conv(textfield2.getText());
        textfield3.setText(x.deriv(y).toString());
    }
    private void button5Integr(ActionEvent evt) {
        Conversion xy = new Conversion();
        Polynomial x = new Polynomial();
        x = xy.conv(textfield1.getText());
        Polynomial y = new Polynomial();
        y = xy.conv(textfield2.getText());
        textfield3.setText(x.integr(y).toString());
    }

    public static void main(String args[]) {
        JFrame frame = new View("Pol Calc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(20,20,600,200);
        frame.setVisible(true);

    }
}
