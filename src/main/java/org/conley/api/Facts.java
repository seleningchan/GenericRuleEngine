package org.conley.api;

import java.util.*;

public class Facts implements Iterable<Fact<?>>{
    private final Set<Fact<?>> facts = new HashSet<>();
    public <T> void put(String name, T value){
        //Objects.requireNonNull(name,"name must not be null");
        CheckFact(name);
        Objects.requireNonNull(value, "value must not be null");
        Fact<?> retrievedFact = getFact(name);
        if(retrievedFact!=null)
            remove(retrievedFact);
        add(new Fact<>(name, value));
    }

    public <T> void add(Fact<T> fact){
        //Objects.requireNonNull(fact, "fact must not be null");
        CheckFact(fact);
        Fact<?> retrievedFact = getFact(fact.getName());
        if (retrievedFact!=null)
            remove(retrievedFact);
        facts.add(fact);
    }

    public void remove(String factName){
        //Objects.requireNonNull(factName, "fact name must not be null");
        CheckFact(factName);
        Fact<?> fact = getFact(factName);
        if(fact!=null)
            remove(fact);
    }

    public <T> void remove(Fact<T> fact){
        //Objects.requireNonNull(fact, "fact must not be null");
        CheckFact(fact);
        facts.remove(fact);
    }

    public <T> T get(String factName){
        //Objects.requireNonNull(factName,"fact name must not be null");
        CheckFact(factName);
        Fact<?> fact = getFact(factName);
        if(fact!=null)
            return (T) fact.getValue();
        return null;
    }

    public Fact<?> getFact(String factName){
        CheckFact(factName);
        return facts.stream()
                .filter(fact -> fact.getName().equals(factName))
                .findFirst()
                .orElse(null);
    }

    public boolean contains(String factName){
        return getFact(factName) != null;
    }

    public boolean contains(Fact fact){
        if (fact == null)
            return  false;
        return getFact(fact.getName()) != null;
    }

    public int size(){
        return facts.size();
    }

    public Map<String, Object> asMap(){
        Map<String, Object> map = new HashMap<>();
        for (Fact<?> fact : facts)
            map.put(fact.getName(), fact.getValue());
        return map;
    }

    public void clear(){
        facts.clear();
    }

    @Override
    public String toString() {
        Iterator<Fact<?>> iterator = facts.iterator();
        StringBuilder stringBuilder = new StringBuilder("[");
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next().toString());
            if(iterator.hasNext())
                stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Fact<?>> iterator() {
        return facts.iterator();
    }

    private void CheckFact(Object obj){
        if(obj instanceof String){
            Objects.requireNonNull((String)obj, "fact name must not be null");
        }
        /*if(obj instanceof T.getClass())
            Objects.requireNonNull(obj, "value must not be null");*/
        if(obj instanceof Fact<?>)
            Objects.requireNonNull(obj, "fact must not be null");
    }
}
