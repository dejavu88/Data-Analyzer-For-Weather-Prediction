package neuralnetwork;

public class FeedForwardTesting {

public double[] ihl;

/*



*wh is weight at hidden layer
*wo=weight at output layer
*/
public class FeedForwardNeuralNetwork{

public int no_of_neuron=4;
public int no_of_input_index=4;
double [] inp;
//double[] w; 
double[] ohl;
double ool;
double iol;
double[][] weight_at_hidden_layer;
double[] weight_at_ouput_layer;
private double[] weight_at_output_layer;
private double[] input;
   public double testNeralNetwork(double[] inputFeature, double[][]  weight_at_hidden_layer, double[] weight_at_ouput_layer) {
       this.input=inputFeature;
       this.weight_at_hidden_layer=weight_at_hidden_layer;
       this.weight_at_output_layer=weight_at_ouput_layer;
       for(double w:weight_at_ouput_layer){
       System.out.println(w);
       }
          calculateHiddenLayerOutput();
          calculateOutputlayerOutput();  
           
          return ool;
          }

public void calculateHiddenLayerOutput(){
inp=new double[no_of_neuron];
ihl=new double[no_of_neuron];
double[] f=new double[no_of_neuron];
for(int i=1;i<=no_of_neuron;i++)
{
	ihl[i]=0;
	f[i]=0;
	for(int j=1;j<=no_of_input_index;j++){
		ihl[i]=ihl[i]+weight_at_hidden_layer[i][j]*inp[j];
	}
	f[i]=1/(1+Math.exp(-ihl[i]));
}
}
private void calculateOutputlayerOutput(){
/*
*input to output layer is f[i] output from each hidden neuron ie her x vaneko f[i] vo
*/
double ff=0.0;
for(int i=1; i<=no_of_neuron;i++){
	iol=iol+weight_at_ouput_layer[i]*ohl[i];
	}
ff=1/(1+Math.exp(-iol));
 System.out.println("output_of_output_layer"+ff);
}

}


}
