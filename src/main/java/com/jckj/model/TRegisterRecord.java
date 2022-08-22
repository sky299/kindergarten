package com.jckj.model;

public class TRegisterRecord {
    private String id;

    private Integer child_id;

    private String record_type;

    private Integer guardian_id;

    private String guardian_name;

    private String child_name;

    private String relation;

    private Long record_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getChild_id() {
        return child_id;
    }

    public void setChild_id(Integer child_id) {
        this.child_id = child_id;
    }

    public String getRecord_type() {
        return record_type;
    }

    public void setRecord_type(String record_type) {
        this.record_type = record_type == null ? null : record_type.trim();
    }

    public Integer getGuardian_id() {
        return guardian_id;
    }

    public void setGuardian_id(Integer guardian_id) {
        this.guardian_id = guardian_id;
    }

    public String getGuardian_name() {
        return guardian_name;
    }

    public void setGuardian_name(String guardian_name) {
        this.guardian_name = guardian_name == null ? null : guardian_name.trim();
    }

    public String getChild_name() {
        return child_name;
    }

    public void setChild_name(String child_name) {
        this.child_name = child_name == null ? null : child_name.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public Long getRecord_time() {
        return record_time;
    }

    public void setRecord_time(Long record_time) {
        this.record_time = record_time;
    }
}