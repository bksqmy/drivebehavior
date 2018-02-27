package cn.yesway.algorithm.drivebehavior.drive.service;

import java.util.Calendar;
import java.util.Date;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 高峰驾驶行为
 
*/
public class HightBehavior extends BaseBehavior{
	/** 
	 高峰标度
	 
	*/
	private float heightscale;
	/** 
	 高峰时间
	 
	*/
	private long heighttimes;
	/** 
	 高峰类型  0-无效、1-早高峰、2-晚高峰、3-高峰区间
	 
	*/
	private int heighttype;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata 行程数据
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		Date endtime = bhvdata.getEndtime();
		Calendar cal = Calendar.getInstance();
		cal.setTime(endtime);	
		
		if ((bhvdata.getRunningtime() <= 0) || (bhvdata.getDistance() <= 0))	{
			super.setLevel(0);
			super.setEnvmark(0);
			super.setSafemark(0);
			this.heighttype = 0;
		}else if (cal.get(Calendar.YEAR) == 1970){
			super.setLevel(0);
			super.setEnvmark(0);
			super.setSafemark(0);
			this.heighttype = 0;
		}else if ((cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY))	{
			super.setLevel(0);
			super.setEnvmark(0);
			super.setSafemark(0);
			this.heighttype = 0;
		}else{
			java.util.Date time3 = new java.util.Date(0);
			java.util.Date time4 = new java.util.Date(0);
			long num=0L;
			int runningTime = bhvdata.getRunningtime();	
			
			Calendar cal1 = Calendar.getInstance();
			cal1.setTimeInMillis(cal.getTime().getTime()-runningTime);
			java.util.Date time2 = cal1.getTime();
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(time2);
			
			Calendar cal3 = Calendar.getInstance();
			Calendar cal4 = Calendar.getInstance();
			if (cal2.get(Calendar.DATE) == cal.get(Calendar.DATE)){
				
				cal3.set(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), cal2.get(Calendar.DATE), 7, 0,0);
				cal4.set(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), cal2.get(Calendar.DATE), 9, 0,0);
				
				time3 = cal3.getTime();
				time4 = cal4.getTime();
				num = Utility.getOverlapTimes(time2, endtime, time3, time4);
			}else{
				
				cal3.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 7, 0,0);
				cal4.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 9, 0,0);
				
				time3 = cal3.getTime();
				time4 = cal4.getTime();
				num = Utility.getOverlapTimes(time2, endtime, time3, time4);
			}
			cal3.set(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), cal2.get(Calendar.DATE), 17, 0,0);
			cal4.set(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), cal2.get(Calendar.DATE), 19, 0,0);
			
			time3 = cal3.getTime();
			time4 = cal4.getTime();			
			
			long num2 = Utility.getOverlapTimes(time2, endtime, time3, time4);
			if ((num > 0) && (num2 > 0)){
				this.heighttype = 3;
			}else if (num > 0){
				this.heighttype = 1;
			}else if (num2 > 0)	{
				this.heighttype = 2;
			}else{
				this.heighttype = 0;
			}
			this.heighttimes = num + num2;
			this.heightscale = ((float)this.heighttimes) / ((float)bhvdata.getRunningtime());
			if (bhvdata.getAvgspeed() < 30){
				super.setEnvmark( -((int)((5f * this.heighttimes) / 7200f)));
				super.setSafemark( -((int)((5f * this.heighttimes) / 7200f)));
			}else{
				super.setEnvmark(0);
				super.setSafemark(0);
			}
		}
		if (this.heighttype == 1){
			super.setLevel(2);
			this.addDriveTag(DriveTagId.hightmoring);
			String indesc = String.format("早高峰行驶%1$s，%2$s", Utility.getTimeString(this.heighttimes), DriveTagSet.getDriveTag(DriveTagId.hightmoring).getPropose());
			this.addDesc(indesc);
		}else if (this.heighttype == 2)	{
			super.setLevel(2);
			this.addDriveTag(DriveTagId.hithgnight);
			String str2 = String.format("晚高峰行驶%1$s，%2$s", Utility.getTimeString(this.heighttimes), DriveTagSet.getDriveTag(DriveTagId.hithgnight).getPropose());
			this.addDesc(str2);
		}
	}
	public float getHeightscale() {
		return heightscale;
	}
	public void setHeightscale(float heightscale) {
		this.heightscale = heightscale;
	}
	public long getHeighttimes() {
		return heighttimes;
	}
	public void setHeighttimes(long heighttimes) {
		this.heighttimes = heighttimes;
	}
	public int getHeighttype() {
		return heighttype;
	}
	public void setHeighttype(int heighttype) {
		this.heighttype = heighttype;
	}
	
	
}