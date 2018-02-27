package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 最高速-速度驾驶行为分析
 
*/
public class SpeedBehavior_top extends BaseBehavior{
	/** 
	 最高速度
	 
	*/
	public int topspeed;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		this.topspeed = bhvdata.getTopspeed();
		super.setLevel(1);
		super.setEnvmark(0);
		super.setSafemark(0);
		if (this.topspeed > 120){
			super.setLevel(1);
		}
	}
}