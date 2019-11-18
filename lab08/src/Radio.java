public class Radio implements VolumeChangeable {
    private static final int MAX_VOLUME = 200;
    private static final int MIN_VOLUME = 0;
    private int volume;

    @Override
    public void increaseVolume() {
        volume = ++volume > MAX_VOLUME ? MAX_VOLUME : volume;
    }

    @Override
    public void decreaseVolume() {
        volume = --volume < MIN_VOLUME ? MIN_VOLUME : volume;
    }


}
