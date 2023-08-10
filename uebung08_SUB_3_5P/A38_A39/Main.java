package uebung08_sub_3_5P.A38_A39;

public class Main {
    public static void main(String[] args) {

        Team team1 = new Team("Team1", new Player[]{});
        Team team2 = new Team("Team2", new Player[]{});

        Player player1 = new Player("Player1", team1);
        Player player2 = new Player("Player2", team2);
        
        System.out.println(player1.getTeam().equals(team1)); // Should be true
        System.out.println(player2.getTeam().equals(team2)); // Should be true
    }
}
