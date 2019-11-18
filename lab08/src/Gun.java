class Gun extends Weapon {
    private int numAmmo;
    private double accuracy;

    public Gun() {
        super(0, 0);
    }

    public Gun(int dmg, int dur, int ammo, double acc) {
        super(dmg, dur);
        numAmmo = ammo;
        accuracy = acc;
    }
    @Override
    public void use() {
        super.use();
        if (--numAmmo < 0) numAmmo = 0;
    }

}
