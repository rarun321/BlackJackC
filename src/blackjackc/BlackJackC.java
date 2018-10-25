 package blackjackc;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BlackJackC implements ActionListener {

    JLabel p1Name = new JLabel();
    JButton Hit = new JButton("Hit");
    JButton Stay = new JButton("Stay");
    JLabel nameLabel = new JLabel("Name:");
    JTextField name = new JTextField(20);
    String name2 = "";
    JButton connect = new JButton("Connect");
    JButton reset = new JButton("Reset");
    JLabel ipLabel = new JLabel("IP:");
    JTextField ip = new JTextField(20);
    JFrame loginFrame = new JFrame();
    Client client;
    Client client2;
    Client client3;
    Client client4;
    Client client5;
    Client client6;
    String IPA = "192.168.1.144";
    JLabel card1;
    JLabel card2;
    JLayeredPane player2;
    JLayeredPane player3;
    JLayeredPane player4;
    JLayeredPane serverPane;
    ArrayList<Cards> cardsArray = new ArrayList<Cards>();
    int chipCount1 = 0;
    int chipCount5 = 0;
    int chipCount10 = 0;
    int chipCount25 = 0;
    int chipCount100 = 0;
    Thread t;
    JLabel chipLabel;
    int betCount = 0;
    JLabel chipnum1;
    JLabel chipnum5;
    JLabel chipnum10;
    JLabel chipnum25;
    JLabel chipnum100;
    JLabel tableMin;
    String tableCount;
    int chipTimes1 = 10;
    int chipTimes5 = 8;
    int chipTimes10 = 6;
    int chipTimes25 = 4;
    int chipTimes100 = 2;
    String x1;
    String x5;
    String x10;
    String x25;
    String x100;
    JButton bet;
    int count = 0;
    int Score = 0;
    int count2 = 0;
    int count4 = 0;
    boolean counter = false;
    int firstPlayer2;
    int secondPlayer2;
    int thirdPlayer2;
    boolean randomboo = false;
    boolean f = true;
    int firstBets = 0;
    int count3 = 0;
    int count10 =0;

    public static void main(String[] args) throws IOException {
        new BlackJackC();

    }

    public BlackJackC() throws IOException {

        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = (JPanel) loginFrame.getContentPane();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel panel2 = new JPanel();
        connect.addActionListener(this);
        panel2.add(nameLabel);
        panel2.add(name);
        panel2.add(connect);
        panel.add(panel2);
        loginFrame.pack();
        loginFrame.setVisible(true);
    }

    public void GameBoard() throws IOException {

        player2 = new JLayeredPane();
        player3 = new JLayeredPane();
        player4 = new JLayeredPane();
        serverPane = new JLayeredPane();
        Cards acespades = new Cards(11, ImageIO.read(new File("ASpades.png")));
        Cards spades2 = new Cards(2, ImageIO.read(new File("2Spades.png")));
        Cards spades3 = new Cards(3, ImageIO.read(new File("3Spades.png")));
        Cards spades4 = new Cards(4, ImageIO.read(new File("4Spades.png")));
        Cards spades5 = new Cards(5, ImageIO.read(new File("5Spades.png")));
        Cards spades6 = new Cards(6, ImageIO.read(new File("6Spades.png")));
        Cards spades7 = new Cards(7, ImageIO.read(new File("7Spades.png")));
        Cards spades8 = new Cards(8, ImageIO.read(new File("8Spades.png")));
        Cards spades9 = new Cards(9, ImageIO.read(new File("9Spades.png")));
        Cards spades10 = new Cards(10, ImageIO.read(new File("10Spades.png")));
        Cards spadesJ = new Cards(10, ImageIO.read(new File("JSpades.png")));
        Cards spadesQ = new Cards(10, ImageIO.read(new File("QSpades.png")));
        Cards spadesK = new Cards(10, ImageIO.read(new File("KSpades.png")));
        Cards acehearts = new Cards(11, ImageIO.read(new File("AHearts.png")));
        Cards hearts2 = new Cards(2, ImageIO.read(new File("2Hearts.png")));
        Cards hearts3 = new Cards(3, ImageIO.read(new File("3Hearts.png")));
        Cards hearts4 = new Cards(4, ImageIO.read(new File("4Hearts.png")));
        Cards hearts5 = new Cards(5, ImageIO.read(new File("5Hearts.png")));
        Cards hearts6 = new Cards(6, ImageIO.read(new File("6Hearts.png")));
        Cards hearts7 = new Cards(7, ImageIO.read(new File("7Hearts.png")));
        Cards hearts8 = new Cards(8, ImageIO.read(new File("8Hearts.png")));
        Cards hearts9 = new Cards(9, ImageIO.read(new File("9Hearts.png")));
        Cards hearts10 = new Cards(10, ImageIO.read(new File("10Hearts.png")));
        Cards heartsJ = new Cards(10, ImageIO.read(new File("JHearts.png")));
        Cards heartsQ = new Cards(10, ImageIO.read(new File("QHearts.png")));
        Cards heartsK = new Cards(10, ImageIO.read(new File("KHearts.png")));
        Cards aceclubs = new Cards(11, ImageIO.read(new File("AClubs.png")));
        Cards clubs2 = new Cards(2, ImageIO.read(new File("2Clubs.png")));
        Cards clubs3 = new Cards(3, ImageIO.read(new File("3Clubs.png")));
        Cards clubs4 = new Cards(4, ImageIO.read(new File("4Clubs.png")));
        Cards clubs5 = new Cards(5, ImageIO.read(new File("5Clubs.png")));
        Cards clubs6 = new Cards(6, ImageIO.read(new File("6Clubs.png")));
        Cards clubs7 = new Cards(7, ImageIO.read(new File("7Clubs.png")));
        Cards clubs8 = new Cards(8, ImageIO.read(new File("8Clubs.png")));
        Cards clubs9 = new Cards(9, ImageIO.read(new File("9Clubs.png")));
        Cards clubs10 = new Cards(10, ImageIO.read(new File("10Clubs.png")));
        Cards clubsJ = new Cards(10, ImageIO.read(new File("JClubs.png")));
        Cards clubsQ = new Cards(10, ImageIO.read(new File("QClubs.png")));
        Cards clubsK = new Cards(10, ImageIO.read(new File("KClubs.png")));
        Cards acediamonds = new Cards(11, ImageIO.read(new File("ASpades.png")));
        Cards diamonds2 = new Cards(2, ImageIO.read(new File("2Diamonds.png")));
        Cards diamonds3 = new Cards(3, ImageIO.read(new File("3Diamonds.png")));
        Cards diamonds4 = new Cards(4, ImageIO.read(new File("4Diamonds.png")));
        Cards diamonds5 = new Cards(5, ImageIO.read(new File("5Diamonds.png")));
        Cards diamonds6 = new Cards(6, ImageIO.read(new File("6Diamonds.png")));
        Cards diamonds7 = new Cards(7, ImageIO.read(new File("7Diamonds.png")));
        Cards diamonds8 = new Cards(8, ImageIO.read(new File("8Diamonds.png")));
        Cards diamonds9 = new Cards(9, ImageIO.read(new File("9Diamonds.png")));
        Cards diamonds10 = new Cards(10, ImageIO.read(new File("10Diamonds.png")));
        Cards diamondsJ = new Cards(10, ImageIO.read(new File("JDiamonds.png")));
        Cards diamondsQ = new Cards(10, ImageIO.read(new File("QDiamonds.png")));
        Cards diamondsK = new Cards(10, ImageIO.read(new File("KDiamonds.png")));
        Cards chip1 = new Cards(1, ImageIO.read(new File("Chip1.png")));
        Cards chip5 = new Cards(5, ImageIO.read(new File("Chip5.png")));
        Cards chip10 = new Cards(10, ImageIO.read(new File("Chip10.png")));
        Cards chip25 = new Cards(25, ImageIO.read(new File("Chip25.png")));
        Cards chip100 = new Cards(100, ImageIO.read(new File("Chip100.png")));

        cardsArray.add(acespades);
        cardsArray.add(spades2);
        cardsArray.add(spades3);
        cardsArray.add(spades4);
        cardsArray.add(spades5);
        cardsArray.add(spades6);
        cardsArray.add(spades7);
        cardsArray.add(spades8);
        cardsArray.add(spades9);
        cardsArray.add(spades10);
        cardsArray.add(spadesJ);
        cardsArray.add(spadesQ);
        cardsArray.add(spadesK);
        cardsArray.add(acehearts);
        cardsArray.add(hearts2);
        cardsArray.add(hearts3);
        cardsArray.add(hearts4);
        cardsArray.add(hearts5);
        cardsArray.add(hearts6);
        cardsArray.add(hearts7);
        cardsArray.add(hearts8);
        cardsArray.add(hearts9);
        cardsArray.add(hearts10);
        cardsArray.add(heartsJ);
        cardsArray.add(heartsQ);
        cardsArray.add(heartsK);
        cardsArray.add(aceclubs);
        cardsArray.add(clubs2);
        cardsArray.add(clubs3);
        cardsArray.add(clubs4);
        cardsArray.add(clubs5);
        cardsArray.add(clubs6);
        cardsArray.add(clubs7);
        cardsArray.add(clubs8);
        cardsArray.add(clubs9);
        cardsArray.add(clubs10);
        cardsArray.add(clubsJ);
        cardsArray.add(clubsQ);
        cardsArray.add(clubsK);
        cardsArray.add(acediamonds);
        cardsArray.add(diamonds2);
        cardsArray.add(diamonds3);
        cardsArray.add(diamonds4);
        cardsArray.add(diamonds5);
        cardsArray.add(diamonds6);
        cardsArray.add(diamonds7);
        cardsArray.add(diamonds8);
        cardsArray.add(diamonds9);
        cardsArray.add(diamonds10);
        cardsArray.add(diamondsJ);
        cardsArray.add(diamondsQ);
        cardsArray.add(diamondsK);

        JFrame blackJack = new JFrame();
        blackJack.getContentPane().setBackground(Color.GREEN.darker());
        blackJack.getContentPane().add(player2);
        blackJack.getContentPane().add(player3);
        blackJack.getContentPane().add(player4);
        blackJack.getContentPane().add(serverPane);
        blackJack.setSize(1800, 1000);
        blackJack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        blackJack.setLayout(new GridLayout(0, 4, 10, 0));
        blackJack.setVisible(true);

        serverPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        JLabel dealer = new JLabel("Dealer");
        dealer.setBounds(175, 0, 50, 50);
        dealer.setFont(new Font("Impact", Font.PLAIN, 15));
        serverPane.add(dealer);
        blackJack.add(serverPane);

        p1Name.setText(name.getText());
        p1Name.setFont(new Font("Impact", Font.PLAIN, 25));
        p1Name.setBounds(170, 0, 100, 75);
        Hit.setBounds(120, 790, 150, 30);
        Hit.addActionListener(this);
        Stay.setBounds(120, 830, 150, 30);
        Stay.addActionListener(this);
        player2.add(Hit);
        player2.add(Stay);
        player2.add(p1Name);
        player2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        blackJack.add(player2);

        player3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        blackJack.add(player3);

        player4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        JLabel label = new JLabel(new ImageIcon(chip1.getCardImage()));
        JLabel label5 = new JLabel(new ImageIcon(chip5.getCardImage()));
        JLabel label10 = new JLabel(new ImageIcon(chip10.getCardImage()));
        JLabel label25 = new JLabel(new ImageIcon(chip25.getCardImage()));
        JLabel label100 = new JLabel(new ImageIcon(chip100.getCardImage()));

        label.setBounds(125, 25, 150, 150);
        label5.setBounds(125, 150, 150, 150);
        label10.setBounds(125, 275, 150, 150);
        label25.setBounds(125, 400, 150, 150);
        label100.setBounds(125, 525, 150, 150);

        x1 = String.valueOf(chipTimes1);
        chipnum1 = new JLabel("x" + x1);
        chipnum1.setBounds(275, 25, 150, 150);
        chipnum1.setFont(new Font("Impact", Font.PLAIN, 50));

        x5 = String.valueOf(chipTimes5);
        chipnum5 = new JLabel("x" + x5);
        chipnum5.setBounds(275, 150, 150, 150);
        chipnum5.setFont(new Font("Impact", Font.PLAIN, 50));

        x10 = String.valueOf(chipTimes10);
        chipnum10 = new JLabel("x" + x10);
        chipnum10.setBounds(275, 275, 150, 150);
        chipnum10.setFont(new Font("Impact", Font.PLAIN, 50));

        x25 = String.valueOf(chipTimes25);
        chipnum25 = new JLabel("x" + x25);
        chipnum25.setBounds(275, 400, 150, 150);
        chipnum25.setFont(new Font("Impact", Font.PLAIN, 50));

        x100 = String.valueOf(chipTimes100);
        chipnum100 = new JLabel("x" + x100);
        chipnum100.setBounds(275, 525, 150, 150);
        chipnum100.setFont(new Font("Impact", Font.PLAIN, 50));

        String ab = String.valueOf(betCount);
        chipLabel = new JLabel("Your Bet: " + ab);
        chipLabel.setFont(new Font("Impact", Font.PLAIN, 20));
        chipLabel.setBounds(125, 670, 200, 200);

        bet = new JButton("Bet");
        bet.setBounds(120, 830, 150, 30);
        bet.addActionListener(this);

        player4.add(bet);
        player4.add(chipLabel);
        player4.add(chipnum1);
        player4.add(chipnum5);
        player4.add(chipnum10);
        player4.add(chipnum25);
        player4.add(chipnum100);
        player4.add(label);
        player4.add(label5);
        player4.add(label10);
        player4.add(label25);
        player4.add(label100);

        blackJack.add(player4);

        MouseListener ml1 = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && betCount > 0) {

                    chipTimes1++;
                    x1 = String.valueOf(chipTimes1);
                    chipnum1.setText("x" + x1);

                    betCount = betCount - 1;
                    chipLabel.setFont(new Font("Impact", Font.PLAIN, 20));
                    String count = String.valueOf(betCount);
                    chipLabel.setText("Your Bet: " + count);

                } else if ((chipTimes1 > 0)) {
                    chipTimes1--;
                    x1 = String.valueOf(chipTimes1);
                    chipnum1.setText("x" + x1);

                    betCount = betCount + 1;
                    chipLabel.setFont(new Font("Impact", Font.PLAIN, 20));
                    String count = String.valueOf(betCount);
                    chipLabel.setText("Your Bet: " + count);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        MouseListener ml5 = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && betCount > 0) {

                    chipTimes5++;
                    x5 = String.valueOf(chipTimes5);
                    chipnum100.setText("x" + x5);

                    betCount = betCount - 5;
                    chipLabel.setFont(new Font("Impact", Font.PLAIN, 20));
                    String count = String.valueOf(betCount);
                    chipLabel.setText("Your Bet: " + count);

                } else if ((chipTimes5 > 0)) {
                    chipTimes5--;
                    x5 = String.valueOf(chipTimes5);
                    chipnum5.setText("x" + x5);

                    betCount = betCount + 5;
                    chipLabel.setFont(new Font("Impact", Font.PLAIN, 20));
                    String count = String.valueOf(betCount);
                    chipLabel.setText("Your Bet: " + count);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        MouseListener ml10 = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && betCount > 0) {

                    chipTimes10++;
                    x10 = String.valueOf(chipTimes10);
                    chipnum10.setText("x" + x10);

                    betCount = betCount - 10;
                    chipLabel.setFont(new Font("Impact", Font.PLAIN, 20));
                    String count = String.valueOf(betCount);
                    chipLabel.setText("Your Bet: " + count);

                } else if ((chipTimes10 > 0)) {
                    chipTimes10--;
                    x10 = String.valueOf(chipTimes10);
                    chipnum10.setText("x" + x10);

                    betCount = betCount + 10;
                    chipLabel.setFont(new Font("Impact", Font.PLAIN, 20));
                    String count = String.valueOf(betCount);
                    chipLabel.setText("Your Bet: " + count);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        MouseListener ml25 = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && betCount > 0) {

                    chipTimes25++;
                    x25 = String.valueOf(chipTimes25);
                    chipnum25.setText("x" + x25);

                    betCount = betCount - 25;
                    chipLabel.setFont(new Font("Impact", Font.PLAIN, 20));
                    String count = String.valueOf(betCount);
                    chipLabel.setText("Your Bet: " + count);

                } else if ((chipTimes25 > 0)) {
                    chipTimes25--;
                    x25 = String.valueOf(chipTimes25);
                    chipnum25.setText("x" + x25);

                    betCount = betCount + 25;
                    chipLabel.setFont(new Font("Impact", Font.PLAIN, 20));
                    String count = String.valueOf(betCount);
                    chipLabel.setText("Your Bet: " + count);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        MouseListener ml100 = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && betCount > 0) {

                    chipTimes100++;
                    x100 = String.valueOf(chipTimes100);
                    chipnum100.setText("x" + x100);

                    betCount = betCount - 100;
                    chipLabel.setFont(new Font("Impact", Font.PLAIN, 20));
                    String count = String.valueOf(betCount);
                    chipLabel.setText("Your Bet: " + count);

                } else if ((chipTimes100 > 0)) {
                    chipTimes100--;
                    x100 = String.valueOf(chipTimes100);
                    chipnum100.setText("x" + x100);

                    betCount = betCount + 100;
                    chipLabel.setFont(new Font("Impact", Font.PLAIN, 20));
                    String count = String.valueOf(betCount);
                    chipLabel.setText("Your Bet: " + count);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        label.addMouseListener(ml1);
        label5.addMouseListener(ml5);
        label10.addMouseListener(ml10);
        label25.addMouseListener(ml25);
        label100.addMouseListener(ml100);

        chipLabel.setTransferHandler(new TransferHandler("icon"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object control = ((JButton) e.getSource()).getText();

        if (control == "Connect") {
            try {

                GameBoard();

                client = new Client(IPA, 5555);
                client2 = new Client(IPA, 5555);
                client3 = new Client(IPA, 5555);
                client4 = new Client(IPA, 5555);
                client5 = new Client(IPA, 5555);
                client6 = new Client(IPA, 5555);

                client.recieveTableMin();
                tableMin = new JLabel("Table Minimum: " + Client.tableMin);
                tableMin.setBounds(120, 750, 300, 100);
                tableMin.setFont(new Font("Impact", Font.PLAIN, 20));
                player4.add(tableMin);

                client.recivefirstCard();
                card1 = new JLabel(new ImageIcon(cardsArray.get(Client.Card1).getCardImage()));
                card1.setBounds(100, 50, 200, 250);
                player3.add(card1, new Integer(1));

                client.firstCard();

                client.serverCard1();
                card1 = new JLabel(new ImageIcon(cardsArray.get(Client.serverCard1).getCardImage()));
                card1.setBounds(100, 50, 200, 250);
                serverPane.add(card1, new Integer(1));

                client.recivesecondCard();
                card1 = new JLabel(new ImageIcon(cardsArray.get(Client.Card2).getCardImage()));
                card1.setBounds(100, 120, 200, 250);
                player3.add(card1, new Integer(2));

                client.secondCard();

                client.serverCard2();
                card1 = new JLabel(new ImageIcon(cardsArray.get(Client.serverCard2).getCardImage()));
                card1.setBounds(100, 120, 200, 250);
                serverPane.add(card1, new Integer(2));

                client.sendNames(name.getText());
                client.catchName();
                JLabel otherName = new JLabel();
                otherName.setText(Client.otherPlayersName);
                otherName.setFont(new Font("Impact", Font.PLAIN, 25));
                otherName.setBounds(170, 0, 100, 75);
                player3.add(otherName);

                t = new Thread() {
                    Cards faceDown = new Cards(0, ImageIO.read(new File("FaceDown.png")));

                    public void run() {
                        try {

                            while (client.reciveCard()) {

                                switch (count2) {
                                    case 0:
                                        firstPlayer2 = Client.gg;
                                        if (count != 1 && randomboo == false) {
                                            JLabel face = new JLabel(new ImageIcon(faceDown.getCardImage()));
                                            face.setBounds(100, 190, 200, 250);
                                            player3.add(face, new Integer(3));
                                            count2 = 1;

                                        } else if (count == 1 || randomboo) {
                                            card1 = new JLabel(new ImageIcon(cardsArray.get(Client.gg).getCardImage()));
                                            card1.setBounds(100, 190, 200, 250);
                                            player3.add(card1, new Integer(3));
                                            count2 = 1;
                                        }

                                        if (count == 1 && randomboo ==false) {
                                            Hit.setEnabled(false);
                                            bet.setEnabled(true);
                                            Stay.setEnabled(true);
                                        }
                                        if (count4 == 1) {
                                            Stay.setEnabled(false);
                                        }

                                        break;
                                    case 1:
                                        secondPlayer2 = Client.gg;
                                        if (count != 2 && randomboo == false) {
                                            JLabel face = new JLabel(new ImageIcon(faceDown.getCardImage()));
                                            face.setBounds(100, 260, 200, 250);
                                            player3.add(face, new Integer(4));
                                            count2 = 2;
                                        } else if (count == 2 || randomboo) {
                                            card1 = new JLabel(new ImageIcon(cardsArray.get(Client.gg).getCardImage()));
                                            card1.setBounds(100, 260, 200, 250);
                                            player3.add(card1, new Integer(4));
                                            count2 = 2;
                                        }

                                        if (count == 2 && randomboo ==false) {
                                            Hit.setEnabled(false);
                                            bet.setEnabled(true);
                                            Stay.setEnabled(true);
                                        }
                                        if (count4 == 1) {
                                            Stay.setEnabled(false);
                                        }

                                        break;
                                    case 2:
                                        thirdPlayer2 = Client.gg;
                                        if (count != 3 && randomboo == false) {
                                            JLabel face = new JLabel(new ImageIcon(faceDown.getCardImage()));
                                            face.setBounds(100, 330, 200, 250);
                                            player3.add(face, new Integer(5));
                                            count2 = 3;

                                        } else if (count == 3 || randomboo) {
                                            card1 = new JLabel(new ImageIcon(cardsArray.get(Client.gg).getCardImage()));
                                            card1.setBounds(100, 330, 200, 250);
                                            player3.add(card1, new Integer(5));
                                            count2 = 3;
                                        }

                                        if (count == 3 && randomboo ==false) {
                                            Hit.setEnabled(false);
                                            bet.setEnabled(true);
                                            Stay.setEnabled(true);
                                        }
                                        if (count4 == 1) {
                                            Stay.setEnabled(false);
                                        }

                                        break;
                                    default:
                                        break;
                                }

                            }

                        } catch (IOException ex) {
                            Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };

                t.start();

                Thread t3 = new Thread() {

                    public void run() {
                        try {

                            while (client2.recieveBets()) {
                                if (Client.betBack > 0) {
                                    System.out.println(Client.betBack);
                                    JOptionPane.showMessageDialog(null, "You win " + Client.betBack);
                                    break;
                                }

                            }
                            int total = Client.betBack;
                            while (f) {
                                if (total >= 100 && total > 0) {
                                    chipTimes100++;
                                    String x100 = String.valueOf(chipTimes100);
                                    chipnum100.setText("x" + x100);
                                    total = total - 100;

                                } else if (total >= 25 && total > 0) {
                                    chipTimes25++;
                                    String x25 = String.valueOf(chipTimes25);
                                    chipnum25.setText("x" + x25);
                                    chipCount25++;
                                    total = total - 25;
                                } else if (total >= 10 && total > 0) {
                                    chipTimes10++;
                                    String x10 = String.valueOf(chipTimes10);
                                    chipnum10.setText("x" + x10);
                                    chipCount10++;
                                    total = total - 10;
                                } else if (total >= 5 && total > 0) {
                                    chipTimes5++;
                                    String x5 = String.valueOf(chipTimes5);
                                    chipnum5.setText("x" + x5);
                                    chipCount5++;
                                    total = total - 5;
                                } else if (total >= 1 && total > 0) {
                                    chipTimes1++;
                                    String x1 = String.valueOf(chipTimes1);
                                    chipnum1.setText("x" + x1);
                                    chipCount1++;
                                    total = total - 1;
                                } else if (total == 0) {
                                    System.out.println("Its Zero");
                                    f = false;
                                    break;

                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                t3.start();

                Thread t4 = new Thread() {

                    public void run() {
                        try {
                            while (client3.catchDealerCards()) {
                                switch (count3) {
                                    case 0:
                                        card1 = new JLabel(new ImageIcon(cardsArray.get(Client.dealerCards).getCardImage()));
                                        card1.setBounds(100, 190, 200, 250);
                                        serverPane.add(card1, new Integer(3));
                                        count3 = 1;
                                        break;
                                    case 1:
                                        card1 = new JLabel(new ImageIcon(cardsArray.get(Client.dealerCards).getCardImage()));
                                        card1.setBounds(100, 260, 200, 250);
                                        serverPane.add(card1, new Integer(4));
                                        count3 = 2;
                                        break;
                                    case 2:
                                        card1 = new JLabel(new ImageIcon(cardsArray.get(Client.dealerCards).getCardImage()));
                                        card1.setBounds(100, 330, 200, 250);
                                        serverPane.add(card1, new Integer(5));
                                        count3 = 3;
                                        break;
                                    default:
                                        break;
                                }
                                serverPane.repaint();
                                serverPane.revalidate();

                            }

                        } catch (IOException ex) {
                            Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                };
                t4.start();

                Thread t5 = new Thread() {

                    public void run() {
                        try {
                            while (client4.stayCommand()) {
                                if (Client.stayCommand.equals("Stay")) {
                                    System.out.println(Client.stayCommand);
                                    JOptionPane.showMessageDialog(null, Client.otherPlayersName + " Chooses To Stay!");
                                    player3.setEnabled(false);
                                    Stay.setEnabled(true);
                                    bet.setEnabled(true);
                                    count10=1;
                                    t.stop();
                                    break;
                                    

                                }
                                else if (Client.stayCommand.equals("Wins")) {
                                    System.out.println(Client.stayCommand);
                                    JOptionPane.showMessageDialog(null, Client.otherPlayersName +" Wins");
                                    player3.setEnabled(false);
                                    t.stop();
                                    break;

                                }

                            }

                        } catch (IOException ex) {
                            Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                };
                t5.start();
                Thread t6 = new Thread() {

                    public void run() {
                        try {
                            while (client5.dealerCommand()) {
                                if (Client.dealerCommand.equals("DealerBust")) {
                                    JOptionPane.showMessageDialog(null, "Dealer Bust");
                                    serverPane.setEnabled(false);
                                    t4.stop();
                                    break;

                                } else if (Client.dealerCommand.equals("DealerStay")) {
                                    JOptionPane.showMessageDialog(null, "Dealer Decides To Stay");
                                    t4.stop();
                                    break;
                                }
                                player2.repaint();
                                player2.revalidate();
                                player3.repaint();
                                player3.revalidate();

                            }

                        } catch (IOException ex) {
                            Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                };
                t6.start();
                Thread t7 = new Thread() {

                    public void run() {
                        try {
                            while (client6.dealerWins()) {
                                if (Client.dealerWins.equals("DealerWins")) {
                                    JOptionPane.showMessageDialog(null, "Dealer Wins");
                                    serverPane.setEnabled(false);
                                    player2.repaint();
                                    player2.revalidate();
                                    player3.repaint();
                                    player3.revalidate();
                                    break;

                                }

                            }

                        } catch (IOException ex) {
                            Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                };
                t7.start();

                loginFrame.dispose();

                Stay.setEnabled(false);
                Hit.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Bet to recieve Cards");

            } catch (IOException ex) {
                Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (control == "Bet") {

            if (firstBets == 0 && betCount > Client.tableMin) {
                try {
                    card1 = new JLabel(new ImageIcon(cardsArray.get(Client.firstCard).getCardImage()));
                    card1.setBounds(100, 50, 200, 250);
                    Score = Score + cardsArray.get(Client.firstCard).getScore();
                    player2.add(card1, new Integer(1));

                    card1 = new JLabel(new ImageIcon(cardsArray.get(Client.secondCard).getCardImage()));
                    card1.setBounds(100, 120, 200, 250);
                    Score = Score + cardsArray.get(Client.secondCard).getScore();
                    player2.add(card1, new Integer(2));

                    System.out.println(Score);

                    Client clientBet = new Client(IPA, 5555);
                    String sendbetcount = String.valueOf(betCount);
                    clientBet.sendBet(sendbetcount);

                    chipLabel.setText("Your Bet: " + "0");
                    betCount = 0;
                    firstBets = 1;

                    Stay.setEnabled(true);
                    bet.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (firstBets == 0 && betCount < Client.tableMin) {
                JOptionPane.showMessageDialog(null, "Please Place more that the the table min");
            } else {
                try {

                    if (betCount > Client.tableMin) {
                        Client clientBet = new Client(IPA, 5555);
                        String sendbetcount = String.valueOf(betCount);
                        clientBet.sendBet(sendbetcount);
                        System.out.println("aklsdjlajalkjds");
                        clientBet.close();
                        chipLabel.setText("Your Bet: " + "0");
                        betCount = 0;
                        Hit.setEnabled(true);
                        Stay.setEnabled(false);
                        bet.setEnabled(false);
                    } else {

                        JOptionPane.showMessageDialog(null, "Please bet the Table Minimum or More");
                    }

                } catch (IOException ex) {
                    Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

        if (control == "Stay") {
            count4 = 1;
            Hit.setEnabled(false);
            try {
                Client stayConnection = new Client(IPA, 5555);
                String sendScore = String.valueOf(Score);
                stayConnection.stay("Stay");
                stayConnection.sendScore(sendScore);
                Hit.setEnabled(false);
                bet.setEnabled(false);
                Stay.setEnabled(false);
                randomboo = true;
                if (count2 == 1) {
                    card1 = new JLabel(new ImageIcon(cardsArray.get(firstPlayer2).getCardImage()));
                    card1.setBounds(100, 190, 200, 250);
                    player3.add(card1, new Integer(4));

                }
                if (count2 == 2) {
                    card1 = new JLabel(new ImageIcon(cardsArray.get(secondPlayer2).getCardImage()));
                    card1.setBounds(100, 260, 200, 250);
                    player3.add(card1, new Integer(5));

                }
                if (count2 == 3) {
                    card1 = new JLabel(new ImageIcon(cardsArray.get(thirdPlayer2).getCardImage()));
                    card1.setBounds(100, 330, 200, 250);
                    player3.add(card1, new Integer(6));
                }

            } catch (IOException ex) {
                Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (control == "Hit" && count == 0) {
            try {

                Client clientConnection = new Client(IPA, 5555);
                clientConnection.thirdCard("Hit");
                clientConnection.close();

            } catch (IOException ex) {
                Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
            }

            card1 = new JLabel(new ImageIcon(cardsArray.get(Client.thirdCard).getCardImage()));
            card1.setBounds(100, 190, 200, 250);
            Score = Score + cardsArray.get(Client.thirdCard).getScore();
            player2.add(card1, new Integer(3));
            count = 1;
            if (count2 == 1 && randomboo == false) {
                card1 = new JLabel(new ImageIcon(cardsArray.get(firstPlayer2).getCardImage()));
                card1.setBounds(100, 190, 200, 250);
                player3.add(card1, new Integer(4));
                count2 = 1;
            }

            if (count == 1) {
                Hit.setEnabled(false);
                Stay.setEnabled(true);
                bet.setEnabled(false);
            }
            if (count2 == 1) {
                bet.setEnabled(true);
                Stay.setEnabled(true);

            }
            if(count10 ==1){
                Hit.setEnabled(false);
                Stay.setEnabled(true);
                bet.setEnabled(true);
            }
            if (Score > 21) {
                try {
                    Client clientConnection = new Client(IPA, 5555);
                    clientConnection.stay("Bust");
                    clientConnection.close();
                    JOptionPane.showMessageDialog(null, "Bust");
                    Hit.setEnabled(false);
                    Stay.setEnabled(false);
                    bet.setEnabled(false);

                } catch (IOException ex) {
                    Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (control == "Hit" && count == 1) {
            try {

                Client clientConnection = new Client(IPA, 5555);
                clientConnection.fourthCard("Hit");
                clientConnection.close();

                Hit.setEnabled(false);

            } catch (IOException ex) {
                Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
            }

            card1 = new JLabel(new ImageIcon(cardsArray.get(Client.fourthCard).getCardImage()));
            Score = Score + cardsArray.get(Client.fourthCard).getScore();
            card1.setBounds(100, 260, 200, 250);
            player2.add(card1, new Integer(4));
            count = 2;
            if (count2 == 2 && randomboo == false) {
                card1 = new JLabel(new ImageIcon(cardsArray.get(secondPlayer2).getCardImage()));
                card1.setBounds(100, 260, 200, 250);
                player3.add(card1, new Integer(5));
                count2 = 2;

            }
            card1 = new JLabel(new ImageIcon(cardsArray.get(Client.gg).getCardImage()));
            card1.setBounds(100, 260, 200, 250);
            player3.add(card1, new Integer(5));
            count2 = 1;

            if (Score > 21) {
                try {
                    Client clientConnection = new Client(IPA, 5555);
                    clientConnection.stay("Bust");
                    clientConnection.close();
                    JOptionPane.showMessageDialog(null, "Bust");
                    Hit.setEnabled(false);
                    Stay.setEnabled(false);
                    bet.setEnabled(false);

                } catch (IOException ex) {
                    Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (count == 2) {
                Hit.setEnabled(false);
                Stay.setEnabled(true);
                bet.setEnabled(false);
            }
            if (count2 == 2 && count == 2) {
                bet.setEnabled(true);
                Stay.setEnabled(true);
            }
            if(count10 ==1){
                Hit.setEnabled(false);
                Stay.setEnabled(true);
                bet.setEnabled(true);
            }

        } else if (control == "Hit" && count == 2) {
            try {
                Client clientConnection = new Client(IPA, 5555);
                clientConnection.fifthCard("Hit");
                clientConnection.close();

                Hit.setEnabled(false);

            } catch (IOException ex) {
                Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (count2 == 3 && randomboo == false) {
                card1 = new JLabel(new ImageIcon(cardsArray.get(thirdPlayer2).getCardImage()));
                card1.setBounds(100, 330, 200, 250);
                player3.add(card1, new Integer(6));
                count2 = 2;

            }

            card1 = new JLabel(new ImageIcon(cardsArray.get(Client.fifthCard).getCardImage()));
            card1.setBounds(100, 330, 200, 250);
            player2.add(card1, new Integer(5));
            Score = Score + cardsArray.get(Client.fifthCard).getScore();
            count = 3;

            if (Score > 21) {
                try {
                    Client clientConnection = new Client(IPA, 5555);
                    clientConnection.stay("Bust");
                    clientConnection.close();
                    JOptionPane.showMessageDialog(null, "Bust");
                    Hit.setEnabled(false);
                    Stay.setEnabled(false);
                    bet.setEnabled(false);

                } catch (IOException ex) {
                    Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (count == 3) {
                Hit.setEnabled(false);
                Stay.setEnabled(true);
                bet.setEnabled(false);
            }
            if (count2 == 3) {
                bet.setEnabled(true);
                Stay.setEnabled(true);
            }
            if(count10 ==1){
                Hit.setEnabled(false);
                Stay.setEnabled(true);
                bet.setEnabled(true);
            }

        }

        player2.repaint();
        player2.revalidate();
        player3.repaint();
        player3.revalidate();

    }
}
