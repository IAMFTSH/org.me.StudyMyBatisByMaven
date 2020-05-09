package org.studyMybatisByMaven.entity;

import java.util.List;

public class Grade {
    private List ids;

    public Grade(List ids) {
        this.ids = ids;
    }

    public List getIds() {
        return ids;
    }

    public void setIds(List ids) {
        this.ids = ids;
    }
}
