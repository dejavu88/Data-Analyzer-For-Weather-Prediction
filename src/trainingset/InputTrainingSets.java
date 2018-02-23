package trainingset;


import weatherPrediction.Normalize;

public class InputTrainingSets {
     public static double[][] input_feature;
     public static double[] expected_output;
   
          public void setInput(){
          input_feature= new double[365][4];
         
          for(int i=0;i<3;i++){
           
            for(int rown=0;rown<365;rown++){
               input_feature[rown][i]=Normalize.traininput[rown][i];
                System.out.println("["+rown+i+"]"+input_feature[rown][i]);
            }
         }
        }
        public void setOutput(){
            expected_output=new double[365];
      
            for(int rown=0;rown<365;rown++){
               expected_output[rown]=Normalize.trainoutput[rown];
                System.out.println("["+rown+"]"+expected_output[rown]);
               
            }
            
        
        }
	
	public static double[][] hidden_layer_weight={
					{0.1,-0.2,0.3,-0.1},
					{0.1,-0.2,0.3,-0.1},
					{0.1,-0.2,0.3,-0.1},
					{0.1,-0.2,0.3,-0.1}};
	
	public static double[] output_weight={0.1,0.2,0.3,0.4};
	

    
}