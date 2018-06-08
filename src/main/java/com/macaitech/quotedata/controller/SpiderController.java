package com.macaitech.quotedata.controller;

import com.macaitech.quotedata.model.FutureGoods;
import com.macaitech.quotedata.spider.FutureSpider;
import com.macaitech.quotedata.vo.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/spider")
public class SpiderController  {

    
    @Autowired
    private FutureSpider futureSpider;

    @RequestMapping(value = "/future", method = RequestMethod.GET)
    @ResponseBody
    public Result updatePassword(@RequestParam("date") String date) {
    	Result result = new Result();
        try {
        	List<FutureGoods> list =this.futureSpider.doCrawel(date);
        	result.setCode("200");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode("300");
		} 
        return result;
    }
}