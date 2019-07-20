package com.tjetc.mapper;

import java.util.List;

import com.tjetc.pojo.News;
import com.tjetc.utils.QueryVo;

public interface NewsMapper {
    /**
     * 查询全部，vo中包含头关键字
     * @return
     */
	public List<News> findAllNews(QueryVo vo);
  /**
   * 增加新闻
   * @param vo
   * @return
   */
    public int doCreateNews(News vo);
    /**
     * 删除新闻
     * @param nid
     * @return
     */
    public int doRemoveNews(int nid);
    
    /**
     * 根据id找新闻
     * @param nid
     * @return
     */
    public News findNewsById(int nid);
    /**
     * 根据id更新新闻
     * @param vo
     * @return
     */
	public void  updateNewsById(News vo);
}
