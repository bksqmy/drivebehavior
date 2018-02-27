package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.SpeedInfo;
import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 速度-怠速驾驶行为分析
 
*/
public class SpeedBehavior_idle extends BaseBehavior{
	/** 
	 怠速距离
	 
	*/
	public int distance;
	/** 
	 怠速时间
	 
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
		this.time = speedgroup[0].getTime();
		this.distance = speedgroup[0].getDistance();
		if (num > 0){
			this.timescale = ((float)this.time) / ((float)num);
			super.setEnvmark((int)((this.timescale * (1f - this.timescale)) * 50f));
			super.setSafemark((int)(this.timescale * 100f));
		}else{
			this.timescale = 1f;
			super.setEnvmark(50);
			super.setSafemark((int)(this.timescale * 100f));
		}
		super.setLevel(1);
		if (this.timescale >= 0.4){
			this.addDriveTag(DriveTagId.longidle);
			String indesc = String.format("怠速%1$s，占整个行程%2$s,%3$s", Utility.getTimeString(this.time), Utility.getScaleString(this.timescale), DriveTagSet.getDriveTag(DriveTagId.longidle).getPropose());
			this.addDesc(indesc);
			super.setLevel(2);
		}
	}
}