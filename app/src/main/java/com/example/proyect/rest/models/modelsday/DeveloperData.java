
package com.example.proyect.rest.models.modelsday;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeveloperData {

    @SerializedName("forks")
    @Expose
    private Double forks;
    @SerializedName("stars")
    @Expose
    private double stars;
    @SerializedName("subscribers")
    @Expose
    private double subscribers;
    @SerializedName("total_issues")
    @Expose
    private Double totalIssues;
    @SerializedName("closed_issues")
    @Expose
    private Double closedIssues;
    @SerializedName("pull_requests_merged")
    @Expose
    private Double pullRequestsMerged;
    @SerializedName("pull_request_contributors")
    @Expose
    private Double pullRequestContributors;
    @SerializedName("code_additions_deletions_4_weeks")
    @Expose
    private CodeAdditionsDeletions4Weeks codeAdditionsDeletions4Weeks;
    @SerializedName("commit_count_4_weeks")
    @Expose
    private Double commitCount4Weeks;

    public Double getForks() {
        return forks;
    }

    public void setForks(Double forks) {
        this.forks = forks;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public Double getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Double subscribers) {
        this.subscribers = subscribers;
    }

    public Double getTotalIssues() {
        return totalIssues;
    }

    public void setTotalIssues(Double totalIssues) {
        this.totalIssues = totalIssues;
    }

    public Double getClosedIssues() {
        return closedIssues;
    }

    public void setClosedIssues(Double closedIssues) {
        this.closedIssues = closedIssues;
    }

    public Double getPullRequestsMerged() {
        return pullRequestsMerged;
    }

    public void setPullRequestsMerged(Double pullRequestsMerged) {
        this.pullRequestsMerged = pullRequestsMerged;
    }

    public Double getPullRequestContributors() {
        return pullRequestContributors;
    }

    public void setPullRequestContributors(Double pullRequestContributors) {
        this.pullRequestContributors = pullRequestContributors;
    }

    public CodeAdditionsDeletions4Weeks getCodeAdditionsDeletions4Weeks() {
        return codeAdditionsDeletions4Weeks;
    }

    public void setCodeAdditionsDeletions4Weeks(CodeAdditionsDeletions4Weeks codeAdditionsDeletions4Weeks) {
        this.codeAdditionsDeletions4Weeks = codeAdditionsDeletions4Weeks;
    }

    public Double getCommitCount4Weeks() {
        return commitCount4Weeks;
    }

    public void setCommitCount4Weeks(Double commitCount4Weeks) {
        this.commitCount4Weeks = commitCount4Weeks;
    }

}
