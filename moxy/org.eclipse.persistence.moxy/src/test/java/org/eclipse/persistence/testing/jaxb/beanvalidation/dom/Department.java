/*
 * Copyright (c) 2014, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Marcel Valovy - 2.6 - initial implementation
package org.eclipse.persistence.testing.jaxb.beanvalidation.dom;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * @author Marcel Valovy - marcel.valovy@oracle.com
 * @since 2.6
 */
@XmlRootElement
public enum Department {
    RDBMS, JavaSE, JavaEE, Sales, Support
}
