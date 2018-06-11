package NIO;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PlainEchoClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(),
                true);
        String number = null;
        int index = 1;
        writer.println(index++);
        while((number = reader.readLine()) != null) {
            System.out.println(number);
            for (int i = 0; i < 10; i++) {
                writer.print((index + i)%10 + 1);
            }
            index++;
            writer.println();
        }

    }
}
