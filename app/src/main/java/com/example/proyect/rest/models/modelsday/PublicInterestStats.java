
package com.example.proyect.rest.models.modelsday;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublicInterestStats {

    @SerializedName("alexa_rank")
    @Expose
    private Double alexaRank;
    @SerializedName("bing_matches")
    @Expose
    private Object bingMatches;

    public Double getAlexaRank() {
        return alexaRank;
    }

    public void setAlexaRank(Double alexaRank) {
        this.alexaRank = alexaRank;
    }

    public Object getBingMatches() {
        return bingMatches;
    }

    public void setBingMatches(Object bingMatches) {
        this.bingMatches = bingMatches;
    }

}
