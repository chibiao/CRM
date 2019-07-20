package com.tjetc.service;

import com.tjetc.pojo.News;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.QueryVo;



public interface NewsService {
	/**
	 * 列出全部的新闻
	 * @param vo
	 * @return
	 */
    public PageListRes listNews(QueryVo vo);
    /**
     * 增加新闻
     * @param vo
     * @return
     */
    public int addNews(News vo);
    /**
     * 根据编号删除新闻
     * @param nid
     * @return
     */
    public int deleteNews(int nid);
    /**
     * 根据编号查询具体新闻
     * @param nid
     * @return
     */
    public News findNewsById(int nid);
    
    /**
     * 根据编号更新新闻
     * @param vo
     */
	public void updateNewsById(News vo);
}
