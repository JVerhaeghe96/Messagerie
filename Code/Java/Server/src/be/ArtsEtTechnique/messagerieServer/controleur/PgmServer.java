package be.ArtsEtTechnique.messagerieServer.controleur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PgmServer {
    public static final int HOST_PORT = 2009;

    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(HOST_PORT);

            System.out.println("Running ...");

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        while(true){
                            Socket s = ss.accept();
                            System.out.println("Client " + s.getInetAddress() + " accepté");
                        }
                    }catch(IOException ioe){
                        System.out.println("Impossible d'accepter la connexion");
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
