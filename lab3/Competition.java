package lab3;

import java.util.LinkedList;

public class Competition {
    private boolean clubs;
    private String name;
    private Country country;
    private int gender;
    protected LinkedList<Team> teams = new LinkedList<>();
    protected LinkedList<Match> matches = new LinkedList<>();

    public Competition(boolean cl, String n, Country co, int g){
        clubs = cl;
        name = n;
        country = co;
        gender = g;
    }

    // Getter methods
    public String getName(){
        return name;
    }

    public boolean getClub(){
        return clubs;
    }

    public int getGender(){
        return gender;
    }

    public Country getCountry(){
        return country;
    }

    public LinkedList<Team> getTeams(){
        return teams;
    }

    public void addTeam(Team t){
        if(t.getGender() == 0 && getGender() == 0){
            if(t.getClub() == false && getClub() == false){
                teams.add(t); 
            }
            else if(t.getClub() == true && getClub() == true){
                teams.add(t);
            }
             else{
                System.out.println("Team can not be added to a league that does not match its type! (club or national league)");
            }
        }
        else if(t.getGender() == 1 && getGender() == 1){
            if(t.getClub() == false && getClub() == false){
                teams.add(t);
            }
            else if(t.getClub() == true && getClub() == true){
                teams.add(t);
            }
             else{
                System.out.println("Team can not be added to a league that does not match its type! (club or national league)");
            }
        }
        else{
            System.out.println("Team can not be added to a league that does not match its gender! ");
        }   
    }

    public void addMatch(Match m){
        matches.add(m);
    }

    public void simulateMatches(){
        for (Match match : matches){
            match.simulateMatch();
            match.getHome().updateStats(match);            
            match.getAway().updateStats(match);
        }
    }

    public void printMatches(){
        for (Match match : matches){
            match.printMatch();
        }
    }

    public void generateMatches(){
    }


}
