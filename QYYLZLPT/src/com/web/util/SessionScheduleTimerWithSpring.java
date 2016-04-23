package com.web.util;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SessionScheduleTimerWithSpring extends QuartzJobBean {
	private int timeout;

	// 调度工厂实例化后，经过timeout时间开始执行调度
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		System.out.println("method has been invoked");
	}
}
