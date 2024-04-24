package SoSe23.B_Uebung.uebung08_sub_3_5P.A38_A39b;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Team {

    // --------------------------------------

    // Attribute
    private static Set<String> teamNames = new HashSet<>();
    
    private String name;
    private Set<Player> players = new HashSet<>();

    // --------------------------------------

    // Konstruktor
    public Team(String name, Player[] players) {
        if (teamNames.contains(name)) {
            throw new IllegalArgumentException("Team name must be unique");
        }
        this.name = name;
        teamNames.add(name);
        for (Player player : players) {
            addPlayer(player);
        }
    }

    // --------------------------------------
    
    public void addPlayer(Player player) {
        players.add(player);
        player.setTeam(this);
    }

    // --------------------------------------

    // removePlayer
    public void removePlayer(Player player) {
        players.remove(player);
    }

    // --------------------------------------
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // --------------------------------------

}
