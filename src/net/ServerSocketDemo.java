package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// Run this program before running SocketDemo
public class ServerSocketDemo {
    public static void main(String[] args) throws IOException {
        // Create server
        ServerSocket serverSocket = new ServerSocket(50000);

        // Accept connection
        Socket socket = serverSocket.accept();

        // Grab output and input stream from socket (for writing and reading data)
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();

        // Write data (send message)
        byte[] data = "Hello".getBytes();
        out.write(data);
        out.flush();

        // Read data (read message)
        byte[] incomingData = new byte[2]; // 2 bytes for "Hi"
        in.read(incomingData);

        // Prepare data for presenting (String message, in this case), present data
        String incomingMessage = new String(incomingData);
        System.out.println(incomingMessage);
    }
}
