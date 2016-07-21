package serverfun;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by antz on 20/07/16.
 */
public class SingleThreadedBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(2121);
        while(true) {
                //blocking
            Socket socket = ss.accept();
            handle(socket);
        }

    }

    private static void handle(Socket socket) throws IOException {
        System.out.println("Blocking request opened");
        try(InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        ) {
            int data;
            while((data = in.read()) != -1) {
                data = transform(data);
                out.write(data);
            }

        } catch (IOException ex) {
            throw ex;
        }
        System.out.println("Blocking request closed");
    }

    private static int transform(int data) {
        return Character.isLetter(data)? data ^ ' ' : data;
    }
}
