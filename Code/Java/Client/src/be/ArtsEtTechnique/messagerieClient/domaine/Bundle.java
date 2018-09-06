package be.ArtsEtTechnique.messagerieClient.domaine;

import java.util.HashMap;
import java.util.Map;

public class Bundle {
    public static final String OPERATION_REUSSIE = "operation_reussie";
    public static final String MESSAGE = "message";

    private Map<String, Object> map;

    public Bundle(){
        this.map = new HashMap<>();
        this.map.put(OPERATION_REUSSIE, false);
        this.map.put(MESSAGE, "");
    }

    public Object get(String key){
        return this.map.get(key);
    }

    public void set(String key, Object value){
        this.map.put(key, value);
    }

    public void vider(){
        this.map.clear();
    }
}
