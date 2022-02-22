package com.jiajia.builder;

/**
 * 默写一个建造者模式
 * 参考：https://blog.csdn.net/ShuSheng0007/article/details/86619675
 */
public class Computer {

    /**
     * 必须包含的参数
     */
    private String brand;
    private String cpu;

    /**
     * 可选参数
     */
    private int usbCount;
    private boolean hasKeyboard;
    private String display;

    private Computer(Builder builder) {
        this.brand = builder.brand;
        this.cpu = builder.cpu;
        this.usbCount = builder.usbCount;
        this.hasKeyboard = builder.hasKeyboard;
        this.display = builder.display;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", cpu='" + cpu + '\'' +
                ", usbCount=" + usbCount +
                ", hasKeyboard=" + hasKeyboard +
                ", display='" + display + '\'' +
                '}';
    }

    public static class Builder {
        private String brand;
        private String cpu;
        private int usbCount;
        private boolean hasKeyboard;
        private String display;

        public Builder(String brand, String cpu) { // 必选参数的构造方法
            this.brand = brand;
            this.cpu = cpu;
        }

        public Builder setUsbCount(int count) {
            this.usbCount = count;
            return this;
        }

        public Builder setHasKeyboard(boolean hasKeyboard) {
            this.hasKeyboard = hasKeyboard;
            return this;
        }

        public Builder setDisplay(String display) {
            this.display = display;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
