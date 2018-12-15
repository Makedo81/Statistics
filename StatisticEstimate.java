package com.kodilla.testing.forum.statistics;

public class StatisticEstimate  {

    Statistics statistics;
    int postsCount;
    int commentsCount;
    int usersNames;
    double averagePostPerUser;
    double averageCommentsPerUser;
    double averageCommentsPerPost;

    public StatisticEstimate(Statistics statistics) {

        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        usersNames = statistics.userNames().size();

        if (postsCount!=0 && commentsCount>0 || postsCount!=0 && usersNames>0 || commentsCount!=0 && usersNames>0 ){
            averagePostPerUser = (((double)statistics.postsCount() / (double)statistics.userNames().size()));
            averageCommentsPerUser = (((double)statistics.commentsCount() / (double)statistics.userNames().size()));
            averageCommentsPerPost =(((double)statistics.commentsCount()/ (double)statistics.postsCount()));
        } else if (postsCount>0 && commentsCount==0 ||postsCount>0 && usersNames==0 || commentsCount>0 && usersNames==0){
            averagePostPerUser = statistics.userNames().size();
            averageCommentsPerUser = statistics.userNames().size();
            averageCommentsPerPost = statistics.commentsCount();
        }
        else {
            averagePostPerUser = statistics.postsCount();
            averageCommentsPerUser = statistics.commentsCount();
            averageCommentsPerPost = statistics.postsCount();
        }
    }

    public double getAveragePostPerUser() {
        return averagePostPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {

        return averageCommentsPerPost;
    }
}
