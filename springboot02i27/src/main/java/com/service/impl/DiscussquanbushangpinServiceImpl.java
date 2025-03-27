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


import com.dao.DiscussquanbushangpinDao;
import com.entity.DiscussquanbushangpinEntity;
import com.service.DiscussquanbushangpinService;
import com.entity.vo.DiscussquanbushangpinVO;
import com.entity.view.DiscussquanbushangpinView;

@Service("discussquanbushangpinService")
public class DiscussquanbushangpinServiceImpl extends ServiceImpl<DiscussquanbushangpinDao, DiscussquanbushangpinEntity> implements DiscussquanbushangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussquanbushangpinEntity> page = this.selectPage(
                new Query<DiscussquanbushangpinEntity>(params).getPage(),
                new EntityWrapper<DiscussquanbushangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussquanbushangpinEntity> wrapper) {
		  Page<DiscussquanbushangpinView> page =new Query<DiscussquanbushangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussquanbushangpinVO> selectListVO(Wrapper<DiscussquanbushangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussquanbushangpinVO selectVO(Wrapper<DiscussquanbushangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussquanbushangpinView> selectListView(Wrapper<DiscussquanbushangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussquanbushangpinView selectView(Wrapper<DiscussquanbushangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
