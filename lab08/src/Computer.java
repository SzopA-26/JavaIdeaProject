class Computer implements VolumeChangeable, NetworkInterface {
    private static final int MAX_VOLUME = 100;
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

    @Override
    public void connect(Network network) {
        System.out.println("Connected");
    }

    @Override
    public void disconnect(Network network) {
        System.out.println("Disconnected");
    }

}
