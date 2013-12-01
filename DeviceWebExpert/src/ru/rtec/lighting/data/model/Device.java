package ru.rtec.lighting.data.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * ��������� ����������. 
 * <p>
 * <b> Date</b>: 15 ����. 2013 �. 17:24:16
 * </p>
 */
@Entity
public class Device
{
	/**
	 * �������� ����� �������.
	 */
	@Id
	private Long serialNumber;
	
	/**
	 * ������� �����
	 */
	private boolean online;
	
	/**
	 * �������� ��� ���������� ����������.
	 */
	private String description;
	
	/**
	 * ������ ������ ����������. ��� ������� ���� ������� ��� �����.
	 * ���� ���������� � �� ���� ��� ��� ����������.
	 */
	@OneToMany(mappedBy="device", cascade = CascadeType.ALL)
	private List<ExtendsBlock> extendsBloks;
	
	/**
	 * ������ ���������� ��������������� �����������. 
	 * � �������� ������ �������� � ��������� �������.
	 */
	@OneToMany(mappedBy="device", cascade = CascadeType.ALL)
	private List<Parameter> deviceParameters;

	public Device()
	{
		
	}
	
	public Device(long serialNumber,
			boolean online,
			String description/*,
			List<ExtendsBlock> extendsBloks*/)
	{
		super();
		this.serialNumber = serialNumber;
		this.online = online;
		this.description = description;
		//this.extendsBloks = extendsBloks;
	}

	public Long getSerialNumber()
	{
		return serialNumber;
	}

	public void setSerialNumber(long serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	public boolean isOnline()
	{
		return online;
	}

	public void setOnline(boolean online)
	{
		this.online = online;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<ExtendsBlock> getExtendsBloks()
	{
		return extendsBloks;
	}

	public void setExtendsBloks(List<ExtendsBlock> extendsBloks)
	{
		this.extendsBloks = extendsBloks;
	}
	
	public List<Parameter> getDeviceParameters()
	{
		return deviceParameters;
	}

	public void setDeviceParameters(List<Parameter> deviceParameters)
	{
		this.deviceParameters = deviceParameters;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (serialNumber ^ (serialNumber >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		if (serialNumber != other.serialNumber)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Device [serialNumber=" + serialNumber + ", online=" + online
				+ ", description=" + description + "]";
	}
	
}
