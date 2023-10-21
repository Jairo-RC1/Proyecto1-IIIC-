/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class FlowChart {

    public static JFreeChart createFlowChart(List<FlowWithWaterSpring> flows) {
        CategoryDataset dataset = createDataset(flows);
        JFreeChart chart = ChartFactory.createBarChart(
                "Capacidad de Flujo por Naciente", // Título del gráfico
                "Naciente", // Etiqueta del eje X
                "Capacidad", // Etiqueta del eje Y
                dataset);                           // Datos

        return chart;
    }

    private static CategoryDataset createDataset(List<FlowWithWaterSpring> flows) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (FlowWithWaterSpring flow : flows) {
            dataset.addValue(Double.parseDouble(flow.getCapacity()), "Capacidad", flow.getWaterSpringName());
        }

        return dataset;
    }
}
