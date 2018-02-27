package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 油耗分析-驾驶行为
 
*/
public class OilBhavior extends BaseBehavior
{
	/** 
	 油耗分析
	 
	*/
	public AverageOilBhavior avgbhavior;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata 行程数据
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		this.avgbhavior = new AverageOilBhavior();
		this.avgbhavior.getBehavior(bhvdata);
	}
}