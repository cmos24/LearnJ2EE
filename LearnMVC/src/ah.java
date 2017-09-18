import bean.Hero;
import dao.HeroDAO;

public class ah {
	public static void main(String[] args){
		HeroDAO hd=new HeroDAO();
		for(int i = 0;i<50;i++){
			Hero h=new Hero();
			h.setName("hero"+i);
			h.setHp(500+i);
			h.setDamage(200+i);			
			//hd.add(h);
		}
	}
}
