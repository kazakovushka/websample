package ru.rtec.lighting.data.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import ru.rtec.lighting.data.model.exceptions.DaoExceptions;

public class ServerDAO
{
	private EntityManagerFactory emf;
	
	private static volatile ServerDAO inst;
	
	public static ServerDAO getInstance()
	{
		ServerDAO localInstance = inst;
        if (localInstance == null) {
            synchronized (ServerDAO.class) {
                localInstance = inst;
                if (localInstance == null) {
                	inst = localInstance = new ServerDAO();
                }
            }
        }
        return localInstance;
	}
	
	private ServerDAO()
	{	
		//emf = Persistence.createEntityManagerFactory("lighting_srv_db");
	}
	
	@SuppressWarnings("unchecked")
	public List<Device> getDevice() throws DaoExceptions
	{
//		EntityManager em = null;
//		List<Device> result=null;
//		try{
//			em = emf.createEntityManager();
//			EntityTransaction transaction = em.getTransaction();
//			transaction.begin();
//			Query query =
//				em.createQuery("select device from Device device");		
//			result=query.getResultList();
//			transaction.commit();
//		}
//		catch(PersistenceException ex)
//		{
//			throw new DaoExceptions("Server DAO persistance exception!",ex);
//		}
//		finally
//		{
//			if(em!=null)
//			{
//				em.close();					
//			}		
//		}
//		return result;
		List<Device> devices=new ArrayList<Device>();
		Device d1=new Device();
		d1.setDescription("Прибор 1");
		d1.setSerialNumber(1l);
		d1.setOnline(true);
		
		Device d2=new Device();
		d2.setDescription("Прибор 2");
		d2.setSerialNumber(2l);
		d2.setOnline(true);
		
		Device d3=new Device();
		d3.setDescription("Прибор 3");
		d3.setSerialNumber(3l);
		d3.setOnline(false);
		
		Device d4=new Device();
		d4.setDescription("Прибор 4");
		d4.setSerialNumber(4l);
		d4.setOnline(true);
		
		Device d5=new Device();
		d5.setDescription("Прибор 5");
		d5.setSerialNumber(5l);
		d5.setOnline(false);
		devices.add(d1);
		devices.add(d2);
		devices.add(d3);
		devices.add(d4);
		devices.add(d5);
		
	return devices;
	}
	
	@SuppressWarnings("unchecked")
	public List<Parameter> getDeviceParameters(Device deviceId) throws DaoExceptions
	{
		if(deviceId==null)
		{
			return null;
		}
		EntityManager em = null;
		List<Parameter> result=null;
		try{
			em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			Query query =
				em.createQuery("select parameter from Parameter parameter where parameter.device.serialNumber=:devId");
			query.setParameter("devId", deviceId.getSerialNumber());
			result=query.getResultList();
			transaction.commit();
		}
		catch(PersistenceException ex)
		{
			throw new DaoExceptions("Server DAO persistance exception!",ex);
		}
		finally
		{
			if(em!=null)
			{
				em.close();					
			}		
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<ExtendsBlock> getExtBlockForDevice(Device deviceId) throws DaoExceptions
	{
		if(deviceId==null)
		{
			return null;
		}
		EntityManager em = null;
		List<ExtendsBlock> result=null;
		try{
			em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			Query query =
				em.createQuery("select block from ExtendsBlock block where block.device.serialNumber=:devId");
			query.setParameter("devId", deviceId.getSerialNumber());
			result=query.getResultList();
			transaction.commit();
		}
		catch(PersistenceException ex)
		{
			throw new DaoExceptions("Server DAO persistance exception!",ex);
		}
		finally
		{
			if(em!=null)
			{
				em.close();					
			}		
		}
		return result;
	}
	
	public Device getDeviceBySN(Long sn){
		return  null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Parameter> getExtBlockParameters(ExtendsBlock extBlockId) throws DaoExceptions
	{
		if(extBlockId==null)
		{
			return null;
		}
		//�������� �� �� ������� � ��
		if(extBlockId.getBlockId()==null)
		{			
			return extBlockId.getParameters();
		}
		EntityManager em = null;
		List<Parameter> result=null;
		try{
			em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			Query query =
				em.createQuery("select parameter from Parameter parameter where parameter.extendsBlock.blockId=:blockId");
			query.setParameter("blockId", extBlockId.getBlockId());
			result=query.getResultList();
			transaction.commit();
		}
		catch(PersistenceException ex)
		{
			throw new DaoExceptions("Server DAO persistance exception!",ex);
		}
		finally
		{
			if(em!=null)
			{
				em.close();					
			}		
		}
		return result;
	}

}
