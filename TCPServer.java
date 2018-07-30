import java.io.*;
import java.net.*;
import java.util.*;

class TCPServer {
    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        long counter = 0;
        String contentType="text/html";
        int code=200;
        ServerSocket welcomeSocket = new ServerSocket(80);

        System.out.println("Ready to accept incoming packets");
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient =
                new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            counter+= 1;
            System.out.println("Received: " + clientSentence + ". Counter: " + counter);
            outToClient.writeBytes("HTTP/1.0 " + code + " OK\r\n" + 
                                    "Date: " + new Date().toString() + "\r\n" +
                                    "Server: TestWebServer/1.0\r\n" +
                                    "Content-Type: " + contentType + "\r\n" +
                                    "Expires: Thu, 01 Dec 1994 16:00:00 GMT\r\n" +
                                   "Last-modified: " + new Date(System.currentTimeMillis()).toString() + "\r\n" +
                                    "\r\n");
            outToClient.writeBytes("<html><h1>Counter: " + counter + "</h1></html>");
            outToClient.flush();
            outToClient.close();
        }
    }
}
