/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

/**
 *
 * @author Pilat
 */
public class Word {

    private String wordText;
    private long left;
    private long top;
    private long height;
    private long width;

    @Override
    public String toString() {
        return "Word{" + "wordText=" + wordText + ", left=" + left + ", top=" + top + ", height=" + height + ", width=" + width + '}';
    }

    public Word(String wordText, long left, long top, long height, long width) {
        this.wordText = wordText;
        this.left = left;
        this.top = top;
        this.height = height;
        this.width = width;
    }
    
    public Word(){
        
    }

    /**
     * @return the wordText
     */
    public String getWordText() {
        return wordText;
    }

    /**
     * @param wordText the wordText to set
     */
    public void setWordText(String wordText) {
        this.wordText = wordText;
    }

    /**
     * @return the left
     */
    public long getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(long left) {
        this.left = left;
    }

    /**
     * @return the top
     */
    public long getTop() {
        return top;
    }

    /**
     * @param top the top to set
     */
    public void setTop(long top) {
        this.top = top;
    }

    /**
     * @return the height
     */
    public long getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(long height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public long getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(long width) {
        this.width = width;
    }    
}
