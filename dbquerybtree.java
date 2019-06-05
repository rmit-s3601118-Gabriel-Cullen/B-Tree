package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class dbquerybtree implements dbimpl {
	
	  Integer pageSize; 
	  Integer deviceID;
	  Integer pageCount; 
      
      BPlusTree btree;
	  
	public static void main(String args[]){
		dbquerybtree query = new dbquerybtree(); 
		
		dbload load = new dbload();
		load.readArguments();
	    query.btree = load.getBtree();
	    query.readArguments(args);
	      
	}

	
	public void readArguments(String args[])
	   {
		System.out.println(args.length);
	      if (args.length == 2)
	      {
	         if (isInteger(args[1]) && isInteger(args[0]))
	         {
	        	 deviceID = Integer.parseInt(args[0]);
	        	 pageSize = Integer.parseInt(args[1]);
	     		System.out.println(pageSize.toString());

	        	 pageCount = (Integer) btree.search(deviceID);
	        	 readHeap(deviceID, pageSize, pageCount);
	         }
	      }
	      else
	      {
	          System.out.println("Error: only pass in two arguments");
	      }
	   }
	
	public boolean isInteger(String s)
	   {
	      boolean isValidInt = false;
	      try
	      {
	         Integer.parseInt(s);
	         isValidInt = true;
	      }
	      catch (NumberFormatException e)
	      {
	         e.printStackTrace();
	      }
	      return isValidInt;
	   }

	public void readHeap(Integer deviceID, int pagesize, int pageCount)
	   {
	      File heapfile = new File(HEAP_FNAME + pagesize);
	      System.out.println(heapfile.getAbsolutePath());
	      int intSize = 4;
	      int recCount = 0;
	      int recordLen = 0;
	      int rid = 0;
	      boolean isNextPage = true;
	      boolean isNextRecord = true;
	      try
	      {
	         FileInputStream fis = new FileInputStream(heapfile);
	         // reading page by page
	         while (isNextPage)
	         {
	            byte[] bPage = new byte[pagesize];
	            byte[] bPageNum = new byte[intSize];
//	            System.out.println("PageCount: " + pageCount + "pageSize" + pagesize);
//	            System.out.println("skipping to: " + (pageCount -1)*pagesize + " FileBytes=" + heapfile.length());
	            fis.skip(pageCount * pagesize);
	            fis.read(bPage, 0, pagesize);
//	            System.out.println("read " + Arrays.toString(bPage));
	            System.arraycopy(bPage, bPage.length-intSize, bPageNum, 0, intSize);

	            // reading by record, return true to read the next record
	            isNextRecord = true;
	            while (isNextRecord)
	            {
	               byte[] bRecord = new byte[RECORD_SIZE];
	               byte[] bRid = new byte[intSize];
	               try
	               {
	                  System.arraycopy(bPage, recordLen, bRecord, 0, RECORD_SIZE);
	                  System.arraycopy(bRecord, 0, bRid, 0, intSize);
	                  rid = ByteBuffer.wrap(bRid).getInt();
	                  if (rid != recCount)
	                  {
	                     isNextRecord = false;
	                  }
	                  else
	                  {
	                     printRecord(bRecord, deviceID);
	                     recordLen += RECORD_SIZE;
	                  }
	                  recCount++;
	                  // if recordLen exceeds pagesize, catch this to reset to next page
	               }
	               catch (ArrayIndexOutOfBoundsException e)
	               {
	                  isNextRecord = false;
	                  recordLen = 0;
	                  recCount = 0;
	                  rid = 0;
	               }
	            }
	            // check to complete all pages
	            if (ByteBuffer.wrap(bPageNum).getInt() != pageCount)
	            {
	               isNextPage = false;
	            }
	            pageCount++;
	         }
	      }
	      catch (FileNotFoundException e)
	      {
	         System.out.println("File: " + HEAP_FNAME + pagesize + " not found.");
	      }
	      catch (IOException e)
	      {
	         e.printStackTrace();
	      }
	   }
	
	
	public void printRecord(byte[] rec, int deviceID)
	   {
	      String record = new String(rec);
	      int offset = record.indexOf(" ");
	      if (offset > 0) {
		      String ST_NAME = record.substring(0,offset);
	//	      System.out.println("checking  " +ST_NAME + " matches " + Integer.toString(deviceID));
		      if (ST_NAME.toLowerCase().contains(Integer.toString(deviceID)))
		      {
		         System.out.println("match  " +record);
		         
		      }else {
	//	    	  System.out.println("No match " +record);
		      }
	      }
	   }

}
