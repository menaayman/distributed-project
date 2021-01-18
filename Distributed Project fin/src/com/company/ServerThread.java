package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;


public class ServerThread implements Runnable {
        
        Socket client;
        String userName;
        BufferedReader cin;
        PrintStream cout;
        int id;
        CopyOnWriteArrayList<Integer> team;

    {
        team = new CopyOnWriteArrayList<>();
    }


    ServerThread(Socket client, int count  )  {
            
            this.client=client;
            this.id=count;
            System.out.println("Connection "+id+" established with client "+client);
                try {
                        cin=new BufferedReader(new InputStreamReader(client.getInputStream()));
                        cout=new PrintStream(client.getOutputStream());
                } catch (IOException e) {
                        e.printStackTrace();
                }


        }

        void setUserName (String userName) {
        	this.userName = userName;
        }


    public void run() {
        boolean isRegistered = LoginSystem.Login(this);
        	//registration


    }//end of run method


    }//end of ServerThread