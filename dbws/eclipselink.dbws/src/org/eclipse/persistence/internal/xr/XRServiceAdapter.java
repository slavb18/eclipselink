/*******************************************************************************
 * Copyright (c) 1998, 2007 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/

package org.eclipse.persistence.internal.xr;

// Javase imports
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Java extension imports
import javax.xml.namespace.QName;

// EclipseLink imports
import org.eclipse.persistence.internal.oxm.schema.model.Schema;
import org.eclipse.persistence.oxm.XMLContext;
import org.eclipse.persistence.oxm.XMLDescriptor;
import org.eclipse.persistence.sessions.Session;

/**
 * <p><b>INTERNAL</b>: runtime implementation of TopLink XR Service
 *
 * @author Mike Norman - michael.norman@oracle.com
 * @since Oracle TopLink 11.x.x
 */
public class XRServiceAdapter extends XRServiceModel {

    protected String schemaNamespace;
    protected Session orSession;
    protected Session oxSession;
    protected XMLContext xmlContext;
    protected Schema schema;
    protected Set<QName> schemaTypes = new HashSet<QName>();
    protected Map<QName, QName> elementTypes = new HashMap<QName, QName>();
    protected Map<QName, XMLDescriptor> descriptorsByType = new HashMap<QName, XMLDescriptor>();
    protected Map<QName, XMLDescriptor> descriptorsByElement = new HashMap<QName, XMLDescriptor>();

    public Session getORSession() {
        return orSession;
    }
    public void setORSession(Session orSession) {
        this.orSession = orSession;
    }

    public Session getOXSession() {
        return oxSession;
    }
    public void setOXSession(Session oxSession) {
        this.oxSession = oxSession;
    }

    public XMLContext getXMLContext() {
        return xmlContext;
    }
    public void setXMLContext(XMLContext xmlContext) {
        this.xmlContext = xmlContext;
    }

    public String getSchemaNamespace() {
        return schemaNamespace;
    }
    public void setSchemaNamespace(String schemaNamespace) {
        this.schemaNamespace = schemaNamespace;
    }

    public Schema getSchema() {
        return schema;
    }
    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public Set<QName> getSchemaTypes() {
        return schemaTypes;
    }
    public void setSchemaTypes(Set<QName> schemaTypes) {
        this.schemaTypes = schemaTypes;
    }

    public Map<QName, QName> getElementTypes() {
        return elementTypes;
    }
    public void setElementTypes(Map<QName, QName> elementTypes) {
        this.elementTypes = elementTypes;
    }

    public Map<QName, XMLDescriptor> getDescriptorsByType() {
        return descriptorsByType;
    }
    public void setDescriptorsByType(Map<QName, XMLDescriptor> descriptorsByType) {
        this.descriptorsByType  = descriptorsByType;
    }

    public Map<QName, XMLDescriptor> getDescriptorsByElement() {
        return descriptorsByElement;
    }
    public void setDescriptorsByElement(Map<QName, XMLDescriptor> descriptorsByElement) {
        this.descriptorsByElement = descriptorsByElement;
    }

    public Class<?> getTypeClass(QName type) {
        if (schemaTypes.contains(type)) {
            return descriptorsByType.get(type).getJavaClass();
        }
        else {
            return null;
        }
    }

    public String getTypeAlias(QName type) {
        if (schemaTypes.contains(type)) {
            return descriptorsByType.get(type).getAlias();
        }
        else {
            return null;
        }
    }
}