package com.brule.utils;

import java.util.Map;
import java.util.UUID;

import javax.xml.namespace.QName;

import com.brule.models.GenerateDMNRequest;
import com.brule.models.datamodels.Element;
import com.brule.models.datamodels.Library;
import com.brule.models.datamodels.Schema;
import com.brule.models.datamodels.SchemaGroup;

import org.kie.dmn.api.marshalling.DMNMarshaller;
import org.kie.dmn.backend.marshalling.v1x.DMNMarshallerFactory;
import org.kie.dmn.model.api.Definitions;
import org.kie.dmn.model.api.ItemDefinition;
import org.kie.dmn.model.v1_2.KieDMNModelInstrumentedBase;
import org.kie.dmn.model.v1_2.TDefinitions;
import org.kie.dmn.model.v1_2.TItemDefinition;
import org.kie.dmn.model.v1_2.dmndi.DMNDI;

public class DMNGenerator {
    
    private static String generateUUID()
    {
        UUID id = UUID.randomUUID();
        return id.toString();
    }

    private static void setDefaultNSContext(Definitions definitions) {
        Map<String, String> nsContext = definitions.getNsContext();
        nsContext.put("feel", KieDMNModelInstrumentedBase.URI_FEEL);
        nsContext.put("dmn", KieDMNModelInstrumentedBase.URI_DMN);
        nsContext.put("dmndi", KieDMNModelInstrumentedBase.URI_DMNDI);
        nsContext.put("di", KieDMNModelInstrumentedBase.URI_DI);
        nsContext.put("dc", KieDMNModelInstrumentedBase.URI_DC);
    }

    private static void setDefaultNSContextDMNDI(DMNDI definitions) {
        Map<String, String> nsContext = definitions.getNsContext();
        nsContext.put("feel", KieDMNModelInstrumentedBase.URI_FEEL);
        nsContext.put("dmn", KieDMNModelInstrumentedBase.URI_DMN);
        nsContext.put("dmndi", KieDMNModelInstrumentedBase.URI_DMNDI);
        nsContext.put("di", KieDMNModelInstrumentedBase.URI_DI);
        nsContext.put("dc", KieDMNModelInstrumentedBase.URI_DC);
    }

    private static QName determineType(Element element)
    {
        QName type = null;
        if(element.getDatatype().equals("string") || element.getDatatype().equals("integer") || element.getDatatype().equals("number")
           || element.getDatatype().equals("Any")  || element.getDatatype().equals("date") || element.getDatatype().equals("time")
           || element.getDatatype().equals("boolean"))
           type = new QName(element.getDatatype());
        else if (element.getDatatype().equals("object"))
           type = new QName("context");   
        else
           type = new QName("t"+element.getDatatype());
        return type;
    }

    public static String generateDMNwithImports(GenerateDMNRequest request)
    {

       Definitions definitions = new TDefinitions();
       definitions.setName("model1");
       definitions.setDescription("ModelDescription");
       definitions.setId("modelid1");
       setDefaultNSContext(definitions);

       for(Library library : request.getLibraryList())
       {
           for(SchemaGroup grp : library.getSchemaGroupList())
           {
                 for(Schema schema : grp.getSchemaList())
                 {
                      ItemDefinition defn = new TItemDefinition();
                      defn.setId(generateUUID());
                      defn.setName("t"+schema.getName());
                      defn.setIsCollection(false);
                      for(Element element : schema.getElements())
                      {
                          ItemDefinition eledefn = new TItemDefinition();
                          eledefn.setId(generateUUID());
                          eledefn.setName(element.getName());
                         
                          eledefn.setTypeRef(determineType(element));
                          if(element.getIsList())
                            eledefn.setIsCollection(true);
                          else
                            eledefn.setIsCollection(false);  
                         
                          defn.getItemComponent().add(eledefn);  
                      }
                      definitions.getItemDefinition().add(defn);   
                 }
           }
       }
       DMNMarshaller dmnMarshaller = DMNMarshallerFactory.newDefaultMarshaller();
       String xml = dmnMarshaller.marshal(definitions);
       System.out.println(xml);
       return xml;

    }
}
