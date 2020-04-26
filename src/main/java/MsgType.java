import com.google.common.collect.ImmutableList;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.List;



// MSG,3,1,1,68BD6E,1,2020/04/20,09:11:27.498,2020/04/20,09:11:27.540,,21325,,,,,,,0,,0,
//    4: 'txdr_code',
//    10: 'callsign',
//    11: 'altitude',
//    12: 'ground_speed',
//    13: 'track',
//    14: 'latitude',
//    15: 'longitude',
//    16: 'vspeed',
//    17: 'squawk'
public class MsgType {
    private static final List<MsgField> MSG_FIELDS = ImmutableList.of(new MsgString("ModeS", 4),
            new MsgString("eventDate", 6),
            new MsgString("eventTime", 7),
            new MsgString("callsign", 10),
            new MsgBigInteger("altitude", 11),
            new MsgBigInteger("groundspeed", 12),
            new MsgBigInteger("track", 13),
            new MsgDouble("latitude", 14),
            new MsgDouble("longitude", 15),
            new MsgBigInteger("vspeed", 16),
            new MsgString("squawk", 17));


    private MsgType() {
    }


    public static JsonObject buildJson(List<String> fields) {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObjectBuilder builder = factory.createObjectBuilder();

        MSG_FIELDS.forEach(fld -> {
                    int idx = fld.getIndex();
                    if (idx < fields.size()) {
                        String value = fields.get(idx);
                        if (!value.isBlank()) {
                            String name = fld.getName();
                            builder.add(name, value);
                        }
                    }
                }
        );

        return builder.build();
    }

}
