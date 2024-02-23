package Prisoner;

import java.util.ArrayList;

public class PrisonerG extends Prisoner {

    private Boolean result = false;

    public PrisonerG() {
        teamName = "OpponentSavedResult";
    }

    public Boolean makeDecision(ArrayList<Boolean> myDecisions, ArrayList<Boolean> opponentDecisions) {
        if (!opponentDecisions.isEmpty()) {
            if (opponentDecisions.get(opponentDecisions.size() - 1)) {
                result = !result;
            }
        }
        return result;
    }

    public void reset() {
        result = false;
    }
}

