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

import com.brule.models.BuildProjectResponse;
import com.brule.models.DeployProjectRequest;
import com.brule.models.Project;
import com.brule.models.ProjectItem;

import org.apache.commons.io.FileUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@Path("/project")
public class ProjectResource {

    @ConfigProperty(name = "projectBaseDir")
     private String projectBaseDir;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy " + this.projectBaseDir;
    }


    @Path("/deploy")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BuildProjectResponse deployProject(DeployProjectRequest request)
    {
        BuildProjectResponse response = new BuildProjectResponse();
        response.setProjectName(request.getProjectName());
        String result = "failed";
        try{
            String applicationPropPath = this.projectBaseDir+"/"+request.getProjectName()+"/src/main/resources/application.properties";
            File appProp = new File(applicationPropPath);
            String data  = "quarkus.http.port="+request.getPortno();
            FileUtils.writeStringToFile(appProp,data, Charset.defaultCharset(), false);
            ProcessBuilder vBuilder = new ProcessBuilder();
            String command = "mvn compile quarkus:dev";
            vBuilder.directory(new File(this.projectBaseDir+"/"+request.getProjectName()));
            vBuilder.command("/bin/sh","-c",command);
            System.out.println("Executing Mvn Command  " + vBuilder.command().toString());
              Process process = vBuilder.start();
              BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if(line.contains("Listening on: http://localhost"))
                  break;
            }
 
           /*  int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode); */

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        response.setResult(result);
        return response;

    }



    @Path("/build")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BuildProjectResponse createProject(Project project)
    {
          BuildProjectResponse response = new BuildProjectResponse();
          response.setProjectName(project.getName());
          
          String existingProject = this.projectBaseDir+"/"+project.getName();
          //java.nio.file.Path existingPath = Paths.get(existingProject);
          
          String result = "failed";
          try {
              FileUtils.deleteQuietly(new File(existingProject));
              ProcessBuilder vBuilder = new ProcessBuilder();
              String command = "mvn archetype:generate -B -DarchetypeGroupId=com.generator  -DarchetypeArtifactId=kogito-template-archetype  -DarchetypeVersion=1.0.0-SNAPSHOT";
              command = command + " -DgroupId=com."+ project.getCompanyName();
              command = command + " -DartifactId="+project.getName()+" -Dversion="+project.getVersion();
              vBuilder.directory(new File(this.projectBaseDir));
              vBuilder.command("/bin/sh","-c",command);
              System.out.println("Executing Mvn Command  " + vBuilder.command().toString());
              Process process = vBuilder.start();
              BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
 
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
            if(exitCode == 0)
            {
                String packageName = "com."+project.getCompanyName()+"."+project.getName().toLowerCase();
                String packagePath = packageName.replaceAll("\\.","/");
                String resourcesDirPath = this.projectBaseDir+"/"+project.getName()+"/src/main/resources/"+packagePath;
                java.nio.file.Path path = Paths.get(resourcesDirPath);
                System.out.println("Package : " + packageName);
                System.out.println("PackagePath : " + resourcesDirPath);
                Files.createDirectories(path);
                System.out.println("project models " + project.getModels().size());
                for(ProjectItem item : project.getModels())
                {
                      File ruleFile = new File(resourcesDirPath+"/"+item.getName()+"_models"+".drl");
                      FileUtils.writeStringToFile(ruleFile, "package "+packageName+";\n", Charset.defaultCharset(), false);
                      FileUtils.writeStringToFile(ruleFile, item.getValue(), Charset.defaultCharset(), true);
                } 
                for(ProjectItem item : project.getRulebooks())
                {
                      File ruleFile = new File(resourcesDirPath+"/"+item.getName()+".drl");
                      FileUtils.writeStringToFile(ruleFile, "package "+packageName+";\n", Charset.defaultCharset(), false);
                      FileUtils.writeStringToFile(ruleFile, item.getValue(), Charset.defaultCharset(), true);
                } 
                result = "Project Created Successfully";
            }
               
          }catch(Exception e)
          {
              e.printStackTrace();
          }

          response.setResult(result);
          return response;
    }
}