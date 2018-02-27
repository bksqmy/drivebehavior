package cn.yesway.algorithm.drivebehavior.drive.service;

/** 
 驾驶标签ID
 
*/
public interface DriveTagId{
	/** 
	 早高峰行驶
	 
	*/
	public int hightmoring = 3;
	/** 
	 晚高峰行驶
	 
	*/
	public int hithgnight = 4;
	/** 
	 长途行驶
	 
	*/
	public int longdistance = 10;
	/** 
	 怠速偏长
	 
	*/
	public int longidle = 11;
	/** 
	 长时间驾驶
	 
	*/
	public int longtime = 0x12;
	/** 
	 凌晨行车
	 
	*/
	public int morning = 5;
	/** 
	 晚间行车
	 
	*/
	public int night = 6;
	/** 
	 油耗偏高
	 
	*/
	public int oilhight = 0x13;
	/** 
	 超速行驶
	 
	*/
	public int outspeed = 0x10;
	/** 
	 急减速
	 
	*/
	public int rapidlydown = 14;
	/** 
	 急加速
	 
	*/
	public int rapidlyup = 13;
	/** 
	 急转弯
	 
	*/
	public int rapidturn = 15;
	/** 
	 短距离行驶
	 
	*/
	public int shortdistance = 8;
	/** 
	 行驶缓慢
	 
	*/
	public int slow = 12;
	/** 
	 疲劳驾驶
	 
	*/
	public int tired = 7;
	/** 
	 极短距离行驶
	 
	*/
	public int tooshort = 9;
	/** 
	 原地怠速
	 
	*/
	public int zeroidle = 1;
	/** 
	 原地长时间怠速
	 
	*/
	public int zerolongidle = 2;
	/** 
	 熄火过快
	 
	*/
	public int zerotime = 0x11;
	
	
}