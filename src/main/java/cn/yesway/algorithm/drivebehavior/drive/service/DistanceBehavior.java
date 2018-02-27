package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;


/** 
 驾驶行为-里程分析
 
*/
public class DistanceBehavior extends BaseBehavior{
	/** 
	 里程分析
	 
	*/
	private LengthBehavior lenbhv;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata 行程数据
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		this.lenbhv = new LengthBehavior();
		this.lenbhv.getBehavior(bhvdata);
		super.setEnvmark(this.lenbhv.getEnvmark()) ;
		super.setSafemark(this.lenbhv.getSafemark());
		super.setEnvmark((super.getEnvmark() > 0) ? super.getEnvmark() : 0);
		super.setEnvmark((super.getEnvmark() < 100) ? super.getEnvmark() : 100);
		super.setSafemark((super.getSafemark() > -100) ? super.getSafemark() : -100);
		super.setSafemark((super.getSafemark() < 0) ? super.getSafemark() : 0);
		this.addDriveTags(this.lenbhv.getDrivetags());
		this.addDescs(this.lenbhv.getDescs());
	}
}