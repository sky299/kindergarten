package com.jckj.model;

public class TRStudentGuardian {
    private Integer id;

    private Integer guardian_id;

    private Integer child_id;

    private String relation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuardian_id() {
        return guardian_id;
    }

    public void setGuardian_id(Integer guardian_id) {
        this.guardian_id = guardian_id;
    }

    public Integer getChild_id() {
        return child_id;
    }

    public void setChild_id(Integer child_id) {
        this.child_id = child_id;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }
}