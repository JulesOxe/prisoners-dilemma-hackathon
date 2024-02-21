import EvaluationLibary.Evaluation;
import EvaluationLibary.PrisonerEvaluation;
import Prisoner.Prisoner;
import Prisoner.PrisonerA;
import Prisoner.PrisonerB;
import Prisoner.PrisonerC;
import Prisoner.PrisonerD;
import Prisoner.PrisonerE;
import Prisoner.PrisonerF;
import Prisoner.PrisonerG;
import Prisoner.PrisonerH;

public class Main {


    public static void main(String[] args) {

        PrisonerA pri1 = new PrisonerA();
        PrisonerA pri2 = new PrisonerA();
        PrisonerB pri3 = new PrisonerB();
        PrisonerB pri4 = new PrisonerB();
        PrisonerC pri5 = new PrisonerC();
        PrisonerC pri6 = new PrisonerC();
        PrisonerD pri7 = new PrisonerD();
        PrisonerD pri8 = new PrisonerD();
        PrisonerE pri9 = new PrisonerE();
        PrisonerE pri10 = new PrisonerE();
        PrisonerF pri11 = new PrisonerF();
        PrisonerF pri12 = new PrisonerF();
        PrisonerG pri13 = new PrisonerG();
        PrisonerG pri14= new PrisonerG();
        PrisonerH pri15= new PrisonerH();
        PrisonerH pri16= new PrisonerH();


        Prisoner[] prisoners = {pri1, pri2, pri3, pri4, pri5, pri6, pri7, pri8, pri9, pri10, pri11, pri12, pri13, pri14, pri15, pri16};

        Evaluation evaluates = new PrisonerEvaluation();

        evaluates.evaluation(prisoners);

    }
}
