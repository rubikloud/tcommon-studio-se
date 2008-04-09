// ============================================================================
//
// Copyright (C) 2006-2007 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.dataprofiler.core.ui.editor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.talend.cwm.helper.SwitchHelpers;
import org.talend.cwm.relational.TdColumn;
import org.talend.dataprofiler.core.PluginConstant;
import org.talend.dataprofiler.core.exception.DataprofilerCoreException;
import org.talend.dataprofiler.core.model.ColumnIndicator;
import org.talend.dataprofiler.core.ui.dialog.ColumnsSelectionDialog;
import org.talend.dataprofiler.core.ui.editor.composite.AnasisColumnTreeViewer;
import org.talend.dataprofiler.core.ui.editor.composite.DataFilterComp;
import org.talend.dataquality.indicators.Indicator;
import org.talend.dq.analysis.AnalysisWriter;
import org.talend.dq.analysis.ColumnAnalysisHandler;
import org.talend.utils.sugars.ReturnCode;
import orgomg.cwm.objectmodel.core.ModelElement;

/**
 * @author rli
 * 
 */
public class ColumnMasterDetailsPage extends FormPage implements PropertyChangeListener {

    private static Logger log = Logger.getLogger(ColumnMasterDetailsPage.class);

    private Text nameText;

    private Text purposeText;

    private Text descriptionText;

    private AnasisColumnTreeViewer treeViewer;

    private DataFilterComp dataFilterComp;

    private ColumnAnalysisHandler analysisHandler;

    private ColumnIndicator[] currentColumnIndicators;

    public ColumnMasterDetailsPage(FormEditor editor, String id, String title) {
        super(editor, id, title);
        this.initAnalysis(editor);
    }

    private void initAnalysis(FormEditor editor) {
        IEditorInput input = editor.getEditorInput();
        analysisHandler = new ColumnAnalysisHandler();
        analysisHandler.setAnalysis(((AnalysisEditorInuput) input).getAnalysis());
        EList<ModelElement> analyzedColumns = analysisHandler.getAnalyzedColumns();
        List<ColumnIndicator> columnIndicatorList = new ArrayList<ColumnIndicator>();
        ColumnIndicator currentColumnIndicator;
        for (ModelElement element : analyzedColumns) {
            TdColumn tdColumn = SwitchHelpers.COLUMN_SWITCH.doSwitch(element);
            if (tdColumn == null) {
                continue;
            }
            currentColumnIndicator = new ColumnIndicator(tdColumn);
            Collection<Indicator> indicatorList = analysisHandler.getIndicators(tdColumn);
            currentColumnIndicator.setIndicators(indicatorList.toArray(new Indicator[indicatorList.size()]));
            columnIndicatorList.add(currentColumnIndicator);
        }
        currentColumnIndicators = columnIndicatorList.toArray(new ColumnIndicator[columnIndicatorList.size()]);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.forms.editor.FormPage#createFormContent(org.eclipse.ui.forms.IManagedForm)
     */
    @Override
    protected void createFormContent(IManagedForm managedForm) {
        final ScrolledForm form = managedForm.getForm();
        FormToolkit toolkit = this.getEditor().getToolkit();
        Composite body = form.getBody();
        form.setText("Analysis Settings");

        // TableWrapLayout layout = new TableWrapLayout();
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        body.setLayout(layout);

        Composite anasisDataComp = toolkit.createComposite(body);
        GridData anasisData = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING);
        anasisData.horizontalSpan = 1;
        anasisDataComp.setLayoutData(anasisData);
        anasisDataComp.setLayout(new GridLayout(1, true));

        createAnalysisMetadataSection(form, toolkit, anasisDataComp);
        createAnalysisColumnsSection(form, toolkit, anasisDataComp);
        createDataFilterSection(form, toolkit, anasisDataComp);
    }

    private void createAnalysisMetadataSection(final ScrolledForm form, FormToolkit toolkit, Composite anasisDataComp) {
        Section section = createSection(form, toolkit, anasisDataComp, "Analysis metadata", false,
                "Set the properties of analysis.");
        Composite labelButtonClient = toolkit.createComposite(section);

        labelButtonClient.setLayout(new GridLayout(2, false));

        Label label = toolkit.createLabel(labelButtonClient, "Analysis Name:");
        label.setLayoutData(new GridData());
        nameText = toolkit.createText(labelButtonClient, null, SWT.BORDER);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(nameText);
        nameText.setText(analysisHandler.getName() == null ? PluginConstant.EMPTY_STRING : analysisHandler.getName());
        label = toolkit.createLabel(labelButtonClient, "Analysis Purpose:");
        label.setLayoutData(new GridData());
        purposeText = toolkit.createText(labelButtonClient, null, SWT.BORDER);
        // purposeText.setLayoutData(new GridData());
        GridDataFactory.fillDefaults().grab(true, true).applyTo(purposeText);
        purposeText.setText(analysisHandler.getPurpose() == null ? PluginConstant.EMPTY_STRING : analysisHandler.getPurpose());
        label = toolkit.createLabel(labelButtonClient, "Analysis Description:");
        label.setLayoutData(new GridData());
        descriptionText = toolkit.createText(labelButtonClient, null, SWT.BORDER);
        // descriptionText.setLayoutData(new GridData());
        GridDataFactory.fillDefaults().grab(true, true).applyTo(descriptionText);
        descriptionText.setText(analysisHandler.getDescription() == null ? PluginConstant.EMPTY_STRING : analysisHandler
                .getDescription());
        section.setClient(labelButtonClient);
    }

    private void createAnalysisColumnsSection(final ScrolledForm form, FormToolkit toolkit, Composite anasisDataComp) {
        Section section = createSection(form, toolkit, anasisDataComp, "Analyzed Columns", true, "Select the columns to analyze:");

        Composite topComp = toolkit.createComposite(section);
        topComp.setLayout(new GridLayout(3, true));

        Composite tree = toolkit.createComposite(topComp, SWT.BORDER);
        GridDataFactory.fillDefaults().span(2, 1).align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(tree);
        tree.setLayout(new GridLayout());

        treeViewer = new AnasisColumnTreeViewer(tree, currentColumnIndicators);
        treeViewer.setDirty(false);
        treeViewer.addPropertyChangeListener(this);
        Composite buttonsComp = toolkit.createComposite(topComp, SWT.None);
        GridDataFactory.fillDefaults().span(1, 1).applyTo(buttonsComp);
        buttonsComp.setLayout(new GridLayout(1, true));
        Button button = toolkit.createButton(buttonsComp, "Add..", SWT.None);
        GridDataFactory.fillDefaults().span(1, 1).align(SWT.FILL, SWT.TOP).applyTo(button);
        button.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                openColumnsSelectionDialog();
            }
        });

        section.setClient(topComp);

    }

    /**
     * 
     */
    private void openColumnsSelectionDialog() {
        ColumnsSelectionDialog dialog = new ColumnsSelectionDialog(getSite().getShell(), "Column Selection");
        if (dialog.open() == Window.OK) {
            Object[] columns = dialog.getResult();
            treeViewer.setInput(columns);
            return;
        }
    }

    /**
     * @param form
     * @param toolkit
     * @param anasisDataComp
     */
    private void createDataFilterSection(final ScrolledForm form, FormToolkit toolkit, Composite anasisDataComp) {
        Section section = createSection(form, toolkit, anasisDataComp, "Data Filter", false, "Edit the data filter:");

        Composite sectionClient = toolkit.createComposite(section);
        dataFilterComp = new DataFilterComp(sectionClient);
        section.setClient(sectionClient);
    }

    /**
     * @param form
     * @param toolkit
     * @param anasisDataComp
     * @param title
     * @param expanded
     * @param discription
     * @return
     */
    private Section createSection(final ScrolledForm form, FormToolkit toolkit, Composite parent, String title, boolean expanded,
            String discription) {
        Section section = toolkit.createSection(parent, Section.DESCRIPTION

        | Section.TWISTIE | Section.TITLE_BAR);

        section.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING));

        section.addExpansionListener(new ExpansionAdapter() {

            public void expansionStateChanged(ExpansionEvent e) {
                form.reflow(true);
            }

        });

        section.setText(title);
        section.setExpanded(expanded);

        // toolkit.createCompositeSeparator(section);

        section.setDescription(discription);
        return section;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.forms.editor.FormPage#doSave(org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    public void doSave(IProgressMonitor monitor) {
        super.doSave(monitor);
        try {
            saveAnalysis();
            treeViewer.setDirty(false);
        } catch (DataprofilerCoreException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param outputFolder
     * @throws DataprofilerCoreException
     */
    private void saveAnalysis() throws DataprofilerCoreException {
        AnalysisEditorInuput editorInput = (AnalysisEditorInuput) this.getEditorInput();
        String fileName = editorInput.getName();

        ColumnIndicator[] columnIndicators = treeViewer.getColumnIndicator();
        if (columnIndicators != null) {
            for (ColumnIndicator columnIndicator : columnIndicators) {
                analysisHandler.addIndicator(columnIndicator.getTdColumn(), columnIndicator.getIndicators());
            }
        }
        AnalysisWriter writer = new AnalysisWriter();
        File file = new File(editorInput.getFile().getParent() + File.separator + fileName);
        ReturnCode saved = writer.save(analysisHandler.getAnalysis(), file);
        if (saved.isOk()) {
            log.info("Saved in  " + file.getAbsolutePath() + " successful");
        } else {
            throw new DataprofilerCoreException("Problem saving file: " + file.getAbsolutePath() + ": " + saved.getMessage());
        }

        // TODO get the domain constraint, we will see later.
        // Domain dataFilter = getDataFilter(dataManager, (Column) column); // CAST here for test
        // analysisBuilder.addFilterOnData(dataFilter);
        //
        // FolderProvider folderProvider = new FolderProvider();
        // folderProvider.setFolder(new File(outputFolder));
        // DqRepositoryViewService.saveDomain(dataFilter, folderProvider);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.forms.editor.FormPage#isDirty()
     */
    @Override
    public boolean isDirty() {
        return super.isDirty() || treeViewer.isDirty();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.forms.editor.FormPage#dispose()
     */
    @Override
    public void dispose() {
        super.dispose();
        if (this.treeViewer != null) {
            this.treeViewer.removePropertyChangeListener(this);
        }
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (PluginConstant.ISDIRTY_PROPERTY.equals(evt.getPropertyName())) {
            ((AnalysisEditor) this.getEditor()).firePropertyChange(IEditorPart.PROP_DIRTY);
        }

    }

}
