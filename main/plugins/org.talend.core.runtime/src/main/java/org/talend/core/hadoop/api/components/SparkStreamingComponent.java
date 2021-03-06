// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.core.hadoop.api.components;

/**
 * Interface that exposes specific Spark Streaming methods.
 *
 */
public interface SparkStreamingComponent extends SparkComponent {

    /**
     * This method defines if a distribution supports the checkpointing in Spark Streaming
     * 
     * @return true if the distribution supports the checkpointing
     */
    public boolean doSupportCheckpointing();

}
