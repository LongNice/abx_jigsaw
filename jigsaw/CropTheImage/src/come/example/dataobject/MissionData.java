/**
 * 
 */
package come.example.dataobject;

/**
 * 任務關卡基本資料存放的物件類別
 * @author kawachi
 *
 */
public class MissionData {

	private int id;
	private String name;
	private String imageUrl;
	private int costPoint;
	private int prizePoint;
	private int hardLvl;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * @return the costPoint
	 */
	public int getCostPoint() {
		return costPoint;
	}
	/**
	 * @param costPoint the costPoint to set
	 */
	public void setCostPoint(int costPoint) {
		this.costPoint = costPoint;
	}
	/**
	 * @return the prizePoint
	 */
	public int getPrizePoint() {
		return prizePoint;
	}
	/**
	 * @param prizePoint the prizePoint to set
	 */
	public void setPrizePoint(int prizePoint) {
		this.prizePoint = prizePoint;
	}
	/**
	 * @return the hardLvl
	 */
	public int getHardLvl() {
		return hardLvl;
	}
	/**
	 * @param hardLvl the hardLvl to set
	 */
	public void setHardLvl(int hardLvl) {
		this.hardLvl = hardLvl;
	}
}
