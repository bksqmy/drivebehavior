package cn.yesway.algorithm.drivebehavior.drive.model;

import java.io.Serializable;

/** 
 位置基类
 
*/
public class BaseLocation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 332312506475933827L;
	/** 
	 经度
	 
	*/
	private float x;
	/** 
	 纬度
	 
	*/
	private float y;
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	
}