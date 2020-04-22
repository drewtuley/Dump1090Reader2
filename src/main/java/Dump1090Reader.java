import javax.json.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class Dump1090Reader {
    private Socket clientSocket;
    private BufferedReader in;


    public void startConnection(String host, int feedPort) throws IOException {
        this.clientSocket = new Socket(host, feedPort);
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }


    public static void main(String[] args) {
        Dump1090Reader client = new Dump1090Reader();
        try {
            client.startConnection("elref.co.uk", 30003);
            JsonObject message;
            while ((message = client.getNextJson()) != null) {
                System.out.println(message.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private JsonObject convertToJson(List<String> fields) {
        //System.out.println(fields);
        JsonObject json = MsgType.buildJson(fields);

        return json;
    }

    private List<String> parseInput(String inputLine) {
        return Arrays.asList(inputLine.split(","));
    }


    public JsonObject getNextJson() throws IOException {
        String in_data = this.in.readLine();
        if (in_data != null) {
            return this.convertToJson(parseInput(in_data));
        }
        return null;
    }
}

