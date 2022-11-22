import java.io.Serializable;

public class Interview extends Broadcasting implements Recording, Serializable {

    String minutesRecordingTime;
    String nameInterviewee;


    public Interview(String minutesRecordingTime, String nameInterviewee) {
        this.minutesRecordingTime = minutesRecordingTime;
        this.nameInterviewee = nameInterviewee;
    }

    public void add(Recording record){

        Interview interviewRec = (Interview) record;
        if(this.checkRec(interviewRec)) {
            final double interviewPrice = 30.0 / 60 / 1000.0;
            DataBroadcasting.PlayList.add(interviewRec);
            int time = Integer.parseInt(interviewRec.minutesRecordingTime) * 60 * 1000;
            DataBroadcasting.playListTimeMillisecond += time;
            DataBroadcasting.income += interviewPrice * time;
            DataBroadcasting.painingContentTimeMillisecond += time;
            System.out.println("Інтервю заплановано.");
        }
    }
    public boolean check(Recording record) {


        Interview interviewRec = (Interview) record;
        int timeRecordMillisecond = Integer.parseInt(interviewRec.minutesRecordingTime) * 60 * 1000;

        return timeRecordMillisecond < DataBroadcasting.broadcastingTimeMillisecond &&
                        timeRecordMillisecond + DataBroadcasting.painingContentTimeMillisecond < DataBroadcasting.broadcastingTimeMillisecond / 2 &&
                        DataBroadcasting.playListTimeMillisecond + timeRecordMillisecond < DataBroadcasting.broadcastingTimeMillisecond;
    }
    public void play(Recording record) {
        Interview interviewRec = (Interview) record;
        System.out.printf ("Інтервю: довжиною %s хвилин, імя людини в якої беруть інтервю %s.\n",
                interviewRec.minutesRecordingTime,
                interviewRec.nameInterviewee);
    }
}