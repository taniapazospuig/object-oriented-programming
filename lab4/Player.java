package lab4;
import java.util.HashMap;

public class Player {
    private int gender;
    private String name;
    private int age;
    private Country nationality;
    protected int noMatches;
    protected HashMap<Competition, PlayerStats> stats = new HashMap<Competition, PlayerStats>();

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

    public PlayerStats getPlayerStats(Competition c){
        return stats.get(c);
    }

    public void update(Competition c, Match m){
    }
    
}
