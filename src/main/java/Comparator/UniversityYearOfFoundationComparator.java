package Comparator;

import Model.University;

public class UniversityYearOfFoundationComparator implements UniversityComparator{
    @Override
    public int compare(University uni1, University uni2) {
        return Integer.compare(uni1.getYearOfFoundation(),uni2.getYearOfFoundation());
    }
}
