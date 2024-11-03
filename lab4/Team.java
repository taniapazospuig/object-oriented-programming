package lab4;

import java.util.LinkedList;
import java.util.HashMap;

public class Team {
    protected String name;
    protected Country country;
    protected int gender;
    protected LinkedList<Player> players = new LinkedList<>();
    protected boolean club;
    protected HashMap<Competition, TeamStats> stats = new HashMap<Competition, TeamStats>();

    public Team(String n, Country c, int g, boolean cl){
        name = n;
        country = c;
        gender = g;
        club = cl;
    }

    // Getter methods
    public String getName(){
        return name;
    }

    public Country getCountry(){
        return country;
    }

    public int getGender(){
        return gender;
    }

    public LinkedList<Player> getPlayers(){
        return players;
    }

    public boolean getClub(){
        return club;
    }

    public TeamStats getTeamStats(Competition c){
        return stats.get(c); 
    }

    public void addPlayer(Player p){
        if(p.getGender() == 0){
            if(getGender() == 0){
                players.add(p);
            }
             else{
                System.out.println("Player can not be added to a team that does not match its gender!");
            }
        }
        else{
            if(getGender() == 1){
                players.add(p);
            }
            else{
                System.out.println("Player can not be added to a team that does not match its gender!");
            }
        }        
    }

    public void removePlayer(Player p){
        players.remove(p);
    }

    public void update(Competition c, Match m){
        if(stats.get(c) == null){
            TeamStats firstStats = new TeamStats(this);
            firstStats.updateStats(m);
            stats.put(c, firstStats);
        }
        else{
            TeamStats competitionStats = stats.get(c);
            competitionStats.updateStats(m);
            stats.put(c, competitionStats);
        }
        
        for(Player p : players){
                p.update(c, m);
            }
    }
    
   

    
}
