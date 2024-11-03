package lab4;

public class NationalTeam extends Team{ 
    public NationalTeam(String n, Country c, int g, boolean cl){
        super(n, c, g, cl);
    }

    @Override
    public void addPlayer(Player p){
        if(super.country.equals(p.getNationality())){
            super.addPlayer(p);
        }
        else{
            System.out.println("Can't add a player with a different nationality than the team's");
        }
    }
}
