package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 驾驶行为基类
 
*/
public class BaseBehavior{
	/** 
	 驾驶行为描述
	 
	*/
	private java.util.ArrayList<String> descs;
	/** 
	 驾驶标签
	 
	*/
	private java.util.ArrayList<Integer> drivetags;
	/** 
	 环保得分
	 
	*/
	private int envmark;
	/** 
	 级别
	 
	*/
	private int level = 0;
	/** 
	 安全得分
	 
	*/
	private int safemark;
	/** 
	 添加驾驶行为描述（单条）
	 
	 @param indesc 描述
	*/
	public void addDesc(String indesc){
		if (this.descs == null)	{
			this.descs = new java.util.ArrayList<String>();
		}
		this.descs.add(indesc);
	}
	/** 
	 添加驾驶行为描述（批量）
	 
	 @param indescs 描述
	*/
	public void addDescs(java.util.ArrayList<String> indescs){
		if ((indescs != null) && (indescs.size() > 0))	{
			if (this.descs == null)	{
				this.descs = new java.util.ArrayList<String>();
			}
			for (String str : indescs){
				this.descs.add(str);
			}
		}
	}
	/** 
	 添加驾驶行为标签（单条）
	 
	 @param tagid 驾驶行为标签
	*/
	public void addDriveTag(int tagid){
		if (this.drivetags == null){
			this.drivetags = new java.util.ArrayList<Integer>();
		}
		this.drivetags.add(tagid);
	}
	/** 
	 添加驾驶行为标签（批量）
	 
	 @param tags 驾驶行为标签集合
	*/
	public void addDriveTags(java.util.ArrayList<Integer> tags){
		if ((tags != null) && (tags.size() > 0)){
			if (this.drivetags == null)
			{
				this.drivetags = new java.util.ArrayList<Integer>();
			}
			for (int num : tags){
				this.drivetags.add(num);
			}
		}
	}
	/** 
	 获取驾驶行为
	 
	 @param bhvdata 行程数据
	*/
	public void getBehavior(TripBehaviorData bhvdata){
	}
	public java.util.ArrayList<String> getDescs() {
		return descs;
	}
	public void setDescs(java.util.ArrayList<String> descs) {
		this.descs = descs;
	}
	public java.util.ArrayList<Integer> getDrivetags() {
		return drivetags;
	}
	public void setDrivetags(java.util.ArrayList<Integer> drivetags) {
		this.drivetags = drivetags;
	}
	public int getEnvmark() {
		return envmark;
	}
	public void setEnvmark(int envmark) {
		this.envmark = envmark;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getSafemark() {
		return safemark;
	}
	public void setSafemark(int safemark) {
		this.safemark = safemark;
	}
	
	
}