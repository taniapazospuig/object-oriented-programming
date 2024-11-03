package lab3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;


public class Cup extends Competition{
    private LinkedList<LinkedList<Team>> tr = new LinkedList<>();    
    private LinkedList<LinkedList<CupMatch>> mr = new LinkedList<>();
    private Team spareTeam; //attribute to store team that is not paired in case of odd number of teams so it can progress rounds

    public Cup(boolean cl, String n, Country c, int g){
        super(cl, n, c, g);
    }

    public void simulateMatches(LinkedList<CupMatch> roundMatches){
        LinkedList<Team> nextRoundTeams = new LinkedList<>();
        for(CupMatch match : roundMatches){
            match.simulateMatch();
            match.getHome().updateStats(match);
            match.getAway().updateStats(match);
            match.printMatch();
            if(match.gethomeGoals() > match.getawayGoals()){
                nextRoundTeams.add(match.getHome());
            }
            else{
                nextRoundTeams.add(match.getAway());
            }
        }
        if(spareTeam != null){   //only add the spare team if there is actually a spare team
            nextRoundTeams.add(spareTeam);
        }
        tr.add(nextRoundTeams);
    }
        

    public void generateMatches(){
        tr.add(teams);
        int round = 1;
        int currentIndex = 0;
        while(tr.getLast().size()>1){
            LinkedList<Team> roundTeams = tr.get(currentIndex); //teams from each round
            Collections.shuffle(roundTeams); //randomize teams
            LinkedList<CupMatch> roundMatches = new LinkedList<>(); //matches from each round 
            int size = roundTeams.size();
            if(size % 2 == 0){  //case even number of teams
                for(int i = 0; i < size; i+=2){  //increase i by 2 because we pair 2 consecutive teams at a time
                    CupMatch match = new CupMatch(roundTeams.get(i), roundTeams.get(i+1));
                    addMatch(match);
                    roundMatches.add(match);
                }
                spareTeam = null;
            }
            else{ //case odd number of teams
                for(int i = 0; i < size - 1; i+=2){ //we iterate until the penultimate team because this one doesn't have a pair
                    CupMatch match = new CupMatch(roundTeams.get(i), roundTeams.get(i+1));
                    addMatch(match); 
                    roundMatches.add(match);
                }
                spareTeam = roundTeams.get(size-1);
            }
            mr.add(roundMatches);
            System.out.println("\nRound " + round );
            simulateMatches(roundMatches);

            currentIndex++;
            round++;
        }
        System.out.println("Winner team is " + tr.getLast().get(0).getName());
        
        }
        
        
    }

