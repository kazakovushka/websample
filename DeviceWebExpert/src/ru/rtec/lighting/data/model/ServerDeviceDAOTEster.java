package ru.rtec.lighting.data.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ru.rtec.lighting.data.model.exceptions.DaoExceptions;

public class ServerDeviceDAOTEster
{
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lighting_srv_db");
	
	public List<Device> readAllHierarchy()
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query =
				em.createQuery("select device from Device device");
		@SuppressWarnings({ "unchecked" })		
		List<Device> devices = query.getResultList();
		em.getTransaction().commit();
		return devices;
	}
	
	private void testFillDB()
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Device dev = new Device(1, true, "�������� �����");
		List<Parameter> devParameters = new ArrayList<>();
		BooleanParameter param = new BooleanParameter("val1", true);
		param.setDevice(dev);
		devParameters.add(param);
		LongParameter paramLong = new LongParameter("val2", 15000L);
		paramLong.setDevice(dev);
		devParameters.add(paramLong);
		dev.setDeviceParameters(devParameters);
		em.persist(dev);
		em.getTransaction().commit();
	}
	
	private static Device getDevice()
	{
		Device dev = new Device(1, true, "�������� �����");
		List<Parameter> devParameters = new ArrayList<>();
		Parameter param = new BooleanParameter("devVal1", true);
		param.setDevice(dev);
		devParameters.add(param);
		param = new LongParameter("devVal2",100500L);
		param.setDevice(dev);
		devParameters.add(param);
		dev.setDeviceParameters(devParameters);
		
		ExtendsBlock extBlock = new ExtendsBlock(1, dev);
		devParameters = new ArrayList<>();
		param = new BooleanParameter("extVal2", false);
		param.setDevice(null);	
		devParameters.add(param);		
		param.setExtendsBlock(extBlock);
		extBlock.setParameters(devParameters);
		
		dev.setExtendsBloks(Arrays.asList(extBlock));
		return dev;
	}
	
	private void testModify()
	{
		List<Device> devices = readAllHierarchy();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		for(Device dev : devices)
		{
			for(Parameter param : dev.getDeviceParameters())
			{
				((BooleanParameter)param).setValue(false);				
			}
			dev.setOnline(false);
			em.merge(dev);
		}
		
		em.getTransaction().commit();
	}
	
	
	public static void main(String[] args) throws DaoExceptions
	{
		/*EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Device dev = getDevice(); 
		//em.persist(dev);
		em.getTransaction().commit();*/
		Device dev = getDevice(); 
		
		ServerDAO dao = ServerDAO.getInstance();
		System.err.println("device="+ dao.getDevice());
		System.err.println("device params="+ dao.getDeviceParameters(dev));
		System.err.println("device extBl="+ dao.getExtBlockForDevice(dev));
		System.err.println("extBlock params="+ dao.getExtBlockParameters(dev.getExtendsBloks().get(0)));
		
	}
	
	
	/*public static void main(String[] args)
	{
		ServerDeviceDAOTEster dao = new ServerDeviceDAOTEster();
		//dao.testFillDB();
		List<Device> devices = dao.readAllHierarchy();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		for(Device dev : devices)
		{
			for(Parameter param : dev.getDeviceParameters())
			{
				if(param instanceof BooleanParameter)
				{
					BooleanParameter bPar = (BooleanParameter)param;
					boolean b = (Boolean) bPar.getValue();
					System.err.println(b);
				}
				else if (param instanceof LongParameter)
				{
					LongParameter lPar = (LongParameter)param;
					long l= (Long) lPar.getValue();
					System.err.println(l);
				}
							
			}
			//dev.setOnline(false);
			//em.merge(dev);
		}
		
		em.getTransaction().commit();
		System.err.println(devices);
		
	}*/
	
}
