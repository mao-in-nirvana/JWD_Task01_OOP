package by.tc.task01.finder;

import by.tc.task01.dataprovider.DataProvider;
import by.tc.task01.entity.criteria.Criteria;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ApplianceFinder {
        public <E> String finder(File file, Criteria<E> criteria) {
            DataProvider dataProvider = new DataProvider();
            List<String> criteriaList = new ArrayList<>();
            if (criteria.getApplianceType() != null){
                criteriaList.add(criteria.getApplianceType());
            } else {
                return null;
            }
            criteria.getCriteria().forEach((key, value) ->
                    criteriaList.add((key + "=" + value)));
            List<String> applianceData = dataProvider.readDataFromFile(file);
            for (String string : applianceData) {
                boolean found = criteriaList.stream().allMatch(string::contains);
                if (found){
                    return string;
                }
            }
            return null;
        }
}
