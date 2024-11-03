package lab4;

public class TeamStats implements Comparable<TeamStats>{
    private Team team;
    private int noMatches;
    private int noWins;
    private int noTies;
    private int noLosses;
    private int noPoints;
    private int goalsScored;
    private int goalsAgainst;

    public TeamStats(Team t){
        team = t;
    }

    public Team getTeam(){
        return team;
    }

    public int getMatches(){
        return noMatches;
    }

    public int getWins(){
        return noWins;
    }

    public int getTies(){
        return noTies;
    }

    public int getLosses(){
        return noLosses;
    }

    public int getPoints(){
        return noPoints;
    }

    public int getScored(){
        return goalsScored;
    }

    public int getAgainst(){
        return goalsAgainst;
    }

    public void playMatch(int favour, int against){
        if(favour > against){
            noPoints += 3;
            noWins += 1;
        }
        else if(favour == against){
            noPoints += 1;
            noTies += 1;
        }
        else{
            noLosses += 1;
        }

        goalsScored += favour;
        goalsAgainst += against;
    }

    public void updateStats(Match m){
        noMatches++;
        if (m.getHome().name.equals(team.name)){
            playMatch(m.gethomeGoals(), m.getawayGoals());
        }
        else{
            playMatch(m.getawayGoals(), m.gethomeGoals());
        }
    }

    public void printStats(){
        System.out.println(team.name + "\t\t" + noMatches + "\t" + + noWins + "\t" + noTies + "\t" +  noLosses + "\t" + goalsScored + "\t" + goalsAgainst + "\t" + noPoints);
    }

    @Override
    public int compareTo(TeamStats ts){
        if(noPoints > ts.noPoints) return -1;
        if(noPoints < ts.noPoints) return 1;
        else{
            if((goalsScored - goalsAgainst) > (ts.goalsScored - ts.goalsAgainst)) return -1;
            if((goalsScored - goalsAgainst) < (ts.goalsScored - ts.goalsAgainst)) return 1;
            else{
                if(goalsScored > ts.goalsScored) return -1;
                if(goalsScored < ts.goalsScored) return 1;
                else return 0; //are exactly equals in all the items we consider to compare
            }
        }
            
        
    }
    
}
