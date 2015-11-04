package com.util.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.domain.MetaBean;

public class DeployList {

	public DeployList(){
		super();
	}
	
	public HashMap<String, List<MetaBean>> getDeployListByOrg(List<Object> deployList){
		HashMap<String, List<MetaBean>> map = new HashMap<String, List<MetaBean>>();
		for (Iterator<Object> iterator = deployList.iterator(); iterator.hasNext();) {
			MetaBean beanObject = (MetaBean) iterator.next();
			if(map.containsKey(beanObject.getTargetOrg())){
				(map.get(beanObject.getTargetOrg())).add(beanObject);
			}
			else{
				List<MetaBean> l = new ArrayList<MetaBean>();
				l.add(beanObject);
				map.put(beanObject.getTargetOrg(), l);
			}
		}
		return map;
	}
	
	public LinkedHashMap<String, List<MetaBean>> getDeployListByOrder2(List<Object> deployList){
		LinkedHashMap<String, List<MetaBean>> map = new LinkedHashMap<String, List<MetaBean>>();
		for (Iterator<Object> iterator = deployList.iterator(); iterator.hasNext();) {
			MetaBean beanObject = (MetaBean) iterator.next();
			Double order = beanObject.getOrder();
			if(map.containsKey(order+"~"+beanObject.getPackageName())){
				(map.get(beanObject.getOrder()+"~"+beanObject.getPackageName())).add(beanObject);
			}
			else{
				List<MetaBean> l = new ArrayList<MetaBean>();
				l.add(beanObject);
				map.put(order+"~"+beanObject.getPackageName(), l);
			}
		}
		return map;
	}
	
	public LinkedHashMap<Double, List<MetaBean>> getDeployListByOrder(List<Object> deployList){
		LinkedHashMap<Double, List<MetaBean>> map = new LinkedHashMap<Double, List<MetaBean>>();
		for (Iterator<Object> iterator = deployList.iterator(); iterator.hasNext();) {
			MetaBean beanObject = (MetaBean) iterator.next();
			Double order = beanObject.getOrder();
			
			if(map.containsKey(order)){
				(map.get(beanObject.getOrder())).add(beanObject);
			}
			else{
				List<MetaBean> l = new ArrayList<MetaBean>();
				l.add(beanObject);
				map.put(order, l);
			}
		}
		return map;
	}

}
