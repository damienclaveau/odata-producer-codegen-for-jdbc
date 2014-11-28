package core;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory; 
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

/**
 * 
 * Title: MVNO-CRM <br>
 * Description: <br>
 * Date: 2014年10月11日 <br>
 * Copyright (c) 2014 Microsoft <br>
 * 
 * @author Li Ming Ding
 */
public  class SemOdataJPAServiceFactory extends ODataJPAServiceFactory {
	private static final String persistenceUnitName = "odata2_jpa2";

	@Override
	public ODataJPAContext initializeODataJPAContext()
			throws ODataJPARuntimeException {
		  ODataJPAContext oDataJPAContext = this.getODataJPAContext();  
	        try {  
	            EntityManagerFactory emf = Persistence  
	                    .createEntityManagerFactory(persistenceUnitName);
	            oDataJPAContext.setEntityManagerFactory(emf);
	            oDataJPAContext.setPersistenceUnitName(persistenceUnitName);  
	            return oDataJPAContext;  
	        } catch (Exception e) {  
	        	System.out.println(e.getMessage());
	            throw new RuntimeException(e);  
	        }  
	}

}
