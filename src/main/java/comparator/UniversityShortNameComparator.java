package comparator;

import model.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityShortNameComparator implements UniversityComparator{
    @Override
    public int compare(University uni1, University uni2) {
        return StringUtils.compare(uni1.getShortName(),uni2.getShortName());
    }
}
