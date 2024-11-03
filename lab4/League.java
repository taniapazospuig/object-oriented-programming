package lab4;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class League extends Competition{
    public League(boolean cl, String n, Country c, int g){
        super(cl, n, c, g); 
    }
    
    @Override
    public void generateMatches(){
        for (Team team : teams){
            for (Team team2 : teams){
                if(team != team2){
                    Match match = new Match(team, team2);
                    addMatch(match);
                }
                
            }
        }
    }

    
    public void printTable(){
        List<TeamStats> totalTeamStats = new ArrayList<>(); //we create a list to include all team stats so that we can sort them later
        for(Team t : teams){        
            TeamStats teamStats = t.getTeamStats(this);
            totalTeamStats.add(teamStats);        
        }
        Collections.sort(totalTeamStats);
        System.out.println("\t\tPLAYED\tWINS\tTIES\tLOSSES\tFOR\tAGAINST\tPOINTS\n");

        for(TeamStats ts : totalTeamStats){
            System.out.println(ts.getTeam().name + "\t\t" + ts.getMatches() + "\t" + ts.getWins() + "\t" + ts.getTies() + "\t" + ts.getLosses() + "\t" + ts.getScored() + "\t" + ts.getAgainst() + "\t" + ts.getPoints() + "\t");
        }
        System.out.println("\n");
    }
}

