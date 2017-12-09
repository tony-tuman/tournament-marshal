package tmarshal.server.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TournamentMarshalConfig {
    HashMap<String, String> configProperties = new HashMap();
    public TournamentMarshalConfig(String configFileName) throws IOException {
        File file = new File(configFileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] property = line.split(",");
            if (property.length==2){
                configProperties.put(property[0], property[1]);
            } else {
                throw new IOException("Invalid config file format.");
            }
        }
        fileReader.close();
    }

    public String getProperty (String propertyName){
        return configProperties.get(propertyName);
    }

    public HashMap<String, String> getProperties (String propertyRegex) {
        HashMap<String, String> returnProperties = new HashMap();
        for (Map.Entry<String,String> entry : configProperties.entrySet()) {
            if (entry.getKey().matches(propertyRegex)) {
                returnProperties.put(entry.getKey(), entry.getValue());
            }
        }
        return returnProperties;
    }
}
