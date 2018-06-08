/**
 * 
 */
package com.macaitech.quotedata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macaitech.quotedata.dao.FutureGoodsDao;
import com.macaitech.quotedata.model.FutureGoods;
import com.macaitech.quotedata.vo.QueryFutureGoodsVo;

/**
 * @author sz
 *
 */
@Service
public class FutureGoodsService {

	@Autowired
	private FutureGoodsDao futureGoodsDao;
	
	/**
	 * 更新
	 * @param futureGoods
	 * @return
	 */
	public int update(FutureGoods futureGoods) {
		return this.futureGoodsDao.update(futureGoods);
	}
	
	/**
	 * 插入
	 * @param futureGoods
	 * @return
	 */
	public int insert(FutureGoods futureGoods) {
		return this.futureGoodsDao.insert(futureGoods);
	}
	
	/**
	 * 获取
	 * @param id
	 * @return
	 */
	public FutureGoods get(Long id) {
		return this.futureGoodsDao.get(id);
	}
	
	/**
	 * 查询
	 * @param vo
	 * @return
	 */
	public PageInfo<FutureGoods> findList(QueryFutureGoodsVo vo){
        if (!vo.isDisablePaging()) {
            PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        }
        return new PageInfo<>(this.futureGoodsDao.findList(vo));
	}
	
}
