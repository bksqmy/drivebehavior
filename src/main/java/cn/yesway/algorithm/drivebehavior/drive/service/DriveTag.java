package cn.yesway.algorithm.drivebehavior.drive.service;

/** 
 驾驶标签
 
*/
public class DriveTag{
	/** 
	 标签缩写
	 
	*/
	private String ab;
	/** 
	 ID
	 
	*/
	private int id;
	/** 
	 级别
	 
	*/
	private int level;
	/** 
	 驾驶建议
	 
	*/
	private String propose;
	/** 
	 驾驶小结
	 
	*/
	private String summary;
	/** 
	 驾驶标签
	 
	*/
	private String tag;
	/** 
	 构造函数
	 
	 @param inid ID
	 @param intag 驾驶标签
	 @param inab 标签缩写
	 @param inlevel 级别
	 @param insummary 驾驶小结
	 @param inpropose 驾驶建议
	*/
	public DriveTag(int inid, String intag, String inab, int inlevel, String insummary, String inpropose){
		this.id = inid;
		this.tag = intag;
		this.ab = inab;
		this.level = inlevel;
		this.summary = insummary;
		this.propose = inpropose;
	}
	public String getAb() {
		return ab;
	}
	public void setAb(String ab) {
		this.ab = ab;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getPropose() {
		return propose;
	}
	public void setPropose(String propose) {
		this.propose = propose;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
}