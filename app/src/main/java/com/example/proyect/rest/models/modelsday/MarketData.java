
package com.example.proyect.rest.models.modelsday;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarketData {

    @SerializedName("current_price")
    @Expose
    private CurrentPrice currentPrice;
    @SerializedName("market_cap")
    @Expose
    private MarketCap marketCap;
    @SerializedName("total_volume")
    @Expose
    private TotalVolume totalVolume;

    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }

    public MarketCap getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(MarketCap marketCap) {
        this.marketCap = marketCap;
    }

    public TotalVolume getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(TotalVolume totalVolume) {
        this.totalVolume = totalVolume;
    }

}
