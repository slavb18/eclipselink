/*
 * Copyright (c) 2020 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2020 IBM Corporation. All rights reserved.
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
//     04/17/2020 - Will Dazey
//       - 561664: JoinColumn with same name as referencedColumnName
package org.eclipse.persistence.jpa.test.mapping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BASE_CHILD")
public class BaseChild {

    @Id
    @Column(name = "BASE_CHILD_ID")
    private Long id;

    @Embedded
    private BaseEmbeddable parentRef;
}
