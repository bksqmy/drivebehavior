package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.SpeedInfo;
import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 中速-速度驾驶行为分析
 
*/
public class SpeedBehavior_mid extends BaseBehavior{
	/** 
	 平均速度
	 
	*/
	public int average;
	/** 
	 行驶距离
	 
	*/
	public int distance;
	/** 
	 距离百分比
	 
	*/
	public float distancescale;
	/** 
	 行驶时间
	 
	*/
	public int time;
	/** 
	 时间百分比
	 
	*/
	public float timescale;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata 行程数据
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		SpeedInfo[] speedgroup = bhvdata.getSpeedgroup();		
		int num = (((speedgroup[0].getTime() + speedgroup[1].getTime()) + speedgroup[2].getTime()) + speedgroup[3].getTime()) + speedgroup[4].getTime() + speedgroup[5].getTime();
		this.time = speedgroup[3].getTime();
		this.distance = speedgroup[3].getDistance();
		if (num > 0){
			this.timescale = ((float)this.time) / ((float)num);
		}else{
			this.timescale = 0f;
		}
		if (bhvdata.getDistance() > 0){
			this.distancescale = ((float)this.distance) / ((float)bhvdata.getDistance());
		}else{
			this.distancescale = 0f;
		}
		if (this.time > 0){
			this.average = (int)((((double)this.distance) / 1000.0) / (((double)this.time) / 3600.0));
		}else{
			this.average = 0;
		}
		float num2 = ((float)Math.abs((int)(this.average - 90))) / 40f;
		num2 = (num2 < 1f) ? num2 : 1f;
		num2 = (num2 > 0f) ? num2 : 0f;
		super.setEnvmark((int)(this.timescale * (100f - (0f * num2))));
		num2 = ((float)Math.abs((int)(this.average - 60))) / 40f;
		num2 = (num2 < 1f) ? num2 : 1f;
		num2 = (num2 > 0f) ? num2 : 0f;
		super.setSafemark((int)(this.timescale * (96f - (2f * num2))));
		super.setLevel(1);
		if (this.timescale > 0f){
			super.setLevel(1);
		}
	}
}