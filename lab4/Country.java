package lab4;

public class Country {
    private String name;

    public Country(String n){
        name = n;
    }
    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Country){
                Country co = (Country)o;
                return name.equals(co.name);
        }
    return false;
    }
}