package com.ggl.esb.interceptor;

import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.interceptor.Interceptor;
import org.mule.api.processor.MessageProcessor;
import org.mule.interceptor.AbstractEnvelopeInterceptor;
import org.mule.management.stats.ProcessingTime;

public class BeforeAfterInterceptor extends AbstractEnvelopeInterceptor {

	@Override
	public void setListener(MessageProcessor listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MuleEvent before(MuleEvent event) throws MuleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MuleEvent after(MuleEvent event) throws MuleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MuleEvent last(MuleEvent event, ProcessingTime time, long startTime, boolean exceptionWasThrown)
			throws MuleException {
		// TODO Auto-generated method stub
		return null;
	}

}
