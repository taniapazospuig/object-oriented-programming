package lab4;

public abstract class PlayerStats {
    protected Player player;
    protected int noMatches;

    public PlayerStats(Player p){
        player = p;
    }

    public abstract void updateStats(Match m);

    public abstract void printStats();
    


}
