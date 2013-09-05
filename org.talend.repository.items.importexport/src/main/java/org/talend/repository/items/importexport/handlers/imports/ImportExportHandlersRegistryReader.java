// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.repository.items.importexport.handlers.imports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.SafeRunner;
import org.talend.core.utils.RegistryReader;
import org.talend.repository.items.importexport.handlers.model.internal.EPriority;
import org.talend.repository.items.importexport.handlers.model.internal.ImportProviderRegistry;
import org.talend.repository.items.importexport.handlers.model.internal.ImportResourcesProviderRegistry;

/**
 * DOC ggu class global comment. Detailled comment
 */
public class ImportExportHandlersRegistryReader extends RegistryReader {

    private static Logger log = Logger.getLogger(ImportExportHandlersRegistryReader.class);

    private List<ImportProviderRegistry> imortRegistries = new ArrayList<ImportProviderRegistry>();

    private List<ImportResourcesProviderRegistry> resImportResistries = new ArrayList<ImportResourcesProviderRegistry>();

    public ImportExportHandlersRegistryReader() {
        super("org.talend.repository.items.importexport", "handler"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    public void init() {
        readRegistry();

        // according to the priority
        Collections.sort(this.imortRegistries, new Comparator<ImportProviderRegistry>() {

            @Override
            public int compare(ImportProviderRegistry arg0, ImportProviderRegistry arg1) {
                return arg1.getPriority().compareTo(arg0.getPriority());
            }
        });
        // according to the priority
        Collections.sort(this.resImportResistries, new Comparator<ImportResourcesProviderRegistry>() {

            @Override
            public int compare(ImportResourcesProviderRegistry arg0, ImportResourcesProviderRegistry arg1) {
                return arg1.getPriority().compareTo(arg0.getPriority());
            }
        });
    }

    public IImportHandler[] getImportHandlers() {
        List<IImportHandler> handers = new ArrayList<IImportHandler>();
        for (ImportProviderRegistry ir : this.imortRegistries) {
            handers.add(ir.getImportHandler());
        }
        return handers.toArray(new IImportHandler[0]);
    }

    public IImportResourcesHandler[] getImportResourcesHandlers() {
        List<IImportResourcesHandler> handers = new ArrayList<IImportResourcesHandler>();
        for (ImportResourcesProviderRegistry ir : this.resImportResistries) {
            handers.add(ir.getImportResourcesHandler());
        }
        return handers.toArray(new IImportResourcesHandler[0]);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.utils.RegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
     */
    @Override
    protected boolean readElement(final IConfigurationElement element) {
        if ("importProvider".equals(element.getName())) { //$NON-NLS-1$
            SafeRunner.run(new RegistryReader.RegistrySafeRunnable() {

                @Override
                public void run() throws Exception {
                    try {
                        String id = element.getAttribute("id"); //$NON-NLS-1$
                        String name = element.getAttribute("name"); //$NON-NLS-1$
                        String description = element.getAttribute("description"); //$NON-NLS-1$

                        String priorityString = element.getAttribute("priority"); //$NON-NLS-1$
                        EPriority priority = (priorityString != null && priorityString.length() > 0) ? EPriority
                                .valueOf(priorityString.toUpperCase()) : EPriority.NORMAL;

                        IImportHandler handler = (IImportHandler) element.createExecutableExtension("handler"); //$NON-NLS-1$
                        if (handler == null) {
                            log.error("Can't create handlder for " + name); //$NON-NLS-1$
                            return;
                        }

                        ImportProviderRegistry importRegistry = new ImportProviderRegistry(element.getContributor().getName(), id);
                        importRegistry.setName(name);
                        importRegistry.setDescription(description);
                        importRegistry.setImportHandler(handler);
                        importRegistry.setPriority(priority);

                        imortRegistries.add(importRegistry);
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }

                }

            });
            return true;
        } else if ("importResourcesProvider".equals(element.getName())) { //$NON-NLS-1$
            SafeRunner.run(new RegistryReader.RegistrySafeRunnable() {

                @Override
                public void run() throws Exception {
                    try {
                        String id = element.getAttribute("id"); //$NON-NLS-1$
                        String description = element.getAttribute("description"); //$NON-NLS-1$

                        String priorityString = element.getAttribute("priority"); //$NON-NLS-1$
                        EPriority priority = (priorityString != null && priorityString.length() > 0) ? EPriority
                                .valueOf(priorityString.toUpperCase()) : EPriority.NORMAL;

                        IImportResourcesHandler resImportHandler = (IImportResourcesHandler) element
                                .createExecutableExtension("importResoucesHandler");//$NON-NLS-1$

                        ImportResourcesProviderRegistry registry = new ImportResourcesProviderRegistry(element.getContributor().getName(), id);
                        registry.setDescription(description);
                        registry.setPriority(priority);
                        registry.setImportResourcesHandler(resImportHandler);

                        resImportResistries.add(registry);
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }

                }

            });
            return true;
        }
        return false;
    }

}
