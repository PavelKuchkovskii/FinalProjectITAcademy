package org.kucher.itacademyfitness.app.audit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.kucher.itacademyfitness.app.audit.dto.AuditDTO;
import org.kucher.itacademyfitness.app.config.util.mapper.deserializer.LocalDateTimeDeserializer;
import org.kucher.itacademyfitness.app.config.util.mapper.serializer.LocalDateTimeSerializer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

@Service
public class AuditService {

    private static final String URI = "http://localhost:8080/api/v1/audit";

    private final ObjectMapper mapper;

    public AuditService() {
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        mapper.registerModule(module);
    }

    public void createAudit(AuditDTO dto) {

        try {
            String body = mapper.writeValueAsString(dto);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(URI))
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .headers("Content-Type", "application/json;charset=UTF-8")
                    .build();

            HttpClient client = HttpClient.newBuilder().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }


    }
}
