package cn.yesway.algorithm.drivebehavior.drive.service;

import cn.yesway.algorithm.drivebehavior.drive.model.TripBehaviorData;



public class AverageOilBhavior extends BaseBehavior{
	/** 
	 平均油耗（单位：升/百公里）
	 
	*/
	private float avgoil;
	/** 
	 累计油耗（单位：升/百公里）
	 
	*/
	private float avgtotal;
	/** 
	 行驶油耗增长率（正值为上升；负值为下降）
	 
	*/
	private float deltascale;
	/** 
	 获取驾驶行为
	 
	 @param bhvdata 行程数据
	*/
	@Override
	public void getBehavior(TripBehaviorData bhvdata){
		this.avgoil = bhvdata.getOilavg();
		this.avgtotal = bhvdata.getOiltotal();
		this.deltascale = (this.avgoil - this.avgtotal) / this.avgtotal;
		if (this.deltascale > 0.3){
			super.setLevel(1);
		}else{
			super.setLevel(1);
		}
	}
}