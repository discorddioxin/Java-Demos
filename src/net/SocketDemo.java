package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) throws IOException {
        // Create connection to server
        Socket socket = new Socket("localhost", 50000);

        // Grab output and input stream from socket (for writing and reading data)
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();

        // Read data (read message)
        byte[] incomingData = new byte[5]; // 2 bytes for "Hello"
        in.read(incomingData);

        // Prepare data for presenting (String message, in this case), present data
        String incomingMessage = new String(incomingData);
        System.out.println(incomingMessage);

        // Write data (send message)
        byte[] data = "Hi".getBytes();
        out.write(data);
        out.flush();
    }
}
