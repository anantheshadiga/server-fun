package serverfun;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by antz on 20/07/16.
 */
public class NIOSingleThreadedBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(2121));
        while(true) {
                //blocking
            SocketChannel socket = ss.accept();
            handle(socket);
        }

    }

    private static void handle(SocketChannel socket) throws IOException {

        System.out.println("Blocking request opened");
        ByteBuffer buf = ByteBuffer.allocate(80);
        int data;
        while((data = socket.read(buf)) != -1) {
            buf.flip();
            transform(buf);
            while(buf.hasRemaining())
                socket.write(buf);

            buf.compact();
        }
        System.out.println("Blocking request closed");
    }

    private static void transform(ByteBuffer buf) {
        for(int index=0;index<buf.limit();index++) {
            buf.put(index, (byte) transform(buf.get(index)));
        }
    }

    private static int transform(int data) {
        return Character.isLetter(data)? data ^ ' ' : data;
    }
}
