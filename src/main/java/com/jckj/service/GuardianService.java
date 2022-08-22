package com.jckj.service;

import com.jckj.model.TGuardianInfo;
import com.jckj.vo.PageVo;

public interface GuardianService {
    /**
     * 列表
     */
    PageVo list(TGuardianInfo tGuardianInfo);
    /**
     * 详情
     */
    TGuardianInfo info(Integer id);
    /**
     * 新增
     */
    void add(TGuardianInfo tGuardianInfo);
    /**
     * 修改
     */
    void update(TGuardianInfo tGuardianInfo);
    /**
     * 删除
     */
    void remove(Integer id);
    /**
     * 列表总数
     */
    Integer count(TGuardianInfo tGuardianInfo);
}
