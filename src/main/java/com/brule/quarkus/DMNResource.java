package com.brule.quarkus;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brule.models.DMNResponse;
import com.brule.models.GenerateDMNRequest;
import com.brule.utils.DMNGenerator;

@Path("/DMN")
public class DMNResource {

    @Path("/importSchemas")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public DMNResponse deployProject(GenerateDMNRequest request)
    {
        DMNResponse response = new DMNResponse();
        String dmn = DMNGenerator.generateDMNwithImports(request);
        response.setGenerated(true);
        response.setDmnXML(dmn);
        return response;

    }


    
}
