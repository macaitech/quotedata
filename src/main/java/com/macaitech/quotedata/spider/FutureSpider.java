/**
 * 
 */
package com.macaitech.quotedata.spider;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.macaitech.quotedata.model.FutureGoods;
import com.macaitech.quotedata.service.FutureGoodsService;
import com.macaitech.quotedata.service.HqSysCodeService;
import com.macaitech.quotedata.util.DateUtils;

/**
 * @author sz
 *
 */
@Service
public class FutureSpider {
	
	@Autowired
	private FutureGoodsService futureGoodsService;
	
	@Autowired
	private HqSysCodeService hqSysCodeService;
	
	public static void main(String[] args) throws Exception {		
		
	}
	
	/**
	 * 抓取数据
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public List<FutureGoods> doCrawel(String date) throws Exception{
		Date targetDate = DateUtils.parseDate(date, DateUtils.parsePatterns);
		String yyyyMMddString = DateUtils.formatDate(targetDate, "yyyy-MM-dd");
		String url = "http://www.100ppi.com/price/table2-"+yyyyMMddString+".html";
		Connection connection= Jsoup.connect(url);
		Response response =  connection.execute();
		String content = response.body();
		Document doc = Jsoup.parse(content);
		int yyyyMMddint = Integer.parseInt(DateUtils.formatDate(targetDate, "yyyyMMdd"));
		List<FutureGoods> list = this.parseData(doc,yyyyMMddint);
		Map<String,String> map = this.hqSysCodeService.getNameKeyValues();
		for (FutureGoods futureGoods : list) {
			String name = futureGoods.getName();
			if(!StringUtils.isEmpty(name) && map.containsKey(name)) {
				String code = map.get(name);
				futureGoods.setCode(code);
				this.futureGoodsService.insert(futureGoods);
			}
			else {
				System.err.println(futureGoods.getName());
			}
		}
		return list;
	}
		
	/**
	 * 解码数据
	 * @param doc
	 * @param date
	 * @return
	 */
	private List<FutureGoods> parseData(Document doc,int date){
		List<FutureGoods> list = new ArrayList<>();
		Elements trElement = doc.select("table").select("tr");  
		String text =  "";
		for (int i = 0; i < trElement.size(); i++) {
			Elements tds = trElement.get(i).select("td");
			String name = tds.get(0).text();
			if(tds.size()<=7 || StringUtils.isEmpty(name)) continue;
			try {
				BigDecimal goodPrice = new BigDecimal(tds.get(1).text().trim());
				String latelyHqCode = tds.get(2).text();
				BigDecimal latelyHqPrice = new BigDecimal(tds.get(3).text().trim());
				text = tds.get(4).text().trim().replace("&nbsp;", "");
				BigDecimal latelyBaseOffset = new BigDecimal(text);
				String hqCode = tds.get(5).text();
				BigDecimal hqPrice = new BigDecimal(tds.get(6).text().trim());
				BigDecimal baseOffset = new BigDecimal(tds.get(7).text().trim());
				FutureGoods futureGoods = new FutureGoods();
				futureGoods.setCode("").setHqDate(date).setName(name).setGoodPrice(goodPrice)
					.setLatelyHqCode(latelyHqCode).setLatelyHqPrice(latelyHqPrice).setLatelyBaseOffset(latelyBaseOffset)
					.setHqCode(hqCode).setHqPrice(hqPrice).setBaseOffset(baseOffset);
				list.add(futureGoods);
			}catch(Exception e) {
				//e.printStackTrace();
				//System.err.println(tds.html());
			}
		}
		return list;
	}
}
