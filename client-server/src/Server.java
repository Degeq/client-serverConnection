import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int portNum;

    public Server(int port){
        this.portNum = port;
    }

    public void server() {
        try {
            ServerSocket serverSocket = new ServerSocket(portNum);
        while (true) {

            try (Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                String line;
                while((line = in.readLine()) != null) {

                    if (line.equals("end")) {
                        break;
                    }

                    int i = Integer.parseInt(line.trim());
                    int current = 1;
                    int prev = 0;
                    int answ = 0;

                    for (int j = 0; j < i - 2; j++) {
                        answ = current+prev;
                        prev = current;
                        current = answ;
                    }

                    out.println("На " + i + "ой позиции в ряду Фибоначчи находится: " + answ);

                }

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        }
    } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
