package cn.yesway.algorithm.drivebehavior.drive.model;

import java.io.Serializable;

/** 
 速度信息
 
*/
public class SpeedInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8292723167648304778L;
	/** 
	 行驶距离（单位：米）
	 
	*/
	private int distance;
	/** 
	 最高车速（单位：公里/时）
	 
	*/
	private int hightspeed;
	/** 
	 最低车速（单位：公里/时）
	 
	*/
	private int lowspeed;
	/** 
	 行驶时间（单位：秒）
	 
	*/
	private int time;
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getHightspeed() {
		return hightspeed;
	}
	public void setHightspeed(int hightspeed) {
		this.hightspeed = hightspeed;
	}
	public int getLowspeed() {
		return lowspeed;
	}
	public void setLowspeed(int lowspeed) {
		this.lowspeed = lowspeed;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	
}