package com.foo.struts2;
import com.opensymphony.xwork2.ActionSupport;
public class UploadAction extends ActionSupport {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String path;
	
	 public String execute() throws Exception {
	      System.out.println("Inside action....");
	      return "success";
	   } 
	    
	 public String getPath() {
		 String s = path;
		 System.out.println(s + " becomes: ");
		 s = s.replaceAll("\\\\", "\\\\\\\\");
		 //System.out.println(s); 
		 return s;
	      
	   }

	   public void setPath(String path) {
	      this.path = path;
	   }

}