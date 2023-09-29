package B_Uebung.uebung08_sub_3_5P.A38_A39b_neu;

import java.util.HashMap;
import java.util.HashSet;

public class Team_neu {

    private String name;
    private HashSet <Player_neu> players = new HashSet<>();

    private static HashMap <String, Team_neu> teams = new HashMap<>();

    public Team_neu (String name, HashSet<Player_neu> players) {

        if (teams.containsKey(name)) {

            throw new IllegalArgumentException("Name schon vergeben");

        }

        else {

            this.name = name;
            this.players = players;

            teams.put(name, this);
        }

    }
    
    public void linkPlayer(Player_neu player) {

        players.add(player);

        if (player.getlinkTeam() != this ){
        
            player.linkTeam(this);

        }

    }

    public void unlinkPlayer(Player_neu player){

        this.players.remove(player);

        if (player.getlinkTeam() == this)
        player.unlinkTeam(this);


    }

    public HashSet<Player_neu> getlinkPlayers(){

        return players;
    }

    @Override

    public boolean equals (Object o) {

        if (o == null){
            return false;
        }

        else if (! (o instanceof Team_neu)) {
            return false;
        }
        
        Team_neu temp = (Team_neu) o;

        return temp.name.equals(this.name);


    }
    
}
