/**
 * 
 */

package com.cloderia.helion.client.local.ui.page;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.common.client.dom.DateInput;
import org.jboss.errai.common.client.dom.Event;
import org.jboss.errai.common.client.dom.EventListener;
import org.jboss.errai.common.client.dom.Span;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.common.client.dom.MouseEvent;
import org.jboss.errai.common.client.dom.TextArea;
import org.jboss.errai.common.client.dom.TextInput;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.ForEvent;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.dom.client.AnchorElement;

import com.cloderia.helion.client.local.ui.EntityEditor;
import com.cloderia.helion.client.local.ui.NativeUIFunctions;

import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.model.Classification;
import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.model.Subject;
import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.model.AcademicLevel;
import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.model.WritingStyle;
import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.model.Urgency;
import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.model.Assignment;
import com.cloderia.helion.client.shared.operation.AssignmentOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.service.ClassificationStorageService;
import com.cloderia.helion.client.shared.service.SubjectStorageService;
import com.cloderia.helion.client.shared.service.AcademicLevelStorageService;
import com.cloderia.helion.client.shared.service.WritingStyleStorageService;
import com.cloderia.helion.client.shared.service.UrgencyStorageService;
import com.cloderia.helion.client.shared.service.AssignmentStorageService;
import com.cloderia.helion.client.shared.service.PricingOptionsStorageService;
import com.cloderia.helion.client.shared.util.Calculator;
import com.cloderia.helion.client.shared.util.DateConverter;

import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.ListBox;

/**
 * 
 */
@Templated(value = "create-assignment-page.html#entityEditor")
public class AssignmentEditor extends EntityEditor<Assignment> {
  	
  	@Inject
  	@DataField
  	private AnchorElement submitBtn;

  	@Inject
	@Bound @DataField
  	private TextInput name;
  	
  	@Inject
	@DataField
  	private ListBox docType;
  	
  	@Inject
	@DataField
  	private ListBox subject;
  	
  	@Inject
	@DataField
  	private ListBox alevel;
  	
  	@Inject
	@DataField
  	private ListBox style;
  	
  	@Inject
	@DataField
  	private ListBox urgency;
  	
  	@Inject
	@Bound @DataField
  	private TextInput pageCount;
  	
  	@Inject
	@Bound @DataField
  	private TextInput sourcesCount;
  	
  	@Inject
	@Bound @DataField
  	private TextArea description;
  	

	private List<Classification> docTypeList;

	private List<Subject> subjectList;

	private List<AcademicLevel> alevelList;

	private List<WritingStyle> styleList;

	private List<Urgency> urgencyList;

	@Inject
	protected Caller<ClassificationStorageService> docTypeService;

	@Inject
	protected Caller<SubjectStorageService> subjectService;

	@Inject
	protected Caller<AcademicLevelStorageService> alevelService;

	@Inject
	protected Caller<WritingStyleStorageService> styleService;

	@Inject
	protected Caller<UrgencyStorageService> urgencyService;
  	
  	@Inject Calculator calculator;
  	
  	@Inject @DataField Span priceField;
  	
  	protected BigDecimal pricingFactor = new BigDecimal(0);
	
  	@Inject
  	protected Caller<AssignmentStorageService> entityDataService;

	@Inject
	protected Caller<PricingOptionsStorageService> pricingOptionService;

	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.EntityEditor#init()
	 */
	@Override
	public void init() {
		loadClassifications();
		loadSubjects();
		loadAcademicLevels();
		loadWritingStyles();
		loadUrgencys();
		loadPriceOptionData();
		pageCount.setValue("1");
		pageCount.setOnchange(new EventListener<Event>() {
			@Override
			public void call(Event event) {
				calculate(urgencyList.get(urgency.getSelectedIndex() - 1),	alevelList.get(alevel.getSelectedIndex() - 1));
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.Editor#load(java.lang.String)
	 */
	@Override
	public void load(String entityCode) {
	}
	
	/**
  	 * @param event
  	 */
  	@EventHandler("submitBtn")
    public void onSubmitBtnClicked(final @ForEvent("click") MouseEvent event) {
		getValue().setPageCount(Integer.valueOf(pageCount.getValue()));
		super.onSubmitBtnClicked(event);
    }
  	
  	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.EntityEditor#save()
	 */
	@Override
	public void save() {
		// No validation errors we now execute the remote call 
		AssignmentOperation ops = new AssignmentOperation(getValue(), bus.getSessionId());
		ops.setDocTypeId(docTypeList.get(docType.getSelectedIndex() - 1).getId());
		ops.setSubjectId(subjectList.get(subject.getSelectedIndex() - 1).getId());
		ops.setAlevelId(alevelList.get(alevel.getSelectedIndex() - 1).getId());
		ops.setStyleId(styleList.get(style.getSelectedIndex() - 1).getId());
		ops.setUrgencyId(urgencyList.get(urgency.getSelectedIndex() - 1).getId());
		entityDataService.call((final Response response) -> {
		}).create(ops);
	}
	
	/**
	 * 
	 */
	private void loadPriceOptionData() {
		pricingOptionService.call(new RemoteCallback<PricingOptions>() {
			@Override
			public void callback(PricingOptions option) {
				pricingFactor = option.getPriceFactor();
			}
		}).findByCode("DEFAULT");
	}
	
	
	/**
	 * 
	 */
	protected void loadClassifications() {
		docTypeService.call(new RemoteCallback<List<Classification>>() {
			@Override
			public void callback(List<Classification> entitiesList) {
				docTypeList = entitiesList;
				for (Classification entity : entitiesList) {
					docType.addItem(entity.getName(), entity.getId().toString());
				}
				NativeUIFunctions.refreshWidgets();
				registerHandlers();
			}
		}).findByType("DOCUMENT_TYPE".toLowerCase());
	}
	
	/**
	 * 
	 */
	protected void loadSubjects() {
		subjectService.call(new RemoteCallback<List<Subject>>() {
			@Override
			public void callback(List<Subject> entitiesList) {
				subjectList = entitiesList;
				for (Subject entity : entitiesList) {
					subject.addItem(entity.getName(), entity.getId().toString());
				}
				NativeUIFunctions.refreshWidgets();
				registerHandlers();
			}
		}).findAll();
	}
	
	/**
	 * 
	 */
	protected void loadAcademicLevels() {
		alevelService.call(new RemoteCallback<List<AcademicLevel>>() {
			@Override
			public void callback(List<AcademicLevel> entitiesList) {
				alevelList = entitiesList;
				for (AcademicLevel entity : entitiesList) {
					alevel.addItem(entity.getName(), entity.getId().toString());
				}
				NativeUIFunctions.refreshWidgets();
				registerHandlers();
			}
		}).findAll();
	}
	
	/**
	 * 
	 */
	protected void loadWritingStyles() {
		styleService.call(new RemoteCallback<List<WritingStyle>>() {
			@Override
			public void callback(List<WritingStyle> entitiesList) {
				styleList = entitiesList;
				for (WritingStyle entity : entitiesList) {
					style.addItem(entity.getName(), entity.getId().toString());
				}
				NativeUIFunctions.refreshWidgets();
				registerHandlers();
			}
		}).findAll();
	}
	
	/**
	 * 
	 */
	protected void loadUrgencys() {
		urgencyService.call(new RemoteCallback<List<Urgency>>() {
			@Override
			public void callback(List<Urgency> entitiesList) {
				urgencyList = entitiesList;
				for (Urgency entity : entitiesList) {
					urgency.addItem(entity.getName(), entity.getId().toString());
				}
				NativeUIFunctions.refreshWidgets();
				registerHandlers();
			}
		}).findAll();
	}
	/**
	 * 
	 */
	protected native void registerHandlers()/*-{
  		var theInstance = this;
		$wnd.$('.selectpicker').on('changed.bs.select', function (e, clickedIndex, newValue, oldValue) {
			var id = e.target.id;
        	theInstance.@com.cloderia.helion.client.local.ui.page.AssignmentEditor::onChangedBSSelect(Ljava/lang/String;Ljava/lang/String;)(id, clickedIndex);
        });
	}-*/;

	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.EntityEditor#onChangedBSSelect()
	 */
	protected void onChangedBSSelect(String id, String clickedIndex) {
		logger.info("######## onChangedBSSelect called");
		
		calculate(docTypeList.get(docType.getSelectedIndex() - 1), subjectList.get(subject.getSelectedIndex() - 1),
				alevelList.get(alevel.getSelectedIndex() - 1), styleList.get(style.getSelectedIndex() - 1),	urgencyList.get(urgency.getSelectedIndex() - 1));

		/*
		if(id.equals("urgency")){
			for (Urgency entity : urgencyList) {
				if(entity.getId().equals(Integer.valueOf(clickedIndex))){
					calculate(entity, alevelList.get(alevel.getSelectedIndex() - 1));
				}
			}
		} 
		if(id.equals("alevel")){
			for (AcademicLevel entity : alevelList) {
				if(entity.getId().equals(Integer.valueOf(clickedIndex))){
					calculate(urgencyList.get(urgency.getSelectedIndex() - 1), entity);
				}
			}
		} */
	}

	/**
	 * @param classification
	 * @param subject
	 * @param academicLevel
	 * @param writingStyle
	 * @param urgency
	 */
	private void calculate(Classification classification, Subject subject, AcademicLevel academicLevel,
			WritingStyle writingStyle, Urgency urgency) {
		logger.info("######## calculate called" + urgency.getPriceFactor() + ":" + academicLevel.getPriceFactor() + ":" + pageCount.getValue());
		BigDecimal price = calculator.calculate(academicLevel, urgency, new BigDecimal(pageCount.getValue()), pricingFactor);
		priceField.setTextContent(price.setScale(2, RoundingMode.CEILING).toString());
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param entity
	 */
	protected void calculate(Urgency urgencyData, AcademicLevel aLevelData) {
		logger.info("######## calculate called" + urgencyData.getPriceFactor() + ":" + aLevelData.getPriceFactor() + ":" + pageCount.getValue());
		BigDecimal price = calculator.calculate(aLevelData, urgencyData, new BigDecimal(pageCount.getValue()), pricingFactor);
		priceField.setTextContent(price.setScale(2, RoundingMode.CEILING).toString());
	}

}
