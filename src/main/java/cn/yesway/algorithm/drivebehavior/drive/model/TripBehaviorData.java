package cn.yesway.algorithm.drivebehavior.drive.model;

import java.io.Serializable;

/** 
 行程数据
 
*/
public class TripBehaviorData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -172534170957076913L;
	/** 
	 设备信息
	 
	*/
	private DeviceInfo devinfo;
	/** 
	 平均车速（单位：公里/时）
	 
	*/
	private int avgspeed;
	/** 
	 点火位置
	 
	*/
	private Location beginloc;
	/** 
	 点火时间
	 
	*/
	private java.util.Date begintime = new java.util.Date(0);
	/** 
	 行驶距离（单位：米）
	 
	*/
	private int distance;
	/** 
	 熄火位置
	 
	*/
	private Location endloc;
	/** 
	 熄火时间
	 
	*/
	private java.util.Date endtime = new java.util.Date(0);
	/** 
	 本次油耗（单位：升/百公里）
	 
	*/
	private float oilavg;
	/** 
	 累计油耗（单位：升/百公里）
	 
	*/
	private float oiltotal;
	/** 
	 超速时间（单位：秒）
	 
	*/
	private int outspeedtime;
	/** 
	 急刹车次数
	 
	*/
	private int rapidlydowntimes;
	/** 
	 急转弯次数
	 
	*/
	private int rapidlyturntimes;
	/** 
	 急加速次数
	 
	*/
	private int rapidlyuptimes;
	/** 
	 行驶时间
	 
	*/
	private int runningtime;
	/** 
	 速度分组
	 
	*/
	private SpeedInfo[] speedgroup;
	/** 
	 子行程ID集合
	 
	*/
	private String[] subtrips;
	/** 
	 最高车速（单位：公里/时）
	 
	*/
	private int topspeed;
	/** 
	 行程ID
	 
	*/
	private String tripid;
	public DeviceInfo getDevinfo() {
		return devinfo;
	}
	public void setDevinfo(DeviceInfo devinfo) {
		this.devinfo = devinfo;
	}
	public int getAvgspeed() {
		return avgspeed;
	}
	public void setAvgspeed(int avgspeed) {
		this.avgspeed = avgspeed;
	}
	public Location getBeginloc() {
		return beginloc;
	}
	public void setBeginloc(Location beginloc) {
		this.beginloc = beginloc;
	}
	public java.util.Date getBegintime() {
		return begintime;
	}
	public void setBegintime(java.util.Date begintime) {
		this.begintime = begintime;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public Location getEndloc() {
		return endloc;
	}
	public void setEndloc(Location endloc) {
		this.endloc = endloc;
	}
	public java.util.Date getEndtime() {
		return endtime;
	}
	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}
	public float getOilavg() {
		return oilavg;
	}
	public void setOilavg(float oilavg) {
		this.oilavg = oilavg;
	}
	public float getOiltotal() {
		return oiltotal;
	}
	public void setOiltotal(float oiltotal) {
		this.oiltotal = oiltotal;
	}
	public int getOutspeedtime() {
		return outspeedtime;
	}
	public void setOutspeedtime(int outspeedtime) {
		this.outspeedtime = outspeedtime;
	}
	public int getRapidlydowntimes() {
		return rapidlydowntimes;
	}
	public void setRapidlydowntimes(int rapidlydowntimes) {
		this.rapidlydowntimes = rapidlydowntimes;
	}
	public int getRapidlyturntimes() {
		return rapidlyturntimes;
	}
	public void setRapidlyturntimes(int rapidlyturntimes) {
		this.rapidlyturntimes = rapidlyturntimes;
	}
	public int getRapidlyuptimes() {
		return rapidlyuptimes;
	}
	public void setRapidlyuptimes(int rapidlyuptimes) {
		this.rapidlyuptimes = rapidlyuptimes;
	}
	public int getRunningtime() {
		return runningtime;
	}
	public void setRunningtime(int runningtime) {
		this.runningtime = runningtime;
	}
	public SpeedInfo[] getSpeedgroup() {
		return speedgroup;
	}
	public void setSpeedgroup(SpeedInfo[] speedgroup) {
		this.speedgroup = speedgroup;
	}
	public String[] getSubtrips() {
		return subtrips;
	}
	public void setSubtrips(String[] subtrips) {
		this.subtrips = subtrips;
	}
	public int getTopspeed() {
		return topspeed;
	}
	public void setTopspeed(int topspeed) {
		this.topspeed = topspeed;
	}
	public String getTripid() {
		return tripid;
	}
	public void setTripid(String tripid) {
		this.tripid = tripid;
	}
	
	
}