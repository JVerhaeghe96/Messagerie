package be.ArtsEtTechnique.messagerieClient.controleur;

import be.ArtsEtTechnique.messagerieClient.domaine.Bundle;
import be.ArtsEtTechnique.messagerieClient.usecase.GestionClient;
import be.ArtsEtTechnique.messagerieClient.usecaseimpl.GestionClientImpl;

public class GestionnaireUseCase implements GestionClient {
    private GestionClient gestionClient;

    private static final GestionnaireUseCase INSTANCE = new GestionnaireUseCase();

    public static GestionnaireUseCase getINSTANCE() {
        return INSTANCE;
    }

    private GestionnaireUseCase(){
        this.gestionClient = new GestionClientImpl();
    }

    @Override
    public void connectionServer(Bundle bundle) {
        this.gestionClient.connectionServer(bundle);
    }
}
