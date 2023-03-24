package ETest;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

public class Etest_project extends JFrame {
    private static final int NUM_QUESTIONS = 5;
    private static final String QUESTIONS_FILE = "questions.txt";
    private static int score = 0;
    private JButton submitbtn;

    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JLabel questionlbl;
    private JLabel scorelbl;
    private JPanel panel1;

    File file = new File(QUESTIONS_FILE);
    Scanner scan = new Scanner(file);
    int question_number = 0;
    String correct_answer;
    String message;


    public Etest_project(String title) throws IOException {
        super(title);
        this.setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setSize(800,600);
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);
        bg.add(radioButton4);
        loadPage();
        submitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                loadPage();
            }
        });

            }
   our score is " + score;
                JFrameOptionPane.showMessageDialog(null, public void loadPage() {
                    String question = "", option1 = "", option2 = "", option3 = "", option4 = "";
                    for (int i = 0; i < NUM_QUESTIONS; i++) {
                        try{
                            question = scan.nextLine();
                            option1 = scan.nextLine();
                            option2 = scan.nextLine();
                            option3 = scan.nextLine();
                            option4 = scan.nextLine();
                            correct_answer = scan.nextLine();

                        }catch(NoSuchElementException e){
                            message = "You have come to the end of the test.\n Ysage);

            }
            questionlbl.setText(question);
            radioButton1.setText(option1);
            radioButton2.setText(option2);
            radioButton3.setText(option3);
            radioButton4.setText(option4);
            if ((question_number + 6) % 6 == 0) {
                break;
            }
        }
        question_number = question_number + 6;
    }
    public void checkAnswer() {
        if (radioButton1.isSelected() && Integer.parseInt(radioButton1.getText().trim()) == Integer.parseInt(correct_answer.trim())) {
            score++;
        } else if (radioButton2.isSelected() && Integer.parseInt(radioButton2.getText().trim()) == Integer.parseInt(correct_answer.trim())) {
            score++;
        } else if (radioButton3.isSelected() && Integer.parseInt(radioButton3.getText().trim()) == Integer.parseInt(correct_answer.trim())) {
            score++;
        } else if (radioButton4.isSelected() && Integer.parseInt(radioButton4.getText().trim()) == Integer.parseInt(correct_answer.trim())) {
            score++;
        }
        scorelbl.setText("Score: " + score);
    }
    public static void main(String[] args) throws IOException {
        JFrame frame = new Etest_project("EXAM");
        frame.setVisible(true);
    }
}



