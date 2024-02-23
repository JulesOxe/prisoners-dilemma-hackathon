package Prisoner;

import java.util.ArrayList;

public class PrisonerB extends Prisoner {
    public PrisonerB() {
        teamName = "AlwaysTrue";
    }

    public Boolean makeDecision(ArrayList<Boolean> myDecisions, ArrayList<Boolean> opponentDecisions) {
        return true;
    }

    public void reset() {
    }
}
