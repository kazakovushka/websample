package ru.rtec.lighting.data.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ExtendsBlock
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long blockId;
	
	private int numberBlock;
	
	@ManyToOne
	@JoinColumn(name="serialNumber")
	private Device device;
	
	@OneToMany(mappedBy="extendsBlock", cascade = {CascadeType.ALL, }, fetch = FetchType.EAGER)
	private List<Parameter> parameters;
	
	public ExtendsBlock(
			int numberBlock,
			Device device)
	{
		super();
		this.numberBlock = numberBlock;
		this.device = device;
	}

	public ExtendsBlock()
	{		
	}
	
	public Long getBlockId()
	{
		return blockId;
	}

	public void setBlockId(long blockId)
	{
		this.blockId = blockId;
	}

	public int getNumberBlock()
	{
		return numberBlock;
	}

	public void setNumberBlock(int numberBlock)
	{
		this.numberBlock = numberBlock;
	}

	public Device getDevice()
	{
		return device;
	}

	public void setDevice(Device device)
	{
		this.device = device;
	}

	public List<Parameter> getParameters()
	{
		return parameters;
	}

	public void setParameters(List<Parameter> parameters)
	{
		this.parameters = parameters;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((device == null) ? 0 : device.hashCode());
		result = prime * result + numberBlock;
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
		ExtendsBlock other = (ExtendsBlock) obj;
		if (device == null)
		{
			if (other.device != null)
				return false;
		}
		else if (!device.equals(other.device))
			return false;
		if (numberBlock != other.numberBlock)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "ExtendsBlock [blockId=" + blockId + ", numberBlock="
				+ numberBlock + ", device=" + device + "]";
	}

	
}
