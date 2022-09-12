import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {

    public static void main(String[] args) throws IOException {
        Server serverFibonachi = new Server(45614);

        Thread server = new Thread(null, () -> serverFibonachi.server(), "ServerThread");
        server.start();

        Socket socket = new Socket("127.0.0.1", 45614);

        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            Scanner scanner = new Scanner(System.in)) {

            String msg;
            while(true) {
                System.out.println("Введите порядковый номер члена последовательности Фибаначчи, который Вы хотите " +
                        "узнать или 'end', чтобы завершить программу");

                msg = scanner.nextLine();
                out.println(msg);
                if (msg.equals("end")) break;

                System.out.println("SERVER: " + in.readLine());

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
