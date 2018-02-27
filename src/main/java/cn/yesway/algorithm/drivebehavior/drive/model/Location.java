package cn.yesway.algorithm.drivebehavior.drive.model;

/** 
 位置信息
 
*/
public class Location extends BaseLocation{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7019486297389363977L;
	/** 
	 方向（0-360度，正北为0度，顺时针顺序）
	 
	*/
	private int direction;
	/** 
	 里程（单位：米）
	 注：从发动机点火开始计算的累计里程
	 
	*/
	private int distance;
	/** 
	 定位时间
	 
	*/
	private java.util.Date dtLocation = new java.util.Date(0);
	/** 
	 速度（单位：公里/时）
	 
	*/
	private int speed;
	/** 
	 定位方式（0-未定位、1-基站定位、2-GPS定位、3-北斗定位）
	 
	*/
	private String type;
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public java.util.Date getDtLocation() {
		return dtLocation;
	}
	public void setDtLocation(java.util.Date dtLocation) {
		this.dtLocation = dtLocation;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}