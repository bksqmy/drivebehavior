package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.SpeedInfo;
import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 超高速-速度驾驶行为分析
 
*/
public class SpeedBehavior_superhight extends BaseBehavior{
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
		this.time = bhvdata.getOutspeedtime();
		SpeedInfo[] speedgroup = bhvdata.getSpeedgroup();		
		int num = (((speedgroup[0].getTime() + speedgroup[1].getTime()) + speedgroup[2].getTime()) + speedgroup[3].getTime()) + speedgroup[4].getTime() + speedgroup[5].getTime();
		if (this.time >= speedgroup[5].getTime()){
			this.time = 0;
		}
		if (num > 0){
			this.timescale = ((float)this.time) / ((float)num);
		}else{
			this.timescale = 0f;
		}
		float num2 = 1f;
		super.setEnvmark((int)(this.timescale * (92f - (5f * num2))));
		super.setSafemark((int)(-100f * this.timescale));
		if (this.timescale > 0f){
			super.setLevel(3);
			this.addDriveTag(DriveTagId.outspeed);
			String indesc = String.format("超速行驶%1$s，占整个行程%2$s,%3$s", Utility.getTimeString(this.time), Utility.getScaleString(this.timescale), DriveTagSet.getDriveTag(DriveTagId.outspeed).getPropose());
			this.addDesc(indesc);
		}
	}
}