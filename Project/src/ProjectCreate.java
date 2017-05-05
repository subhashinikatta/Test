import org.json.JSONObject;
import org.json.simple.JSONArray;

class ProjectCreate {      
	   // Config variables must be declared by users     
	   private String projectName = "@{project_name}";   
	   private String roleName = "@{role_name}";      
	   private String projectUuid = null;       
	   private String roleUuid = null;      
	   private String userUuid = null;    
	   private String name = null;     
	   private RestResponse result, response = null;   
	   // private JSONObject jObj = null;      
	   private Object jObj = null;    
	   public static void main(String[] args) {     
		   if (args.length == 3) {  
                   ProjectCreate newProject = new ProjectCreate();  
                  newProject.projectCreateCall(args[0], args[1], args[2]);  
      } else { 
    System.out.println("Usage : filename <ip> <username> <password>");  
  }  
       }  
         public void projectCreateCall(String ip, String userName, String password) {  
                // Rest API Call  
     RestApi restCall = RestApi.getInstance();  
            restCall.setParms(ip, userName, password);  
            // Get role Uuid from role name.  
          result = Helper.getRoles(this.roleName); 
              if (result.getResponseCode() != 200) { 
                      System.out.println("Failed  to get roles \n"); 
                       result.errorPrint();  
              return; 
          }  
             // If response is ok(200), program will continue execution.  
               JSONObject roles = result.getResponse();  
              org.json.JSONArray role = Helper.getJSONArrayValue(roles, "entities"); 
               for (int i = 0; i < role.length(); i++) {  
             // jObj = role.getJSONObject(i);  
                jObj = role.opt(i);  
                     name = Helper.parseResult(jObj, "status", "name"); 
                       if (name.equals(roleName)) { 
                              roleUuid = Helper.parseResult(jObj, "metadata", "uuid");  
                                System.out.println("roleUuid : " + roleUuid + "\n");  
                                break; // Added to reduce the loop  
                     }  
                }  
              // Get the current logged users. 
              response = Helper.listLoggedInUsers();  
         if (response.getResponseCode() != 200) { 
                      System.out.println("Failed to get the logged users"); 
                      response.errorPrint(); 
           return;  

            }  
     // Assign the userUuid 
          userUuid = Helper.parseResult(response.getResponse(), "metadata", "uuid"); 
             System.out.println("Current user Uuid:" + userUuid);  
         // Check if project Exists.  
 response = Helper.getProjects(); 
   if (response.getResponseCode() != 200) { 
                    System.out.println("Failed to list projects \n"); 
                     response.errorPrint();  
               return;  
            } 
           // Print the list of project names  
         JSONObject projects = response.getResponse();  
               org.json.JSONArray project = Helper.getJSONArrayValue(projects, "entities"); 
                 for (int i = 0; i < project.length(); i++) {  
                        jObj = project.opt(i);  
                       name = Helper.parseResult(jObj, "status", "name");  
                         //System.out.println("Project Name : " + name);  
                        if (name.equals(projectName)) {  
                                 System.out.println("Project Name already exists.");  
                                return;  
                        }  
               }  
             System.out.println("Project does not exists, Creating new project call");  
                // Create a Project
                 if (roleUuid != null) {  
                       response = Helper.createProject(this.projectName, this.roleUuid, this.userUuid);  
                       if (response.getResponseCode() != 200) { 
                              System.out.println("Failed to create project call:");  
                               response.errorPrint();  
                               return;  
                        }  
                        try { 
                              projectUuid = Helper.trackApiStatus(response,  
                                                 Helper.class.getMethod("getProject", new Class[] { String.class }));  
                        } catch (NoSuchMethodException e) { 
                             e.printStackTrace(); 
                        } catch (SecurityException e) { 
                               e.printStackTrace(); 
                        } 
                        if (projectUuid != null) { 
                          System.out.println("Created project with Uuid : " + projectUuid); 
                    } else { 
                                System.out.println("Failed to create project : " + projectName); 
                              return; 
                       } 
                } else {
                      System.out.println("Role is null"); 
                       return; 
                } 
                // Retrieve a project. 
                if (projectUuid != null) { 
                      response = Helper.getProject(projectUuid);
                        if (response.getResponseCode() != 200) { 
                              System.out.println("Failed to retrieve a project");
                                response.errorPrint(); 
                                 return; 
                         } 
                       projectName = Helper.parseResult(response.getResponse(), "spec", "name"); 
                         System.out.println("Project Name :" + projectName); 
               } 

         } 

	   }
  
  
   