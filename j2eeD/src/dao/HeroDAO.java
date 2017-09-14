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

//׼��һ��HeroDAO���ṩ���ӣ�ɾ�����޸ģ���ѯ�ȳ������ݿ��������
public class HeroDAO {
	public HeroDAO() {// ��ʼ��ʱ��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// �������
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8&useSSL=true",
				"root", "123456");
	}

	// ��������
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

	// �����Hero
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

	// �޸���Ϣ
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

	// ɾ��
	public void delete(int id) {
		String sql = "delete from hero where id =" + id;
		try (Connection c = getConnection(); Statement s = c.createStatement();) {
			s.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ȡ������
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
	
	//��÷�ҳ����
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
