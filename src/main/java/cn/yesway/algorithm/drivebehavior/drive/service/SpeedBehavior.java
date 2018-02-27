package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 速度-驾驶行为
 
*/
public class SpeedBehavior extends BaseBehavior{
	/** 
	 平均速度分析
	 
	*/
	public SpeedBehavior_average averagebhv;
	/** 
	 高速分析
	 
	*/
	public SpeedBehavior_hight hightbhv;
	/** 
	 怠速分析
	 
	*/
	public SpeedBehavior_idle idlebhv;
	/** 
	 低速分析
	 
	*/
	public SpeedBehavior_low lowbhv;
	/** 
	 中速分析
	 
	*/
	public SpeedBehavior_mid midbhv;
	/** 
	 超高速分析
	 
	*/
	public SpeedBehavior_superhight superhightbhv;
	/** 
	 超低速分析
	 
	*/
	public SpeedBehavior_superlow superlowbhv;
	/** 
	 最高速度分析
	 
	*/
	public SpeedBehavior_top topbhv;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		this.idlebhv = new SpeedBehavior_idle();
		this.superlowbhv = new SpeedBehavior_superlow();
		this.lowbhv = new SpeedBehavior_low();
		this.midbhv = new SpeedBehavior_mid();
		this.hightbhv = new SpeedBehavior_hight();
		this.superhightbhv = new SpeedBehavior_superhight();
		this.topbhv = new SpeedBehavior_top();
		this.averagebhv = new SpeedBehavior_average();
		this.idlebhv.getBehavior(bhvdata);
		this.superlowbhv.getBehavior(bhvdata);
		this.lowbhv.getBehavior(bhvdata);
		this.midbhv.getBehavior(bhvdata);
		this.hightbhv.getBehavior(bhvdata);
		this.superhightbhv.getBehavior(bhvdata);
		this.topbhv.getBehavior(bhvdata);
		this.averagebhv.getBehavior(bhvdata);
		this.addDriveTags(this.idlebhv.getDrivetags());
		this.addDriveTags(this.superlowbhv.getDrivetags());
		this.addDriveTags(this.lowbhv.getDrivetags());
		this.addDriveTags(this.midbhv.getDrivetags());
		this.addDriveTags(this.hightbhv.getDrivetags());
		this.addDriveTags(this.superhightbhv.getDrivetags());
		this.addDriveTags(this.topbhv.getDrivetags());
		this.addDriveTags(this.averagebhv.getDrivetags());
		this.addDescs(this.idlebhv.getDescs());
		this.addDescs(this.superlowbhv.getDescs());
		this.addDescs(this.lowbhv.getDescs());
		this.addDescs(this.midbhv.getDescs());
		this.addDescs(this.hightbhv.getDescs());
		this.addDescs(this.superhightbhv.getDescs());
		this.addDescs(this.topbhv.getDescs());
		this.addDescs(this.averagebhv.getDescs());
		this.idlebhv.timescale += 1f - ((((this.superlowbhv.timescale + this.lowbhv.timescale) + this.midbhv.timescale) + this.hightbhv.timescale) + this.superhightbhv.timescale);
		super.setEnvmark(((((((this.idlebhv.getEnvmark() + this.superlowbhv.getEnvmark()) + this.lowbhv.getEnvmark()) + this.midbhv.getEnvmark()) + this.hightbhv.getEnvmark()) + this.superhightbhv.getEnvmark()) + this.averagebhv.getEnvmark()) + this.topbhv.getEnvmark());
		super.setSafemark(((((((this.idlebhv.getSafemark() + this.superlowbhv.getSafemark()) + this.lowbhv.getSafemark()) + this.midbhv.getSafemark()) + this.hightbhv.getSafemark()) + this.superhightbhv.getSafemark()) + this.averagebhv.getSafemark()) + this.topbhv.getSafemark());
		super.setEnvmark((super.getEnvmark() > 0) ? super.getEnvmark() : 0);
		super.setEnvmark((super.getEnvmark() < 100) ? super.getEnvmark() : 100);
	}
}