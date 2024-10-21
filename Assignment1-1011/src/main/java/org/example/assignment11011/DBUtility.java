package org.example.assignment11011;

import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DBUtility {

    private static String user="sql5736387";
    private static String password="hlTX4D4fnl";
    private static String url="jdbc:mysql://sql5.freesqldatabase.com:3306/sql5736387";

    public static ArrayList<CpuBenchmark> getAllCpuBenchmark(String... sqls) throws SQLException {

        ArrayList<CpuBenchmark> cpuBenchmarks = new ArrayList<>();
        String sql = "select * from cpubenchmark2024";

        if(sqls.length>0) sql=sqls[0];

        try(Connection conn= DriverManager.getConnection(url,user,password);
            Statement stmt=conn.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);) {

            while (resultSet.next()) {
                String cpuName = resultSet.getString("name");
                double cpuPrice = resultSet.getDouble("price");
                int cpuFps = resultSet.getInt("fps");
                String cpuResolution = resultSet.getString("resolution");

                CpuBenchmark cpuBenchmark = new CpuBenchmark(cpuName, cpuPrice, cpuFps, cpuResolution);
                cpuBenchmarks.add(cpuBenchmark);

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return cpuBenchmarks;
    }

    public static ArrayList<GpuBenchmark> getAllGpuBenchmark(String... sqls) throws SQLException {

        ArrayList<GpuBenchmark> gpuBenchmarks = new ArrayList<>();
        String sql2 = "select * from gpus";

        if(sqls.length>0) sql2=sqls[0];

        try(Connection conn= DriverManager.getConnection(url,user,password);
            Statement stmt=conn.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql2);) {

            while (resultSet.next()) {
                String gpuName = resultSet.getString("gpuName");
                double gpuPrice = resultSet.getDouble("gpuPrice");
                int G3D_Mark = resultSet.getInt("G3D_mark");

                GpuBenchmark gpuBenchmark = new GpuBenchmark(gpuName,gpuPrice,G3D_Mark);
                gpuBenchmarks.add(gpuBenchmark);

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return gpuBenchmarks;
    }

    public static ArrayList<CoolerBenchmark> getAllCoolerBenchmark(String... sqls) throws SQLException {

        ArrayList<CoolerBenchmark> coolerBenchmarks = new ArrayList<>();
        String sql3 = "select * from cooler";

        if(sqls.length>0) sql3=sqls[0];

        try(Connection conn= DriverManager.getConnection(url,user,password);
            Statement stmt=conn.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql3);) {

            while (resultSet.next()) {
                String coolerName = resultSet.getString("coolerName");
                int rpm = resultSet.getInt("rpm");
                double cpuLoad = resultSet.getDouble("cpu_load");

                CoolerBenchmark coolerBenchmark = new CoolerBenchmark(coolerName,rpm,cpuLoad);
                coolerBenchmarks.add(coolerBenchmark);

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return coolerBenchmarks;
    }


    // Bar Graphs
    public static XYChart.Series<String, Double> getTopCpus() {
        XYChart.Series<String, Double> topCpuSeries = new XYChart.Series<>();
        topCpuSeries.setName("FPS vs Price");

        try{
            ArrayList<CpuBenchmark> topCpus = getAllCpuBenchmark("select *,  (fps / price) AS performance_score FROM sql5736387.cpubenchmark2024 ORDER BY \n" +
                    "    performance_score DESC LIMIT 10;");

            for (CpuBenchmark cpuBenchmark : topCpus){
                topCpuSeries.getData().add(new XYChart.Data<>(cpuBenchmark.getName(), cpuBenchmark.getPrice()));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return topCpuSeries;
    }

    public static XYChart.Series<String, Double> getTopGpus() {
        XYChart.Series<String, Double> topGpuSeries = new XYChart.Series<>();
        topGpuSeries.setName("G3D Mark vs GPU Price");

        try{
            ArrayList<GpuBenchmark> topGpus = getAllGpuBenchmark("select *,  (G3D_mark / gpuPrice) AS price_performance FROM sql5736387.gpus ORDER BY \n" +
                    "    price_performance DESC LIMIT 10; ");

            for (GpuBenchmark gpuBenchmark : topGpus){
                topGpuSeries.getData().add(new XYChart.Data<>(gpuBenchmark.getName(), gpuBenchmark.getPrice()));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return topGpuSeries;
    }

    public static XYChart.Series<String, Integer> getTopCoolers() {
        XYChart.Series<String, Integer> topCoolerSeries = new XYChart.Series<>();
        topCoolerSeries.setName("CPU Load");

        try{
            ArrayList<CoolerBenchmark> topCoolers = getAllCoolerBenchmark("SELECT * FROM cooler ORDER BY cpu_load ASC LIMIT 10;\n ");

            for (CoolerBenchmark coolerBenchmark : topCoolers){
                topCoolerSeries.getData().add(new XYChart.Data<>(coolerBenchmark.getName(), coolerBenchmark.getRpm()));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return topCoolerSeries;
    }







}
