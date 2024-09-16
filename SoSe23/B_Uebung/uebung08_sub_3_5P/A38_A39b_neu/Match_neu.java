package SoSe23.B_Uebung.uebung08_sub_3_5P.A38_A39b_neu;

public class Match_neu {

    Team_neu team1;
    Team_neu team2;
    Team_neu winner;

    public Match_neu(Team_neu team1, Team_neu team2, Team_neu winner) {

        if (team1.equals(team2)){

            throw new IllegalArgumentException("Teams müssen unterschiedlich sein");

        }

        else if (!winner.equals(team1) && !winner.equals(team2)){
            throw new IllegalArgumentException("Es muss einen Sieger geben");
        }

        this.team1 = team1
        this.team2 = team2
        this.winner = winner

        // Think of a database where you enter matches

    }
    
}
