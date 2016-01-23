package Message;
import java.io.Serializable;

public class CompetitorMessage implements Serializable {
	
	//competition_id Capation Teammate1 Teammate2 Award
	private String competition_id;
	private String capation;
	private String teammate1;
	private String teammate2;
	private String award;
	
	public String getCompetition_id() {
		return competition_id;
	}
	public void setCompetition_id(String competition_id) {
		this.competition_id = competition_id;
	}
	public String getCapation() {
		return capation;
	}
	public void setCapation(String capation) {
		this.capation = capation;
	}
	public String getTeammate1() {
		return teammate1;
	}
	public void setTeammate1(String teammate1) {
		this.teammate1 = teammate1;
	}
	public String getTeammate2() {
		return teammate2;
	}
	public void setTeammate2(String teammate2) {
		this.teammate2 = teammate2;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	

}
