package serverfun;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by antz on 20/07/16.
 */
public class MultiThreadedBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(2121);
        ExecutorService threadPool = Executors.newFixedThreadPool(200);
        while(true) {
            final Socket socket = ss.accept();
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    //blocking
                    handle(socket);
                }
            });

        }

    }

    private static void handle(Socket socket) throws RuntimeException {
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
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
        System.out.println("Blocking request closed");
    }

    private static int transform(int data) {
        return Character.isLetter(data)? data ^ ' ' : data;
    }
}
