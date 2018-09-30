package com.yunpayroll.formular.test;

import java.io.StringReader;
import java.util.StringTokenizer;

import com.yunpayroll.formular.Parser;

public class Test {

	
	public static void main(String[] args) throws  Exception {
		// TODO Auto-generated method stub
		long s = System.currentTimeMillis();
		Parser parser = new Parser(new StringReader("case  when a>'1' then 1 else 3 end"));
//		Parser parser = new Parser(new StringReader("case a  when 1 then 1 else 3 end"));
		parser.addGlobalVar("BFV_NATURE_MONTH", "2017-01-01");
		parser.addVariable("a", 1l);
		Object v = parser.getValue();
		
		
		System.out.println(v);
		System.out.println("12345");
		StringTokenizer strtoken = new StringTokenizer("abc( def)");
		while(strtoken.hasMoreTokens()) {
			System.out.println(strtoken.nextToken());
		}
//		String a=null;
//		Files.lines(Paths.get("D:/workspace/formular/test/testcase")).forEach(
//				p->{
//					
//					parser.ReInit(new StringReader(p));
//					try {
//						SelectExpressionItem item = parser.Statement();
//						item.accept(expressionVisitor);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
////					System.out.println(System.currentTimeMillis()- s);
//				}
//				);
		
		
	}

}
