import java.util.LinkedList;
import java.util.Random;
public class Match {
    private Team home;
    private Team away;
    private int homeGoals;
    private int awayGoals;
    private LinkedList<Player> homegoalScorers = new LinkedList<>();
    private LinkedList<Player> awaygoalScorers = new LinkedList<>();

    public Match(Team h, Team a){
        home = h;
        away = a;
    }
    
    public void simulateMatch(){
        Random random = new Random();
        int homegoals = random.nextInt(10);
        int awaygoals = random.nextInt(10);
        homeGoals = homegoals;
        awayGoals = awaygoals;
        simulateScores(homegoals, awaygoals);
    }

    public Team getHome(){
        return home;
    }

    public Team getAway(){
        return away;
    }

    public int gethomeGoals(){
        return homeGoals;
    }

    public int getawayGoals(){
        return awayGoals;
    }

    public LinkedList<Player> gethomeScorers(){
        return homegoalScorers;
    }

     public LinkedList<Player> getawayScorers(){
        return awaygoalScorers;
    }

    public void simulateScores(int home_goals, int away_goals){
        Random random = new Random();
        for(int i = 0; i < home_goals; i++){
            int home_num = random.nextInt(home.getPlayers().size());
            if (!homegoalScorers.contains(home.getPlayers().get(home_num))){
            homegoalScorers.add(home.getPlayers().get(home_num));
            }
        }

        for(int j = 0; j < away_goals; j++){
            int away_num = random.nextInt(away.getPlayers().size());
            if (!awaygoalScorers.contains(away.getPlayers().get(away_num))){
                awaygoalScorers.add(away.getPlayers().get(away_num));
            }  
        }     
        }
        

    public void printMatch(){
        StringBuilder homeScorers = new StringBuilder();
        StringBuilder awayScorers = new StringBuilder();
        for (Player player : homegoalScorers){
            homeScorers.append(player.getName()).append(", ");
        }
        for (Player player : awaygoalScorers){
            awayScorers.append(player.getName()).append(", ");
        }
        // Remove the trailing comma and space for both home and away scorers
        String homeScorersString = homeScorers.toString();
        String awayScorersString = awayScorers.toString();

        if (homeScorersString.length() > 2) {
            homeScorersString = homeScorersString.substring(0, homeScorersString.length() - 2);
        }

        if (awayScorersString.length() > 2) {
            awayScorersString = awayScorersString.substring(0, awayScorersString.length() - 2);
        }
        System.out.println(home.getName() + "-" + away.getName() + ": " + homeGoals + "-" + awayGoals + "\n" + home.getName() + " goal scorers: " + homeScorersString + "\t\t" + away.getName() + " goal scorers: " + awayScorersString);
    }
}

