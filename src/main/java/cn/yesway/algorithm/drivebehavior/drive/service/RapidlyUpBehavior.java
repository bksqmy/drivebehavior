package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 急加速-激烈驾驶行为分析
 
*/
public class RapidlyUpBehavior extends BaseBehavior{
	/** 
	 次
	 
	*/
	public int times;
	/** 
	  百公里急加速次数
	 
	*/
	public float timesper100;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata 行程数据
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		int distance = bhvdata.getDistance();
		this.times = bhvdata.getRapidlyuptimes();
		if (distance < 100000){
			this.timesper100 = this.times;
		}else{
			this.timesper100 = ((float)this.times) / (((float)distance) / 100000f);
		}
		if (this.timesper100 >= 15f){
			super.setEnvmark(-30);
			super.setSafemark(-30);
			super.setLevel(2);
			this.addDriveTag(DriveTagId.rapidlyup);
			String indesc = String.format("急加速%1$s次，%2$s", this.times, DriveTagSet.getDriveTag(DriveTagId.rapidlyup).getPropose());
			this.addDesc(indesc);
		}else if ((this.timesper100 > 0f) && (this.timesper100 < 15f)){
			super.setEnvmark((int)(-2f * this.timesper100)) ;
			super.setEnvmark((super.getEnvmark() > -20) ? super.getEnvmark() : -20);
			super.setSafemark((int)(-2f * this.timesper100));
			super.setLevel(2);
			this.addDriveTag(DriveTagId.rapidlyup);
			String str2 = String.format("急加速%1$s次，%2$s", this.times, DriveTagSet.getDriveTag(DriveTagId.rapidlyup).getPropose());
			this.addDesc(str2);
		}else{
			super.setEnvmark(0);
			super.setSafemark(0);
			super.setLevel(1);
		}
	}
}