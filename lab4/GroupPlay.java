package lab4;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class GroupPlay extends Competition{
    private int noGroups;
    private LinkedList<League> groups = new LinkedList<>();

    public GroupPlay(boolean cl, String n, Country c, int g, int ng){
        super(cl, n, c, g);
        noGroups = ng;
    }

    public LinkedList<League> getGroups(){
        return groups;
    }

    public void formGroups(){
        LinkedList<Team> teamsLeft = new LinkedList<>(teams); //variable to store teams that have to be added to a league of the group play
        int teamsxGroup = teams.size()/noGroups;
        for(League league : groups){
            Collections.shuffle(teamsLeft);
            if(teamsLeft.size() >= teamsxGroup){
                Iterator<Team> iterator = teamsLeft.iterator();
                for(int i = 0; i < teamsxGroup; i++){
                    if(iterator.hasNext()){
                        Team team = iterator.next();
                        league.addTeam(team);
                        iterator.remove();
                    }
                }
            }           
            
        }
        if(teamsLeft.size() != 0){
            for(int j = 0; j < teamsLeft.size(); j++){
                groups.getLast().addTeam(teamsLeft.get(j));
            }
        }
        
    }


    public void generateMatches(){
        for (League group : groups){
            for (Team team : group.getTeams()){
                for (Team team2 : group.getTeams()){
                    if(team != team2){
                        Match match = new Match(team, team2);
                        addMatch(match);
                    }
                    
                }
            }
        }       
    }

    public void addLeague(League l){
        if(l.getGender() == 0 && getGender() == 0){
            if(l.getClub() == false && getClub() == false){
                groups.add(l); 
            }
            else if(l.getClub() == true && getClub() == true){
                groups.add(l);
            }
                else{
                System.out.println("League can not be added to a group play that does not match its type! (club or national league)");
            }
        }
        else if(l.getGender() == 1 && getGender() == 1){
            if(l.getClub() == false && getClub() == false){
                groups.add(l);
            }
            else if(l.getClub() == true && getClub() == true){
                groups.add(l);
            }
                else{
                System.out.println("League can not be added to a group play that does not match its type! (club or national league)");
            }
        }
        else{
            System.out.println("League can not be added to a group play that does not match its gender! ");
        }   
    }

    public void printGroups(){
        int i = 1;
        for(League l : groups){
            System.out.println("Group " + i + "\n");
            for(Team t : l.teams){
                System.out.println(t.getName());
            }
            System.out.println("\n");
            i++;
            
        }
    }

    public void printTables(){
        int i = 1;
        for(League l : groups){
            System.out.println("Group " + i + " table: \n");
            List<TeamStats> totalTeamStats = new ArrayList<>(); //we create a list to include all outfielders' stats (those who can score goals) in the competition for it to be sorted later
            for(Team t : l.teams){        
                TeamStats teamStats = t.getTeamStats(this);
                totalTeamStats.add(teamStats);        
            }
            Collections.sort(totalTeamStats);
            System.out.println("\t\tPLAYED\tWINS\tTIES\tLOSSES\tFOR\tAGAINST\tPOINTS");

            for(TeamStats ts : totalTeamStats){
                System.out.println(ts.getTeam().name + "\t\t" + ts.getMatches() + "\t" + ts.getWins() + "\t" + ts.getTies() + "\t" + ts.getLosses() + "\t" + ts.getScored() + "\t" + ts.getAgainst() + "\t" + ts.getPoints() + "\t");
            }
            System.out.println("\n");
            i++;
        }
    }

}


