package Message;
import java.io.Serializable;

public class CompetitionMessage implements Serializable {
	
	//competition_id competition_name competition_time 
	private String competition_id;
	private String competition_name;
	private String competition_time;
	
	
	public String getCompetition_id() {
		return competition_id;
	}
	public void setCompetition_id(String competition_id) {
		this.competition_id = competition_id;
	}
	public String getCompetition_name() {
		return competition_name;
	}
	public void setCompetition_name(String competition_name) {
		this.competition_name = competition_name;
	}
	public String getCompetition_time() {
		return competition_time;
	}
	public void setCompetition_time(String competition_time) {
		this.competition_time = competition_time;
	}
	
}
