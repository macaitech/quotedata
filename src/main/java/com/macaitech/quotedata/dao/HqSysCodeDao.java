/**
 * 
 */
package com.macaitech.quotedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.macaitech.quotedata.model.HqSysCode;

/**
 * @author sz
 *
 */
@Mapper
public interface HqSysCodeDao {
	
	public List<HqSysCode> findAll();
}
