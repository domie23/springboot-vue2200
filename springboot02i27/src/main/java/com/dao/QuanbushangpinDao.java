package com.dao;

import com.entity.QuanbushangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QuanbushangpinVO;
import com.entity.view.QuanbushangpinView;


/**
 * 全部商品
 * 
 * @author 
 * @email 
 * @date 2023-04-11 16:26:53
 */
public interface QuanbushangpinDao extends BaseMapper<QuanbushangpinEntity> {
	
	List<QuanbushangpinVO> selectListVO(@Param("ew") Wrapper<QuanbushangpinEntity> wrapper);
	
	QuanbushangpinVO selectVO(@Param("ew") Wrapper<QuanbushangpinEntity> wrapper);
	
	List<QuanbushangpinView> selectListView(@Param("ew") Wrapper<QuanbushangpinEntity> wrapper);

	List<QuanbushangpinView> selectListView(Pagination page,@Param("ew") Wrapper<QuanbushangpinEntity> wrapper);
	
	QuanbushangpinView selectView(@Param("ew") Wrapper<QuanbushangpinEntity> wrapper);
	

}
