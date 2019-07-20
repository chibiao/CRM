package com.tjetc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.mapper.NewsMapper;
import com.tjetc.pojo.News;
import com.tjetc.service.NewsService;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.QueryVo;
@Service
public class NewsServiceImpl implements NewsService{
     @Resource
	private NewsMapper newsmapper;
	
	
	@Override
	public PageListRes listNews(QueryVo vo) {
		PageListRes pagelist = new PageListRes();
		PageHelper.startPage(vo.getPage(),vo.getLimit());// （当前页，每页条数）
		List<News> list = this.newsmapper.findAllNews(vo);
		PageInfo<News> page = new PageInfo<News>(list);
		pagelist.setRows(list);//存储数据
		pagelist.setTotal(page.getTotal());
		return pagelist;
	}

	@Override
	public int addNews(News vo) {
		return this.newsmapper.doCreateNews(vo);
	}

	@Override
	public int deleteNews(int nid) {
		return this.newsmapper.doRemoveNews(nid);
	}

	@Override
	public News findNewsById(int nid) {
		return this.newsmapper.findNewsById(nid);
	}

	@Override
	public void updateNewsById(News vo) {
	   this.newsmapper.updateNewsById(vo);
		
	}

}
