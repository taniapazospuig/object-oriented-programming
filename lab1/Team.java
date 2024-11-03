package lab1;

import java.util.LinkedList;
public class Team {
    private String name;
    private Country country;
    private int gender;
    private LinkedList<Player> players = new LinkedList<>();
    private int noMatches;
    private int noPoints;
    private int noWins;
    private int noTies;
    private int noLosses;
    private int goalsScored;
    private int goalsAgainst;

    public Team(String n, Country c, int g){
        name = n;
        country = c;
        gender = g;
    }

    public String getName(){
        return name;
    }

    public Country getCountry(){
        return country;
    }

    public int getGender(){
        return gender;
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

    public void printPlayers() {
        System.out.print("Players in the team: ");
        StringBuilder playerNames = new StringBuilder();
        
        for (Player player : players) {
            playerNames.append(player.getName()).append(", ");
        }
        
        
        if (playerNames.length() > 0) {
            playerNames.setLength(playerNames.length() - 2); 
            System.out.println(playerNames);
        } else {
            System.out.println("No players in the team.");
        }
    }

    public void printStats(){
        System.out.println("Team " + name + " statistics:");
        printPlayers();
        System.out.println("Matches Played: " + noMatches);
        System.out.println("Wins: " + noWins);
        System.out.println("Ties: " + noTies);
        System.out.println("Losses: " + noLosses);
        System.out.println("Points: " + noPoints);
        System.out.println("Goals Scored: " + goalsScored);
        System.out.println("Goals Against: " + goalsAgainst);        
    }    
} 
