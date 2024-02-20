package HelperClasses;

import Prisoner.Prisoner;

import java.util.Comparator;

public class PrisonerPrisonYearsPair extends Pair<Prisoner, Integer>{

public PrisonerPrisonYearsPair(Prisoner first, Integer second) {
        super(first, second);
    }

    public static Comparator<PrisonerPrisonYearsPair> PrisonYearsComparator = new Comparator<PrisonerPrisonYearsPair>() {

        public int compare(PrisonerPrisonYearsPair p1, PrisonerPrisonYearsPair p2) {
            Integer prisonYears1 = p1.getSecond();
            Integer prisonYears2 = p2.getSecond();
            return prisonYears1.compareTo(prisonYears2);
        }
    };
}
