package com.project.microservices.StatisticsMicroservice.services;

import com.project.microservices.StatisticsMicroservice.entities.Statistics;

import java.util.List;

public interface StatisticsService {

    List<Statistics> getStatistics(String jwt, String email);
}
