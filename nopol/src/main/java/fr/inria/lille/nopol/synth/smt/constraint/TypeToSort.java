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
package fr.inria.lille.nopol.synth.smt.constraint;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.smtlib.ISort;
import org.smtlib.ISort.IFactory;

import com.google.common.base.Function;

import fr.inria.lille.nopol.synth.smt.model.Type;

/**
 * @author Favio D. DeMarco
 */
final class TypeToSort implements Function<Type, ISort> {

	private final ISort boolSort;
	private final ISort realSort;

	/**
	 * @param sortFactory
	 */
	TypeToSort(@Nonnull final IFactory sortFactory, @Nonnull final org.smtlib.IExpr.IFactory eFactory) {
		boolSort = sortFactory.Bool();
		realSort = sortFactory.createSortExpression(eFactory.symbol("Real"));
	}

	@Override
	@Nullable
	public ISort apply(@Nullable final Type input) {
		switch (input) {
		case BOOLEAN:
			return boolSort;
		case NUMBER:
			return realSort;

		default:
			throw new IllegalArgumentException("Unknown type " + input);
		}
	}
}
