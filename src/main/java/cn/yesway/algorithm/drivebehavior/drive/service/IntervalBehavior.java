package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 行驶时长-驾驶行为
 
*/
public class IntervalBehavior extends BaseBehavior{
	/** 
	 Interval时间
	 
	*/
	private int interval;
	/** 
	 疲劳时间
	 
	*/
	private int tiredtimes;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata 行程数据
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		this.interval = bhvdata.getRunningtime();
		if (this.interval == 0)	{
			super.setEnvmark(0);
			super.setSafemark(0);
			this.addDriveTag(DriveTagId.zerotime);
			String indesc = String.format("熄火太快，%1$s", DriveTagSet.getDriveTag(DriveTagId.zerotime).getPropose());
			this.addDesc(indesc);
			super.setLevel(2);
		}
		if (bhvdata.getDistance() > 0){
			if (this.interval < 7200)	{
				super.setEnvmark(0);
				super.setSafemark(0);
				super.setLevel(1);
			}else if ((this.interval > 7200) && (this.interval < 14400))	{
				super.setSafemark( (-(this.interval - 7200) * 10) / 7200);
				super.setEnvmark(0);
				super.setLevel(2);
				this.addDriveTag(DriveTagId.longtime);
				String str2 = String.format("行驶%1$s，%2$s", Utility.getTimeString(this.interval), DriveTagSet.getDriveTag(DriveTagId.longtime).getPropose());
				this.addDesc(str2);
			}else if (this.interval > 0x3840){
				this.tiredtimes = this.interval - 0x3840;
				super.setEnvmark(0);
				super.setSafemark(-100);
				super.setLevel(3);
				this.addDriveTag(DriveTagId.tired);
				String str3 = String.format("行驶时间%1$s,属疲劳驾驶，%2$s", Utility.getTimeString(this.interval), DriveTagSet.getDriveTag(DriveTagId.tired).getPropose());
				this.addDesc(str3);
			}
		}
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public int getTiredtimes() {
		return tiredtimes;
	}
	public void setTiredtimes(int tiredtimes) {
		this.tiredtimes = tiredtimes;
	}
	
	
}