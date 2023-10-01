package B_Uebung.uebung08_sub_3_5P.A38_A39b_neu;

public class Match_neu {

    Team_neu team1;
    Team_neu team2;

    public Match_neu(Team_neu team1, Team_neu team2, Team_neu winner) {

        if (team1.equals(team2)){

            throw new IllegalArgumentException("Teams müssen unterschiedlich sein");

        }

        else if (!winner.equals(team1) && !winner.equals(team2)){
            throw new IllegalArgumentException("Es muss einen Sieger geben");
        }

    }
    
}
