package lab1;

public class Player {
    private int gender;
    private String name;
    private int age;
    private Country nationality;
    private int noMatches;
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;

    public Player(int g, String n, int a, Country nat){
        gender = g;
        name = n;
        age = a;
        nationality = nat;
    }

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

    public void update(int t, int p, int s, int a, int g){
        noMatches++;
        noTackles += t;
        noPasses += p;
        noShots += s;
        noAssists += a;
        noGoals += g;
    }

    public void printStats(){
        System.out.println("Player Name: " + name);
        System.out.println("Matches: " + noMatches);
        System.out.println("Tackles: " + noTackles);
        System.out.println("Passes: " + noPasses);
        System.out.println("Assists: " + noAssists);
        System.out.println("Goals: " + noGoals);     
    }

    
}
