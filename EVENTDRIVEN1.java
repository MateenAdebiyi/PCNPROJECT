/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MATEEN
 */
import java.util.Random;
 import java.util.TreeMap;
 class EventList1 {

    public String type;
    public double time;
}
public class EVENTDRIVEN1 {
    
    private final double k = 16807.0;
     private final double m = 2147483647;
     public  double s0 = 1234.0;
     
     
      public  void EventDriven1(double lambda ) {
        int N1,N2,N3,NDep1,NDep2,NDep3,NArr1,NArr2, NArr3,Dep3d;
        double clock1, clock2,clock3, gamma,mew,mew1,mew2,mew3,u1,u2,u3,rs1,rs2,r11,r13,r3d,r32,EN1,EN2,EN3,prevclock1,prevclock2,prevclock3;
         
  rs1 = 0.25;  
  rs2 = 0.75;  
  r11 = 0.5;  
  r13 = 0.5;  
  r3d = 0.4;  
  r32 =0.6 ;
  mew1 = 6;  
  mew2 = 25;
  mew3 = 30; 
  lambda=1;
  N1 = 0; 
  N2 =0;
  N3=0;
  clock1 = 0.0;
  clock2 = 0.0;
  clock3 =0.0;
  prevclock1=0.0;
  prevclock2=0.0;
  prevclock3=0.0;
  EN1= 0.0;
  EN2= 0.0;
  EN3= 0.0; 
  NDep1 = 0;
  NDep2 = 0;
  NDep3 = 0;
  NArr1 = 0;
  NArr2 = 0;
  NArr3 = 0;
  u1 = 0.0;
  u2= 0.0;
  u3=0.0;
  Dep3d=0;
    TreeMap<Double, String> events1 = new TreeMap<>();
    EventList1 currentEvent1 = new EventList1();
    EVENTDRIVEN1 exp = new EVENTDRIVEN1(); 
    events1.put(exp.RandomVariable(lambda*rs1), "ARV1"); 
    events1.put(exp.RandomVariable(lambda*rs2), "ARV2");
    
    while (Dep3d<= 5){
     currentEvent1 = returnEvent(events1);
     prevclock1 = clock1;
     clock1=currentEvent1.time;    
       if (currentEvent1.type.equals("ARV1")){
         events1.put(exp.RandomVariable(lambda), "ARV1"); 
         
             EN1 = EN1 + (N1* (clock1 - prevclock1));
            
           
            N1++;
           
       
     
         
         if (N1==1){
                   
                   events1.put(clock1+exp.RandomVariable(mew1*r11), "DEP11");
                   events1.put(clock1+exp.RandomVariable(mew1*r13), "DEP13");
                   
               
      }  
       
        
     
     } 
       if (currentEvent1.type.equals("ARV2")){
         events1.put(exp.RandomVariable(lambda), "ARV2"); 
         
             EN2 = EN2 + (N2* (clock1 - prevclock1));
            
           
            N2++;
            //System.out.println(N1);
            //events1.put(exp.RandomVariable(lambda), "ARV"); 
       
     
         
         if (N2==1){
                   
                   events1.put(clock1+exp.RandomVariable(mew1), "DEP2");
                   
               
      }  
       
        
     
     }
        if (currentEvent1.type.equals("DEP11")){
                   
                  EN1 += N1*(clock1-prevclock1); 
                  N1--;
                  NDep1++;
                  //double time = currentEvent1.time;
                  
                 
                      
                  EN1 += N1*(clock1-prevclock1);
                   N1++;
      
                   
                   
                   
                  if (N1>0){
                  
                  //double newdepart= exp.RandomVariable(clock1+mew1);
                  events1.put(clock1+exp.RandomVariable(mew1*r11),"DEP11");
                  
       
                  
                  }
      
        
    }
         if (currentEvent1.type.equals("DEP13")){
                   
                  EN1 += N1*(clock1-prevclock1); 
                  N1--;
                  NDep1++;
                  EN3 += N3*(clock1-prevclock1); 
                  N3++;
                  
                  
                  //double time = currentEvent1.time;
                  
                  
                       //events1.put(clock1+time, "ARV");
                   
      
                   
                   
                   
                  if (N1>0){
                  
                  //double newdepart= exp.RandomVariable(clock1+mew1);
                  events1.put(clock1+exp.RandomVariable(mew1*r11),"DEP2");
                  
       
                  
                  }
      
        
    }
        if (currentEvent1.type.equals("DEP23")){
                   
                  EN2 += N2*(clock1-prevclock1); 
                  N2--;
                  NDep2++;
                  //double time = currentEvent1.time;
                  
                  if (uniformgen()<=r32){
                       //events1.put(clock1+time, "ARV");
                      EN2 += N2*(clock1-prevclock1);
                      N2++;
      
                   
                   }
                   else{
                       //EN3 += N3*(clock1-prevclock1);
                       Dep3d++;
                        System.out.println("Dep3d"+ Dep3d);
      
                               }
                  if (N3>0){
                  
                  //double newdepart= exp.RandomVariable(clock1+mew1);
                  events1.put(clock1+exp.RandomVariable(mew3),"DEP3");
                  
       
                  
                  }
      
        
    }
        
        
        
        
      }
    System.out.println("Expected number of customers in the system: " + EN1 / clock1);
         System.out.println("Expected number of customers in the system: " + EN2 / clock1);
        System.out.println("Expected number of customers in the system: " + EN3 / clock1);
     
      }
     
     public EventList1 returnEvent(TreeMap<Double, String> tmap) {
        EventList1 returnEvent = new EventList1();
        double key;
        String value;
        key = tmap.firstKey();
        value = tmap.get(key);
        returnEvent.type = value;
        returnEvent.time = key;
        tmap.remove(key);
        return returnEvent;
    }
     
     public double RandomVariable(Double lambda) {
         
         s0 = (k * s0) % m;
         double uniformgen= s0 / m;
         double exponvar = ((-1) / lambda) * (Math.log(uniformgen));
         return exponvar;
    }
         public double uniformgen(){
        Random rt = new Random();
    
    double a = rt.nextDouble();
    return a;
    }
      
          public static void main (String[]args){
 
 //EventDriven(double lambda )
 EVENTDRIVEN1 tt = new EVENTDRIVEN1();
 tt.EventDriven1(1.0);
}
    
}
