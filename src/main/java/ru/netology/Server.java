package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void start() {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("New connection accepted from port " + clientSocket.getPort());

                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String message = in.readLine();
                    System.out.println("Received message: " + message);

                    out.println("Hi, your message is: " + message + ", and your port is: " + clientSocket.getPort());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}