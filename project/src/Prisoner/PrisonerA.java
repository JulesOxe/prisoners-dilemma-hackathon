package Prisoner;

import java.util.ArrayList;

public class PrisonerA extends Prisoner {

    public PrisonerA() {
        teamName = "Bob";
    }

    public Boolean makeDecision(ArrayList<Boolean> myDecisions, ArrayList<Boolean> opponentDecisions) {
        return false;
    }

}