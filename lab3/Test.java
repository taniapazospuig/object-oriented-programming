package lab3;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args){
        Country c1 = new Country("Spain");
        Team t1 = new Team("Girona", c1, 0, true);
        Team t2 = new Team("Bcn", c1, 0, true);
        Team t3 = new Team("Lleida", c1, 0, true);
        Team t4 = new Team("Tarrago", c1, 0, true);
        Team t5 = new Team("Madrid", c1, 0, true);
        Team t6 = new Team("Atletic", c1, 0, true);
        Team t7 = new Team("Osasuna", c1, 0, true);
        Team t8 = new Team("Rayo", c1, 0, true);        
        Team t9 = new Team("Real", c1, 0, true);

        Player p1 = new Player(0, "Aniol", 19, c1);
        Player p2 = new Player(0, "Pol", 19, c1);
        Player p3 = new Player(0, "Jan", 19, c1);
        Player p4 = new Player(0, "Pau", 19, c1);
        Player p5 = new Player(0, "Gerard", 19, c1);
        Player p6 = new Player(0, "Marc", 19, c1);
        Player p7 = new Player(0, "Roger", 19, c1);
        Player p8 = new Player(0, "Ferran", 19, c1);
        Player p9 = new Player(0, "Pere", 19, c1);
        

        t1.addPlayer(p1);
        t2.addPlayer(p2);
        t3.addPlayer(p3);
        t4.addPlayer(p4);
        t5.addPlayer(p5);
        t6.addPlayer(p6);
        t7.addPlayer(p7);
        t8.addPlayer(p8);
        t9.addPlayer(p9);
        

        Cup cup = new Cup(true, "LaLiga", c1, 0);

        cup.addTeam(t1);        
        cup.addTeam(t2);
        cup.addTeam(t3);
        cup.addTeam(t4);
        cup.addTeam(t5);        
        cup.addTeam(t6);
        cup.addTeam(t7);
        cup.addTeam(t8);
        cup.addTeam(t9);

        cup.generateMatches();

        League l1 = new League(true, "Premier", c1, 0);
        League l2 = new League(true, "bundes", c1, 0);
        
        LinkedList<League> leagues = new LinkedList<>();
        leagues.add(l1);
        leagues.add(l2);
        
        GroupPlay gp = new GroupPlay(true, "Groups", c1, 0, 2);

        gp.addTeam(t1);
        gp.addTeam(t2);
        gp.addTeam(t3);
        gp.addTeam(t4);
        gp.addTeam(t5);
        gp.addTeam(t6);
        gp.addTeam(t7);
        gp.addTeam(t8);
        gp.addTeam(t9);

        gp.formGroups(leagues);

        int i = 1;
        for(League league : gp.getGroups()){
            System.out.println("\nGroup " + i + ": ");
            for(Team team : league.teams){
                System.out.println(team.getName());
            }
            i++;
        }


    }
}
