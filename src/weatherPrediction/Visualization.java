/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// class for visualization 
package weatherPrediction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;




/**
 *
 * @author dejavu88
 */
public class Visualization {
    public void visualize(){
            mainFrame f=new mainFrame();
            String x="date",y=mainFrame.var1;
            String query="SELECT"+"`"+x+"`"+","+"`"+y+"`"+ "FROM `weather`";
        
            try {
                //dBConnect con =new dBConnect();
                 JDBCCategoryDataset data=new JDBCCategoryDataset((Connection) dBConnect.connect(),query);
                 JFreeChart chart= ChartFactory.createLineChart(y+" "+"graph","date",y,data);
                 BarRenderer renderer =null;
                 CategoryPlot plot=null;
                 renderer=new BarRenderer();
                 ChartFrame frame=new ChartFrame("Graph",chart);
                 frame.setVisible(true);
                 frame.setSize(500,650 );
                 
            } catch (SQLException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
           
    }

}
    
   

