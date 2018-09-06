package be.ArtsEtTechnique.messagerieClient.usecaseimpl;

import be.ArtsEtTechnique.messagerieClient.domaine.Bundle;
import be.ArtsEtTechnique.messagerieClient.usecase.GestionClient;

import java.io.*;
import java.net.*;

public class GestionClientImpl implements GestionClient {
    public static final String HOST_IP = "127.0.0.1";
    public static final int HOST_PORT = 2009;

    @Override
    public void connectionServer(Bundle bundle) {
        try{
            Socket socket = new Socket(HOST_IP, HOST_PORT);
            bundle.set(Bundle.OPERATION_REUSSIE, true);
        }catch(IOException ioe){
            bundle.set(Bundle.OPERATION_REUSSIE, false);
            bundle.set(Bundle.MESSAGE, "Connexion au serveur impossible");
        }
    }
}
