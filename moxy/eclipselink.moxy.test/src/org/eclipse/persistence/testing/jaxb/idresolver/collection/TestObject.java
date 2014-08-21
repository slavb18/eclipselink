/*******************************************************************************
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *  - rbarkhouse - 29 January 2013 - 2.4 - Initial implementation
 ******************************************************************************/
package org.eclipse.persistence.testing.jaxb.idresolver.collection;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class TestObject {

    @XmlTransient
    public boolean processed = false;

    @XmlID
    public int id;

    public String name;

    @XmlIDREF
    public TestObject single;

    @XmlIDREF
    @XmlElement(name = "ref")
    public ArrayList<TestObject> refs = new ArrayList<TestObject>();

    @Override
    public String toString() {
        return "TestObject{" +
                "processed=" + processed +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", single=" + single +
                ", refs=" + refs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestObject that = (TestObject) o;

        if (id != that.id) return false;
        if (processed != that.processed) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (refs != null ? !refs.equals(that.refs) : that.refs != null) return false;
        if (single != null ? !single.equals(that.single) : that.single != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (processed ? 1 : 0);
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (single != null ? single.hashCode() : 0);
        result = 31 * result + (refs != null ? refs.hashCode() : 0);
        return result;
    }
}