package ru.rtec.lighting.data.model;

import javax.persistence.Entity;

@Entity
public class DoubleParameter extends Parameter
{
	

	
	public DoubleParameter()
	{		
	}
	
	
	

	@Override
	public Double getValue()
	{
		return (Double) super.getValue();
	}




	public DoubleParameter(String prefix, Double value)
	{
		super(prefix, value);
	}



	@Override
	public String toString()
	{
		return "DoubleParameter [value=" + getValue() + ", getPrefix()="
				+ getPrefix() + ", getModbusAddress()=" + "]";
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
