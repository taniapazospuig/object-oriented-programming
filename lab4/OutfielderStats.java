package lab4;
import java.util.Random;

public class OutfielderStats extends PlayerStats implements Comparable<OutfielderStats>{
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    protected int noGoals;

    public OutfielderStats(Player p){
        super(p);
    }

    public void updateStats(Match m){
        Random random = new Random();
        for(Player p : m.gethomeScorers()){
            if(p.equals(this.player)){
                noGoals++;
            }
        }
        for(Player p : m.getawayScorers()){
            if(p.equals(this.player)){
                noGoals++;
            }
        }
        noMatches++;
        noTackles+=random.nextInt(10);
        noPasses+=random.nextInt(10);
        noShots+=random.nextInt(10);
        noAssists+=random.nextInt(2);
    }

    public void printStats(){
        System.out.println("\t\t PLAYED\tGOALS\tASSISTS\tSHOTS\tPASSES\tTACKLES");
        System.out.println(player.getName() + "\t\t" + noMatches + "\t" + + noGoals + "\t" + noAssists + "\t" +  noShots + "\t" + noPasses + "\t" + noTackles + "\n");
    }

    @Override
    public int compareTo(OutfielderStats os){
        if(noGoals > os.noGoals) return -1;
        else if(noGoals == os.noGoals) return 0;
        else return 1;
    }
}
