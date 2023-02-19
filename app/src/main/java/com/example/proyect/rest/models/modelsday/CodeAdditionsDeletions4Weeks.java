
package com.example.proyect.rest.models.modelsday;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CodeAdditionsDeletions4Weeks {

    @SerializedName("additions")
    @Expose
    private Double additions;
    @SerializedName("deletions")
    @Expose
    private Double deletions;

    public Double getAdditions() {
        return additions;
    }

    public void setAdditions(Double additions) {
        this.additions = additions;
    }

    public Double getDeletions() {
        return deletions;
    }

    public void setDeletions(Double deletions) {
        this.deletions = deletions;
    }

}
