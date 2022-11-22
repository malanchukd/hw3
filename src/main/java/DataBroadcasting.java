import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataBroadcasting implements Serializable {
    protected static long broadcastingTimeMillisecond;
    protected static long playListTimeMillisecond;
    protected static long painingContentTimeMillisecond;
    public static double income;
    protected static ArrayList<Recording> PlayList = new ArrayList<>();

    private static RadioHost radioHost;
    private ArrayList<Recording> broadcastingPlayList = new ArrayList<>();
    private RadioHost broadcastingRadioHost;

    static public void setDuration(int minutes) {
        DataBroadcasting.broadcastingTimeMillisecond = (long) minutes * 60 * 1000;
    }

    public static void setRadioHost(RadioHost radioHost) {
        DataBroadcasting.radioHost = radioHost;
    }

        public static void save() {
            DataBroadcasting data = new DataBroadcasting();
            data.broadcastingPlayList = DataBroadcasting.PlayList;
            data.broadcastingRadioHost = DataBroadcasting.radioHost;
            try (ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(Paths.get("data.dat")))) {
                stream.writeObject(data);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void load() {
            DataBroadcasting data;
            try (ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(Paths.get("data.dat")))) {
                data = (DataBroadcasting) stream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
             DataBroadcasting.PlayList = data.broadcastingPlayList;
             DataBroadcasting.radioHost = data.broadcastingRadioHost;
        }
    }

