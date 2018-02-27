package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.SpeedInfo;
import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 超低速-速度驾驶行为分析
 
*/
public class SpeedBehavior_superlow extends BaseBehavior{
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
	 
	 @param bhvdata
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		SpeedInfo[] speedgroup = bhvdata.getSpeedgroup();		
		int num = (((speedgroup[0].getTime() + speedgroup[1].getTime()) + speedgroup[2].getTime()) + speedgroup[3].getTime()) + speedgroup[4].getTime() + speedgroup[5].getTime();
		
		int num2 = ((speedgroup[1].getTime() + speedgroup[2].getTime()) + speedgroup[3].getTime()) + speedgroup[4].getTime() + speedgroup[5].getTime();
		this.time = speedgroup[1].getTime();
		this.distance = speedgroup[1].getDistance();
		float num3 = 0f;
		if (num > 0)		{
			this.timescale = ((float)this.time) / ((float)num);
			num3 = ((float)speedgroup[0].getTime()) / ((float)num);
		}
		else{
			this.timescale = 0f;
			num3 = 0f;
		}
		if (bhvdata.getDistance() > 0){
			this.distancescale = ((float)this.distance) / ((float)bhvdata.getDistance());
		}
		else{
			this.distancescale = 0f;
		}
		if (this.time > 0){
			this.average = (int)((((double)this.distance) / 1000.0) / (((double)this.time) / 3600.0));
		}
		else{
			this.average = 0;
		}
		float num4 = (float)(((double)this.average) / 30.0);
		num4 = (num4 < 1f) ? num4 : 1f;
		num4 = (num4 > 0f) ? num4 : 0f;
		super.setEnvmark((int)(this.timescale * (80f + (10f * num4))));
		super.setSafemark((int)(this.timescale * (100f - (2f * num4))));
		if (num2 > 0)	{
			/*float single1 = ((float)this.time) / ((float)num2);*/
		}
		if (((this.timescale >= 0.5) && (this.time > 60)) && (bhvdata.getAvgspeed() <= 30)){
			this.addDriveTag(DriveTagId.slow);
			String indesc = String.format("低速行驶%1$s，占整个行程时间%2$s，%3$s", Utility.getTimeString(this.time), Utility.getScaleString(this.timescale), DriveTagSet.getDriveTag(DriveTagId.slow).getPropose());
			this.addDesc(indesc);
			super.setLevel(2);
		}else if ((((this.timescale + num3) > 0.7) && (num3 < 0.4)) && ((this.time > 60) && (bhvdata.getAvgspeed() <= 30))){
			this.addDriveTag(DriveTagId.slow);
			String str2 = String.format("行驶缓慢，可能部分路段拥堵，%3$s", Utility.getTimeString(this.time), Utility.getScaleString(this.timescale), DriveTagSet.getDriveTag(DriveTagId.slow).getPropose());
			this.addDesc(str2);
			super.setLevel(2);
		}else if (this.timescale > 0f){
			super.setLevel(1);
		}
	}
}