public class Camera {
    private String brand;
    private int megaPixels;
    private int displaySize;
    private boolean colored;
    private Lens lens;
    private int cameraCount;

    public int getCameraCount() {
        return cameraCount;
    }

    public void setCameraCount(int cameraCount) {
        this.cameraCount = cameraCount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMegaPixels() {
        return megaPixels;
    }

    public void setMegaPixels(int megaPixels) {
        this.megaPixels = megaPixels;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(int displaySize) {
        this.displaySize = displaySize;
    }

    public boolean isColored() {
        return colored;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }

    public Lens getLens() {
        return lens;
    }

    public void setLens(Lens lens) {
        this.lens = lens;
    }

    @Override
    public String toString() {
        return "Camera: \n" +
                "Brand= " + brand +
                ", Megapixels= " + megaPixels +
                ", Display Size= " + displaySize + " Inches" +
                ", Colored= " + colored +
                ", Lens= " + lens +
                ", Camera Count= " + cameraCount;
    }
}
