package ru.netology;

public class Main {
    public static void main(String[] args) {

        Server server = new Server();
        Client client = new Client();


        Thread serverThread = new Thread(() -> {
            server.start();
        });
        serverThread.start();


        client.connect();


        try {
            serverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}