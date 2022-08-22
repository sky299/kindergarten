package com.jckj.service.impl;

import com.jckj.mapper.GuardianMapper;
import com.jckj.model.TGuardianInfo;
import com.jckj.service.GuardianService;
import com.jckj.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuardianServiceImpl implements GuardianService {

    @Autowired
    private GuardianMapper guardianMapper;

    @Override
    public PageVo list(TGuardianInfo tGuardianInfo) {
        tGuardianInfo.setPage(0);
        Integer count = guardianMapper.count(tGuardianInfo);
        if (count == 0){
            return PageVo.successPage();
        }
        return PageVo.successPage(guardianMapper.list(tGuardianInfo),count);
    }

    @Override
    public TGuardianInfo info(Integer id) {
        return guardianMapper.info(id);
    }

    @Override
    public void add(TGuardianInfo tGuardianInfo) {
        tGuardianInfo.setCreateTime(System.currentTimeMillis());
        tGuardianInfo.setUpdateTime(System.currentTimeMillis());
        guardianMapper.add(tGuardianInfo);
    }

    @Override
    public void update(TGuardianInfo tGuardianInfo) {
        tGuardianInfo.setUpdateTime(System.currentTimeMillis());
        guardianMapper.update(tGuardianInfo);
    }

    @Override
    public void remove(Integer id) {
        guardianMapper.remove(id);
    }

    @Override
    public Integer count(TGuardianInfo tGuardianInfo) {
        return guardianMapper.count(tGuardianInfo);
    }
}
