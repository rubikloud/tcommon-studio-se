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

import org.talend.core.hadoop.api.ESparkVersion;

/**
 * Interface that exposes specific Spark methods.
 *
 */
public interface SparkComponent extends MRComponent {

    /**
     * A distribution can be using Spark 1.3 or Spark 1.4. This method returns the used Spark version.
     * 
     * @return the @link{ESparkVersion} of the distribution.
     */
    public ESparkVersion getSparkVersion();

    /**
     * @return true if the Spark version included in the distribution is 1.4.
     */
    public boolean isSpark14();

    /**
     * @return true if the distribution supports the Dynamic Allocation feature.
     * @see http://spark.apache.org/docs/latest/configuration.html#dynamic-allocation
     */
    public boolean doSupportDynamicMemoryAllocation();

    /**
     * @return true if the distribution executes its M/R job through Spark JobServer.
     */
    public boolean isExecutedThroughSparkJobServer();

}
