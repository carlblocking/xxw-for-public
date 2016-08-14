package method;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bean.HouseInfo;

public class Analysis {
	DBHelper dbHelper=new DBHelper();
	Connection connection=dbHelper.getConnection();
	/**解析每个page上的信息*/
	public void analysis(String string){
		try {
			Statement statement=connection.createStatement();
			Document document=Jsoup.connect(string).get();
			Elements elements=document.getElementsByClass("zu-itemmod");
			HouseInfo houseInfo=null;
			for(Element element:elements){
				/*获得含有房屋详细信息的字符串*/
				String result=element.getElementsByTag("address").text();
				int a=result.indexOf(" ");
				//int c=result.indexOf("-");
				Elements elements2=element.getElementsByTag("p");
				String[] strings=elements2.first().text().split("\\|");
				//房屋所在市区
				String district=result.substring(a+2, a+4);
				//房屋小区
				String address=result.substring(0, a);
				//获得月租金价格，int类型数据
				int price=Integer.valueOf(element.getElementsByClass("zu-side").first().getElementsByTag("strong").text());
				//房屋类型
				String houseType=strings[0];
				//出租类型
				String rentType=strings[1];
				//装修类型
				String decoration=strings[2];
				houseInfo=new HouseInfo(houseType, rentType, decoration, address, district, price);
				String sql="insert into test.houseInfo(address,decoration,district,houseType,price,rentType)values(' "
						+houseInfo.getAddress()+"','"+houseInfo.getDecoration()+"','"+houseInfo.getDistrict()+"','"+
						houseInfo.getHouseType()+"',"+houseInfo.getPrice()+",'"+houseInfo.getRentType()+"')";
				if (statement.execute(sql)) {
					System.out.println("failed...");
				}else {
					System.out.println("success!");
				}
				houseInfo.printInformation();//打印信息
			}
			//dbHelper.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
