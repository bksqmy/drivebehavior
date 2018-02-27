package cn.yesway.algorithm.drivebehavior.drive.model;

import java.io.Serializable;

/** 
 设备信息
 
*/
public class DeviceInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1252248473860245204L;
	/** 
	 设备ID
	 
	*/
	private String devid;
	/** 
	 车牌号
	 
	*/
	private String pnumber;
	/** 
	 车架号
	 
	*/
	private String vin;
	/** 
	 车型
	 
	*/
	private String vid;
	public String getDevid() {
		return devid;
	}
	public void setDevid(String devid) {
		this.devid = devid;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	
	
}