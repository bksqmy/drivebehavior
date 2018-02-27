package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 激烈-驾驶行为
 
*/
public class RapidlyBehavior extends BaseBehavior{
	/** 
	 急刹车
	 
	*/
	private RapidlyDownBehavior downbhv;
	/** 
	 急转弯
	 
	*/
	private RapidlyTurnBehavior turnbhv;
	/** 
	 急加速
	 
	*/
	private RapidlyUpBehavior upbhv;

	/** 
	 获取激烈驾驶行为分析
	 
	 @param bhvdata 驾驶行为数据
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		this.upbhv = new RapidlyUpBehavior();
		this.downbhv = new RapidlyDownBehavior();
		this.turnbhv = new RapidlyTurnBehavior();
		this.upbhv.getBehavior(bhvdata);
		this.downbhv.getBehavior(bhvdata);
		this.turnbhv.getBehavior(bhvdata);
		this.addDriveTags(this.upbhv.getDrivetags());
		this.addDriveTags(this.downbhv.getDrivetags());
		this.addDriveTags(this.turnbhv.getDrivetags());
		this.addDescs(this.upbhv.getDescs());
		this.addDescs(this.downbhv.getDescs());
		this.addDescs(this.turnbhv.getDescs());
		super.setEnvmark((this.upbhv.getEnvmark()+ this.downbhv.getEnvmark()) + this.turnbhv.getEnvmark());
		super.setEnvmark((super.getEnvmark() > -25) ? super.getEnvmark() : -25) ;
		super.setEnvmark((super.getEnvmark() < 0) ? super.getEnvmark() : 0) ;
		super.setSafemark((this.upbhv.getSafemark()+ this.downbhv.getSafemark()) + this.turnbhv.getSafemark());
		super.setSafemark((super.getSafemark() > -40) ? super.getSafemark() : -40) ;
		super.setSafemark((super.getSafemark() < 0) ? super.getSafemark() : 0) ;
	}
}