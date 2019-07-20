package com.tjetc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tjetc.pojo.Goods;
import com.tjetc.pojo.News;
import com.tjetc.pojo.Newstype;
import com.tjetc.service.GoodsService;
import com.tjetc.service.NewsService;
import com.tjetc.service.impl.NewsTypeService;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.QueryVo;

@Controller
@RequestMapping("/Goods")
public class GoodsController {
	@Resource
	private GoodsService goodsservice;
	/**
	 * 查询操作
	 * @param vo
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public PageListRes listNews(QueryVo vo){
		return this.goodsservice.listGoods(vo);
	}
	/**
	 * 增加新闻
	 * @param vo
	 */
	@RequestMapping("addGoods")
	public void addNews(Goods vo){
		this.goodsservice.addGoods(vo);
	}
	/**
	 * 根据id查询新闻
	 * @param nid
	 * @param request
	 */
	@RequestMapping("findGoodsById")
	public void findNewsById(int gid,HttpServletRequest request){
		Goods vo =this.goodsservice.findGoodsById(gid);
		request.getSession().setAttribute("goods", vo);
	}
	/**
	 * 更新新闻
	 * @param vo
	 */
	@RequestMapping("updateGoodsById")
	public void updateNewsById(Goods vo){
       this.goodsservice.updateGoodsById(vo);
	}
	/**
	 * 
	 * 根据id删除新闻
	 * @param nid
	 */
	@RequestMapping("deleteGoodsById")
	public void deleteGoodsById(int gid){
		this.goodsservice.deleteGoods(gid);
	}

	@RequestMapping("deleteGoodsByIds")
	public void deleteGoodsByIds(int[] gids){
		for (int i = 0; i < gids.length; i++) {
			int gid = gids[i];
			this.goodsservice.deleteGoods(gid);
		}
	}

	
	
	
	
	
}
