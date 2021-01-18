package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Server class
public class Main {

    int port;
    ServerSocket server=null;
    Socket client=null;
    static ExecutorService A1 = null;

    static ArrayList<ServerThread> serverThreads = new ArrayList<>(); //keeping trace of threads
    int clientcount=0; //to asign id for each client

    public static void main(String[] args) throws IOException {
        Main serverobj=new Main(3214);
        serverobj.startServer();

    }

    Main (int port){
        this.port=port;
        A1 = Executors.newFixedThreadPool(100);
    }


    public void startServer() throws IOException {

        server=new ServerSocket(3214);
        System.out.println("Server Booted");
        System.out.println("waiting for connection");

       // TeamBuild teamBuild = new TeamBuild();
        // A1.execute(teamBuild);

        do {
            client = server.accept();
            clientcount++;
            ServerThread serverThread = new ServerThread(client, clientcount);
            serverThreads.add(serverThread);
            A1.execute(serverThread);
        } while (true);

    }

}
