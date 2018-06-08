/**
 * 
 */
package com.macaitech.quotedata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macaitech.quotedata.dao.HqSysCodeDao;
import com.macaitech.quotedata.model.HqSysCode;

/**
 * @author sz
 *
 */
@Service
public class HqSysCodeService {

	@Autowired
	private HqSysCodeDao hqSysCodeDao;
	
	public List<HqSysCode> findAll(){
		return this.hqSysCodeDao.findAll();
	}
	
	public Map<String,String> getNameKeyValues(){
		List<HqSysCode> list = this.findAll();
		Map<String,String> map = new HashMap<>();
		
		for (HqSysCode hqCode : list) {
			if(!map.containsKey(hqCode.getName())) {
				map.put(hqCode.getName(),hqCode.getCode());
			}
			if(!map.containsKey(hqCode.getAliasName())) {
				map.put(hqCode.getAliasName(),hqCode.getCode());
			}
		}
		return map;
	}
}
