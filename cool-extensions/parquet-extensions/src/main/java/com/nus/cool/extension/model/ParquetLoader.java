package com.nus.cool.extension.model;

import com.nus.cool.core.util.config.DataLoaderConfig;
import com.nus.cool.extension.util.config.ParquetDataLoaderConfig;
import com.nus.cool.model.CoolLoader;

import java.io.IOException;

public class ParquetLoader {
    /**
     * Please list the necessary dataset files for the COOL system to load into a new cube.
     * @param args there are five arguments. List in input order
     *  (1) output cube name: to be specified when loading from the repository
     *  (2) table.yaml (3) dimension.csv (4) data.parquet (5) output cube repository
     */
    public static void main(String[] args) {
        String cube = args[0];
        String schemaFileName = args[1];
        String dimensionFileName = args[2];
        String dataFileName = args[3];
        String cubeRepo = args[4];

        try {
            DataLoaderConfig config = new ParquetDataLoaderConfig();
            CoolLoader coolLoader = new CoolLoader(config);
            coolLoader.load(cube,schemaFileName,dimensionFileName,dataFileName,cubeRepo);
        } catch (IOException e){
            System.out.println("Failed to load data");
            System.out.println(e);
        }
        System.out.println("Cube " + cube + " is loaded successfully from the Parquet format data.");
    }
}
