package com.tjetc.mapper;

import java.util.List;

import com.tjetc.pojo.Goods;
import com.tjetc.utils.QueryVo;

public interface GoodsMapper {
	/**
     * 查询全部，vo中包含头关键字
     * @return
     */
	public List<Goods> findAllGoods(QueryVo vo);
  /**
   * 增加新闻
   * @param vo
   * @return
   */
    public int doCreateGoods(Goods vo);
    /**
     * 删除新闻
     * @param nid
     * @return
     */
    public int doRemoveGoods(int gid);
    
    /**
     * 根据id找新闻
     * @param nid
     * @return
     */
    public Goods findGoodsById(int gid);
    /**
     * 根据id更新新闻
     * @param vo
     * @return
     */
	public void  updateGoodsById(Goods vo);
}
