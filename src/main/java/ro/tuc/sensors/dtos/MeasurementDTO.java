package ro.tuc.sensors.dtos;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@ToString
public class MeasurementDTO {
    private final Timestamp timestamp;

    @SerializedName(value = "device_id")
    private final String deviceId;

    @SerializedName(value = "measurement_value")
    private final Double measurementValue;
}
