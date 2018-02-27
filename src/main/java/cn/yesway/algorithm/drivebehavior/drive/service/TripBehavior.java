package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 驾驶行为-行程
 
*/
public class TripBehavior extends BaseBehavior{
	/** 
	 里程分析
	 
	*/
	public DistanceBehavior distancebhv = new DistanceBehavior();
	/** 
	 油耗分析
	 
	*/
	public OilBhavior oilbhv = new OilBhavior();
	/** 
	 激烈驾驶行为分析
	 
	*/
	public RapidlyBehavior rapidlybhv = new RapidlyBehavior();
	/** 
	 速度分析
	 
	*/
	public SpeedBehavior speedbhv = new SpeedBehavior();
	/** 
	 星级
	 
	*/
	public int star;
	/** 
	 时间分析
	 
	*/
	public TimeBehavior timebhv = new TimeBehavior();
	public DistanceBehavior getDistancebhv() {
		return distancebhv;
	}
	public void setDistancebhv(DistanceBehavior distancebhv) {
		this.distancebhv = distancebhv;
	}
	public OilBhavior getOilbhv() {
		return oilbhv;
	}
	public void setOilbhv(OilBhavior oilbhv) {
		this.oilbhv = oilbhv;
	}
	public RapidlyBehavior getRapidlybhv() {
		return rapidlybhv;
	}
	public void setRapidlybhv(RapidlyBehavior rapidlybhv) {
		this.rapidlybhv = rapidlybhv;
	}
	public SpeedBehavior getSpeedbhv() {
		return speedbhv;
	}
	public void setSpeedbhv(SpeedBehavior speedbhv) {
		this.speedbhv = speedbhv;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public TimeBehavior getTimebhv() {
		return timebhv;
	}
	public void setTimebhv(TimeBehavior timebhv) {
		this.timebhv = timebhv;
	}
	public int getTotalmark() {
		return totalmark;
	}
	public void setTotalmark(int totalmark) {
		this.totalmark = totalmark;
	}
	/** 
	 总分数
	 
	*/
	public int totalmark;
	/** 
	 创建驾驶行为
	 
	 @param bhvdata
	 @return 
	*/
	public static TripBehavior createBehavior(TripBehaviorData bhvdata)
	{
		TripBehavior behavior = new TripBehavior();
		behavior.getBehavior(bhvdata);
		return behavior;
	}
	/** 
	 获取驾驶行为
	 
	 @param bhvdata
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata)
	{
		this.distancebhv.getBehavior(bhvdata);
		this.timebhv.getBehavior(bhvdata);
		this.speedbhv.getBehavior(bhvdata);
		this.rapidlybhv.getBehavior(bhvdata);
		this.oilbhv.getBehavior(bhvdata);
		this.addDriveTags(this.distancebhv.getDrivetags());
		this.addDriveTags(this.timebhv.getDrivetags());
		this.addDriveTags(this.speedbhv.getDrivetags());
		this.addDriveTags(this.rapidlybhv.getDrivetags());
		this.addDriveTags(this.oilbhv.getDrivetags());
		this.addDescs(this.distancebhv.getDescs());
		this.addDescs(this.timebhv.getDescs());
		this.addDescs(this.speedbhv.getDescs());
		this.addDescs(this.rapidlybhv.getDescs());
		this.addDescs(this.oilbhv.getDescs());
		super.setEnvmark(((((this.speedbhv.getEnvmark() * this.distancebhv.getEnvmark()) / 100) + this.timebhv.getEnvmark()) + this.rapidlybhv.getEnvmark()) + this.oilbhv.getEnvmark());
		super.setSafemark((((this.speedbhv.getSafemark() + this.distancebhv.getSafemark()) + this.timebhv.getSafemark()) + this.rapidlybhv.getSafemark()) + this.oilbhv.getSafemark());
		super.setEnvmark((super.getEnvmark() > 0) ? super.getEnvmark() : 0) ;
		super.setEnvmark((super.getEnvmark() < 100) ? super.getEnvmark() : 100) ;
		super.setSafemark((super.getSafemark() < 100) ? super.getSafemark() : 100);
		super.setSafemark((super.getSafemark() > 0) ? super.getSafemark() : 0) ;
		this.totalmark = (super.getEnvmark() + super.getSafemark()) / 2;
		if (this.totalmark < 30)
		{
			this.star = 1;
		}
		else if (this.totalmark < 60)
		{
			this.star = 2;
		}
		else if (this.totalmark < 80)
		{
			this.star = 3;
		}
		else if (this.totalmark < 90)
		{
			this.star = 4;
		}
		else
		{
			this.star = 5;
		}
	}
}