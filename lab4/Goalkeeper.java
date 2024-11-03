package lab4;
import java.util.Random;

public class Goalkeeper extends Player{
    
    public Goalkeeper(int g, String n, int a, Country nat){
        super(g, n, a, nat);
    }

    public void update(Competition c, Match m){
        if(stats.get(c) == null){
            GoalkeeperStats firstStats = new GoalkeeperStats(this);
            firstStats.updateStats(m);
            stats.put(c, firstStats);
        }
        else{
            PlayerStats competitionStats = stats.get(c);
            competitionStats.updateStats(m);
            stats.put(c, competitionStats);
        }
    }
}
