package ru.rtec.lighting.data.model;

import javax.persistence.Entity;

@Entity
public class LongParameter extends Parameter
{

	public LongParameter()
	{		
	}

	public Long getValue()
	{
		return (Long) super.getValue();
	}

	public LongParameter(String prefix, Long value)
	{
		super(prefix, value);
	}




	@Override
	public String toString()
	{
		return "LongParameter [value=" + getValue() + ", getPrefix()="
				+ getPrefix() + ", getModbusAddress()=" 
				+ "]";
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		return true;
	}
}
