package br.com.fnbrandao.artigo_2pc.twophasecommit;

import java.lang.management.ManagementFactory;

import javax.annotation.PostConstruct;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.apache.commons.dbcp2.managed.BasicManagedDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("2pc")
public class AppConfig2PC {

	@Autowired
	private BasicManagedDataSource dataSource;

	@PostConstruct
	public void setup() throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException,
			NotCompliantMBeanException {
		MBeanServer jmx = ManagementFactory.getPlatformMBeanServer();
		ObjectName mBeanName = new ObjectName("datasource:type=DataSourceBean");
		jmx.registerMBean(new DataSourceBeanJMX(dataSource), mBeanName);
	}

}
