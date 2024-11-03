package lab3;
import java.util.Random;
public class Outfielder extends Player{
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;

    public Outfielder(int g, String n, int a, Country nat){
        super(g, n, a, nat);
    }

    public void updateStats(int t, int p, int s, int a, int g){
        Random random = new Random();
        noMatches++;
        noTackles += random.nextInt(10);
        noPasses += random.nextInt(10);
        noShots += random.nextInt(10);
        noAssists += random.nextInt(10);
        noGoals += random.nextInt(10);
    }

    
}
