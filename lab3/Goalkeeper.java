package lab3;
import java.util.Random;

public class Goalkeeper extends Player{
    private int noSaves;
    private int noGoalsLet;

    public Goalkeeper(int g, String n, int a, Country nat){
        super(g, n, a, nat);
    }

    public void updateStats(){
        Random random = new Random();
        noMatches++;
        noSaves += random.nextInt(10);
        noGoalsLet += random.nextInt(25);
    }
}
