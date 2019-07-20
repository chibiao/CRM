package com.tjetc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.mapper.OfferMapper;
import com.tjetc.pojo.Offer;
import com.tjetc.pojo.OfferExample;
import com.tjetc.pojo.OfferExample.Criteria;
import com.tjetc.pojo.User;
import com.tjetc.utils.FuzzyOffer;
import com.tjetc.utils.PageVo;

@Service
public class OfferService {
	@Autowired
	private OfferMapper offerMapper;
	private Criteria fuzzy(FuzzyOffer fuzzy,Criteria criteria){
		if(fuzzy.getOfferId()!=null && fuzzy.getOfferId()!=0)criteria.andOfferIdEqualTo(fuzzy.getOfferId());
		if(fuzzy.getOrderId()!=null && fuzzy.getOrderId()!=0)criteria.andOrderIdEqualTo(fuzzy.getOrderId());
		if(fuzzy.getManagerId()!=null && fuzzy.getManagerId()!=0 && fuzzy.getManagerId()!=99)criteria.andManagerIdEqualTo(fuzzy.getManagerId());
		if(fuzzy.getOfferState()!=null && fuzzy.getOfferState()!=99 && fuzzy.getOfferState()!=5){
			criteria.andOfferStateEqualTo(fuzzy.getOfferState());
		}else if(fuzzy.getOfferState()==5){
			criteria.andOfferStateIsNull();
		}
		if(fuzzy.getProductName()!=null && fuzzy.getProductName()!="")criteria.andProductNameLike("%"+fuzzy.getProductName()+"%");
		if(fuzzy.getQuodationMin()!=null && fuzzy.getQuodationMin()!=0)criteria.andQuodationGreaterThanOrEqualTo(fuzzy.getQuodationMin());
		if(fuzzy.getQuodationMax()!=null && fuzzy.getQuodationMax()!=0)criteria.andQuodationLessThanOrEqualTo(fuzzy.getQuodationMax());
		if(fuzzy.getImplQuodationMin()!=null && fuzzy.getImplQuodationMin()!=0)criteria.andImplQuodationGreaterThanOrEqualTo(fuzzy.getImplQuodationMin());
		if(fuzzy.getImplQuodationMax()!=null && fuzzy.getImplQuodationMax()!=0)criteria.andImplQuodationLessThanOrEqualTo(fuzzy.getImplQuodationMax());
		if(fuzzy.getServQuodationMin()!=null && fuzzy.getServQuodationMin()!=0)criteria.andServQuodationGreaterThanOrEqualTo(fuzzy.getServQuodationMin());
		if(fuzzy.getServQuodationMax()!=null && fuzzy.getServQuodationMax()!=0)criteria.andServQuodationLessThanOrEqualTo(fuzzy.getServQuodationMax());
		if(fuzzy.getSpecQuodationMin()!=null && fuzzy.getSpecQuodationMin()!=0)criteria.andSpecQuodationGreaterThanOrEqualTo(fuzzy.getSpecQuodationMin());
		if(fuzzy.getSpecQuodationMax()!=null && fuzzy.getSpecQuodationMax()!=0)criteria.andSpecQuodationLessThanOrEqualTo(fuzzy.getSpecQuodationMax());
		if(fuzzy.getProfitOrLossMin()!=null && fuzzy.getProfitOrLossMin()!=0)criteria.andProfitOrLossGreaterThanOrEqualTo(fuzzy.getProfitOrLossMin());
		if(fuzzy.getProfitOrLossMax()!=null && fuzzy.getProfitOrLossMax()!=0)criteria.andProfitOrLossLessThanOrEqualTo(fuzzy.getProfitOrLossMax());
		if(fuzzy.getTotalMin()!=null && fuzzy.getTotalMin()!=0)criteria.andTotalGreaterThanOrEqualTo(fuzzy.getTotalMin());
		if(fuzzy.getTotalMax()!=null && fuzzy.getTotalMax()!=0)criteria.andTotalLessThanOrEqualTo(fuzzy.getTotalMax());
		return criteria;
	}
	
	public List<Offer> offerList(FuzzyOffer fuzzy,PageVo page){
		OfferExample example = new OfferExample();
		Criteria criteria = fuzzy(fuzzy, example.createCriteria());
		PageHelper.startPage(page.getPage(), page.getLimit());
		List<Offer> listAll = offerMapper.selectByExample(example);
		PageInfo<Offer> pageInfo = new PageInfo<>(listAll);
		List<Offer> list = pageInfo.getList();
		return list;
	}
	public long getCount(FuzzyOffer fuzzy) {
		OfferExample example = new OfferExample();
		Criteria criteria = fuzzy(fuzzy, example.createCriteria());
		return offerMapper.countByExample(example);
	}
	public List<User> managerList(){
		return offerMapper.managerList();
	}
	
	public void examine(Map<String,Object> map) {
 		offerMapper.examine(map);
	}
	public void delete(int offerId) {
		offerMapper.delete(offerId);
	}
	public void add(Offer offer) {
		offerMapper.insert(offer);
	}

	public void update(Offer offer) {
		offerMapper.updateById(offer);
	}

	public List<String> ordersList() {
		return offerMapper.ordersList();
	}
}
