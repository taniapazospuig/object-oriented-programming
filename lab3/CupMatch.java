package lab3;

import java.util.Random;

public class CupMatch extends Match{

    public CupMatch(Team h, Team a){
        super(h, a);
    }

    @Override
    public void simulateMatch(){
        super.simulateMatch();
        int home_goals_match = super.gethomeGoals();
        int away_goals_match = super.getawayGoals();
        if (home_goals_match == away_goals_match){
            //we don't reuse the simulateMatch because we want to update the goals values, not overwrite them
            Random random = new Random();
            int homegoals = random.nextInt(10);
            int awaygoals = random.nextInt(10);
            homeGoals = homegoals + home_goals_match;
            awayGoals = awaygoals + away_goals_match;
            simulateScores(homegoals, awaygoals); //add the extra time scorers
            int home_goals_total = super.gethomeGoals();
            int away_goals_total = super.getawayGoals();
            do {
                int home_penalties = random.nextInt(5); //Penalty shootouts are typically of 5 penalties
                int away_penalties = random.nextInt(5);
                homeGoals = home_goals_total + home_penalties;
                awayGoals = away_goals_total + away_penalties;
                simulateScores(home_penalties, away_penalties); //add the penalties scorers
            }while (super.gethomeGoals() == super.getawayGoals());
        }
        }
    }

