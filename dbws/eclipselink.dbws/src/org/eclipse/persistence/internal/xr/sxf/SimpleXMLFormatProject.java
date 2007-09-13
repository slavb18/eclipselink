/*******************************************************************************
 * Copyright (c) 1998, 2007 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/

package org.eclipse.persistence.internal.xr.sxf;

// Javase imports

// Java extension imports

// EclipseLink imports
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.oxm.NamespaceResolver;
import org.eclipse.persistence.oxm.XMLDescriptor;
import org.eclipse.persistence.oxm.XMLLogin;
import org.eclipse.persistence.oxm.mappings.XMLFragmentCollectionMapping;
import org.eclipse.persistence.oxm.schema.XMLSchemaReference;
import org.eclipse.persistence.oxm.schema.XMLSchemaURLReference;
import org.eclipse.persistence.sessions.Project;
import static org.eclipse.persistence.internal.xr.sxf.SimpleXMLFormat.DEFAULT_SIMPLE_XML_FORMAT_TAG;
import static org.eclipse.persistence.internal.xr.sxf.SimpleXMLFormat.DEFAULT_SIMPLE_XML_TAG;

@SuppressWarnings("serial")
public class SimpleXMLFormatProject extends Project {

    private NamespaceResolver ns;

    public SimpleXMLFormatProject() {
        ns = new NamespaceResolver();
        setName("SimpleXMLFormatProject");
        applyLogin();
        addDescriptor(buildXRRowSetModelDescriptor());
    }

    public void applyLogin() {
        XMLLogin login = new XMLLogin();
        setDatasourceLogin(login);
    }

    public ClassDescriptor buildXRRowSetModelDescriptor() {

        XMLDescriptor descriptor = new XMLDescriptor();
        descriptor.descriptorIsAggregate();
        descriptor.setJavaClass(SimpleXMLFormatModel.class);
        descriptor.setAlias(DEFAULT_SIMPLE_XML_FORMAT_TAG);
        descriptor.setDefaultRootElement(DEFAULT_SIMPLE_XML_FORMAT_TAG);
        descriptor.setNamespaceResolver(ns);
        XMLSchemaURLReference schemaReference = new XMLSchemaURLReference("");
        schemaReference.setSchemaContext("/any");
        schemaReference.setType(XMLSchemaReference.COMPLEX_TYPE);
        descriptor.setSchemaReference(schemaReference);

        XMLFragmentCollectionMapping fragMapping = new XMLFragmentCollectionMapping();
        fragMapping.setAttributeName("simpleXML");
        fragMapping.setXPath(DEFAULT_SIMPLE_XML_TAG);
        descriptor.addMapping(fragMapping);
        return descriptor;
    }

}