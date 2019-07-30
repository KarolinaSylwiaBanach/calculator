package pl.karolina;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class calculator {
    private JPanel panel1;
    private JTextField text;
    private JButton sevenButton;
    private JButton fourButton;
    private JButton oneButton;
    private JButton eightButton;
    private JButton fiveButton;
    private JButton twoButton;
    private JButton nineButton;
    private JButton sixButton;
    private JButton threeButton;
    private JButton additionButton;
    private JButton subtractButton;
    private JButton resultButton;
    private JButton divisionButton;
    private JButton multiplicationButton;
    private JButton deleteButton;
    private JButton zeroButton;
    private JButton zeroZeroButton;
    private JButton dotButton;
    private JButton backspaceButton;
    private JLabel textLabel;
    double num, ans;
    int calculations = 0;


    public calculator() {

        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(Character.isDigit(e.getKeyChar()) || e.getKeyChar() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == KeyEvent.VK_DELETE)) {
                    e.consume();
                }

            }
        });

        zeroButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int length = text.getText().length();
                if (length > 0) {
                    text.setText(text.getText() + "0");
                }
            }
        });

        zeroZeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = text.getText().length();
                if (length > 0) {
                    text.setText(text.getText() + "00");
                }
            }
        });

        oneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText() + "1");
            }
        });

        twoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText() + "2");
            }
        });

        threeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText() + "3");
            }
        });

        fourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText() + "4");
            }
        });

        fiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText() + "5");
            }
        });

        sixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText() + "6");
            }
        });

        sevenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText() + "7");
            }
        });

        eightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText() + "8");

            }
        });

        nineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText() + "9");
            }
        });

        additionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(text.getText());
                textLabel.setText(text.getText()+"+");
                calculations=1;
                text.setText("");
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(text.getText());
                textLabel.setText(text.getText()+"-");
                calculations=2;
                text.setText("");
            }
        });

        multiplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(text.getText());
                textLabel.setText(text.getText()+"*");
                calculations=3;
                text.setText("");
            }
        });

        divisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(text.getText());
                textLabel.setText(text.getText()+"/");
                calculations=4;
                text.setText("");

            }
        });

        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arithmetic_operation();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
            }
        });

        dotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = text.getText().length();
                if (length > 0) {
                    text.setText(text.getText() + ".");
                } else
                    text.setText("0.");
            }
        });

        backspaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = text.getText().length();
                if (length > 0) {
                    StringBuilder back = new StringBuilder(text.getText());
                    back.deleteCharAt(length - 1);
                    text.setText(back.toString());
                }
            }
        });

    }

    public void arithmetic_operation () {

        switch (calculations) {
            case 1:
                ans = num + Double.parseDouble(text.getText());
                text.setText(String.valueOf(ans));
                break;
            case 2:
                ans = num - Double.parseDouble(text.getText());
                text.setText(String.valueOf(ans));
                break;
            case 3:
                ans = num * Double.parseDouble(text.getText());
                text.setText(String.valueOf(ans));
                break;
            case 4:
                ans = num / Double.parseDouble(text.getText());
                text.setText(String.valueOf(ans));
                break;
            default:
                text.setText("Błąd");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("calculator");
        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.setContentPane(new calculator().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
