package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QuanbushangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QuanbushangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QuanbushangpinView;


/**
 * 全部商品
 *
 * @author 
 * @email 
 * @date 2023-04-11 16:26:53
 */
public interface QuanbushangpinService extends IService<QuanbushangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuanbushangpinVO> selectListVO(Wrapper<QuanbushangpinEntity> wrapper);
   	
   	QuanbushangpinVO selectVO(@Param("ew") Wrapper<QuanbushangpinEntity> wrapper);
   	
   	List<QuanbushangpinView> selectListView(Wrapper<QuanbushangpinEntity> wrapper);
   	
   	QuanbushangpinView selectView(@Param("ew") Wrapper<QuanbushangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QuanbushangpinEntity> wrapper);
   	

}

