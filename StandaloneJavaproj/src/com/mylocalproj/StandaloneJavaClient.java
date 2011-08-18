package com.mylocalproj;

import com.mylocalproj.InputItemDetailServiceStub;

public class StandaloneJavaClient {

	
	 public static void main(String[] args)
	 {
	  try
	  {com.mylocalproj.InputItemDetailServiceStub inputItemStub = new com.mylocalproj.InputItemDetailServiceStub(); 
	  
	  com.mylocalproj.InputItemDetailServiceStub.GetItemName  theParam = new com.mylocalproj.InputItemDetailServiceStub.GetItemName();
	  
   theParam.setName("Apple");
   InputItemDetailServiceStub.GetItemNameResponse theRsp = inputItemStub.getItemName(theParam);
   String result = theRsp.getGetItemNameReturn();
   System.out.println("Result is: " + result);   
	  }
	  catch (Throwable t)
	  {
	   t.printStackTrace();
	   System.out.println(t);
	  }
	 
	
	 }
	
		
}
