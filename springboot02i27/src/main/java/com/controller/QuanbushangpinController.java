package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.entity.OrdersEntity;
import com.service.OrdersService;

import com.entity.QuanbushangpinEntity;
import com.entity.view.QuanbushangpinView;

import com.service.QuanbushangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 全部商品
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-11 16:26:53
 */
@RestController
@RequestMapping("/quanbushangpin")
public class QuanbushangpinController {
    @Autowired
    private QuanbushangpinService quanbushangpinService;

    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuanbushangpinEntity quanbushangpin,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			quanbushangpin.setShangjiamingcheng((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QuanbushangpinEntity> ew = new EntityWrapper<QuanbushangpinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = quanbushangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quanbushangpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QuanbushangpinEntity quanbushangpin, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<QuanbushangpinEntity> ew = new EntityWrapper<QuanbushangpinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = quanbushangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quanbushangpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuanbushangpinEntity quanbushangpin){
       	EntityWrapper<QuanbushangpinEntity> ew = new EntityWrapper<QuanbushangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quanbushangpin, "quanbushangpin")); 
        return R.ok().put("data", quanbushangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuanbushangpinEntity quanbushangpin){
        EntityWrapper< QuanbushangpinEntity> ew = new EntityWrapper< QuanbushangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quanbushangpin, "quanbushangpin")); 
		QuanbushangpinView quanbushangpinView =  quanbushangpinService.selectView(ew);
		return R.ok("查询全部商品成功").put("data", quanbushangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuanbushangpinEntity quanbushangpin = quanbushangpinService.selectById(id);
		quanbushangpin.setClicknum(quanbushangpin.getClicknum()+1);
		quanbushangpin.setClicktime(new Date());
		quanbushangpinService.updateById(quanbushangpin);
        return R.ok().put("data", quanbushangpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuanbushangpinEntity quanbushangpin = quanbushangpinService.selectById(id);
		quanbushangpin.setClicknum(quanbushangpin.getClicknum()+1);
		quanbushangpin.setClicktime(new Date());
		quanbushangpinService.updateById(quanbushangpin);
        return R.ok().put("data", quanbushangpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QuanbushangpinEntity quanbushangpin, HttpServletRequest request){
    	quanbushangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quanbushangpin);
        quanbushangpinService.insert(quanbushangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QuanbushangpinEntity quanbushangpin, HttpServletRequest request){
    	quanbushangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quanbushangpin);
        quanbushangpinService.insert(quanbushangpin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QuanbushangpinEntity quanbushangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quanbushangpin);
        quanbushangpinService.updateById(quanbushangpin);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        quanbushangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<QuanbushangpinEntity> wrapper = new EntityWrapper<QuanbushangpinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			wrapper.eq("shangjiamingcheng", (String)request.getSession().getAttribute("username"));
		}

		int count = quanbushangpinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,QuanbushangpinEntity quanbushangpin, HttpServletRequest request,String pre){
        EntityWrapper<QuanbushangpinEntity> ew = new EntityWrapper<QuanbushangpinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = quanbushangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quanbushangpin), params), params));
        return R.ok().put("data", page);
    }


        /**
     * 协同算法（按用户购买推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,QuanbushangpinEntity quanbushangpin, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String goodtypeColumn = "shangpinleibie";
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>().eq("userid", userId).eq("tablename", "quanbushangpin").orderBy("addtime", false));
        List<String> goodtypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<QuanbushangpinEntity> quanbushangpinList = new ArrayList<QuanbushangpinEntity>();
	//去重
    	List<OrdersEntity> ordersDist = new ArrayList<OrdersEntity>();
    	for(OrdersEntity o1 : orders) {
    		boolean addFlag = true;
    		for(OrdersEntity o2 : ordersDist) {
    			if(o1.getGoodid()==o2.getGoodid() || o1.getGoodtype().equals(o2.getGoodtype())) {
    				addFlag = false;
    				break;
    			}
    		}
    		if(addFlag) ordersDist.add(o1);
    	}
        if(ordersDist!=null && ordersDist.size()>0) {
                for(OrdersEntity o : ordersDist) {
                        quanbushangpinList.addAll(quanbushangpinService.selectList(new EntityWrapper<QuanbushangpinEntity>().eq(goodtypeColumn, o.getGoodtype())));
                }
        }
        EntityWrapper<QuanbushangpinEntity> ew = new EntityWrapper<QuanbushangpinEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = quanbushangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quanbushangpin), params), params));
        List<QuanbushangpinEntity> pageList = (List<QuanbushangpinEntity>)page.getList();
        if(quanbushangpinList.size()<limit) {
                int toAddNum = (limit-quanbushangpinList.size())<=pageList.size()?(limit-quanbushangpinList.size()):pageList.size();
                for(QuanbushangpinEntity o1 : pageList) {
                    boolean addFlag = true;
                    for(QuanbushangpinEntity o2 : quanbushangpinList) {
                        if(o1.getId().intValue()==o2.getId().intValue()) {
                            addFlag = false;
                            break;
                        }
                    }
                    if(addFlag) {
                        quanbushangpinList.add(o1);
                        if(--toAddNum==0) break;
                    }   
                }
        } else if(quanbushangpinList.size()>limit) {
            quanbushangpinList = quanbushangpinList.subList(0, limit);
        }
        page.setList(quanbushangpinList);
        return R.ok().put("data", page);
    }







}
