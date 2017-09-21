package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

//ProductDAO提供对Product的查询
public class ProductDAO {
	
	public ProductDAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8&useSSL=true",
					"root","123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> ListProduct(){
		List<Product> products=new ArrayList<Product>();
		
		try(Connection e=getConnection();Statement s=e.createStatement();){
			String sql="select * from product order by id desc";
			ResultSet rs=s.executeQuery(sql);
			
			while(rs.next()){
				Product product=new Product();
				int id=rs.getInt(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				
				product.setId(id);
				product.setName(name);
				product.setPrice(price);
				products.add(product);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}		
		return products;
	}
	
	//通过id获得产品
	public Product getProduct(int id) {
        Product result = null;
        String sql = "select * from product where id = ?";
        
        try(Connection c =getConnection();PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, id);
 
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                result = new Product();
                result.setId(id);
 
                String name = rs.getString(2);
                float price = rs.getFloat(3);
 
                result.setName(name);
                result.setPrice(price);
 
            }
 
            ps.close();
 
            c.close();
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    } 
}
