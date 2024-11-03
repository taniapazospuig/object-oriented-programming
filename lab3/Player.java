package lab3;

public class Player {
    private int gender;
    private String name;
    private int age;
    private Country nationality;
    protected int noMatches;

    public Player(int g, String n, int a, Country nat){
        gender = g;
        name = n;
        age = a;
        nationality = nat;
    }

     // Getter methods
    public int getGender(){
        return gender;
    }

    public String getName(){
        return name; 
    }

    public int getAge(){
        return age;
    }

    public Country getNationality(){
        return nationality;
    }

    public void updateStats(){
        noMatches++; 
    }
}
