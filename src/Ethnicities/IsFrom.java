package Ethnicities;

import dataStructures.Predicate;

public class IsFrom implements Predicate<Ethnicity>{

    private final String from;

    public IsFrom(String from){
        this.from=from;
    }

    @Override
    public boolean check(Ethnicity from) {
        if(this.from.equals("all")) return true;
        else{
            return from.getName().equals(this.from);
        }
    }
}
