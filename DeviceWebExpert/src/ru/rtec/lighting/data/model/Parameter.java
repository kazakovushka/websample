package ru.rtec.lighting.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Parameter
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String prefix;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	private Serializable value;
	
	public Serializable getValue()
	{
		return value;
	}

	public void setValue(Serializable value)
	{
		this.value = value;
	}

	private boolean isTu;
	
	public boolean isTu() {
		return isTu;
	}

	public void setTu(boolean isTu) {
		this.isTu = isTu;
	}

	private int tuResult;
	
	public int getTuResult() {
		return tuResult;
	}

	public void setTuResult(int tuResult) {
		this.tuResult = tuResult;
	}

	private int quality;
	
	/**
	 * ������ �� ���� ���������� � ������� ��������� ���� ��������. 
	 * ����� ���� �� ��������� ���� �������� ��������� ��������������� � ����������.
	 */
	@ManyToOne
	@JoinColumn(name="blockId")
	private ExtendsBlock extendsBlock;
	
	/**
	 * ��� ���� ����� ��������� ���� �������� �������� ���������� �������, � �� ����� ����������.
	 * ����������� �� ���������� ��������� � ����� ����������.
	 */
	@ManyToOne
	@JoinColumn(name="device", referencedColumnName="serialNumber")
	private Device device;
	
	public Device getDevice()
	{
		return device;
	}

	public void setDevice(Device device)
	{
		this.device = device;
	}

	public Parameter(
			String prefix,
			Serializable value)
	{
		super();
		this.prefix = prefix;
		this.value=value;
	}

	public Parameter()
	{}
	
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getPrefix()
	{
		return prefix;
	}

	public void setPrefix(String prefix)
	{
		this.prefix = prefix;
	}

	

	public ExtendsBlock getExtendsBlock()
	{
		return extendsBlock;
	}

	public void setExtendsBlock(ExtendsBlock extendsBlock)
	{
		this.extendsBlock = extendsBlock;
	}
	
	public Date getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp(Date timestamp)
	{
		this.timestamp = timestamp;
	}

	public int getQuality()
	{
		return quality;
	}

	public void setQuality(int quality)
	{
		this.quality = quality;
	}


	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result =
				prime
						* result
						+ ((extendsBlock == null) ? 0 : extendsBlock.hashCode())
						+ ((device == null) ? 0 : device.hashCode());
		result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
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
		Parameter other = (Parameter) obj;
		if (extendsBlock == null)
		{
			if (other.extendsBlock != null)
				return false;
		}
		else if (!extendsBlock.equals(other.extendsBlock))
			return false;
		
		if (device == null)
		{
			if (other.device != null)
				return false;
		}
		else if (!device.equals(other.device))
			return false;
		
		if (prefix == null)
		{
			if (other.prefix != null)
				return false;
		}
		else if (!prefix.equals(other.prefix))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Parameter [prefix=" + prefix  + ", extendsBlock=" + extendsBlock +", device="+device+ "]";
	}
	
}
