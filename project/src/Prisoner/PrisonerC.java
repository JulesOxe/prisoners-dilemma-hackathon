package Prisoner;

import java.util.ArrayList;

public class PrisonerC extends Prisoner {

    public PrisonerC() {
        teamName = "Random";
    }

    public Boolean makeDecision(ArrayList<Boolean> myDecisions, ArrayList<Boolean> opponentDecisions) {
        double random = (Math.random() * 10) + 1;
        return random > 5;
    }

    public void reset() {
    }

}
