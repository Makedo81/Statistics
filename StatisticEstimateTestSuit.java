package com.kodilla.testing.forum.statistics;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticEstimateTestSuit {
    @Test
    public void testCalculateAdvStatisticsAveragePostPerUserForPostNumberEqualsZero() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticEstimate estimator = new StatisticEstimate(statisticsMock);

        int postsNumber = 0;
        when(statisticsMock.postsCount()).thenReturn(postsNumber);

        ArrayList<String> users = new ArrayList<>();
        for(int i=0;i<100;i++){
            users.add("user"+i);}

        when(statisticsMock.userNames()).thenReturn(users);

        //when
        estimator.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(0,estimator.getAveragePostPerUser(),0);
    }
    @Test
    public void testCalculateAdvStatisticsAveragePostPerUserForPostNumberEquals1000() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticEstimate estimator = new StatisticEstimate(statisticsMock);

        int postsNumber = 1000;
        when(statisticsMock.postsCount()).thenReturn(postsNumber);
        ArrayList<String> users = new ArrayList<>();
        for(int i=0;i<100;i++){
        users.add("user"+i);}

        when(statisticsMock.userNames()).thenReturn(users);
        //when
        estimator.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(10,estimator.getAveragePostPerUser(),0);
    }
    @Test
    public void testCalculateAdvStatisticsAveragePostPerUserForUserNumberEquals0() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticEstimate estimator = new StatisticEstimate(statisticsMock);

        int postsNumber = 1000;
        when(statisticsMock.postsCount()).thenReturn(postsNumber);
        ArrayList<String> users = new ArrayList<>();
        when(statisticsMock.userNames()).thenReturn(users);
        //when
        estimator.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(0,estimator.getAveragePostPerUser(),0);
    }
    @Test
    public void testCalculateAdvStatisticsAveragePostPerUserForUserNumberEquals0AndPostsNumberEquals0() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticEstimate estimator = new StatisticEstimate(statisticsMock);

        int postsNumber = 0;
        when(statisticsMock.postsCount()).thenReturn(postsNumber);
        ArrayList<String> users = new ArrayList<>();

        when(statisticsMock.userNames()).thenReturn(users);
        //when
        estimator.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(0,estimator.getAveragePostPerUser(),0);
    }
    @Test
    public void testCalculateAdvStatisticsForCommentsNumberLessThanPostNumber() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticEstimate estimator = new StatisticEstimate(statisticsMock);

        int commentsNumber = 7;
        when(statisticsMock.commentsCount()).thenReturn(commentsNumber);

        int postsNumber = 1000;
        when(statisticsMock.postsCount()).thenReturn(postsNumber);
        //when
        estimator.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(0.007,estimator.averageCommentsPerPost,0);
    }
    @Test
    public void testCalculateAdvStatisticsAverageCommentsPerPostForCommentsNumberMoreThanPostNumber() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticEstimate estimator = new StatisticEstimate(statisticsMock);
        int commentsNumber = 1500;
        when(statisticsMock.commentsCount()).thenReturn(commentsNumber);
        int postsNumber = 1000;
        when(statisticsMock.postsCount()).thenReturn(postsNumber);

        //when
        estimator.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(1.5,estimator.getAverageCommentsPerPost(), 0);
    }
    @Test
    public void testCalculateAdvStatisticsAveragePostPerUserForCommentsNumberEquals0() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticEstimate estimator = new StatisticEstimate(statisticsMock);

        int commentsNumber = 0;
        when(statisticsMock.commentsCount()).thenReturn(commentsNumber);

        ArrayList<String> users = new ArrayList<>();
        for(int i=0;i<100;i++){
            users.add("user"+i);
        }

        when(statisticsMock.userNames()).thenReturn(users);
        //when
        estimator.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(0,estimator.getAverageCommentsPerUser(),0);
    }
}
