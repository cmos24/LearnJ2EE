package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Hero;

//准备一个HeroDAO，提供增加，删除，修改，查询等常规数据库操作方法
public class HeroDAO {
	public HeroDAO() {// 初始化时加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得连接
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8&useSSL=true",
				"root", "123456");
	}

	// 数据数量
	public int getTotal() {
		int total = 0;
		try (Connection c = getConnection();) {
			String sql = "select count(*) from hero";
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}
			System.out.println("total:" + total);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	// 添加新Hero
	public void add(Hero hero) {
		  
        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
  
            ps.setString(1, hero.name);
            ps.setFloat(2, hero.hp);
            ps.setInt(3, hero.damage);
  
            ps.execute();
  
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                hero.id = id;
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }

	// 修改信息
	public void update(Hero hero) {
		String sql = "update hero set name=?, hp=?, damage=? where id=?";
		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.setInt(4, hero.id);

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 删除
	public void delete(int id) {
		String sql = "delete from hero where id =" + id;
		try (Connection c = getConnection(); Statement s = c.createStatement();) {
			s.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//取出数据
	public Hero get(int id){
		Hero hero=null;
		String sql="select * from hero where id= "+id;
		try(Connection c=getConnection();Statement s=c.createStatement();){
			ResultSet rs=s.executeQuery(sql);
			
			if(rs.next()){
				hero =new Hero();
				int hid=rs.getInt(1);
				String name=rs.getString(2);
				Float hp=rs.getFloat(3);
				int damage=rs.getInt(4);
				hero.id=hid;
				hero.name=name;
				hero.hp=hp;
				hero.damage=damage;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return hero;
	}
	
	public List<Hero> list() {
        return list(0, Short.MAX_VALUE);
    }
	
	//获得分页数据
	public List<Hero> list(int start,int count){
		List<Hero> herolist=new ArrayList<Hero>();
		String sql="select * from hero order by id desc limit ?,?";
		
		try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)
		){
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Hero hero=new Hero();
				int id=rs.getInt(1);
				String name=rs.getString(2);
				float hp=rs.getFloat(3);
				int damage=rs.getInt(4);
				hero.id=id;
				hero.name=name;
				hero.hp=hp;
				hero.damage=damage;
				
				herolist.add(hero);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return herolist;
	}
	
	

}
