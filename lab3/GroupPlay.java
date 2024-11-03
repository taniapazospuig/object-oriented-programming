package lab3;
import java.util.LinkedList;
import java.util.Random;
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

    

    public void formGroups(LinkedList<League> leagues){
        LinkedList<Team> teamsLeft = teams; //variable to store teams that have to be added to a league of the group play
        int teamsxGroup = teams.size()/noGroups;
        for(League league : leagues){
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
            groups.add(league);
        }
        if(teamsLeft.size() != 0){
            for(int j = 0; j < teamsLeft.size(); j++){
                leagues.getLast().addTeam(teamsLeft.get(j));
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
    }

