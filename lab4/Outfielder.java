package lab4;
import java.util.Random;
public class Outfielder extends Player{
    

    public Outfielder(int g, String n, int a, Country nat){
        super(g, n, a, nat);
    }

    public void update(Competition c, Match m){
        if(stats.get(c) == null){
            OutfielderStats firstStats = new OutfielderStats(this);
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
