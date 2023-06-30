package com.naver.user.dao;

import com.naver.user.domain.dto.HeartSupport;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HeartMapper {
    Integer findById(HeartSupport heartSupport);
    Integer updateHearts(HeartSupport heartSupport);
}
