/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherPrediction;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.sqrt;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dejavu88
 */
public class  Normalize{
    /**
     * @param args the command line arguments
     */
     public static double[][] numArray;
     public static double[][]traininput;
     public static double[]trainoutput;
     int row=0;
    public void setAray(){
        // TODO code application logic heretry {
                String filename="D:\\doc\\NetBeansProjects\\WeatherPrediction\\src\\docs\\ktm_009.csv";
                File file=new File(filename);
                Scanner inputStream = null;
                numArray = new double [365][5];
               
        try {
            inputStream = new Scanner(file);
                    int i = 0;
                inputStream.next();
                while(inputStream.hasNext()){
                    String data=inputStream.next();
                    String[] values=data.split(",");
                    for(i=0;i<values.length;i++){
                    numArray[row][i]=Double.parseDouble(values[i]);
                   // System.out.println("****************");
                    System.out.println("mat"+"["+row+"]"+"["+i+"]"+numArray[row][i]);
                    
                    }
                    row++;
            }
                
                
         
                inputStream.close();
               
            }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Normalize.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    public void normalizeInputs(double[][] inputarray){
        int rown,colm=5,i;
        double[] min,max;
        min = new double[5];
        max=new double [5];
//         double[] sum=new double[5];
//         double[] sd = new double [5];
//         double[] mean=new double[5];
//       // calculate mean
//        for(i=0;i<colm;i++){
//            for(rown=0;rown<364;rown++){
//                sum[i]+=inputarray[rown][i];
//            }
//            mean[i]=sum[i]/365;
//            System.out.println("mean="+"["+i+"]"+"="+mean[i]);
//        }
//        //calculate sd
//        for(i=0;i<colm;i++){
//            double x = 0;
//            for(rown=0;rown<364;rown++){
//                
//                x=inputarray[rown][i]-mean[i];
//                
//            }
//           sd[i]=sqrt(x*x/365);
//            System.out.println("sd="+"["+i+"]"+"="+sd[i]);
//        }
        //find min and max
        System.out.println("**********normalized attribute**********");
        for(i=0;i<colm;i++){
            min[i]=inputarray[0][i];
            for(rown=0;rown<365;rown++){
                if(inputarray[rown][i]>max[i])
                max[i]=inputarray[rown][i];
               
                if(inputarray[rown][i]<min[i])
                min[i]=inputarray[rown][i]; 
              }
            System.out.println("max="+"["+i+"]"+max[i]);
            System.out.println("min="+"["+i+"]"+min[i]);
            
        }
        //normalize
         for(i=0;i<colm;i++){
           
            for(rown=0;rown<365;rown++){
               numArray[rown][i]=(numArray[rown][i]-min[i])/(max[i]-min[i]);
                //numArray[rown][i]=(numArray[rown][i]-mean[i])*sd[i];
            }
         }
        traininput=new double[365][4];
        trainoutput=new double[365];
        //initialize train inputs
        for(i=0;i<colm-1;i++){
           
            for(rown=0;rown<365;rown++){
               traininput[rown][i]=numArray[rown][i];
               System.out.println("traininputs"+"["+rown+"]"+"["+i+"]"+"="+traininput[rown][i]);
            }
         }
        //initialize train outputs
        
           
                for(rown=0;rown<365;rown++){
                trainoutput[rown]=numArray[rown][4];
      
                System.out.println("trainoutputs"+"["+rown+"]"+"="+trainoutput[rown]);
            }
                
         }
      
        
     
            
          
        
    
    public static void main() {
        Normalize jav=new Normalize();
        jav.setAray();
        jav.normalizeInputs(numArray);
        
    }
}
    

