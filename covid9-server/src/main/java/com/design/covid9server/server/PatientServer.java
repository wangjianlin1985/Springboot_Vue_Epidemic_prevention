package com.design.covid9server.server;

import com.design.covid9server.dto.PatientL2Dto;
import com.design.covid9server.entity.*;

import java.util.List;
import java.util.Map;

public interface PatientServer {

    int savePatientL1(PatientL1 patientL1);

    List<PatientL1> selectByPage(int currPage);

    long selectCountAll();

    int updateById(PatientL1 patientL1);

    int deleteById(int id);

    int saveCheckRecord(CheckRecord checkRecord);

    List<CheckRecord> selectCheckRecordByPatentId(CheckRecord checkRecord);

    int savePatientL2(PatientL2 patientL2);

    List<PatientL2> selectPatientL2ByPage(int currPage);

    long selectPatientL2CountAll();

    PatientL2 selectByPatientId(int patientId);

    int updatePatientL2ById(PatientL2 patientL2);

    int deletePatientL2ById(int id);

    int saveWatchL1(WatchL1 watchL1);

    int saveWatchL2(WatchL2 watchL2);

    WatchL1 selectWatchL1ByPatientId(int patientL1);

    int updateWatchStatusByPatient(PatientL2 patientL2);

    WatchL2 selectWatchL2ByPatientId(int patientId);

    int saveWatchL3(WatchL3 watchL3);

    WatchL3 selectWatchL3ByPatientId(int patientId);

    int savePatientL3(PatientL3 patientL3);

    List<PatientL3> selectPatientL3ByPage(int currPage);

    long selectPatientL3CountAll();

    int updatePatientL3ById(PatientL3 patientL3);

    int deletePatientL3ById(int id);

    int savePatientL4(PatientL4 patientL4);

    List<PatientL4> selectPatientL4ByPage(int currPage);

    long selectPatientL4CountAll();

    int updatePatientL4ById(PatientL4 patientL4);

    int deletePatientL4ById(int id);

    int saveNews(News news);

    List<News> selectNewsByPage(int currPage);

    long selectNewsCountAll();

    int updateNewsById(News news);

    int deleteNewsById(int id);

    int saveLeader(Leader leader);

    List<Leader> selectLeaderByPage(int currPage);

    long selectLeaderCountAll();

    int updateLeaderById(Leader leader);

    int deleteLeaderById(int id);

    Map<String, List<PatientL2Dto>> selectCountByFromCity();
}
