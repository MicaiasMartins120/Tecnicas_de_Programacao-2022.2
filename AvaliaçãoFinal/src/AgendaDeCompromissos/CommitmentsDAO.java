package AgendaDeCompromissos;

public class CommitmentsDAO {
	private String[] commitmentsList = {"", "", "", "", "", "", "", "", "", "", "", ""};
	
	public CommitmentsDAO() {
		
	}
	
	public String[] getCommitmentsList() {
		return commitmentsList;
	}

	public void setCommitment(int i,String commitment) {
		this.commitmentsList[i] = commitment;
	}
}
