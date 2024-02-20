import EvaluationLibary.Evaluation;
import EvaluationLibary.PrisonerEvaluation;
import Prisoner.Prisoner;
import Prisoner.PrisonerA;
import Prisoner.PrisonerB;

public class Main {


    public static void main(String[] args) {

        PrisonerA pri1 = new PrisonerA();
        PrisonerA pri2 = new PrisonerA();
        PrisonerB pri3 = new PrisonerB();
        PrisonerB pri4 = new PrisonerB();
        PrisonerB pri5 = new PrisonerB();
        PrisonerA pri6 = new PrisonerA();

        Prisoner[] prisoners = {pri1, pri2, pri3, pri4, pri5};

        Evaluation evaluates = new PrisonerEvaluation();

        evaluates.evaluation(prisoners);

    }
}
