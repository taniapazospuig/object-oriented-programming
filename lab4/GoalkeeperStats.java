package lab4;
import java.util.Random;

public class GoalkeeperStats extends PlayerStats{
    private int noSaves;
    private int noGoalsLet;

    public GoalkeeperStats(Player p){
        super(p);
    }

    public void updateStats(Match m){
        for(Player p : m.getHome().players){ 
            if(p.equals(this.player)){ //we check if the goalkeeper belonging to these stats plays in the home team
                noGoalsLet+=m.getawayGoals(); //if it does, its number of goals let increases by the number of away goals
            }
        }
        for(Player p : m.getAway().players){
            if(p.equals(this.player)){ //we check the inverse condition
                noGoalsLet+=m.gethomeGoals();
            }
        }
        Random random = new Random();
        noSaves+=random.nextInt(10); //we increase the number of saves by a random number between 0 and 10
    }

    public void printStats(){
        System.out.println(this.player.getName() + "STATS: \n");
        System.out.println("NUMBER OF SAVES: " + noSaves + "\nGOALS LET: " + noGoalsLet);
    }

    
}
