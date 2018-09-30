package com.yunpayroll.formular;

import java.util.HashMap;



public class FuncMap
  extends HashMap<String, FuncCommand>
{
  private static final long serialVersionUID = -1192898221311853572L;
  
  
  
  public void put(Object o, FuncCommand p)
  {
    put((String)o, (FuncCommand)p);
  }
  
  public FuncCommand get(String s)
  {
    return (FuncCommand)super.get(s);
  }
  
}
