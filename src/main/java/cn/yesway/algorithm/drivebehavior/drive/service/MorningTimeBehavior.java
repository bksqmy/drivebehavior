package cn.yesway.algorithm.drivebehavior.drive.service;

import java.util.Calendar;
import java.util.Date;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 早高峰驾驶行为
 
*/
public class MorningTimeBehavior extends BaseBehavior{
	/** 
	 早高峰标度
	 
	*/
	private float morningscale;
	/** 
	 早高峰时间
	 
	*/
	private long morningtimes;
	/** 
	 晚高峰标度
	 
	*/
	private float nightscale;
	/** 
	 晚高峰时间
	 
	*/
	private int nighttimes;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata 行程数据
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		java.util.Date endtime = bhvdata.getEndtime();
		Calendar cal = Calendar.getInstance();
		cal.setTime(endtime);
		
		Calendar cal3 = Calendar.getInstance();
		Calendar cal4 = Calendar.getInstance();
		if ((bhvdata.getRunningtime() <= 0) || (bhvdata.getDistance() <= 0)){
			super.setLevel(0);
			super.setEnvmark(0);
			super.setSafemark(0);
		}else if (cal.get(Calendar.YEAR) == 1970){
			super.setLevel(0);
			super.setEnvmark(0);
			super.setSafemark(0);
		}else if (bhvdata.getDistance() <= 30){
			super.setLevel(0);
			super.setEnvmark(0);
			super.setSafemark(0);
		}else{
			java.util.Date time3 = new java.util.Date(0);
			java.util.Date time4 = new java.util.Date(0);
			
			int runningTime = bhvdata.getRunningtime();
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(endtime);
			
			Calendar cal2 = Calendar.getInstance();
			cal2.setTimeInMillis(cal1.getTime().getTime() - runningTime);
			Date time2 = cal2.getTime();
			
			if (cal2.get(Calendar.DATE) == cal.get(Calendar.DATE)){
				cal3.set(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), cal2.get(Calendar.DATE), 0, 0,0);
				cal4.set(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), cal2.get(Calendar.DATE), 5, 0,0);

				time3 = cal3.getTime();
				time4 = cal4.getTime();			
				
				this.morningtimes = Utility.getOverlapTimes(time2, endtime, time3, time4);
			}else{
				cal3.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0,0);
				cal4.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 5, 0,0);

				time3 = cal3.getTime();
				time4 = cal4.getTime();	
				this.morningtimes = Utility.getOverlapTimes(time2, endtime, time3, time4);
			}
			this.morningscale = ((float)this.morningtimes) / ((float)bhvdata.getRunningtime());
			super.setEnvmark(0);
			if (this.morningtimes > 0){
				super.setSafemark( -((int)((this.morningtimes * 20f) / 18000f)));
				super.setLevel(0);
				this.addDriveTag(DriveTagId.morning);
				String indesc = String.format("凌晨行驶%1$s，%2$s", Utility.getTimeString(this.morningtimes), DriveTagSet.getDriveTag(DriveTagId.morning).getPropose());
				this.addDesc(indesc);
			}else{
				super.setSafemark(0);
			}
		}
	}
	public float getMorningscale() {
		return morningscale;
	}
	public void setMorningscale(float morningscale) {
		this.morningscale = morningscale;
	}
	public long getMorningtimes() {
		return morningtimes;
	}
	public void setMorningtimes(long morningtimes) {
		this.morningtimes = morningtimes;
	}
	public float getNightscale() {
		return nightscale;
	}
	public void setNightscale(float nightscale) {
		this.nightscale = nightscale;
	}
	public int getNighttimes() {
		return nighttimes;
	}
	public void setNighttimes(int nighttimes) {
		this.nighttimes = nighttimes;
	}
	
	
}