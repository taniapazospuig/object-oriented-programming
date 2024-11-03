package lab4;

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

        Player p1 = new Outfielder(0, "Aniol", 19, c1);
        Player p2 = new Outfielder(0, "Pol", 19, c1);
        Player p3 = new Outfielder(0, "Jan", 19, c1);
        Player p4 = new Outfielder(0, "Pau", 19, c1);
        Player p5 = new Outfielder(0, "Gerard", 19, c1);
        Player p6 = new Outfielder(0, "Marc", 19, c1);
        Player p7 = new Outfielder(0, "Roger", 19, c1);
        Player p8 = new Outfielder(0, "Ferran", 19, c1);
        Player p9 = new Outfielder(0, "Pere", 19, c1);
        Player p10 = new Goalkeeper(0, "Tania", 19, c1);
        Player p11 = new Goalkeeper(0, "Julia", 19, c1);
        Player p12 = new Goalkeeper(0, "Isa", 19, c1);
        Player p13 = new Goalkeeper(0, "Irene", 19, c1);
        Player p14 = new Goalkeeper(0, "Claudia", 19, c1);
        Player p15 = new Goalkeeper(0, "Jana", 19, c1);
        Player p16 = new Goalkeeper(0, "Marta", 19, c1);
        Player p17 = new Goalkeeper(0, "Laura", 19, c1);
        Player p18 = new Goalkeeper(0, "Clara", 19, c1);
        Player p19 = new Outfielder(0, "Savio", 19, c1);
        Player p20 = new Outfielder(0, "Aleix", 19, c1);
        Player p21 = new Outfielder(0, "Stuani", 19, c1);
        Player p22 = new Outfielder(0, "Arnau", 19, c1);
        Player p23 = new Outfielder(0, "Gazzaniga", 19, c1);
        Player p24 = new Outfielder(0, "Blind", 19, c1);
        Player p25 = new Outfielder(0, "Eric", 19, c1);
        Player p26 = new Outfielder(0, "Viktor", 19, c1);
        Player p27 = new Outfielder(0, "Dovbyk", 19, c1);
        

        t1.addPlayer(p1);
        t2.addPlayer(p2);
        t3.addPlayer(p3);
        t4.addPlayer(p4);
        t5.addPlayer(p5);
        t6.addPlayer(p6);
        t7.addPlayer(p7);
        t8.addPlayer(p8);
        t9.addPlayer(p9);
        t1.addPlayer(p10);
        t2.addPlayer(p11);
        t3.addPlayer(p12);
        t4.addPlayer(p13);
        t5.addPlayer(p14);
        t6.addPlayer(p15);
        t7.addPlayer(p16);
        t8.addPlayer(p17);
        t9.addPlayer(p18);
        t1.addPlayer(p19);
        t2.addPlayer(p20);
        t3.addPlayer(p21);
        t4.addPlayer(p22);
        t5.addPlayer(p23);
        t6.addPlayer(p24);
        t7.addPlayer(p25);
        t8.addPlayer(p26);
        t9.addPlayer(p27);
        

        GroupPlay comp = new GroupPlay(true, "LaLiga", c1, 0, 3);
        League  l1 = new League(true, "Premier", c1, 0);
        League l2 = new League(true, "Bundes", c1, 0);
        League l3 = new League(true, "Calcio", c1, 0);
        comp.addLeague(l1);
        comp.addLeague(l2);
        comp.addLeague(l3);

        
        comp.addTeam(t1);        
        comp.addTeam(t2);
        comp.addTeam(t3);
        comp.addTeam(t4);
        comp.addTeam(t5);        
        comp.addTeam(t6);
        comp.addTeam(t7);
        comp.addTeam(t8);
        comp.addTeam(t9);

       
        comp.formGroups();
        comp.printGroups();
        comp.generateMatches();
        comp.simulateMatches();
        comp.printMatches();      
        comp.printGoalScorers(5);
        comp.printTables();

        System.out.println("\n\nSecond test\n");
        

        Competition l = new League(true, "Copa del Rey", c1, 0);

        l.addTeam(t1);        
        l.addTeam(t2);
        l.addTeam(t3);
        l.addTeam(t4);
        l.addTeam(t5);        
        l.addTeam(t6);
        l.addTeam(t7);
        l.addTeam(t8);
        l.addTeam(t9);

        l.generateMatches();
        l.simulateMatches();
        l.printMatches();
        ((League)l).printTable();
        l.printGoalScorers(5);
        
    }
}
