package B_Uebung.uebung08_sub_3_5P.A38_A39b;


import java.util.Objects;

class Player {

    // --------------------------------------

    // Attribute
    private String name;
    private Team team;

    // --------------------------------------

    // Konstruktor
    public Player(String name, Team team) {
        this.name = name;
        setTeam(team);
    }

    // --------------------------------------

    //setTeam
    public void setTeam(Team team) {
        if (Objects.equals(this.team, team)) {
            return; // Avoid recursion
        }

        this.team = team;
        team.addPlayer(this);

        }
    
    // --------------------------------------

    // GetTeam
    public Team getTeam() {
        return team;
    }

    // --------------------------------------

}
