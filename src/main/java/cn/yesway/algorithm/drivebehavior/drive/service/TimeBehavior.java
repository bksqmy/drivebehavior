package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 时间-驾驶行为
 
*/
public class TimeBehavior extends BaseBehavior{
	/** 
	 高峰时间分析
	 
	*/
	public HightBehavior hightbhv;
	/** 
	 区间时间分析
	 
	*/
	public IntervalBehavior intervalbhv;
	/** 
	 早高峰时间分析
	 
	*/
	public MorningTimeBehavior moringbhv;
	/** 
	 晚高峰时间分析
	 
	*/
	public NightTimeBehavior nightbhv;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		this.hightbhv = new HightBehavior();
		this.nightbhv = new NightTimeBehavior();
		this.moringbhv = new MorningTimeBehavior();
		this.intervalbhv = new IntervalBehavior();
		this.hightbhv.getBehavior(bhvdata);
		this.nightbhv.getBehavior(bhvdata);
		this.moringbhv.getBehavior(bhvdata);
		this.intervalbhv.getBehavior(bhvdata);
		this.addDriveTags(this.hightbhv.getDrivetags());
		this.addDriveTags(this.nightbhv.getDrivetags());
		this.addDriveTags(this.moringbhv.getDrivetags());
		this.addDriveTags(this.intervalbhv.getDrivetags());
		this.addDescs(this.hightbhv.getDescs());
		this.addDescs(this.nightbhv.getDescs());
		this.addDescs(this.moringbhv.getDescs());
		this.addDescs(this.intervalbhv.getDescs());
		super.setEnvmark(((this.hightbhv.getEnvmark() + this.nightbhv.getEnvmark()) + this.moringbhv.getEnvmark()) + this.intervalbhv.getEnvmark());
		super.setSafemark(((this.hightbhv.getSafemark() + this.nightbhv.getSafemark()) + this.moringbhv.getSafemark()) + this.intervalbhv.getSafemark()); ;
		super.setEnvmark((super.getEnvmark() > 0) ? super.getEnvmark() : 0);
		super.setEnvmark((super.getEnvmark() < 100) ? super.getEnvmark() : 100) ;
		super.setSafemark((super.getSafemark() > -100) ? super.getSafemark() : -100);
		super.setSafemark((super.getSafemark() < 0) ? super.getSafemark() : 0);
	}
}