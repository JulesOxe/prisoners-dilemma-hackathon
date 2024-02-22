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
import Prisoner.PrisonerI;

import java.time.chrono.MinguoDate;
/**
 *A small hackathon project in which a group of friends can develop several small algorithms
 * that then compete against each other
 * in the context of the Prisoner's dilemma.
 *
 *
 * @author Julius Oexle
 * @version 1.0
 */


/**
 * Main class to start the evaluation of the tournament.
 */
public class Main {
    public static void main(String[] args) {

        //TODO: Create an object of each class of each participant
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
        PrisonerI pri17= new PrisonerI();
        PrisonerI pri18= new PrisonerI();


        //TODO: Put every object in this array
        Prisoner[] prisoners = {
                pri1, pri2, pri3, pri4,
                pri5, pri6, pri7, pri8,
                pri9, pri10, pri11, pri12,
                pri13, pri14, pri15, pri16,
                pri17, pri18
        };


        Evaluation evaluates = new PrisonerEvaluation();

        //an evaluation is generated, which can be found in the Results.md file
        //the number of rounds each prisoner should play against each other is 10000 (can be changed)
        evaluates.evaluation(prisoners, 10000);
    }
}
