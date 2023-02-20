package br.com.fnbrandao.artigo_2pc.twophasecommit;

import org.apache.commons.dbcp2.managed.BasicManagedDataSource;

public class DataSourceBeanJMX implements DataSourceBeanJMXMBean {

	private BasicManagedDataSource dataSource;

	public DataSourceBeanJMX(BasicManagedDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int getAvailableSize() {
		return this.dataSource.getMaxTotal() - this.dataSource.getNumActive();
	}

	@Override
	public int getPoolTotalSize() {
		return this.dataSource.getMaxTotal();
	}

}
