package com.emake.mps.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.emake.common.config.db.Query;
import com.emake.mps.model.entity.Member;
import com.emake.mps.model.vo.MemberVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MemberMapper extends BaseMapper<Member> {

}