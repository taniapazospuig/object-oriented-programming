package lab3;

import java.util.LinkedList;

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
}
