package cn.yesway.algorithm.drivebehavior.drive.service;

/** 
 驾驶标签字典
 
*/
public final class DriveTagSet
{
	/** 
	 驾驶标签字典
	 
	*/
	private static java.util.HashMap<Integer, DriveTag> set = new java.util.HashMap<Integer, DriveTag>();
	/** 
	 构造函数，填充驾驶标签字典
	 
	*/
	static
	{
		set.put(DriveTagId.zeroidle, new DriveTag(DriveTagId.zeroidle, "原地怠速", "原地", 2, "原地怠速是指点火后停在原地，发动机维持最低运转的状况。怠速时，燃油消耗最低，排放最差，发动机空转白白浪费燃油。", "尽量减少原地怠速的行为,怠速时间可能超过3分钟时应熄火。"));
		set.put(DriveTagId.zerolongidle, new DriveTag(DriveTagId.zerolongidle, "原地长时间怠速", "原地", 2, "原地长时间怠速是车辆在原地不动，发动机以最低运转的状况维持超过10分钟。怠速时，燃油消耗最低，排放最差，发动机空转白白浪费燃油。", "着车后立即行车；怠速时间不应超过3分钟，当怠速时间可能超过3分钟时应熄火。"));
		set.put(DriveTagId.hightmoring, new DriveTag(DriveTagId.hightmoring, "早高峰行驶", "高峰", 2, "工作日的早高峰时间为：早7:30-9:30，人们都会在这个时间段上班，交通最为拥挤，比如高架或地铁，早高峰一般是全天交通状况最差的时候，建议错峰出行。", "早高峰车行流量大，请注意保持合适的车距和车速。"));
		set.put(DriveTagId.hithgnight, new DriveTag(DriveTagId.hithgnight, "晚高峰行驶", "高峰", 2, "工作日的晚高峰时间为：早17:00-19:00，人们都会在这个时间段下班，交通最为拥挤，比如高架或地铁，早高峰一般是全天交通状况最差的时候，建议错峰出行。", "晚高峰车行流量大，请注意保持合适的车距和车速。"));
		set.put(DriveTagId.morning, new DriveTag(DriveTagId.morning, "凌晨行车", "凌晨", 2, "凌晨行车指在1:00-5:59时间段驾驶。此时万物处于“休眠状态”，驾驶员容易产生道路“空旷”的感觉，易超速驾驶，结果常有长途驾驶员把车撞到路边的树上、建筑物上还浑然不觉。此外，这段时间人的生理节律处于大脑反应迟钝、血压降低、手足血管神经僵硬麻痹的状态，如果极度疲劳，心脏功能不好的人还容易诱发心脏骤停、心肌梗死和脑血栓等。", "凌晨时段1:00-5:59是交通事故多发时段，尽量避免在此时段出行。"));
		set.put(DriveTagId.night, new DriveTag(DriveTagId.night, "晚间行车", "晚间", 2, "晚间行车指在19:00-22:00时间段驾驶。该时段通常为夜间交通事故的高发期。因为现在人们的夜生活丰富多彩，除了一般的晚宴外，还有跳舞、唱卡拉OK 等娱乐活动，此时，不论是行人还是驾车人都十分疲倦，安全意识薄弱，极易发生交通事故。", "晚间时段19:00-24:00视线容易受到灯光干扰，请注意安全行驶。"));
		set.put(DriveTagId.tired, new DriveTag(DriveTagId.tired, "疲劳驾驶", "疲劳", 3, "疲劳驾驶指驾驶人在长时间（一般4小时）连续行车后，产生生理机能和心理机能的失调，而在客观上出现驾驶技能下降的现象。", "在连续驾驶2小时后停车休息，休息后再继续上路。"));
		set.put(DriveTagId.shortdistance, new DriveTag(DriveTagId.shortdistance, "短距离行驶", "短程", 2, "短距离行驶是单次行驶里程在3公里以内，经常短距离行驶容易造成积碳。", "若行驶距离较短，水温未达到一定热度，容易造成积碳。"));
		set.put(DriveTagId.tooshort, new DriveTag(DriveTagId.tooshort, "极短距离行驶", "极短", 2, "极短距离行驶是单次行驶里程在500米以内，会产生大量的油耗，长时间的短距离行驶容易造成积碳。", "若行驶距离极短，水温未达到一定热度，容易造成积碳。"));
		set.put(DriveTagId.longdistance, new DriveTag(DriveTagId.longdistance, "长途行驶", "长途", 2, "长途行驶是指单次行驶里程超过200公里。长途行驶容易使驾驶人产生生理机能和心理机能的失调，而在客观上出现驾驶技能下降的现象。", "在连续驾驶大于200公里后停车休息，休息后再继续上路。"));
		set.put(DriveTagId.longidle, new DriveTag(DriveTagId.longidle, "怠速偏长", "怠速", 2, "怠速是指发动机维持最低运转的状况，怠速过长是指怠速时间占总行程时间比例较大。怠速时，燃油消耗最低，排放最差，发动机空转白白浪费燃油。", "尽量减少原地怠速的行为,怠速时间可能超过3分钟时应熄火。"));
		set.put(DriveTagId.slow, new DriveTag(DriveTagId.slow, "行驶缓慢", "缓慢", 2, "行驶缓慢指驾驶速度小于30km/h。大量的数据显示汽车时速60-90km/h时，汽车的燃油消耗最少。", "如果客观条件允许，尽量以60-90km/h的速度行驶。"));
		set.put(DriveTagId.rapidlyup, new DriveTag(DriveTagId.rapidlyup, "急加速", "急加", 2, "急加速指短时间内深踩油门，使车速迅速提高。环保方面：1次急加速和缓加速的油耗相差12毫升左右。安全方面：急加速会加大汽车的磨损，伴有危险性。", "需要提速时，踩油门要轻踩缓抬，柔和均匀。"));
		set.put(DriveTagId.rapidlydown, new DriveTag(DriveTagId.rapidlydown, "急减速", "急减", 2, "急减速指直接快速踩下刹车踏板(不能踩离合器),同时拉起手刹。环保方面：数据显示有预见性的滑行减速相比急减速可省2%-6%的燃油。安全方面：急刹车会加大汽车的磨损，伴有危险性。", "需要刹车并在保证安全的情况下，让车辆尽量平稳的减速。"));
		set.put(DriveTagId.rapidturn, new DriveTag(DriveTagId.rapidturn, "急转弯", "急转", 2, "急转弯指极短时间内突然改变汽车行驶方向。急转弯时车辆容易导致翻车或甩出路面并与他车相撞，导致交通事故的发生。", "需要转弯并在保证安全的情况下，先将车速降下来，等离心力降到低点时再转弯。"));
		set.put(DriveTagId.outspeed, new DriveTag(DriveTagId.outspeed, "超速行驶", "超速", 3, "我国高速公路的汽车行驶速度最快不超过一百二十公里，有限速路交通标志或限速面标志时，应严格按照标志规定的速度行驶。超过该路段限定速度行驶就是超速行驶。超速会加大车辆的工作强度和负荷，加剧机件的磨损和损毁，容易导致交通事故的发生。", "控制车速在合理的范围内，远离超速行为。"));
		set.put(DriveTagId.zerotime, new DriveTag(DriveTagId.zerotime, "熄火过快", "熄火", 2, "熄火过快容易令发动机和涡轮没有充足时间冷却润滑，从而对引擎造成损耗。", "汽车熄火应注意延时熄火，延时熄火时间最好在30秒左右。"));
		set.put(DriveTagId.longtime, new DriveTag(DriveTagId.longtime, "长时间驾驶", "长时", 2, "长时间行驶是指行驶时间超过2小时。长时间行驶容易使驾驶人产生生理机能和心理机能的失调，而在客观上出现驾驶技能下降的现象。", "在连续驾驶2小时后停车休息，休息后再继续上路。"));
		set.put(DriveTagId.oilhight, new DriveTag(DriveTagId.oilhight, "油耗偏高", "油耗", 2, "油耗偏高是指本次行程油耗高于本车历史平均油耗30%。", "请注意保持良好的驾驶行为，节能环保，绿色出行。"));
	}
	/** 
	 获取驾驶行为标签
	 
	 @param tagid 标签Id
	 @return 
	*/
	public static DriveTag getDriveTag(int tagid)
	{
		return set.get(tagid);
	}
}