package be.ArtsEtTechnique.messagerieClient.ihm;

import be.ArtsEtTechnique.messagerieClient.controleur.GestionnaireUseCase;
import be.ArtsEtTechnique.messagerieClient.domaine.Bundle;
import be.ArtsEtTechnique.messagerieClient.usecase.GestionClient;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.HashSet;
import java.util.Set;

public final class MessagerieModel {
    private Bundle bundle;
    private GestionClient gestionnaire;
    private Set<ChangeListener> listeners;

    public MessagerieModel(){
        this.bundle = new Bundle();
        this.gestionnaire = GestionnaireUseCase.getINSTANCE();
        this.listeners = new HashSet<>();
    }

    public synchronized void enregistrerListener(ChangeListener listener){
        if(!this.listeners.contains(listener)){
            this.listeners.add(listener);
        }
    }

    public synchronized void removeListener(ChangeListener listener){
        if(this.listeners.contains(listener))
            this.listeners.remove(listener);
    }

    public synchronized void traiterEvent(ChangeEvent e){
        for(ChangeListener listener : this.listeners){
            listener.stateChanged(e);
        }
    }

    public Bundle getBundle(){
        return this.bundle;
    }

    public void setBundle(Bundle bundle){
        this.bundle = bundle;
        this.traiterEvent(new ChangeEvent(this));
    }

    public void connecterServer(){
        this.gestionnaire.connectionServer(this.bundle);
    }
}
