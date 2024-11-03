package lab1;

public class testPlayer {
    public static void main(String[] as){
        // Create countries
        Country country1 = new Country("Spain");
        Country country2 = new Country("England");

        // Create players
        Player player1 = new Player(0, "Pol", 20, country1);
        Player player2 = new Player(1, "Tania", 19, country2);
        Player player3 = new Player(0, "Jan", 22, country1);
        Player player4 = new Player(1, "Jana", 18, country2);

        // Create a team
        Team team1 = new Team("Girona", country1, 0);
        Team team2 = new Team("Manchester", country2, 1);

        // Add players to teams
        team1.addPlayer(player1);
        team2.addPlayer(player2);
        team1.addPlayer(player3);
        team2.addPlayer(player4);

        
        // Play a match
        team1.playMatch(2, 1);
        team2.playMatch(3, 3);

        // Print player statistics
        player1.update(5, 10, 2, 3, 1);
        player1.printStats();

        player2.update(8, 15, 4, 6, 2);
        player2.printStats();

        player3.update(7, 23, 5, 1, 4);
        player3.printStats();

        player4.update(12, 8, 1, 0, 1);
        player4.printStats();


        // Print team statistics
        team1.printStats();
        team2.printStats();

        // Remove a player from each team
        team1.removePlayer(player1);
        team2.removePlayer(player2);

        team1.printStats();
        team2.printStats();

        
    }
    
}
