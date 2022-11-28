package by.itstep.vikvik.model.logic;

import by.itstep.vikvik.model.entity.Group;

public class Manager {

    public static double calculateAvgMark(Group group) {
        double total = 0;

        for (int i = 0; i < group.size(); i++) {
            total += group.get(i).getMark();
        }

        return total / group.size();
    }
}
