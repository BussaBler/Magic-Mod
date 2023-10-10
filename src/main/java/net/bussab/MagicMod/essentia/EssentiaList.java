package net.bussab.MagicMod.essentia;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;


public class EssentiaList implements Serializable {

    public LinkedHashMap<Essentia, Integer> essentia = new LinkedHashMap<>();


    public EssentiaList(){
    }


    public Essentia[] getEssentias(){
        return essentia.keySet().toArray(new Essentia[]{});
    }

    public int getAmount(Essentia key){
        return essentia.get(key)==null?0:essentia.get(key);
    }

    public int[] getAmounts(){
        Collection<Integer> values = essentia.values();
        int[] amounts = new int[values.size()];
        int index = 0;
        for (Integer value: values){
            amounts[index++] = value.intValue();
        }
        return amounts;
    }

    public EssentiaList add(Essentia key, int value){
        if (essentia.containsKey(key)){
            int old = essentia.get(key);
            value+=old;
        }
        essentia.put(key, value);
        return this;
    }

    public EssentiaList reduce(Essentia key, int value){
        
        if(essentia.get(key) >= value){
            int amount = essentia.get(key) - value;
            essentia.put(key, amount);
            if (amount <= 0) remove(key);
        }
        return this;
    }

    public EssentiaList remove(Essentia key){
        essentia.remove(key);
        
        return this;
    }

    public boolean isEmpty(){
        return essentia.isEmpty();
    }

}
