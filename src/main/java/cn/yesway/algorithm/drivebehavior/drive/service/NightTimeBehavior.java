package cn.yesway.algorithm.drivebehavior.drive.service;

import java.util.Calendar;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 晚间驾驶行为
 
*/
public class NightTimeBehavior extends BaseBehavior{
	/** 
	 百分比
	 
	*/
	public float nightscale;
	/** 
	 夜间驾驶时间
	 
	*/
	public long nighttimes;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata 行程数据
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		java.util.Date endtime = bhvdata.getEndtime();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(endtime);
		
		if ((bhvdata.getRunningtime() <= 0) || (bhvdata.getDistance() <= 0)){
			super.setLevel(0);
			super.setEnvmark(0);
			super.setSafemark(0);
		}else if (cal.get(Calendar.YEAR) == 1970){
			super.setLevel(0);
			super.setEnvmark(0);
			super.setSafemark(0);
		}else{
			java.util.Date time3 = new java.util.Date(0);
			java.util.Date time4 = new java.util.Date(0);		
			
			int runningTime = bhvdata.getRunningtime();	
			Calendar cal1 = Calendar.getInstance();
			cal1.setTimeInMillis(cal.getTime().getTime()-runningTime);
			java.util.Date time2 = cal1.getTime();
			
			Calendar cal3 = Calendar.getInstance();
			Calendar cal4 = Calendar.getInstance();
			if (cal1.get(Calendar.DATE) == cal.get(Calendar.DATE)){
				cal3.set(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), cal1.get(Calendar.DATE), 19, 0,0);
				cal4.set(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), cal1.get(Calendar.DATE), 23, 59,59);
				
				time3 = cal3.getTime();
				time4 = cal4.getTime();
				this.nighttimes = Utility.getOverlapTimes(time2, endtime, time3, time4);
			}else{
				cal3.set(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), cal1.get(Calendar.DATE), 19, 0,0);
				cal4.set(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), cal1.get(Calendar.DATE), 23, 59,59);
				
				time3 = cal3.getTime();
				time4 = cal4.getTime();
				this.nighttimes = Utility.getOverlapTimes(time2, endtime, time3, time4);
			}
			this.nightscale = ((float)this.nighttimes) / ((float)bhvdata.getRunningtime());
			super.setEnvmark(0);
			if (this.nighttimes > 0){
				super.setSafemark(-((int)((this.nighttimes * 10f) / 18000f)));
				super.setLevel(2);
				this.addDriveTag(DriveTagId.night);
				String indesc = String.format("晚间行驶%1$s，%2$s", Utility.getTimeString(this.nighttimes), DriveTagSet.getDriveTag(DriveTagId.night).getPropose());
				this.addDesc(indesc);
			}else{
				super.setSafemark(0);
			}
		}
	}
}