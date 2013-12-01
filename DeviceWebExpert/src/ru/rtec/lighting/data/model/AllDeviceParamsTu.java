package ru.rtec.lighting.data.model;

import javax.persistence.Entity;

@Entity
public class AllDeviceParamsTu extends PhantomParameter 
{
	public AllDeviceParamsTu()
	{
		setTu(true);		
	}

	@Override
	public String toString() {
		return "AllDeviceParamsTu [isTu()=" + isTu() + ", getId()=" + getId()
				+ ", getPrefix()=" + getPrefix() + ", getClass()=" + getClass()
				+ "]";
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result =
				prime
						* result
						+ ((getExtendsBlock() == null) ? 0 : getExtendsBlock().hashCode())
						+((getDevice() == null) ? 0 : getDevice().hashCode())
						;
		result = prime * result + ((getPrefix() == null) ? 0 : getPrefix().hashCode());
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
		if (getExtendsBlock() == null)
		{
			if (other.getExtendsBlock() != null)
				return false;
		}
		else if (!getExtendsBlock().equals(other.getExtendsBlock()))
			return false;
		
		
		if (getDevice() == null)
		{
			if (other.getDevice() != null)
				return false;
		}
		else if (!getDevice().equals(other.getDevice()))
			return false;
		if (getPrefix() == null)
		{
			if (other.getPrefix() != null)
				return false;
		}
		else if (!getPrefix().equals(other.getPrefix()))
			return false;
		return true;
	}
}
