import java.util.ArrayList;

public class PrisonerA extends Prisoner {

    public PrisonerA() {
        teamName = "";
    }

    public Boolean makeDecision(ArrayList<Boolean> myDecisions, ArrayList<Boolean> opponentDecisions) {
        return false;
    }

}
