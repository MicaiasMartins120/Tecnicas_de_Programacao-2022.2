package trabalho3;

import java.util.ArrayList;

public class SemiTeamsDAO {
	private ArrayList<TeamDAO> teamList;
	
	public SemiTeamsDAO(ArrayList<TeamDAO> teamList) {
		this.teamList = teamList;
	}

	public ArrayList<TeamDAO> getTeamList() {
		return teamList;
	}

	public void setTeamList(TeamDAO team) {
		this.teamList.add(team);
	}
}
