package ru.rtec.lighting.data.model;

import javax.persistence.Entity;

@Entity
public class BooleanParameter extends Parameter
{
	


	@Override
	public Boolean getValue()
	{	
		return (Boolean) super.getValue();
	}


	public BooleanParameter()
	{		
	}
	
	

	public BooleanParameter(String prefix, Boolean value)
	{
		super(prefix, value);
	}



	@Override
	public String toString()
	{
		return "BooleanParameter [value=" + getValue() + ", getPrefix()="
				+ getPrefix() 
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
