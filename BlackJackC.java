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
    String IPA = "10.168.237.119";
    JLabel card1;
    JLabel card2;
    JLayeredPane player2;
    JLayeredPane player3;
    JLayeredPane serverPane;
    boolean boo = false;
    ArrayList<Cards> cardsArray = new ArrayList<Cards>();
    boolean pressed = false;
    int count = 0;

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
        serverPane = new JLayeredPane();
        Cards acespades = new Cards(1, ImageIO.read(new File("ASpades.png")));
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
        Cards acehearts = new Cards(1, ImageIO.read(new File("AHearts.png")));
        Cards hearts2 = new Cards(2, ImageIO.read(new File("2Hearts.png")));
        Cards hearts3 = new Cards(3, ImageIO.read(new File("3Hearts.png")));
        Cards hearts4 = new Cards(4, ImageIO.read(new File("4Hearts.png")));
        Cards hearts5 = new Cards(5, ImageIO.read(new File("5Hearts.png")));
        Cards hearts6 = new Cards(6, ImageIO.read(new File("6Hearts.png")));
        Cards hearts7 = new Cards(7, ImageIO.read(new File("7Hearts.png")));
        Cards hearts8 = new Cards(8, ImageIO.read(new File("8Hearts.png")));
        Cards hearts9 = new Cards(9, ImageIO.read(new File("9Hearts.png")));
        Cards hearts10 = new Cards(10, ImageIO.read(new File("10Hearts.png")));
        Cards heartsJ = new Cards(1, ImageIO.read(new File("JHearts.png")));
        Cards heartsQ = new Cards(12, ImageIO.read(new File("QHearts.png")));
        Cards heartsK = new Cards(13, ImageIO.read(new File("KHearts.png")));
        Cards aceclubs = new Cards(1, ImageIO.read(new File("AClubs.png")));
        Cards clubs2 = new Cards(2, ImageIO.read(new File("2Clubs.png")));
        Cards clubs3 = new Cards(3, ImageIO.read(new File("3Clubs.png")));
        Cards clubs4 = new Cards(4, ImageIO.read(new File("4Clubs.png")));
        Cards clubs5 = new Cards(5, ImageIO.read(new File("5Clubs.png")));
        Cards clubs6 = new Cards(6, ImageIO.read(new File("6Clubs.png")));
        Cards clubs7 = new Cards(7, ImageIO.read(new File("7Clubs.png")));
        Cards clubs8 = new Cards(8, ImageIO.read(new File("8Clubs.png")));
        Cards clubs9 = new Cards(9, ImageIO.read(new File("9Clubs.png")));
        Cards clubs10 = new Cards(10, ImageIO.read(new File("10Clubs.png")));
        Cards clubsJ = new Cards(11, ImageIO.read(new File("JClubs.png")));
        Cards clubsQ = new Cards(12, ImageIO.read(new File("QClubs.png")));
        Cards clubsK = new Cards(13, ImageIO.read(new File("KClubs.png")));
        Cards acediamonds = new Cards(1, ImageIO.read(new File("ASpades.png")));
        Cards diamonds2 = new Cards(2, ImageIO.read(new File("2Diamonds.png")));
        Cards diamonds3 = new Cards(3, ImageIO.read(new File("3Diamonds.png")));
        Cards diamonds4 = new Cards(4, ImageIO.read(new File("4Diamonds.png")));
        Cards diamonds5 = new Cards(5, ImageIO.read(new File("5Diamonds.png")));
        Cards diamonds6 = new Cards(6, ImageIO.read(new File("6Diamonds.png")));
        Cards diamonds7 = new Cards(7, ImageIO.read(new File("7Diamonds.png")));
        Cards diamonds8 = new Cards(8, ImageIO.read(new File("8Diamonds.png")));
        Cards diamonds9 = new Cards(9, ImageIO.read(new File("9Diamonds.png")));
        Cards diamonds10 = new Cards(10, ImageIO.read(new File("10Diamonds.png")));
        Cards diamondsJ = new Cards(11, ImageIO.read(new File("JDiamonds.png")));
        Cards diamondsQ = new Cards(12, ImageIO.read(new File("QDiamonds.png")));
        Cards diamondsK = new Cards(13, ImageIO.read(new File("KDiamonds.png")));

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
        blackJack.getContentPane().add(player2);
        blackJack.getContentPane().add(player3);
        blackJack.getContentPane().add(serverPane);
        blackJack.setSize(1800, 1000);
        blackJack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        blackJack.setLayout(new GridLayout(0, 4, 10, 0));
        blackJack.setVisible(true);

        serverPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
        blackJack.add(serverPane);

        p1Name.setBounds(170, -100, 200, 250);
        Hit.setBounds(120, 790, 150, 30);
        Hit.addActionListener(this);
        Stay.setBounds(120, 830, 150, 30);
        Stay.addActionListener(this);
        player2.add(Hit);
        player2.add(Stay);
        player2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
        blackJack.add(player2);

        player3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
        blackJack.add(player3);

        JPanel player4 = new JPanel();
        player4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
        blackJack.add(player4);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object control = ((JButton) ae.getSource()).getText();

        if (control == "Connect") {
            try {

                GameBoard();

                client = new Client(IPA, 5555);

                client.firstCard();
                card1 = new JLabel(new ImageIcon(cardsArray.get(Client.firstCard).getCardImage()));
                card1.setBounds(100, 50, 200, 250);
                player2.add(card1, new Integer(1));

                client.recivefirstCard();
                card1 = new JLabel(new ImageIcon(cardsArray.get(Client.Card1).getCardImage()));
                card1.setBounds(100, 50, 200, 250);
                player3.add(card1, new Integer(1));

                client.reciveServerCard1();
                card1 = new JLabel(new ImageIcon(cardsArray.get(Client.serverCard1).getCardImage()));
                card1.setBounds(100, 50, 200, 250);
                serverPane.add(card1, new Integer(1));

                client.secondCard();
                card1 = new JLabel(new ImageIcon(cardsArray.get(Client.secondCard).getCardImage()));
                card1.setBounds(100, 120, 200, 250);
                player2.add(card1, new Integer(2));

                client.recivesecondCard();
                card1 = new JLabel(new ImageIcon(cardsArray.get(Client.Card2).getCardImage()));
                card1.setBounds(100, 120, 200, 250);
                player3.add(card1, new Integer(2));

                client.reciveServerCard2();
                card1 = new JLabel(new ImageIcon(cardsArray.get(Client.serverCard2).getCardImage()));
                card1.setBounds(100, 120, 200, 250);
                serverPane.add(card1, new Integer(2));

                loginFrame.dispose();

            } catch (IOException ex) {
                Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (control == "Stay") {
            Hit.setEnabled(false);
            try {
                client.stay("Stay");
            } catch (IOException ex) {
                Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (control == "Hit" && count == 0) {
            try {
                client.Zero("Zero");
                client.thirdCard("Hit");

                while (boo == false) {
                    if (Client.gg > 0) {
                        break;
                    } else {
                        client.reciveCard("Send");
                    }
                }
                client.Reset("Reset");

            } catch (IOException ex) {
                Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
            }

            card1 = new JLabel(new ImageIcon(cardsArray.get(Client.thirdCard).getCardImage()));
            card1.setBounds(100, 190, 200, 250);
            player2.add(card1, new Integer(3));
            card1 = new JLabel(new ImageIcon(cardsArray.get(Client.gg).getCardImage()));
            card1.setBounds(100, 190, 200, 250);
            player3.add(card1, new Integer(3));

            count = 1;

        } else if (control == "Hit" && count == 1) {
            try {
                client.Zero("Zero");
                client.fourthCard("Hit");

                while (boo == false) {
                    if (Client.gg > 0) {
                        break;
                    } else {
                        client.reciveCard("Send");
                    }
                }
                client.Reset("Reset");

            } catch (IOException ex) {
                Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
            }

            card1 = new JLabel(new ImageIcon(cardsArray.get(Client.fourthCard).getCardImage()));
            card1.setBounds(100, 260, 200, 250);
            player2.add(card1, new Integer(4));
            card1 = new JLabel(new ImageIcon(cardsArray.get(Client.gg).getCardImage()));
            card1.setBounds(100, 260, 200, 250);
            player3.add(card1, new Integer(4));
            count = 2;

        } else if (control == "Hit" && count == 2) {
            try {
                client.Zero("Zero");
                client.fifthCard("Hit");
                while (boo == false) {
                    if (Client.gg > 0) {
                        break;
                    } else {
                        client.reciveCard("Send");
                    }
                }
                client.Reset("Reset");

            } catch (IOException ex) {
                Logger.getLogger(BlackJackC.class.getName()).log(Level.SEVERE, null, ex);
            }

            card1 = new JLabel(new ImageIcon(cardsArray.get(Client.fifthCard).getCardImage()));
            card1.setBounds(100, 330, 200, 250);
            player2.add(card1, new Integer(5));
            card1 = new JLabel(new ImageIcon(cardsArray.get(Client.gg).getCardImage()));
            card1.setBounds(100, 330, 200, 250);
            player3.add(card1, new Integer(5));
            count = 3;

        }
        player2.repaint();
        player2.revalidate();
        player3.repaint();
        player3.revalidate();

    }

}
