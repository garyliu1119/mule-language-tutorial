package com.ggl.esb.utils;

import javax.inject.Inject;

import org.mule.DefaultMuleEvent;
import org.mule.DefaultMuleMessage;
import org.mule.MessageExchangePattern;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.context.notification.MuleContextNotificationListener;
import org.mule.construct.Flow;
import org.mule.context.notification.MuleContextNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FlowInvokerContextListener implements  MuleContextNotificationListener<MuleContextNotification>{
	
	@Inject
    private MuleContext muleContext;
    private String flowName;
	
	private static final Logger logger = LoggerFactory.getLogger(FlowInvokerContextListener.class);
	
	@Override
	public void onNotification(MuleContextNotification notification){
		if (notification.getAction() == MuleContextNotification.CONTEXT_STARTED) {
			logger.info("OK FlowInvoker Is Working");
			FlowConstruct flowConstruct = muleContext.getRegistry().lookupFlowConstruct(this.flowName); 
	    	

	        final MuleEvent muleEvent = new DefaultMuleEvent(new DefaultMuleMessage(null, muleContext),
	            MessageExchangePattern.REQUEST_RESPONSE, flowConstruct);
	        
	        try {
				final MuleEvent resultEvent = ((Flow)flowConstruct).process(muleEvent);
				
			} catch (MuleException e) {
				logger.error("MuleException", e);
				
			}

		}
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
}
