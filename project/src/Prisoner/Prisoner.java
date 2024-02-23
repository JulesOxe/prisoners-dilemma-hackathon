package Prisoner;

/**
 * Abstract class for a prisoner module, which generates a decision based on the previous decisions of the opponent and the prisoner itself
 */
public abstract class Prisoner implements DecisionMaking {

    //Team name of the participant
    protected String teamName = "";

    /**
     * returns the team name of the participant
     *
     * @return team name of the participant
     */
    public String getTeamName() {
        return teamName;
    }
}

