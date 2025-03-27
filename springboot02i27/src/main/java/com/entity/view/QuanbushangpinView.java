package com.entity.view;

import com.entity.QuanbushangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 全部商品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-11 16:26:53
 */
@TableName("quanbushangpin")
public class QuanbushangpinView  extends QuanbushangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QuanbushangpinView(){
	}
 
 	public QuanbushangpinView(QuanbushangpinEntity quanbushangpinEntity){
 	try {
			BeanUtils.copyProperties(this, quanbushangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
