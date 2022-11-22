public class Main {
    public static void main(String[] args) {
        Broadcasting translation = new Broadcasting();
        Recording one = new Song("30", "Alan Walker", "Alone");
        Recording two = new Interview("10", "Dima");
        Recording free = new Advertising("10", "Nivea");
        Recording four = new Advertising("10", "Nissan");
        Recording five = new Advertising("10", "Iphone");
        translation.setRadioHost("Василь", 5);
        translation.setDuration(120);
        translation.checkRec(one);
        translation.checkRec(two);
        translation.checkRec(free);
        translation.checkRec(four);
        translation.checkRec(five);
        translation.addRec(one);
        translation.addRec(two);
        translation.addRec(free);
        translation.addRec(four);
        translation.addRec(five);
        translation.playList();
        translation.income();
        translation.save();
        translation.load();
        translation.playList();

    }
}
