package com.ggl.mule;
import java.io.StringWriter;
import java.util.LinkedHashMap;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;

public class VelocityComponent implements Callable
{
	private static Logger logger = LoggerFactory.getLogger(VelocityComponent.class);

	@SuppressWarnings("unchecked")
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		LinkedHashMap<String, Object> payload = (LinkedHashMap<String, Object>)eventContext.getMessage().getPayload();
		String emailHtml = this.buildEmailHtml(payload);
		return emailHtml;
	}
 
    public String buildEmailHtml(LinkedHashMap<String, Object> emailInfo) throws Exception
    {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        ve.init();
        
        String environment = System.getProperty("mule.env");
        
        emailInfo.put("environment", environment);

        VelocityContext context = new VelocityContext();
        context.put("emailInfo", emailInfo);

        Template t = ve.getTemplate("email-notification-template-velocity.vm" );

        StringWriter writer = new StringWriter();

        t.merge( context, writer );

        logger.info( writer.toString() );
        
        return writer.toString();
    }


}