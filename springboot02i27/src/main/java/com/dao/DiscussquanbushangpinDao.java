package com.dao;

import com.entity.DiscussquanbushangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussquanbushangpinVO;
import com.entity.view.DiscussquanbushangpinView;


/**
 * 全部商品评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-11 16:26:54
 */
public interface DiscussquanbushangpinDao extends BaseMapper<DiscussquanbushangpinEntity> {
	
	List<DiscussquanbushangpinVO> selectListVO(@Param("ew") Wrapper<DiscussquanbushangpinEntity> wrapper);
	
	DiscussquanbushangpinVO selectVO(@Param("ew") Wrapper<DiscussquanbushangpinEntity> wrapper);
	
	List<DiscussquanbushangpinView> selectListView(@Param("ew") Wrapper<DiscussquanbushangpinEntity> wrapper);

	List<DiscussquanbushangpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussquanbushangpinEntity> wrapper);
	
	DiscussquanbushangpinView selectView(@Param("ew") Wrapper<DiscussquanbushangpinEntity> wrapper);
	

}
