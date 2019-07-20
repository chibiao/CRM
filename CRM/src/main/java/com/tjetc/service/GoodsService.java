package com.tjetc.service;

import com.tjetc.pojo.Goods;
import com.tjetc.pojo.News;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.QueryVo;



public interface GoodsService {
	/**
	 * 列出全部的新闻
	 * @param vo
	 * @return
	 */
    public PageListRes listGoods(QueryVo vo);
    /**
     * 增加新闻
     * @param vo
     * @return
     */
    public int addGoods(Goods vo);
    /**
     * 根据编号删除新闻
     * @param nid
     * @return
     */
    public int deleteGoods(int gid);
    /**
     * 根据编号查询具体新闻
     * @param nid
     * @return
     */
    public Goods findGoodsById(int gid);
    
    /**
     * 根据编号更新新闻
     * @param vo
     */
	public void updateGoodsById(Goods vo);
}
