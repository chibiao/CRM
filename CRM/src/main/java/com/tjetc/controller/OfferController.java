package com.tjetc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjetc.pojo.Offer;
import com.tjetc.pojo.Role;
import com.tjetc.pojo.User;
import com.tjetc.service.OfferService;
import com.tjetc.utils.FuzzyOffer;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.PageVo;

@Controller
@RequestMapping("/offer")
public class OfferController {
	static int i = 0;//第一次进要刷新
	@Autowired
	private OfferService offerService; 

	@RequestMapping("/offerList")
	@ResponseBody
	public PageListRes offerList(HttpServletRequest request, FuzzyOffer fuzzy, PageVo page){
		PageListRes res = new PageListRes();
		res.setMsg(i++ +"");//第一次进入offerlist页面会因为先加载模块导致每行按钮全部显示  所以第一次进入该页面时多刷新一次
		boolean judgeUser = true;
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		for (Role role : user.getRoles()) {
			if(role.getId()==1){
				judgeUser=false;
				break;
			}
			if(role.getId()==2){
				judgeUser=false;
				break;
			}
		}
		
		if(judgeUser){//是manager  给fuzzy增加判断 只能查询到自己创建的报价单
			fuzzy.setManagerId(user.getId());//判断当前登录的user 的角色权限  manager director
			request.getSession().setAttribute("userRole", "manager");
		}else{
			// 主管 可以查询所有经理的报价单
			request.getSession().setAttribute("userRole", "director");
		}
		request.getSession().setMaxInactiveInterval(9999999);
		request.getSession().setAttribute("managers", offerService.managerList());
		request.getSession().setAttribute("fuzzyOffer", fuzzy);
		List<Offer> list = offerService.offerList(fuzzy, page);
		res.setCode(0);
		res.setCount(offerService.getCount(fuzzy));
		res.setData(list);
		return res;
	}
	
	//审核报价的方法
	@RequestMapping("/examine")
	@ResponseBody
	public Map<String,Object> examine(int offerId, int state){
		HashMap<String, Object> mapp = new HashMap<String,Object>();
		mapp.put("offerId", offerId);
		mapp.put("state", state);
		Map<String,Object> map = new HashMap<>();
		map.put("status", 0);
		map.put("data", null);
		offerService.examine(mapp);
		return map;
	}
	
	//删除报价的方法
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(int offerId){
		Map<String,Object> map = new HashMap<>();
		map.put("status", 0);
		offerService.delete(offerId);
		//map.put("data", "已删除");
		return map;
	}
	// 修改报价单的方法
	@RequestMapping("/update")
	@ResponseBody
	public Map<String,Object> update(Offer offer){
		Map<String,Object> map = new HashMap<>();
		map.put("status", 0);
		offer.setTotal(offer.getQuodation()+offer.getImplQuodation()+offer.getServQuodation()+offer.getSpecQuodation()+offer.getProfitOrLoss());
		offerService.update(offer);
		map.put("data", "修改成功");
		return map;
	}
	
	//添加
	@RequestMapping("/quotaOfferAdd")
	public String quotaOfferAdd(Offer offer,HttpServletRequest request){
		offer.setTotal(offer.getQuodation()+offer.getImplQuodation()+offer.getServQuodation()+offer.getSpecQuodation()+offer.getProfitOrLoss());
		/*User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user"); 
		offer.setManagerId(user.getId());*/
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		offer.setManagerId(user.getId());
		offerService.add(offer);
		return "offer/offerAdd";
	}
	
	// 添加页面查询所有orderId的方法
	@RequestMapping("/gotoAddOffer")
	public String offerOrderIdList(HttpServletRequest request){
		 request.getSession().setAttribute("offer_orders", offerService.ordersList());
		 return "offer/offerAdd";
	}
	
	
}
