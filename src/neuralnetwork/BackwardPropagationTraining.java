package neuralnetwork;

import trainingset.InputTrainingSets;

public class BackwardPropagationTraining {
	
	    public int no_of_hidden_neuron = 4;
	    public int no_of_pattern = 365;
	    public int no_of_input_index = 4;
	    public double[] input_to_hidden_layer;
	    public double input_to_output_layer;
	    public double[] output_of_hidden_layer;
	    public double output_of_output_layer;
	    public double[] error = new double[no_of_pattern];;
	    public static double total_error = 0.0;
	    public double LEARNING_RATE = 0.1;
	    int total_iteration = 50;
	    double[] input_of_hidden_neuron = new double[no_of_hidden_neuron];
	    static double[][] weight_at_hidden_layerr;
	    static double[] weight_at_output_layerr=null;
	    double[][] inputFeature=null;
	    double[] target_output=null;
	  
	  public boolean trainNeuralNetwork(){
	        BackwardPropagationTraining.weight_at_hidden_layerr=InputTrainingSets.hidden_layer_weight;
	        BackwardPropagationTraining.weight_at_output_layerr=InputTrainingSets.output_weight;
	        this.inputFeature=InputTrainingSets.input_feature;
	        this.target_output=InputTrainingSets.expected_output;
	             System.out.println("************training************");
	        for (int p = 0; p < no_of_pattern; p++) {
	        
	            calculateHiddenLayerOutPut(p);
	            calculateOutputLayerOutPut(p);
	            
	            doBackpropagation(p);

	        }

	        total_error = calculateTotalError();

	        while (total_error >= 0.5) {
	            total_iteration++;
	            for (int p = 0; p < no_of_pattern; p++) {

	                calculateHiddenLayerOutPut(p);
	                calculateOutputLayerOutPut(p);
	                doBackpropagation(p);

	            }
	            total_error = calculateTotalError();
	            System.out.println(total_error);
	            
	        }
	        if(total_error <= 0.000001){
	        	System.out.println("total epoch = "+total_iteration);
	        	 return true;
	        }
	        //adjust weight
	     
	        
	  return false;
	  }
	   

	    private void calculateHiddenLayerOutPut( int p) {

	        input_to_hidden_layer = new double[no_of_hidden_neuron];
	        output_of_hidden_layer = new double[no_of_hidden_neuron];
	        // hidden layer loop starting
	        for (int h = 0; h < no_of_hidden_neuron; h++) {
	            input_to_hidden_layer[h] = 0;
	            // input index loop
	            for (int in = 0; in < no_of_input_index; in++) {
	                input_to_hidden_layer[h] = input_to_hidden_layer[h]
	                        + weight_at_hidden_layerr[in][h] * inputFeature[p][in];

	            }
	            output_of_hidden_layer[h] = 1 / (1 + Math
	                    .exp(-input_to_hidden_layer[h]));

	        }
			// input_to_hidden_layer = null;

	    }

	    private void calculateOutputLayerOutPut(int p) {

	        input_to_output_layer = 0.0;

	        for (int h = 0; h < no_of_hidden_neuron; h++) {

	            input_to_output_layer = input_to_output_layer
	                    + weight_at_output_layerr[h] * output_of_hidden_layer[h];

	        }

	        output_of_output_layer = 1 / (1 + Math.exp(-input_to_output_layer));
	        System.out.println("output="+output_of_output_layer);

	        error[p] = target_output[p] - output_of_output_layer;
                System.out.println("error="+error[p]);
	       

	    }

	    private void doBackpropagation(int p) {

	        // hidden layer loop starting
	        for (int h = 0; h < no_of_hidden_neuron; h++) {
	            // adjusting weight at output layer
	            double temp_weight = LEARNING_RATE * error[p]
	                    * output_of_hidden_layer[h] * output_of_output_layer
	                    * (1 - output_of_output_layer);
	            weight_at_output_layerr[h] = weight_at_output_layerr[h] + temp_weight;

	        }
	        // hidden layer loop starting
	        for (int h = 0; h < no_of_hidden_neuron; h++) {
	            // input index loop
	            for (int in = 0; in < no_of_input_index; in++) {
	                double temp_weight = LEARNING_RATE * error[p] * inputFeature[p][in]
	                        * output_of_hidden_layer[h]
	                        * (1 - output_of_hidden_layer[h]);
	                weight_at_hidden_layerr[in][h] = weight_at_hidden_layerr[in][h]
	                        + temp_weight;
                        System.out.println("wt at hidden layer"+weight_at_hidden_layerr);

	            }

	        }

	    }

	    private double calculateTotalError() {
	       double temp_total_error = 0.0;
			for (int i = 0; i < error.length; i++) {
				temp_total_error = temp_total_error + error[i] * error[i] * 0.5;
			}

			
			return temp_total_error;
	    }

	}

