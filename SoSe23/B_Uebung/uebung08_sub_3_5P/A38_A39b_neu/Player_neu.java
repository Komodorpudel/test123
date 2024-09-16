package SoSe23.B_Uebung.uebung08_sub_3_5P.A38_A39b_neu;

public class Player_neu {

    private String name;
    private Team_neu team;

    public Player_neu (String name, Team_neu team){

        this.name = name;
        linkTeam(team);

    }


    public void linkTeam (Team_neu team){

        if (this.team != null) {
            this.team.unlinkPlayer(this); // if already in a team, wo unlink player
        }
        
        this.team = team; // Player gets info which team he belongs to


        if (!team.getlinkPlayers().contains(this)){

            team.linkPlayer(this); // team gets info that player belongs to team

        }

    }

    public Team_neu getlinkTeam (){

        return this.team;
        
    }

    public void unlinkTeam (Team_neu team){

        this.team = null;

        if (team.getlinkPlayers().contains(this)){

            team.unlinkPlayer(this);
        }

    }

    @Override
    public String toString(){
        return "(" + name + ": " + team + ")";
    }
    
}
