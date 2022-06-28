package comparators;

import model.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityProfileComparator implements UniversityComparator {
    @Override
    public int compare(University uni1, University uni2) {
        return StringUtils.compare(uni1.getMainProfile().name(), uni2.getMainProfile().name());
    }
}
