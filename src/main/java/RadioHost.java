import java.io.Serializable;

class RadioHost implements Serializable {
    private final String nameRadioHost;
    private String resume;
    private int experience;

    public RadioHost(String nameRadioHost, String resume) {
        this.nameRadioHost = nameRadioHost;
        this.resume = resume;
    }
    public RadioHost(String nameRadioHost, int experience) {
        this.nameRadioHost = nameRadioHost;
        this.experience = experience;
    }

    public String getNameRadioHost() {
        return nameRadioHost;
    }

    public String getResume() {
        return resume;
    }

    public int getExperience() {
        return experience;
    }
}

