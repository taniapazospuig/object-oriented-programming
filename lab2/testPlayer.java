public class testPlayer {
    public static void main(String[] as){
        // Create countries
        Country country1 = new Country("Spain");
        Country country2 = new Country("England");

        // Create players
        Player player1 = new Player(0, "Pol", 20, country1);
        Player player2 = new Player(0, "Aniol", 19, country2);
        Player player3 = new Player(0, "Jan", 22, country1);
        Player player4 = new Player(0, "Gerard", 18, country2);

        // Create a team
        Team team1 = new Team("Girona", country1, 0);
        Team team2 = new Team("Manchester", country2, 0);

        // Add players to teams
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team2.addPlayer(player3);
        team2.addPlayer(player4);

        
        // Play matches
        team1.playMatch(2, 1);
        team1.playMatch(3, 3);

        //Print team stats
        team1.printStats();

        // Update and print player stats
        player1.update(5, 10, 2, 3, 1);
        player1.printStats();

        //Create league and add teams
        League league = new League("LaLiga", country1, 0);
        league.addTeam(team2);
        league.addTeam(team1);

        //Generate and play matches
        league.generateMatches();
        league.simulateMatches();
        league.printMatches();

        team1.printStats();
    }
    
}
