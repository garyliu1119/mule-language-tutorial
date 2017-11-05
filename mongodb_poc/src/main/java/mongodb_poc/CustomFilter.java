package mongodb_poc;

import org.mule.api.MuleMessage;
import org.mule.api.routing.filter.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomFilter implements Filter{
	private static Logger LOG = LoggerFactory.getLogger(CustomFilter.class);
	
	private static int count;

	@Override
	public boolean accept(MuleMessage message) {
		String userName = message.getInboundProperty("name");
		count++;
		LOG.info("Count: " + count + " userName: " + userName);
		boolean check = userName != null && userName.equalsIgnoreCase("gary");
		LOG.info("check: " + check+ " -- user name must be ->gary<-");
		
		return check;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		CustomFilter.count = count;
	}
	

}
