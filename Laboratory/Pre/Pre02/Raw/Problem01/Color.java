public class Color {
    private int red;
    private int green;
    private int blue;

    /**
     * Konstruktor Color
     * 
     * @param r nilai red (0-255)
     * @param g nilai green (0-255)
     * @param b nilai blue (0-255)
     */
    public Color(int r, int g, int b) {
        // TODO: Print constructor message with format
        // "Color is being built with RGB(r, g, b)"
        // Example: if r=255, g=0, b=0, print "Color is being built with RGB(255, 0, 0)"
        
        // TODO: Initialize the red, green, and blue instance variables with the
        // parameter values
    }

    @Override
    /**
     * toString
     * 
     * fungsi ini berguna untuk mengembalikan representasi string dari objek Color
     * usage: 
     * System.out.println(colorObject);
     * 
     * pada umumnya, ketika sebuah objek dicetak menggunakan System.out.println atau
     * metode lainnya, metode toString() akan dipanggil secara otomatis untuk
     * mendapatkan representasi string dari objek tersebut.
     * 
     * @return string representasi warna dalam format "RGB(red, green, blue)"
     */
    public String toString() {
        // TODO: Return a string in the format "RGB(red, green, blue)"
        // Example: if red=255, green=128, blue=64, return "RGB(255, 128, 64)"
        return null;
    }

    /**
     * getRed
     * 
     * @return nilai red
     */
    public int getRed() {
        // TODO: Return the red component value
    }

    /**
     * getGreen
     * 
     * @return nilai green
     */
    public int getGreen() {
        // TODO: Return the green component value
    }

    /**
     * getBlue
     * 
     * @return nilai blue
     */
    public int getBlue() {
        // TODO: Return the blue component value
    }

    /**
     * setColor
     * Mengubah nilai warna
     * 
     * @param r nilai red (0-255)
     * @param g nilai green (0-255)
     * @param b nilai blue (0-255)
     */
    public void setColor(int r, int g, int b) {
        // TODO: Set the red, green, and blue instance variables to the parameter values
    }
}
