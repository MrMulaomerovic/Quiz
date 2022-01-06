import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class QuizLogika implements ActionListener {

    ArrayList<Pitanja> questions = Util.pitaj();
    ArrayList<TacanOdgovor> answers = Util.tacno();
    Odgovor [] options = Util.odgovori();

    int seconds = 10;
    char answer;
    int index;
    int correct_quesses = 0;
    int total_questions = questions.size();
    int result;

    JFrame f = new JFrame();
    JPanel mainPanel = new JPanel();

    JTextField tf = new JTextField();
    JTextArea ta = new JTextArea();

    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();

    JLabel answerA = new JLabel();
    JLabel answerB = new JLabel();
    JLabel answerC = new JLabel();
    JLabel answerD = new JLabel();
    JLabel secondsLeft = new JLabel();

    JTextField numberRight = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            secondsLeft.setText(String.valueOf(seconds));
            if (seconds<=0){
                displayAnswer();
            }
        }
    });


    public QuizLogika() throws SQLException {
        f.setContentPane(mainPanel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(700,700);
        SpringLayout sl = new SpringLayout();
        f.setLayout(sl);
        f.getContentPane().setBackground(new Color(97, 226, 226));
       // mainPanel.setBackground();
        f.setResizable(false);
        f.setLocationRelativeTo(null);


        sl.putConstraint(SpringLayout.WEST,tf,0,SpringLayout.WEST,mainPanel);
        sl.putConstraint(SpringLayout.NORTH,tf,0,SpringLayout.NORTH,mainPanel);
        tf.setPreferredSize(new Dimension(700,50));
        tf.setBackground(new Color(78, 227, 67));
        tf.setForeground(Color.black);
        tf.setFont(new Font("Britannic",Font.ITALIC,30));
        tf.setBorder(BorderFactory.createBevelBorder(2));
        tf.setHorizontalAlignment(JTextField.HORIZONTAL);
        tf.setEditable(false);
        f.add(tf);


        sl.putConstraint(SpringLayout.WEST,ta,0,SpringLayout.WEST,mainPanel);
        sl.putConstraint(SpringLayout.NORTH,ta,55,SpringLayout.NORTH,mainPanel);
        ta.setPreferredSize(new Dimension(700,35));
        ta.setBackground(new Color(78, 227, 67));
        ta.setForeground(Color.black);
        ta.setFont(new Font("Britannic",Font.ITALIC,30));
        ta.setBorder(BorderFactory.createBevelBorder(2));
        ta.setEditable(false);
        f.add(ta);

        buttonA.setPreferredSize(new Dimension(50,50));
        buttonA.setText("A");
        sl.putConstraint(SpringLayout.WEST,buttonA,10,SpringLayout.WEST,mainPanel);
        sl.putConstraint(SpringLayout.NORTH,buttonA,120,SpringLayout.WEST,mainPanel);
        buttonA.addActionListener(this);
        f.add(buttonA);

        buttonB.setPreferredSize(new Dimension(50,50));
        buttonB.setText("B");
        sl.putConstraint(SpringLayout.WEST,buttonB,10,SpringLayout.WEST,mainPanel);
        sl.putConstraint(SpringLayout.NORTH,buttonB,180,SpringLayout.WEST,mainPanel);
        buttonB.addActionListener(this);
        f.add(buttonB);

        buttonC.setPreferredSize(new Dimension(50,50));
        buttonC.setText("C");
        sl.putConstraint(SpringLayout.WEST,buttonC,10,SpringLayout.WEST,mainPanel);
        sl.putConstraint(SpringLayout.NORTH,buttonC,240,SpringLayout.WEST,mainPanel);
        buttonC.addActionListener(this);
        f.add(buttonC);

        buttonD.setPreferredSize(new Dimension(50,50));
        buttonD.setText("D");
        sl.putConstraint(SpringLayout.WEST,buttonD,10,SpringLayout.WEST,mainPanel);
        sl.putConstraint(SpringLayout.NORTH,buttonD,300,SpringLayout.WEST,mainPanel);
        buttonD.addActionListener(this);
        f.add(buttonD);


        answerA.setBorder(BorderFactory.createLineBorder(new Color(255,0,0),5,true));
        answerA.setText("ODGOVOR A");
        answerA.setForeground(Color.black);
        answerA.setPreferredSize(new Dimension(600,50));
        sl.putConstraint(SpringLayout.WEST,answerA,70,SpringLayout.WEST,mainPanel);
        sl.putConstraint(SpringLayout.NORTH,answerA,120,SpringLayout.WEST,mainPanel);
        f.add(answerA);

        answerB.setBorder(BorderFactory.createLineBorder(new Color(255,0,0),5,true));
        answerB.setText("ODGOVOR B");
        answerB.setForeground(Color.black);
        answerB.setPreferredSize(new Dimension(600,50));
        sl.putConstraint(SpringLayout.WEST,answerB,70,SpringLayout.WEST,mainPanel);
        sl.putConstraint(SpringLayout.NORTH,answerB,180,SpringLayout.WEST,mainPanel);
        f.add(answerB);

        answerC.setBorder(BorderFactory.createLineBorder(new Color(255,0,0),5,true));
        answerC.setText("ODGOVOR C");
        answerC.setForeground(Color.black);
        answerC.setPreferredSize(new Dimension(600,50));
        sl.putConstraint(SpringLayout.WEST,answerC,70,SpringLayout.WEST,mainPanel);
        sl.putConstraint(SpringLayout.NORTH,answerC,240,SpringLayout.WEST,mainPanel);
        f.add(answerC);

        answerD.setBorder(BorderFactory.createLineBorder(new Color(255,0,0),5,true));
        answerD.setText("ODGOVOR D");
        answerD.setForeground(Color.black);
        answerD.setPreferredSize(new Dimension(600,50));
        sl.putConstraint(SpringLayout.WEST,answerD,70,SpringLayout.WEST,mainPanel);
        sl.putConstraint(SpringLayout.NORTH,answerD,300,SpringLayout.WEST,mainPanel);
        f.add(answerD);

        secondsLeft.setBorder((BorderFactory.createLineBorder(new Color(255,0,0),5,true)));
        secondsLeft.setText(String.valueOf(seconds));
        secondsLeft.setPreferredSize(new Dimension(100,100));
        secondsLeft.setHorizontalAlignment(JTextField.HORIZONTAL);
        secondsLeft.setBackground(Color.orange);
        secondsLeft.setForeground(Color.BLACK);
        secondsLeft.setOpaque(true);
        secondsLeft.setFont(new Font("Ink Free",Font.ITALIC,40));
        sl.putConstraint(SpringLayout.WEST,secondsLeft,600,SpringLayout.WEST,mainPanel);
        sl.putConstraint(SpringLayout.NORTH,secondsLeft,590,SpringLayout.WEST,mainPanel);
        f.add(secondsLeft);


        numberRight.setBorder(BorderFactory.createLineBorder(new Color(255,0,0),5,true));
        numberRight.setForeground(new Color(41, 245, 6));
        numberRight.setFont(new Font("Britannic", Font.BOLD,40));
        numberRight.setBackground(Color.BLACK);
        numberRight.setPreferredSize(new Dimension(200,100));
        sl.putConstraint(SpringLayout.WEST,numberRight,225,SpringLayout.WEST,mainPanel);
        sl.putConstraint(SpringLayout.NORTH,numberRight,225,SpringLayout.WEST,mainPanel);

        percentage.setBorder(BorderFactory.createLineBorder(new Color(255,0,0),5,true));
        percentage.setForeground(new Color(41, 245, 6));
        percentage.setFont(new Font("Britannic", Font.BOLD,40));
        percentage.setBackground(Color.BLACK);
        percentage.setPreferredSize(new Dimension(200,100));
        sl.putConstraint(SpringLayout.WEST,percentage,225,SpringLayout.WEST,mainPanel);
        sl.putConstraint(SpringLayout.NORTH,percentage,325,SpringLayout.WEST,mainPanel);

        f.setVisible(true);

        nextQuestion();

    }

    public void nextQuestion(){


        if (index>=total_questions){
            results();
        }else {
//            buttonA.setEnabled(true);
//            buttonB.setEnabled(true);
//            buttonC.setEnabled(true);
//            buttonD.setEnabled(true);

            tf.setText("Pitanje broj " +questions.get(index).getId());
            ta.setText(questions.get(index).getPitanja());

            answerA.setText(options[index].getPoljeA());
            answerB.setText(options[index].getPoljeB());
            answerC.setText(options[index].getPoljeC());
            answerD.setText(options[index].getPoljeD());

            timer.start();
        }
    }

    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correct_quesses/(double)total_questions)*100);

        tf.setText("RESULTS");
        ta.setText("");
        answerA.setText("");
        answerB.setText("");
        answerC.setText("");
        answerD.setText("");

        numberRight.setText("("+correct_quesses+"/"+total_questions+")");
        percentage.setText(result+"%");

        f.add(numberRight);
        f.add(percentage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource()==buttonA){
            answer = 'A'; //ova varijabla je tipa char
            if (answer == (answers.get(index).getTacanOdgovor())){
                correct_quesses++;
                answerA.setForeground(Color.green);
            }
        }

        if (e.getSource()==buttonB){
            answer = 'B'; //ova varijabla je tipa char
            if (answer == (answers.get(index).getTacanOdgovor())){
                correct_quesses++;
                answerB.setForeground(Color.green);
            }
        }
        if (e.getSource()==buttonC){
            answer = 'C'; //ova varijabla je tipa char
            if (answer == (answers.get(index).getTacanOdgovor())){
                correct_quesses++;
                answerC.setForeground(Color.green);
            }
        }
        if (e.getSource()==buttonD){
            answer = 'D'; //ova varijabla je tipa char
            if (answer == (answers.get(index).getTacanOdgovor())){
                correct_quesses++;
                answerD.setForeground(Color.green);
            }
        }

        displayAnswer();

    }

    public void displayAnswer(){
        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers.get(index).getTacanOdgovor() != 'A')
            answerA.setForeground(Color.red);
        if (answers.get(index).getTacanOdgovor() != 'B')
            answerB.setForeground(Color.red);
        if (answers.get(index).getTacanOdgovor() != 'C')
            answerC.setForeground(Color.red);
        if (answers.get(index).getTacanOdgovor() != 'D')
            answerD.setForeground(Color.red);

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerA.setForeground(Color.BLACK);
                answerB.setForeground(Color.BLACK);
                answerC.setForeground(Color.BLACK);
                answerD.setForeground(Color.BLACK);

                answer =' ';//resetovanje
                seconds=10; //resetovanje
                secondsLeft.setText(String.valueOf(seconds));

                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);

                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
}
