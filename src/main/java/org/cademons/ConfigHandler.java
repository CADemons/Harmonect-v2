package org.cademons;

import java.io.*;
import java.util.HashMap;

public class ConfigHandler {

    private String configFilePath = "src/config.txt";

    public void ConfigHandler() {};
    public void ConfigHandler(String configFilePath) {this.configFilePath = configFilePath;}

    public void setConfigFilePath(String configFilePath) {this.configFilePath = configFilePath;}

    public HashMap<String, String> loadConfig() {
        HashMap<String, String> config = new HashMap<String, String>();
        String line;
        boolean comment = false;
        try {
            File configfile = new File("configFilePath");
            FileReader fileReader = new FileReader(configfile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) !=null) {
                if(line.equals("/*")) {comment = true;}
                else if(line.equals("/*")) {comment = true;}
                else if(comment == false && line.length() > 4) {
                    if(line.contains("Instrument")) {config.put("instrument", line.split(":")[1]);}
                    else if(line.contains("")) {config.put("key", line.split(":")[1]);}
                }
            }
            //Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {ex.printStackTrace();}
        catch(IOException ex) {ex.printStackTrace();}
        return config;
    }
}
