package org.open.cloud.idiom.api;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
	@RefreshScope
	@RestController
	public class IdiomController {
	  public static final String[] IDIOMS = {"齐心协力", "艰苦奋斗", "万紫千红", "走为上"};
	  public static Random random = new Random();
	  @RequestMapping("/")
	  public String idiom() {
	    return IDIOMS[random.nextInt(IDIOMS.length)];
	  }
	  
	    @Value("${age}")
	    private String age;

	    @RequestMapping("/me")
	    public String from() {
	        return  "我今年"+this.age+"岁了！";
	    }
	  
	  @RequestMapping("/add")
	  public String addition() {
		  StringBuffer str=new StringBuffer();
	         for(int i=1;i<=1;i++){             //用for循环语句
	        	int n= Integer.valueOf(this.age);
	        	int difficulty=10;
	        	 if(n>5){
	        		 difficulty=100;
	        	 }
	         int a=(int)(Math.random()*difficulty+1);   //随机生成10以内的数字
	         int b=(int)(Math.random()*difficulty+1);
		  str.append("("+i+")"+a+"+"+b+"=?"+"");
	  }
	         return str.toString();
	  }

	}