/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MATEEN
 */
import java.util.TreeMap;
import java.util.Map;
public class Treemaptest {
    
    public static void main (String[]args){
        
        
        //create TreeMap instance
    TreeMap<String,String> treeMap = new TreeMap<>();

    //add key value pairs to TreeMap
    treeMap.put("1","One");
    treeMap.put("2","Two");
    treeMap.put("3","Three");
    
    for(Map.Entry<String,String> entry : treeMap.entrySet()) {
 String key = entry.getKey();
  String value = entry.getValue();

  System.out.println(key + " => " + value);
}
}
}