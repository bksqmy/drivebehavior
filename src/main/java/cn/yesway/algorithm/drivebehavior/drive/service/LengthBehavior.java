package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 行驶距离-驾驶行为
 
*/
public class LengthBehavior extends BaseBehavior{
	/** 
	 里程
	 
	*/
	private int distance;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata 行程数据
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		super.setSafemark((int)((-bhvdata.getDistance() * 5f) / 400000f));
		if (super.getSafemark() >= 0){
			super.setSafemark(0);
		}
		this.distance = bhvdata.getDistance();
		if (this.distance <= 0){
			super.setEnvmark(0);
			this.addDriveTag(DriveTagId.zeroidle);
			this.addDesc(DriveTagSet.getDriveTag(DriveTagId.zeroidle).getPropose());
			super.setLevel(2);
		}else if (this.distance < 500){
			super.setEnvmark((bhvdata.getDistance() * 50) / 500);
			this.addDriveTag(DriveTagId.tooshort);
			this.addDesc("行程距离小于500米，" + DriveTagSet.getDriveTag(DriveTagId.tooshort).getPropose());
			super.setLevel(2);
		}else if (this.distance < 0x3e8){
			super.setEnvmark( 50 + (((this.distance - 500) * 20) / 500)) ;
			this.addDriveTag(DriveTagId.shortdistance);
			String indesc = String.format("行程距离%1$s米，%2$s", this.distance, DriveTagSet.getDriveTag(DriveTagId.shortdistance).getPropose());
			this.addDesc(indesc);
			super.setLevel(2);
		}else if (this.distance < 0xbb8){
			super.setEnvmark( 70 + (((this.distance - 0x3e8) * 30) / 0x7d0));
			this.addDriveTag(DriveTagId.shortdistance);
			String str2 = String.format("行程距离%1$s米，%2$s", this.distance, DriveTagSet.getDriveTag(DriveTagId.shortdistance).getPropose());
			this.addDesc(str2);
			super.setLevel(2);
		}else if (this.distance < 0x30d40){
			super.setEnvmark(100);
			super.setLevel(1);
		}else{
			super.setEnvmark(100);
			this.addDriveTag(DriveTagId.longdistance);
			String str3 = String.format("行程距离%1$s公里，%2$s", ((Integer)(this.distance / 1000)).toString(), DriveTagSet.getDriveTag(DriveTagId.longdistance).getPropose());
			this.addDesc(str3);
			super.setLevel(2);
		}
	}
}