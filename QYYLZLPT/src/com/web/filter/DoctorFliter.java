package com.web.filter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DoctorFliter {
	public final String pointCut = "execution( * com.web.service.*.*(..))";

	@Pointcut(value = pointCut)
	public void aspect() {
	}

	@Before(value = "aspect()")
	public void testBefore() {
		System.out.println("before");
		return;
	}
}
