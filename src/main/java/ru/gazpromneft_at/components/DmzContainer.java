package ru.gazpromneft_at.components;

import ru.gazpromneft_at.model.Messaga;

import java.util.HashMap;
import java.util.Map;

public class DmzContainer {
    private Map mapa;
    DmzContainer(){
        mapa = new HashMap<String, Messaga>();
    }

    synchronized public void addresult(String corrId, Messaga messaga){
        mapa.put(corrId, messaga);
    }

    synchronized public Messaga getResult(String corrId){
        Messaga result = (Messaga) mapa.get(corrId);
        return result;
    }

    public int getSize(){
        return mapa.size();
    }
}
