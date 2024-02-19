import java.util.ArrayList;

public class Evaluation {

    private static final int NUM_ROUNDS = 1000;

    public static void evaluate(Prisoner p1, Prisoner p2) {
        int p1PrisonYears = 0;
        int p2PrisonYears = 0;
        ArrayList<Boolean> p1Decisions = new ArrayList<Boolean>();
        ArrayList<Boolean> p2Decisions = new ArrayList<Boolean>();

        for (int i = 0; i < NUM_ROUNDS; i++) {
            p1Decisions.add(p1.makeDecision(p1Decisions, p2Decisions));
            p2Decisions.add(p2.makeDecision(p2Decisions, p1Decisions));

            p1PrisonYears += calculatePrisonYears(p1Decisions.get(i), p2Decisions.get(i));
            p2PrisonYears += calculatePrisonYears(p2Decisions.get(i), p1Decisions.get(i));
        }

        System.out.println(p1.getTeamName() + " scored " + p1PrisonYears);
        System.out.println(p2.getTeamName() + " scored " + p2PrisonYears);
    }

    private static int calculatePrisonYears (Boolean p1Decision, Boolean p2Decision) {
        if (p1Decision && p2Decision) {
            return 2;
        } else if (p1Decision && !p2Decision) {
            return 0;
        } else if (!p1Decision && p2Decision) {
            return 3;
        }
        return 1;
    }


    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}