package com.clive.common;

import java.io.Serializable;

public class ZTreeNodeResult implements Serializable{

    private Long id;
    private String name;
    private boolean isParent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }

    @Override
    public String toString() {
        return "ZTreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isParent=" + isParent +
                '}';
    }
}
