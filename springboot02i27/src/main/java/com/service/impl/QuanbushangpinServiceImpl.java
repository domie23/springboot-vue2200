package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.QuanbushangpinDao;
import com.entity.QuanbushangpinEntity;
import com.service.QuanbushangpinService;
import com.entity.vo.QuanbushangpinVO;
import com.entity.view.QuanbushangpinView;

@Service("quanbushangpinService")
public class QuanbushangpinServiceImpl extends ServiceImpl<QuanbushangpinDao, QuanbushangpinEntity> implements QuanbushangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuanbushangpinEntity> page = this.selectPage(
                new Query<QuanbushangpinEntity>(params).getPage(),
                new EntityWrapper<QuanbushangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QuanbushangpinEntity> wrapper) {
		  Page<QuanbushangpinView> page =new Query<QuanbushangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QuanbushangpinVO> selectListVO(Wrapper<QuanbushangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QuanbushangpinVO selectVO(Wrapper<QuanbushangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QuanbushangpinView> selectListView(Wrapper<QuanbushangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuanbushangpinView selectView(Wrapper<QuanbushangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
