/*
 * Copyright (C) 2013 INRIA
 *
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package fr.inria.lille.jefix.synth;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;

import com.google.common.base.Function;

/**
 * @author Favio D. DeMarco
 * 
 */
enum FailureToDescription implements Function<Failure, Description> {
	INSTANCE;

	@Override
	public Description apply(final Failure input) {
		return input.getDescription();
	}
}