package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import config.common.Constantes;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;


import java.io.FileInputStream;
import java.io.IOException;

    @Log4j2
    @Getter
    public class Configuration {

        private static Configuration configuration;
        private String pathJSONCoches;

        private Configuration() {
        }

        public static synchronized Configuration getInstance() {
            if (configuration == null) {
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                mapper.findAndRegisterModules();
                try (FileInputStream fileInputStream = new FileInputStream(Constantes.CONFIG_CONFIG_YAML)) {
                    configuration = mapper.readValue(fileInputStream, Configuration.class);
                } catch (IOException e) {
                    log.error(e.getMessage(),e);
                }
            }
            return configuration;
        }

    }

