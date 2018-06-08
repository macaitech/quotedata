/**
 * 
 */
package com.macaitech.quotedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.macaitech.quotedata.model.FutureGoods;
import com.macaitech.quotedata.vo.QueryFutureGoodsVo;

/**
 * @author sz
 *
 */
@Mapper
public interface FutureGoodsDao {

	/**
	 * 插入
	 * @param futureGoodQuote
	 * @return
	 */
	public int insert(FutureGoods futureGoodQuote);
	
	/**
	 * 更新
	 * @param futureGoodQuote
	 * @return
	 */
	public int update(FutureGoods futureGoodQuote);
	
	
	/**
	 * 获取
	 * @param id
	 * @return
	 */
	public FutureGoods get(Long id);
	
	/**
	 * 查询
	 * @param futureGoodsVo
	 * @return
	 */
	public List<FutureGoods> findList(QueryFutureGoodsVo futureGoodsVo);
	
}
