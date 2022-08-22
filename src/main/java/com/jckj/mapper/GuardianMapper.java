package com.jckj.mapper;

import com.jckj.model.TGuardianInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuardianMapper {

    /**
     * 列表
     */
    List<TGuardianInfo> list(TGuardianInfo tGuardianInfo);

    /**
     * 列表总数
     */
    Integer count(TGuardianInfo tGuardianInfo);

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
}
