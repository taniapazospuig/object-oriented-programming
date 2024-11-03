package lab3;

import java.util.LinkedList;

public class Team {
    protected String name;
    protected Country country;
    protected int gender;
    protected LinkedList<Player> players = new LinkedList<>();
    protected int noMatches;
    protected int noWins;
    protected int noTies;
    protected int noLosses;
    protected int noPoints;
    protected int goalsScored;
    protected int goalsAgainst;
    protected boolean club;

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
    
    public void playMatch(int favour, int against){
        noMatches += 1;
        if(favour > against){
            noPoints += 3;
            noWins += 1;
        }
        else if(favour == against){
            noPoints += 1;
            noTies += 1;
        }
        else{
            noLosses += 1;
        }

        goalsScored += favour;
        goalsAgainst += against;
    }
    public void updateStats(Match m){
        if (m.getHome().name.equals(name)){
            playMatch(m.gethomeGoals(), m.getawayGoals());
        }
        else{
            playMatch(m.getawayGoals(), m.gethomeGoals());
        }
        for(Player player : players){
            player.updateStats();
        }
    }
}
