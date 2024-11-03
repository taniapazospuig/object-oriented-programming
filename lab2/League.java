import java.util.LinkedList;

public class League {
    private String name;
    private LinkedList<Team> teams = new LinkedList<>();
    private Country country;
    private int gender;
    private LinkedList<Match> matches = new LinkedList<>();

    public League(String n, Country c, int g){
        name = n;
        country = c;
        gender = g;
    }

    public String getName(){
        return name;
    }

    public int getGender(){
        return gender;
    }

    public Country getCountry(){
        return country;
    }

    public void addTeam(Team t){
        if(t.getGender() == 0){
            if(getGender() == 0){
                teams.add(t);
            }
             else{
                System.out.println("Team can not be added to a league that does not match its gender!");
            }
        }
        else{
            if(getGender() == 1){
                teams.add(t);
            }
            else{
                System.out.println("Team can not be added to a league that does not match its gender!");
            }
        }     
    }

    public void addMatch(Match m){
        matches.add(m);
    }

    public void generateMatches(){
        for (Team team : teams){
            for (Team team2 : teams){
                if(team != team2){
                    Match match = new Match(team, team2);
                    addMatch(match);
                }
                
            }
        }
    }

    public void simulateMatches(){
        for (Match match : matches){
            match.simulateMatch();
            match.getHome().updateStats(match);            
            match.getAway().updateStats(match);
        }
    }

    public void printMatches(){
        for (Match match : matches){
            match.printMatch();
        }
    }
}
