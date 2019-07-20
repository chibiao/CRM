package com.tjetc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.mapper.GoodsMapper;
import com.tjetc.pojo.Goods;
import com.tjetc.service.GoodsService;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.QueryVo;
@Service
public class GoodsServiceImol implements GoodsService {
    @Resource
	private GoodsMapper goodsmapper;
	
	@Override
	public PageListRes listGoods(QueryVo vo) {
		PageListRes pagelist = new PageListRes();
		PageHelper.startPage(vo.getPage(),vo.getLimit());// （当前页，每页条数）
		List<Goods> list = this.goodsmapper.findAllGoods(vo);
		PageInfo<Goods> page = new PageInfo<Goods>(list);
		pagelist.setRows(list);//存储数据
		pagelist.setTotal(page.getTotal());
		return pagelist;
	}

	@Override
	public int addGoods(Goods vo) {
		return this.goodsmapper.doCreateGoods(vo);
	}

	@Override
	public int deleteGoods(int gid) {
		return this.goodsmapper.doRemoveGoods(gid);
	}

	@Override
	public Goods findGoodsById(int gid) {
		return this.goodsmapper.findGoodsById(gid);
	}

	@Override
	public void updateGoodsById(Goods vo) {
        this.goodsmapper.updateGoodsById(vo);
	}

}
