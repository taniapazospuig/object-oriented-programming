package lab4;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
            match.getHome().update(this, match);            
            match.getAway().update(this, match);
        }
    }

    public void printMatches(){
        for (Match match : matches){
            match.printMatch();
        }
    }

    public void generateMatches(){
    }

    public void printGoalScorers(int top){
        List<OutfielderStats> totalOutfieldersStats = new ArrayList<>(); //we create a linked list to include all outfielders' stats (those who can score goals) in the competition for it to be sorted later
        for(Team t : teams){
            for(Player p: t.getPlayers()){
                if(p instanceof Outfielder){
                    OutfielderStats playerStats = (OutfielderStats)p.stats.get(this);
                    totalOutfieldersStats.add(playerStats);
                }      
            }
        }
        Collections.sort(totalOutfieldersStats);

        System.out.println("TOP " + top + " GOALSCORERS\n");
        for(int i = 0; i<top; i++){
            totalOutfieldersStats.get(i).printStats();
            //System.out.println(totalOutfieldersStats.get(i).player.getName() + ": " + totalOutfieldersStats.get(i).noGoals);
        }
        System.out.println("\n");
    }

}
