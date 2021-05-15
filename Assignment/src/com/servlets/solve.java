package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class solve extends HttpServlet{

    static int condition(int[] arr, int n, int k, int currentTime){
        int count=1;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>currentTime){
                sum=arr[i];
                count++;
            }
        }
        if(count<=k){
            return 1;
        }
        return 0;
    }
    
    static int solve(int n,int k,int[] arr){
        int totalSum=0;
        int maxNumber=0;
        for(int i=0;i<n;i++){
            totalSum+=arr[i];
            maxNumber=Math.max(maxNumber,arr[i]);
        }
        int time=0;
        while(maxNumber<totalSum){
            int currentTime=(maxNumber+totalSum)/2;
            
            if(condition(arr,n,k,currentTime)==1 ){
                time=currentTime;
                totalSum=currentTime-1;
            }
            else{
                maxNumber=currentTime+1;
            }
            
            
        }
        return time;
    }
	
	  @Override
	    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		  PrintWriter out =response.getWriter();
		  
		    String s=request.getParameter("n");
		    int n=Integer.parseInt(s); 
			String s2=request.getParameter("k");
			int k=Integer.parseInt(s2);
			String array=request.getParameter("array");
			String[] splited = array.split(" ");
			int[] numbers = new int[splited.length];
			for(int i = 0; i < splited.length; i++) {
			    numbers[i] = Integer.parseInt(splited[i]);
			}
			
			int ans=solve(n,k,numbers);
			out.println("<br> <br>");
			out.println("<span style='text-align: center'><h1>"+"Minimum time to get this work done "+ans+ " minute</h1>" +"<br>"+"<a href='index.html'>Try-Again</a></span>");
	
	  }
	  
	  
}
