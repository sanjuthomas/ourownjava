package com.ourownjava.atg.pipeline;

/**
 * @author ourownjava.com
 */

import atg.nucleus.logging.ApplicationLoggingImpl;
import atg.service.pipeline.PipelineProcessor;

public class ProcCheckInventory extends ApplicationLoggingImpl implements
		PipelineProcessor {
	public int[] getRetCodes() {
		return new int{1,2};
	}

	public int runProcess(final Object pParam, final PipelineResult pResult)
			throws Exception {
		// check inventory and return the status accordingly
		return 1;
	}
}