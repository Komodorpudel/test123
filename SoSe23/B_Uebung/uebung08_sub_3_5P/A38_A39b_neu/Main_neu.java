package SoSe23.B_Uebung.uebung08_sub_3_5P.A38_A39b_neu;

import java.util.HashSet;

public class Main_neu {
    public static void main(String[] args) {

        Team_neu team1 = new Team_neu("Team1", new HashSet<Player_neu>());
        Team_neu team2 = new Team_neu("Team2", new HashSet<Player_neu>());

        Player_neu player1 = new Player_neu("Player1", team1);
        Player_neu player2 = new Player_neu("Player2", team2);


        System.out.println(player1.getlinkTeam().equals(team1)); // Should be true
        System.out.println(player2.getlinkTeam().equals(team2)); // Should be true

        Player_neu player3 = new Player_neu("Player3", team2);


        System.out.println("Player 3:");
        System.out.println(player3);

        player3.linkTeam(team1);
        System.out.println(player3.getlinkTeam());


        System.out.println("\nTeam1");
        for (Player_neu player : team1.getlinkPlayers()){
            System.out.println(player);
        }

        System.out.println("\nTeam2");
        for (Player_neu player : team2.getlinkPlayers()){
            System.out.println(player);
        }

        System.out.println ("\nLinkPlayer (player3) to team 2");
        team2.linkPlayer(player3);


                System.out.println("\nTeam1");
        for (Player_neu player : team1.getlinkPlayers()){
            System.out.println(player);
        }

        System.out.println("\nTeam2");
        for (Player_neu player : team2.getlinkPlayers()){
            System.out.println(player);
        }

    }
}
