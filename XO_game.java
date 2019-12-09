import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class XO_game extends JFrame implements ActionListener {
    // Buttons
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();
    JButton b7 = new JButton();
    JButton b8 = new JButton();
    JButton b9 = new JButton();
    JButton b_win1 = b1;
    JButton b_win2 = b2;
    JButton b_win3 = b3;

    JButton b_reset = new JButton("Reset");
    JButton b_recommencer = new JButton("Recommencer");
    JButton b_quitter = new JButton("Quitter");
    // Panels
    JPanel p_left = new JPanel();
    JPanel p_right = new JPanel();
    JPanel p_south = new JPanel();
    JPanel p_center = new JPanel();
    // Radio Button
    JRadioButton radioButton_X = new JRadioButton("X", true);
    JRadioButton radioButton_Y = new JRadioButton("O", false);
    ButtonGroup btn_group = new ButtonGroup();
    // Menu
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem i_reset = new JMenuItem("Reset");
    JMenuItem i_recommencer = new JMenuItem("Recommencer");
    JMenuItem i_Quitter = new JMenuItem("Quitter");
    // Game vars
    String turn = new String();
    int num = 0;

    public XO_game() {
        // Main Window Layout
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        // Menu Panel
        menuBar.add(menu);
        menu.add(i_reset);
        i_reset.addActionListener(this);
        menu.add(i_recommencer);
        i_recommencer.addActionListener(this);
        i_recommencer.setEnabled(false);
        menu.add(i_Quitter);
        i_Quitter.addActionListener(this);
        // Left Panel
        b1.setBackground(Color.DARK_GRAY);
        b2.setBackground(Color.DARK_GRAY);
        b3.setBackground(Color.DARK_GRAY);
        b4.setBackground(Color.DARK_GRAY);
        b5.setBackground(Color.DARK_GRAY);
        b6.setBackground(Color.DARK_GRAY);
        b7.setBackground(Color.DARK_GRAY);
        b8.setBackground(Color.DARK_GRAY);
        b9.setBackground(Color.DARK_GRAY);
        b1.setPreferredSize(new Dimension(50, 50));
        b1.addActionListener(this);
        p_left.add(b1);
        b2.addActionListener(this);
        p_left.add(b2);
        b3.addActionListener(this);
        p_left.add(b3);
        b4.addActionListener(this);
        p_left.add(b4);
        b5.addActionListener(this);
        p_left.add(b5);
        b6.addActionListener(this);
        p_left.add(b6);
        b7.addActionListener(this);
        p_left.add(b7);
        b8.addActionListener(this);
        p_left.add(b8);
        b9.addActionListener(this);
        p_left.add(b9);
        p_left.setLayout(new GridLayout(3, 3, 3, 3));
        p_left.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        p_center.add(p_left);
        p_left.setBackground(Color.LIGHT_GRAY);
        // Right Panel
        b_reset.setBackground(Color.DARK_GRAY);
        b_recommencer.setBackground(Color.DARK_GRAY);
        b_quitter.setBackground(Color.DARK_GRAY);
        b_reset.setForeground(Color.WHITE);
        b_recommencer.setForeground(Color.WHITE);
        b_quitter.setForeground(Color.WHITE);
        b_reset.addActionListener(this);
        p_right.add(b_reset);
        b_recommencer.addActionListener(this);
        b_recommencer.setEnabled(false);
        p_right.add(b_recommencer);
        b_quitter.addActionListener(this);
        p_right.add(b_quitter);
        p_right.setLayout(new GridLayout(3, 1, 1, 3));
        p_right.setBorder(BorderFactory.createEmptyBorder(10, 20, 100, 10));
        p_right.setBackground(Color.LIGHT_GRAY);
        p_center.add(p_right);
        // Center Panel
        p_center.setLayout(new GridLayout(1, 2));
        this.add(p_center);
        // South Panel
        radioButton_X.setBackground(Color.LIGHT_GRAY);
        radioButton_Y.setBackground(Color.LIGHT_GRAY);
        p_south.add(radioButton_X);
        radioButton_X.addActionListener(this);
        radioButton_X.setActionCommand("X");
        p_south.add(radioButton_Y);
        radioButton_Y.addActionListener(this);
        radioButton_Y.setActionCommand("O");
        btn_group.add(radioButton_X);
        btn_group.add(radioButton_Y);
        p_south.setLayout(new FlowLayout(FlowLayout.LEFT));
        p_south.setBackground(Color.LIGHT_GRAY);
        this.add(p_south);
        // Main Window
        this.setJMenuBar(menuBar);
        this.setTitle("XO Game");
        this.setResizable(true);
        this.setDefaultCloseOperation(XO_game.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // game
        if (btn_group.getSelection().getActionCommand().equals("X") && num == 0) {
            radioButton_X.setEnabled(false);
            radioButton_Y.setEnabled(false);
            turn = "X";
        } else if (btn_group.getSelection().getActionCommand().equals("O") && num == 0) {
            radioButton_X.setEnabled(false);
            radioButton_Y.setEnabled(false);
            turn = "O";
        }
        if (e.getSource() == b1 || e.getSource() == b2 || e.getSource() == b3 || e.getSource() == b4
                || e.getSource() == b5 || e.getSource() == b6 || e.getSource() == b7 || e.getSource() == b8
                || e.getSource() == b9) {
            JButton btn = (JButton) e.getSource();
            num++;
            if (turn == "X") {
                btn.setText("X");
                btn.setEnabled(false);
                turn = "O";
                radioButton_Y.setSelected(true);
            } else if (turn == "O") {
                btn.setText("O");
                btn.setEnabled(false);
                turn = "X";
                radioButton_X.setSelected(true);
            }
        }
        // Winner or tie Dialogue
        boolean win = false;
        boolean tie = false;
        if (e.getSource() == b1 || e.getSource() == b2 || e.getSource() == b3 || e.getSource() == b4
                || e.getSource() == b5 || e.getSource() == b6 || e.getSource() == b7 || e.getSource() == b8
                || e.getSource() == b9) {
            if (b1.getText() == "X" && b2.getText() == "X" && b3.getText() == "X") {
                JOptionPane.showMessageDialog(null, "Player X Won!");
                win = true;
                b_win1 = b1;
                b_win2 = b2;
                b_win3 = b3;
            } else if (b7.getText() == "X" && b8.getText() == "X" && b9.getText() == "X") {
                JOptionPane.showMessageDialog(null, "Player X Won!");
                win = true;
                b_win1 = b7;
                b_win2 = b8;
                b_win3 = b9;
            } else if (b3.getText() == "X" && b6.getText() == "X" && b9.getText() == "X") {
                JOptionPane.showMessageDialog(null, "Player X Won!");
                win = true;
                b_win1 = b3;
                b_win2 = b6;
                b_win3 = b9;
            } else if (b1.getText() == "X" && b4.getText() == "X" && b7.getText() == "X") {
                JOptionPane.showMessageDialog(null, "Player X Won!");
                win = true;
                b_win1 = b1;
                b_win2 = b4;
                b_win3 = b7;
            } else if (b1.getText() == "X" && b5.getText() == "X" && b9.getText() == "X") {
                JOptionPane.showMessageDialog(null, "Player X Won!");
                win = true;
                b_win1 = b1;
                b_win2 = b5;
                b_win3 = b9;
            } else if (b3.getText() == "X" && b5.getText() == "X" && b7.getText() == "X") {
                JOptionPane.showMessageDialog(null, "Player X Won!");
                win = true;
                b_win1 = b3;
                b_win2 = b5;
                b_win3 = b7;
            } else if (b4.getText() == "X" && b5.getText() == "X" && b6.getText() == "X") {
                JOptionPane.showMessageDialog(null, "Player X Won!");
                win = true;
                b_win1 = b4;
                b_win2 = b5;
                b_win3 = b6;
            } else if (b2.getText() == "X" && b5.getText() == "X" && b8.getText() == "X") {
                JOptionPane.showMessageDialog(null, "Player X Won!");
                win = true;
                b_win1 = b2;
                b_win2 = b5;
                b_win3 = b8;
            } else if (b1.getText() == "O" && b2.getText() == "O" && b3.getText() == "O") {
                JOptionPane.showMessageDialog(null, "Player O Won!");
                win = true;
                b_win1 = b1;
                b_win2 = b2;
                b_win3 = b3;
            } else if (b7.getText() == "O" && b8.getText() == "O" && b9.getText() == "O") {
                JOptionPane.showMessageDialog(null, "Player O Won!");
                win = true;
                b_win1 = b7;
                b_win2 = b8;
                b_win3 = b9;
            } else if (b3.getText() == "O" && b6.getText() == "O" && b9.getText() == "O") {
                JOptionPane.showMessageDialog(null, "Player O Won!");
                win = true;
                b_win1 = b3;
                b_win2 = b6;
                b_win3 = b9;
            } else if (b1.getText() == "O" && b4.getText() == "O" && b7.getText() == "O") {
                JOptionPane.showMessageDialog(null, "Player O Won!");
                win = true;
                b_win1 = b1;
                b_win2 = b4;
                b_win3 = b7;
            } else if (b1.getText() == "O" && b5.getText() == "O" && b9.getText() == "O") {
                JOptionPane.showMessageDialog(null, "Player O Won!");
                win = true;
                b_win1 = b1;
                b_win2 = b5;
                b_win3 = b9;
            } else if (b3.getText() == "O" && b5.getText() == "O" && b7.getText() == "O") {
                JOptionPane.showMessageDialog(null, "Player O Won!");
                win = true;
                b_win1 = b3;
                b_win2 = b5;
                b_win3 = b7;
            } else if (b4.getText() == "O" && b5.getText() == "O" && b6.getText() == "O") {
                JOptionPane.showMessageDialog(null, "Player O Won!");
                win = true;
                b_win1 = b4;
                b_win2 = b5;
                b_win3 = b6;
            } else if (b2.getText() == "O" && b5.getText() == "O" && b8.getText() == "O") {
                JOptionPane.showMessageDialog(null, "Player O Won!");
                win = true;
                b_win1 = b2;
                b_win2 = b5;
                b_win3 = b8;
            } else if (num == 9) {
                JOptionPane.showMessageDialog(null, "It's a tie!");
                tie = true;
            }
        }
        if (win) {
            b_recommencer.setEnabled(true);
            i_recommencer.setEnabled(true);
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b_win1.setBackground(Color.YELLOW);
            b_win2.setBackground(Color.YELLOW);
            b_win3.setBackground(Color.YELLOW);
            num = 0;
            win = false;
        } else if (tie) {
            b_recommencer.setEnabled(true);
            i_recommencer.setEnabled(true);
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            num = 0;
            tie = false;
        }
        // Reset, Recommencer and Quitter buttons
        if (e.getSource() == b_reset || e.getSource() == b_recommencer || e.getSource() == i_reset
                || e.getSource() == i_recommencer) {
            radioButton_X.setSelected(true);
            b_recommencer.setEnabled(false);
            i_recommencer.setEnabled(false);
            radioButton_X.setEnabled(true);
            radioButton_Y.setEnabled(true);
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);
            b_win1.setBackground(Color.DARK_GRAY);
            b_win2.setBackground(Color.DARK_GRAY);
            b_win3.setBackground(Color.DARK_GRAY);
            num = 0;
        } else if (e.getSource() == b_quitter || e.getSource() == i_Quitter) {
            this.setVisible(false);
            this.dispose();
        }
    }
}