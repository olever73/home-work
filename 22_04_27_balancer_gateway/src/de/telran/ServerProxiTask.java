package de.telran;

import de.telran.server.ServerData;
import de.telran.server.ServerSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerProxiTask implements Runnable {

    Socket socket;
    ServerSource serverSource;

    public ServerProxiTask(Socket socket, ServerSource serverSource) {
        this.socket = socket;
        this.serverSource = serverSource;
    }

    @Override
    public void run() {

        ServerData serverData = serverSource.getLast();

        String host = serverData.getHost();
        int port = serverData.getPort();

        Socket socketToServer;

        try {
            System.out.println(host + ":" + port);
            socketToServer = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        try (PrintStream toClient = new PrintStream(socket.getOutputStream());
             BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintStream toServer = new PrintStream(socketToServer.getOutputStream());
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()));
        ) {
            String lineFromClient;


            while ((lineFromClient = fromClient.readLine()) != null) {
                toServer.println(lineFromClient);
                String lineFromServer = fromServer.readLine();
                toClient.println(lineFromServer);
            }

            socketToServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}