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
package fr.inria.lille.jefix.sps.gzoltar;

import static com.google.common.base.Preconditions.checkNotNull;

import com.gzoltar.core.components.Statement;

import fr.inria.lille.jefix.sps.SuspiciousStatement;

/**
 * @author Favio D. DeMarco
 * 
 */
final class GZoltarStatement implements SuspiciousStatement {

	private final Statement statement;

	/**
	 * @param statement
	 */
	GZoltarStatement(final Statement statement) {
		this.statement = checkNotNull(statement);
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		GZoltarStatement other = (GZoltarStatement) obj;
		if (this.statement == null) {
			if (other.statement != null) {
				return false;
			}
		} else if (!this.statement.equals(other.statement)) {
			return false;
		}
		return true;
	}

	/**
	 * @see fr.inria.lille.jsemfix.sps.SuspiciousStatement#getContainingClass()
	 */
	@Override
	public String getContainingClassName() {
		return this.statement.getClazz().getLabel();
	}

	/**
	 * @see fr.inria.lille.jsemfix.sps.SuspiciousStatement#getLineNumber()
	 */
	@Override
	public int getLineNumber() {
		return this.statement.getLineNumber();
	}

	/**
	 * @see fr.inria.lille.jsemfix.sps.SuspiciousStatement#getSuspiciousness()
	 */
	@Override
	public double getSuspiciousness() {
		return this.statement.getSuspiciousness();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.statement.getLabel().hashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GZoltarStatement [ContainingClass=");
		builder.append(this.getContainingClassName());
		builder.append(", LineNumber=");
		builder.append(this.getLineNumber());
		builder.append(", Suspiciousness=");
		builder.append(this.getSuspiciousness());
		builder.append("]");
		return builder.toString();
	}
}
