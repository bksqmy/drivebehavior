package cn.yesway.algorithm.drivebehavior.drive.service;

/** 
 工具类
 
*/
public class Utility{
	/** 
	 两组时间相交的部分
	 
	 @param begin1 开始时间1
	 @param end1 结束时间1
	 @param begine2 开始时间2
	 @param end2 结束时间2
	 @return 
	*/
	public static long getOverlapTimes(java.util.Date begin1, java.util.Date end1, java.util.Date begine2, java.util.Date end2){
		java.util.Date time = new java.util.Date(0);
		java.util.Date time2 = new java.util.Date(0);
		if (begin1.compareTo(begine2) < 0)
		{
			time = begine2;
		}
		else
		{
			time = begin1;
		}
		if (end1.compareTo(end2) > 0)
		{
			time2 = end2;
		}
		else
		{
			time2 = end1;
		}
//		TimeSpan span = (TimeSpan)(time2 - time);
//		int totalSeconds = (int)span.TotalSeconds;
		long totalSeconds = time2.getTime() - time.getTime();
		
		if (totalSeconds <= 0)
		{
			totalSeconds = 0;
		}
		return totalSeconds;
	}
	/** 
	 获取字符串类型标度（百分比）
	 
	 @param m float类型参数
	 @return 标度
	*/
	public static String getScaleString(float m){
		int num = (int)(m * 10000f);
		int num2 = num / 100;
		int num3 = num % 100;
		if (num3 > 0)
		{
			return String.format("%1$s.%2$s%%", num2, num3);
		}
		return String.format("%1$s%%", num2);
	}

	/** 
	 格式化时间。将 X秒 转换为 X小时X分钟X秒格式
	 
	 @param m 秒
	 @return 格式化后的时间
	*/
	public static String getTimeString(long m){
		long num = m / 3600;
		long num2 = (m % 3600) / 60;
		long num3 = m % 60;
		String str = "";
		if (num > 0)
		{
			str = str + String.format("%1$s小时", (new Long(num)).toString());
		}
		if (num2 > 0)
		{
			str = str + String.format("%1$s分钟", (new Long(num2)).toString());
		}
		if (num3 > 0)
		{
			str = str + String.format("%1$s秒", (new Long(num3)).toString());
		}
		return str;
	}
}