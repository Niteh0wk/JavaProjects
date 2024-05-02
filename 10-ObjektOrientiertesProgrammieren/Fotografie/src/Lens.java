public class Lens {

    static int min = 2;
    static int max = 500;
    static int lensCount = 0;
    private int focalLength;

    public static int getLensCount() {
        return lensCount;
    }

    public static void setLensCount(int lensCount) {
        Lens.lensCount = lensCount;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        if (focalLength >= min){
            this.focalLength = focalLength;
            lensCount++;
        }
    }

    @Override
    public String toString() {
        return focalLength + "mm" + ", Lens Count= " + lensCount;
    }
}
