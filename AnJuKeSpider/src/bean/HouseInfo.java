package bean;

public class HouseInfo {
	private String houseType;//房型
	private String rentType;//出租类型
	private String decoration;//装修
	private String address;//地址
	private String district;//所属区
	private int price;//月租金
	public HouseInfo(String houseType,String rentType,String decoration,String address,String district,int price){
		this.houseType=houseType;
		this.rentType=rentType;
		this.decoration=decoration;
		this.address=address;
		this.district=district;
		this.price=price;
		System.out.println("catching information...");
	}
	public void printInformation(){
		System.out.println(houseType);
		System.out.println(rentType);
		System.out.println(decoration);
		System.out.println(address);
		System.out.println(district);
		System.out.println(price);
	}
	/**
	 * @return the houseType
	 */
	public String getHouseType() {
		return houseType;
	}
	/**
	 * @param houseType the houseType to set
	 */
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	/**
	 * @return the rentType
	 */
	public String getRentType() {
		return rentType;
	}
	/**
	 * @param rentType the rentType to set
	 */
	public void setRentType(String rentType) {
		this.rentType = rentType;
	}
	/**
	 * @return the decoration
	 */
	public String getDecoration() {
		return decoration;
	}
	/**
	 * @param decoration the decoration to set
	 */
	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
}
