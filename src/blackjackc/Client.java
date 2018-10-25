package blackjackc;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private Socket socket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    String line = "";
    public static int firstCard = 0;
    public static int secondCard = 0;
    public static int gg = 0;
    public static int dealerCard = 0;
    public static int thirdCard = 0;
    public static int fourthCard = 0;
    public static int fifthCard = 0;
    public static int sixthCard = 0;
    public static int card = 0;
    public static int Card1 = 0;
    public static int Card2 = 0;
    public static int serverCard1 = 0;
    public static int serverCard2 = 0;
    public static int betBack = 0;
    public static int tableMin = 0;
    public static int dealerCards = 0;
    public static String stayCommand = "";
    public static String dealerCommand = "";
    public static String dealerWins = "";
    public static String otherPlayersName = "";
    public Client(String IP, int port) throws IOException {

        try {
            socket = new Socket(IP, port);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

    }

    public void close() throws IOException {
        socket.close();
    }

    public void stay(String key) throws IOException {
        String data = key;
        out.writeUTF(data);

    }

    public void DealerCard(String key) throws IOException {
        String data = key;
        out.writeUTF(data);
        int line;
        line = in.readInt();
        dealerCard = line;
    }

    public void firstCard() throws IOException {
        int line;
        line = in.readInt();
        firstCard = line;
    }

    public void secondCard() throws IOException {
        int line;
        line = in.readInt();
        secondCard = line;
    }

    public void recivefirstCard() throws IOException {
        int line;
        line = in.readInt();
        Card1 = line;
    }

    public void recivesecondCard() throws IOException {
        int line;
        line = in.readInt();
        Card2 = line;
    }

    public boolean reciveCard() throws IOException {
        int line;
        line = in.readInt();
        gg = line;
        return true;
    }

    public void serverCard1() throws IOException {
        int line;
        line = in.readInt();
        serverCard1 = line;
    }

    public void serverCard2() throws IOException {
        int line;
        line = in.readInt();
        serverCard2 = line;
    }

    public void thirdCard(String key) throws IOException {
        String data = key;
        out.writeUTF(data);
        int line;
        line = in.readInt();
        thirdCard = line;
    }

    public void fourthCard(String key) throws IOException {
        String data = key;
        out.writeUTF(data);
        int line;
        line = in.readInt();
        fourthCard = line;
    }

    public void fifthCard(String key) throws IOException {
        String data = key;
        out.writeUTF(data);
        int line;
        line = in.readInt();
        fifthCard = line;
    }

    public void sendBet(String key) throws IOException {
        String data = key;
        out.writeUTF(data);
    }

    public void sendScore(String key) throws IOException {
        String data = key;
        out.writeUTF(data);
    }

    public boolean recieveBets() throws IOException {
        int line;
        line = in.readInt();
        betBack = line;
        return true;

    }

    public void recieveTableMin() throws IOException {
        int line;
        line = in.readInt();
        tableMin = line;

    }

    public boolean catchDealerCards() throws IOException {
        int line;
        line = in.readInt();
        dealerCards = line;
        return true;

    }

    public boolean stayCommand() throws IOException {
        String line;
        line = in.readUTF();
        stayCommand = line;
        return true;

    }

    public boolean dealerCommand() throws IOException {
        String line;
        line = in.readUTF();
        dealerCommand = line;
        return true;

    }

    public boolean dealerWins() throws IOException {
        String line;
        line = in.readUTF();
        dealerWins = line;
        return true;

    }

    public void sendNames(String name) throws IOException {
        String line = name;
        out.writeUTF(line);
    }
      public void catchName() throws IOException {
        String line;
        line = in.readUTF();
        otherPlayersName = line;

    }

}

    


