package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class Validator {

	public static <E> boolean criteriaValidator(Criteria<E> criteria) {
	    boolean valid = true;
		if (criteria == null) {
            valid = false;
        }
		if (criteria.getCriteria().isEmpty()) {
            valid = false;
        }
        if (criteria.getApplianceType() == null){
		    return false;
        }
        switch (criteria.getApplianceType()){
            case "Oven":
                break;
            case "Laptop":
                break;
            case "Refrigerator":
                break;
            case "VacuumCleaner":
                break;
            case "TabletPC":
                break;
            case "Speakers":
                break;
            default:
                valid = false;
        }
		return valid;
	}
}
