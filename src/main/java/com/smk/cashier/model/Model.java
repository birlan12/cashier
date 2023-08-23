package com.smk.cashier.model;

import java.util.Date;

public abstract class Model {
    protected Date dateCreated;
    protected Date lastModified;
    protected String createdBy;
    protected String undatedBy;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUndatedBy() {
        return undatedBy;
    }

    public void setUndatedBy(String undatedBy) {
        this.undatedBy = undatedBy;
    }


}
