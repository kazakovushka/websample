import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ru.rtec.lighting.data.model.BooleanParameter;
import ru.rtec.lighting.data.model.Device;
import ru.rtec.lighting.data.model.DoubleParameter;
import ru.rtec.lighting.data.model.ExtendsBlock;
import ru.rtec.lighting.data.model.LongParameter;
import ru.rtec.lighting.data.model.Parameter;


public class InsertTry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lighting_srv_db");
		Device d=new Device(1l,true,"first device");
		Device d2=new Device(2l,false,"second device");
		
		Parameter dp1=new BooleanParameter("boolVal", true);
		Parameter p2=new LongParameter("long par", 22l);
		
		Parameter dp3=new DoubleParameter("doublePar", 99.9);
		d.setDeviceParameters(Arrays.asList(dp1,p2));
		
		
		ExtendsBlock b1=new ExtendsBlock(2,d);
		b1.setParameters(Arrays.asList(dp3));
		d.setExtendsBloks(Arrays.asList(new ExtendsBlock(1,d),b1));
		
		
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.persist(d2);
		em.getTransaction().commit();
		em.close();
		
		
		

	}

}
