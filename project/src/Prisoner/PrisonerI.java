package Prisoner;

import java.util.ArrayList;

public class PrisonerI extends Prisoner {

    public PrisonerI() {
        teamName = "Tit or Tat";
    }

    private Boolean firstDecision = false;

    public Boolean makeDecision(ArrayList<Boolean> myDecisions, ArrayList<Boolean> opponentDecisions) {
        if (!opponentDecisions.isEmpty()) {
            return opponentDecisions.get(opponentDecisions.size() - 1);
        }
        return firstDecision;
    }

    public void reset() {
    }

}