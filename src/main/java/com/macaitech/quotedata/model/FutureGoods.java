/**
 * 
 */
package com.macaitech.quotedata.model;

import java.math.BigDecimal;

/**
 * @author yuhui.tang
 *  期现
 */
public class FutureGoods {

	private Long id;
	private String code;//代码
	private String name;//名称
	private int hqDate;//行情日期
	private BigDecimal goodPrice;//现货价格
	private BigDecimal latelyHqPrice;//最近合约价格
	private String latelyHqCode;//最近合约
	private BigDecimal latelyBaseOffset; //最近基差
	private BigDecimal hqPrice;//主力合约价格
	private String hqCode;//主力合约
	private BigDecimal baseOffset; //主力基差
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public FutureGoods setCode(String code) {
		this.code = code;
		return this;
	}
	public String getName() {
		return name;
	}
	public FutureGoods setName(String name) {
		this.name = name;
		return this;
	}
	public int getHqDate() {
		return hqDate;
	}
	public FutureGoods setHqDate(int hqDate) {
		this.hqDate = hqDate;
		return this;
	}
	public BigDecimal getGoodPrice() {
		return goodPrice;
	}
	public FutureGoods setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
		return this;
	}
	public BigDecimal getLatelyHqPrice() {
		return latelyHqPrice;
	}
	public FutureGoods setLatelyHqPrice(BigDecimal latelyHqPrice) {
		this.latelyHqPrice = latelyHqPrice;
		return this;
	}
	public String getLatelyHqCode() {
		return latelyHqCode;
	}
	public FutureGoods setLatelyHqCode(String latelyTreatyCode) {
		this.latelyHqCode = latelyTreatyCode;
		return this;
	}
	public BigDecimal getLatelyBaseOffset() {
		return latelyBaseOffset;
	}
	public FutureGoods setLatelyBaseOffset(BigDecimal latelyBaseOffset) {
		this.latelyBaseOffset = latelyBaseOffset;
		return this;
	}
	public BigDecimal getHqPrice() {
		return hqPrice;
	}
	public FutureGoods setHqPrice(BigDecimal mainHqPrice) {
		this.hqPrice = mainHqPrice;
		return this;
	}
	public String getHqCode() {
		return hqCode;
	}
	public FutureGoods setHqCode(String mainTreatyCode) {
		this.hqCode = mainTreatyCode;
		return this;
	}
	public BigDecimal getBaseOffset() {
		return baseOffset;
	}
	public FutureGoods setBaseOffset(BigDecimal mainBaseOffset) {
		this.baseOffset = mainBaseOffset;
		return this;
	}
	
	
	
	
}
