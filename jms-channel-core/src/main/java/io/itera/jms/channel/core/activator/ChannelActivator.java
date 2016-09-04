
package io.itera.jms.channel.core.activator;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import weblogic.application.ApplicationException;
import weblogic.application.ApplicationLifecycleEvent;
import weblogic.application.ApplicationLifecycleListener;

public class ChannelActivator extends ApplicationLifecycleListener {

    private static final Logger LOG = Logger.getLogger(ChannelActivator.class);
    
    private ApplicationContext ctx;
    
    @Override
    public void preStart(ApplicationLifecycleEvent ale) throws ApplicationException {
        super.preStart(ale); 
        LOG.info("[pre start] starting spring application context");
        ctx = new ClassPathXmlApplicationContext("spring/jms-context.xml");
    }

    @Override
    public void preStop(ApplicationLifecycleEvent ale) throws ApplicationException {
        super.preStop(ale); 
        LOG.info("[pre stop] stopping spring application context");
        ((ConfigurableApplicationContext) ctx).close();
    }

}
