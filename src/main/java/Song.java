import java.io.Serializable;

public class Song extends Broadcasting implements Recording, Serializable {
    String minutesRecordingTime;
    String nameSinger;
    String songsTitle;


    public Song(String minutesRecordingTime, String nameSinger, String songsTitle) {
        this.minutesRecordingTime = minutesRecordingTime;
        this.nameSinger = nameSinger;
        this.songsTitle = songsTitle;
    }

    public void add(Recording record){

        Song rec = (Song) record;
        if(this.checkRec(rec)) {
            DataBroadcasting.PlayList.add(rec);
            int time = Integer.parseInt(rec.minutesRecordingTime) * 60 * 1000;
            DataBroadcasting.playListTimeMillisecond += time;
            System.out.println("Пісня в плейлисті.");
        }
    }
    public boolean check(Recording record) {
        Song songRec = (Song) record;
        int timeRecordMillisecond = Integer.parseInt(songRec.minutesRecordingTime) * 60 * 1000;
        return timeRecordMillisecond <= DataBroadcasting.broadcastingTimeMillisecond &&
                DataBroadcasting.playListTimeMillisecond + timeRecordMillisecond <= DataBroadcasting.broadcastingTimeMillisecond;
    }
    public void play(Recording record) {
        Song songRec = (Song) record;
        System.out.printf ("Пісня: довжиною %s хвилин, назва пісні \"%s\", виконавець %s.\n",
                songRec.minutesRecordingTime,
                songRec.songsTitle,
                songRec.nameSinger);
    }
}