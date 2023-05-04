package com.design.covid9server.server.impl;

import com.design.covid9server.dto.PatientL2Dto;
import com.design.covid9server.entity.*;
import com.design.covid9server.mapper.*;
import com.design.covid9server.server.PatientServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientServerImpl implements PatientServer {

    private static final int PAGESIZE = 10;

    @Autowired
    private PatientL1Mapper patientL1Mapper;

    @Autowired
    private CheckRecordMapper checkRecordMapper;

    @Autowired
    private PatientL2Mapper patientL2Mapper;

    @Autowired
    private WatchL1Mapper watchL1Mapper;

    @Autowired
    private WatchL2Mapper watchL2Mapper;

    @Autowired
    private WatchL3Mapper watchL3Mapper;

    @Autowired
    private PatientL3Mapper patientL3Mapper;

    @Autowired
    private PatientL4Mapper patientL4Mapper;

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private LeaderMapper leaderMapper;

    @Override
    public int savePatientL1(PatientL1 patientL1) {
        return patientL1Mapper.insert(patientL1);
    }

    @Override
    public List<PatientL1> selectByPage(int currPage) {
        int start = PAGESIZE * (currPage - 1);
        return patientL1Mapper.selectByPage(start, 10);
    }

    @Override
    public long selectCountAll() {
        return patientL1Mapper.selectCountAll();
    }

    @Override
    public int updateById(PatientL1 patientL1) {
        return patientL1Mapper.updateByPrimaryKeySelective(patientL1);
    }

    @Override
    public int deleteById(int id) {
        return patientL1Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int saveCheckRecord(CheckRecord checkRecord) {
        checkRecord.setOrderNo(checkRecordMapper.selectMaxOrderNoByPatentId(checkRecord.getPatientId(), checkRecord.getPatientLevel()) + 1);
        return checkRecordMapper.insert(checkRecord);
    }

    @Override
    public List<CheckRecord> selectCheckRecordByPatentId(CheckRecord checkRecord) {
        List<CheckRecord> checkRecordList = new ArrayList<>();
        if (1 == checkRecord.getPatientLevel()) {
            checkRecordList = checkRecordMapper.selectCheckRecordByPatentL1Id(checkRecord);
        } else if (3 == checkRecord.getPatientLevel()) {
            checkRecordList = checkRecordMapper.selectCheckRecordByPatentL3Id(checkRecord);
        }
        
        return checkRecordList;
    }

    @Override
    public int savePatientL2(PatientL2 patientL2) {
        patientL2.setStatus(99);
        return patientL2Mapper.insert(patientL2);
    }

    @Override
    public List<PatientL2> selectPatientL2ByPage(int currPage) {
        int start = PAGESIZE * (currPage - 1);
        return patientL2Mapper.selectPatientL2ByPage(start, 10);
    }

    @Override
    public long selectPatientL2CountAll() {
        return patientL2Mapper.selectPatientL2CountAll();
    }

    @Override
    public PatientL2 selectByPatientId(int id) {
        return patientL2Mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updatePatientL2ById(PatientL2 patientL2) {
        return patientL2Mapper.updateByPrimaryKeySelective(patientL2);
    }

    @Override
    public int deletePatientL2ById(int id) {
        return patientL2Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int saveWatchL1(WatchL1 watchL1) {
        if (0 == watchL1.getId()) {
            PatientL2 patientL2 = patientL2Mapper.selectByPrimaryKey(watchL1.getPatientId());
            patientL2.setStatus(0);
            patientL2Mapper.updateByPrimaryKeySelective(patientL2);
            return watchL1Mapper.insert(watchL1);
        } else {
            return watchL1Mapper.updateByPrimaryKeySelective(watchL1);
        }
    }

    @Override
    public int saveWatchL2(WatchL2 watchL2) {
        if (0 == watchL2.getId()) {
            return watchL2Mapper.insert(watchL2);
        } else {
            return watchL2Mapper.updateByPrimaryKeySelective(watchL2);
        }
    }

    @Override
    public WatchL1 selectWatchL1ByPatientId(int patientL1) {
        return watchL1Mapper.selectByPatientId(patientL1);
    }

    @Override
    public int updateWatchStatusByPatient(PatientL2 patientL2) {
        return patientL2Mapper.updateByPrimaryKeySelective(patientL2);
    }

    @Override
    public WatchL2 selectWatchL2ByPatientId(int patientId) {
        return watchL2Mapper.selectByPatientId(patientId);
    }

    @Override
    public int saveWatchL3(WatchL3 watchL3) {
        if (0 == watchL3.getId()) {
            return watchL3Mapper.insert(watchL3);
        } else {
            return watchL3Mapper.updateByPrimaryKeySelective(watchL3);
        }
    }

    @Override
    public WatchL3 selectWatchL3ByPatientId(int patientId) {
        return watchL3Mapper.selectByPatientId(patientId);
    }

    @Override
    public int savePatientL3(PatientL3 patientL3) {
        return patientL3Mapper.insert(patientL3);
    }

    @Override
    public List<PatientL3> selectPatientL3ByPage(int currPage) {
        int start = PAGESIZE * (currPage - 1);
        return patientL3Mapper.selectPatientL3ByPage(start, 10);
    }

    @Override
    public long selectPatientL3CountAll() {
        return patientL3Mapper.selectPatientL3CountAll();
    }

    @Override
    public int updatePatientL3ById(PatientL3 patientL3) {
        return patientL3Mapper.updateByPrimaryKeySelective(patientL3);
    }

    @Override
    public int deletePatientL3ById(int id) {
        return patientL3Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int savePatientL4(PatientL4 patientL4) {
        return patientL4Mapper.insert(patientL4);
    }

    @Override
    public List<PatientL4> selectPatientL4ByPage(int currPage) {
        int start = PAGESIZE * (currPage - 1);
        return patientL4Mapper.selectPatientL4ByPage(start, 10);
    }

    @Override
    public long selectPatientL4CountAll() {
        return patientL4Mapper.selectPatientL4CountAll();
    }

    @Override
    public int updatePatientL4ById(PatientL4 patientL4) {
        return patientL4Mapper.updateByPrimaryKeySelective(patientL4);
    }

    @Override
    public int deletePatientL4ById(int id) {
        return patientL4Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int saveNews(News news) {
        return newsMapper.insert(news);
    }

    @Override
    public List<News> selectNewsByPage(int currPage) {
        int start = PAGESIZE * (currPage - 1);
        return newsMapper.selectNewsByPage(start, 10);
    }

    @Override
    public long selectNewsCountAll() {
        return newsMapper.selectNewsCountAll();
    }

    @Override
    public int updateNewsById(News news) {
        return newsMapper.updateByPrimaryKeySelective(news);
    }

    @Override
    public int deleteNewsById(int id) {
        return newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int saveLeader(Leader leader) {
        return leaderMapper.insert(leader);
    }

    @Override
    public List<Leader> selectLeaderByPage(int currPage) {
        int start = PAGESIZE * (currPage - 1);
        return leaderMapper.selectLeaderByPage(start, 10);
    }

    @Override
    public long selectLeaderCountAll() {
        return leaderMapper.selectLeaderCountAll();
    }

    @Override
    public int updateLeaderById(Leader leader) {
        return leaderMapper.updateByPrimaryKeySelective(leader);
    }

    @Override
    public int deleteLeaderById(int id) {
        return leaderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, List<PatientL2Dto>> selectCountByFromCity() {
        Map<String, List<PatientL2Dto>> map = new HashMap<>();
        map.put("patientL2FromCity", patientL2Mapper.selectCountByFromCity());
        map.put("patientL2Gender", patientL2Mapper.selectCountByGender());
        map.put("patientL2Age", patientL2Mapper.selectCountByAge());

        map.put("patientL3Gender", patientL3Mapper.selectCountByGender());
        map.put("patientL3Age", patientL3Mapper.selectCountByAge());

        map.put("patientL1Gender", patientL1Mapper.selectCountByGender());
        map.put("patientL1Age", patientL1Mapper.selectCountByAge());

        return map;
    }


}
