package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dataprovider.FileCreator;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.finder.ApplianceFinder;

import java.io.File;
import java.io.IOException;

public class ApplianceDAOImpl implements ApplianceDAO {
    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        Appliance appliance = null;
        ApplianceFinder applianceFinder = new ApplianceFinder();
        FileCreator fileCreator = new FileCreator();
        File file = null;
        try {
            file = fileCreator.createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String applianceString = applianceFinder.finder(file, criteria);
        if (applianceString == null){
            return null;
        }
        final String TYPE_REGEX = "\\s:\\s";
        final String END_REGEX = ";";
        final String COMMA_REGEX = ",\\s";
        final String EQUALITY_REGEX = "=";
        String type = applianceString.split(TYPE_REGEX)[0].toUpperCase();
        String[] parameters= applianceString.split(TYPE_REGEX)[1].split(END_REGEX)[0].split(COMMA_REGEX);
        switch (type){
            case "OVEN":
                appliance = new Oven(Integer.parseInt(parameters[0].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[1].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[2].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[3].split(EQUALITY_REGEX)[1]),
                        Double.parseDouble(parameters[4].split(EQUALITY_REGEX)[1]),
                        Double.parseDouble(parameters[5].split(EQUALITY_REGEX)[1]));
                break;
            case "LAPTOP":
                appliance = new Laptop(Double.parseDouble(parameters[0].split(EQUALITY_REGEX)[1]),
                        parameters[1].split(EQUALITY_REGEX)[1].toUpperCase(),
                        Integer.parseInt(parameters[2].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[3].split(EQUALITY_REGEX)[1]),
                        Double.parseDouble(parameters[4].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[5].split(EQUALITY_REGEX)[1]));
                break;
            case "REFRIGERATOR":
                appliance = new Refrigerator(Integer.parseInt(parameters[0].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[1].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[2].split(EQUALITY_REGEX)[1]),
                        Double.parseDouble(parameters[3].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[4].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[5].split(EQUALITY_REGEX)[1]));
                break;
            case "VACUUMCLEANER":
                appliance = new VacuumCleaner(Integer.parseInt(parameters[0].split(EQUALITY_REGEX)[1]),
                        parameters[1].split(EQUALITY_REGEX)[1].toUpperCase(),
                        parameters[2].split(EQUALITY_REGEX)[1].toUpperCase(),
                        parameters[3].split(EQUALITY_REGEX)[1].toUpperCase(),
                        Integer.parseInt(parameters[4].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[5].split(EQUALITY_REGEX)[1]));
                break;
            case "TABLETPC":
                appliance = new TabletPC(Integer.parseInt(parameters[0].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[1].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[2].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[3].split(EQUALITY_REGEX)[1]),
                        parameters[4].split(EQUALITY_REGEX)[1].toUpperCase());
            case "SPEAKERS":
                appliance = new Speakers(Integer.parseInt(parameters[0].split(EQUALITY_REGEX)[1]),
                        Integer.parseInt(parameters[1].split(EQUALITY_REGEX)[1]),
                        parameters[2].split(EQUALITY_REGEX)[1].toUpperCase(),
                        Integer.parseInt(parameters[3].split(EQUALITY_REGEX)[1]));
                break;
        }
        return appliance;
    }

}
