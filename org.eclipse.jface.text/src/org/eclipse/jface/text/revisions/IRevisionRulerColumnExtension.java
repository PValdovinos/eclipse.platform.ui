/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jface.text.revisions;

import org.eclipse.jface.text.Assert;

import org.eclipse.jface.viewers.ISelectionProvider;

/**
 * Extension interface for {@link IRevisionRulerColumn}.
 * <p>
 * Introduces the ability to register a selection listener on revisions and a configurable rendering
 * mode.
 *
 * @see IRevisionRulerColumn
 * @since 3.3
 */
public interface IRevisionRulerColumnExtension {
	/**
	 * Rendering mode typesafe enum.
	 */
	final class RenderingMode {
		private final String fName;
		private RenderingMode(String name) {
			Assert.isLegal(name != null);
			fName= name;
		}
		/**
		 * Returns the name of the rendering mode.
		 * @return the name of the rendering mode
		 */
		public String name() {
			return fName;
		}
	}
	/**
	 * Rendering mode that assigns a unique color to each revision contributor.
	 */
	RenderingMode COMMITTER= new RenderingMode("Committer"); //$NON-NLS-1$
	/**
	 * Rendering mode that assigns colors to revisions by their age. The most recent revision is
	 * red, the oldest is a faint yellow.
	 */
	RenderingMode AGE= new RenderingMode("Age"); //$NON-NLS-1$
	/**
	 * Rendering mode that assigns unique colors per revision contributor, and that selects lighter
	 * colors for older revisions and more intense colors for more recent revisions.
	 */
	RenderingMode COMMITTER_SHADED_BY_AGE= new RenderingMode("Both"); //$NON-NLS-1$

	/**
	 * Changes the rendering mode and triggers redrawing if needed.
	 *  
	 * @param mode the rendering mode
	 */
	public void setRevisionRenderingMode(RenderingMode mode);

	/**
	 * Returns the revision selection provider.
	 * 
	 * @return the revision selection provider
	 */
	public ISelectionProvider getRevisionSelectionProvider();
}
