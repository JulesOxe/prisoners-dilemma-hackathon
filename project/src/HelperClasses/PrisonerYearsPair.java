package HelperClasses;

import Prisoner.Prisoner;

import java.util.Comparator;

public class PrisonerYearsPair extends Pair<Prisoner, Integer>{

public PrisonerYearsPair(Prisoner first, Integer second) {
        super(first, second);
    }

    public static Comparator<PrisonerYearsPair> PrisonYearsComparator = new Comparator<PrisonerYearsPair>() {

        public int compare(PrisonerYearsPair p1, PrisonerYearsPair p2) {
            Integer prisonYears1 = p1.getSecond();
            Integer prisonYears2 = p2.getSecond();
            return prisonYears1.compareTo(prisonYears2);
        }
    };
}
