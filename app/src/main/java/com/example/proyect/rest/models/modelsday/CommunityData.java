
package com.example.proyect.rest.models.modelsday;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommunityData {

    @SerializedName("facebook_likes")
    @Expose
    private Object facebookLikes;
    @SerializedName("twitter_followers")
    @Expose
    private Double twitterFollowers;
    @SerializedName("reddit_average_posts_48h")
    @Expose
    private Double redditAveragePosts48h;
    @SerializedName("reddit_average_comments_48h")
    @Expose
    private Double redditAverageComments48h;
    @SerializedName("reddit_subscribers")
    @Expose
    private Double redditSubscribers;
    @SerializedName("reddit_accounts_active_48h")
    @Expose
    private String redditAccountsActive48h;

    public Object getFacebookLikes() {
        return facebookLikes;
    }

    public void setFacebookLikes(Object facebookLikes) {
        this.facebookLikes = facebookLikes;
    }

    public Double getTwitterFollowers() {
        return twitterFollowers;
    }

    public void setTwitterFollowers(Double twitterFollowers) {
        this.twitterFollowers = twitterFollowers;
    }

    public Double getRedditAveragePosts48h() {
        return redditAveragePosts48h;
    }

    public void setRedditAveragePosts48h(Double redditAveragePosts48h) {
        this.redditAveragePosts48h = redditAveragePosts48h;
    }

    public Double getRedditAverageComments48h() {
        return redditAverageComments48h;
    }

    public void setRedditAverageComments48h(Double redditAverageComments48h) {
        this.redditAverageComments48h = redditAverageComments48h;
    }

    public Double getRedditSubscribers() {
        return redditSubscribers;
    }

    public void setRedditSubscribers(Double redditSubscribers) {
        this.redditSubscribers = redditSubscribers;
    }

    public String getRedditAccountsActive48h() {
        return redditAccountsActive48h;
    }

    public void setRedditAccountsActive48h(String redditAccountsActive48h) {
        this.redditAccountsActive48h = redditAccountsActive48h;
    }

}
