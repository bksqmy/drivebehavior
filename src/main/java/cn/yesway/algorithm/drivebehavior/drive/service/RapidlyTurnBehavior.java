﻿package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 急转弯-激烈驾驶行为分析
 
*/
public class RapidlyTurnBehavior extends BaseBehavior{
	/** 
	 次
	 
	*/
	public int times;
	/** 
	  百公里急转弯次数
	 
	*/
	public float timesper100;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata 行程数据
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		int distance = bhvdata.getDistance();
		this.times = bhvdata.getRapidlydowntimes();
		if (distance < 0x186a0){
			this.timesper100 = this.times;
		}else{
			this.timesper100 = ((float)this.times) / (((float)distance) / 100000f);
		}
		if (this.timesper100 >= 15f){
			super.setEnvmark(0);
			super.setSafemark(-60);
			super.setLevel(2);
			this.addDriveTag(DriveTagId.rapidturn);
			String indesc = String.format("急转弯%1$s次，%2$s", this.times, DriveTagSet.getDriveTag(DriveTagId.rapidturn).getPropose());
			this.addDesc(indesc);
		}else if ((this.timesper100 > 0f) && (this.timesper100 < 15f)){
			super.setEnvmark(0);
			super.setSafemark((int)(-4f * this.timesper100));
			super.setLevel(2);
			this.addDriveTag(DriveTagId.rapidturn);
			String str2 = String.format("急转弯%1$s次，%2$s", this.times, DriveTagSet.getDriveTag(DriveTagId.rapidturn).getPropose());
			this.addDesc(str2);
		}else{
			super.setEnvmark(0);
			super.setSafemark(0);
			super.setLevel(1);
		}
	}
}