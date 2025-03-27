package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussquanbushangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussquanbushangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussquanbushangpinView;


/**
 * 全部商品评论表
 *
 * @author 
 * @email 
 * @date 2023-04-11 16:26:54
 */
public interface DiscussquanbushangpinService extends IService<DiscussquanbushangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussquanbushangpinVO> selectListVO(Wrapper<DiscussquanbushangpinEntity> wrapper);
   	
   	DiscussquanbushangpinVO selectVO(@Param("ew") Wrapper<DiscussquanbushangpinEntity> wrapper);
   	
   	List<DiscussquanbushangpinView> selectListView(Wrapper<DiscussquanbushangpinEntity> wrapper);
   	
   	DiscussquanbushangpinView selectView(@Param("ew") Wrapper<DiscussquanbushangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussquanbushangpinEntity> wrapper);
   	

}

