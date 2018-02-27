package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 平均速度-速度驾驶行为分析
 
*/
public class SpeedBehavior_average extends BaseBehavior{
	/** 
	 平均速度
	 
	*/
	public int average;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata 行程数据
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		this.average = bhvdata.getAvgspeed();
		super.setLevel(1);
		super.setEnvmark(0);
		super.setSafemark(0);
	}
}