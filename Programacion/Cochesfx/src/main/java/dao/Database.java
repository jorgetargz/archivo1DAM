package dao;

import com.google.gson.*;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import config.Configuration;
import domain.modelo.Coche;
import lombok.extern.log4j.Log4j2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Log4j2
public class Database {
    private final Gson gson;
    private final Configuration configuracion;

    public Database() {

        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                                LocalDateTime.parse(json.getAsJsonPrimitive().getAsString()))
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonSerializer<LocalDateTime>) (localDateTime, type, jsonSerializationContext) ->
                                new JsonPrimitive(localDateTime.toString()))
                .registerTypeAdapter(LocalDate.class,
                        (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) ->
                                LocalDate.parse(json.getAsJsonPrimitive().getAsString()))
                .registerTypeAdapter(LocalDate.class,
                        (JsonSerializer<LocalDate>) (localDateTime, type, jsonSerializationContext) ->
                                new JsonPrimitive(localDateTime.toString()))
                .create();

        this.configuracion = Configuration.getInstance();

    }

    public List<Coche> readJSONCoches() {

        Type userMapType = new TypeToken<List<Coche>>() {
        }.getType();

        try (FileReader fileReader = new FileReader(configuracion.getPathJSONCoches())) {
            return gson.fromJson(fileReader, userMapType);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public boolean writeJSONCoches(List<Coche> inventario) {

        try (FileWriter fileWriter = new FileWriter(configuracion.getPathJSONCoches())) {
            gson.toJson(inventario, fileWriter);
            return true;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}
