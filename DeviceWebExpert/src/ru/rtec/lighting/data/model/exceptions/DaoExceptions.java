package ru.rtec.lighting.data.model.exceptions;

public class DaoExceptions extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3889513634505448290L;

	public DaoExceptions()
	{
	}

	public DaoExceptions(String message)
	{
		super(message);
	}

	public DaoExceptions(Throwable cause)
	{
		super(cause);
	}

	public DaoExceptions(String message, Throwable cause)
	{
		super(message, cause);
	}

	public DaoExceptions(String message,
			Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
