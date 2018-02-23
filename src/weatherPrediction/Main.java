/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package weatherPrediction;

import neuralnetwork.BackwardPropagationTraining;
import neuralnetwork.FeedForwardTesting;
import trainingset.InputTrainingSets;

/**
 *
 * @author dejavu88
 */
public class Main {
    public static void main(String[] args) {
       mainFrame.main();  
       Normalize.main(); 
       InputTrainingSets in=new InputTrainingSets();
       BackwardPropagationTraining b=new BackwardPropagationTraining();
       in.setInput();
       in.setOutput();
       b.trainNeuralNetwork();
        //FeedForwardTesting fe=new FeedForwardTesting();
//        FeedForwardTesting.FeedForwardNeuralNetwork = new ;
       //in.normalize();
        
       
}   
}
