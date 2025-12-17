package edu.grinnell.csc207.soundsofsorting;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    private NoteIndices notes;
   
    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Integer[] arr = notes.getNotes();
        int n = arr.length;
        if (n == 0) {
            return;
        }

        int w = getWidth();
        int h = getHeight();

        int barWidth = Math.max(1, w / n);

        for (int i = 0; i < n; i++) {
            int value = arr[i]; // 0..n-1
            int barHeight = (int) Math.round(((value + 1.0) / n) * h);

            int x = i * barWidth;
            int y = h - barHeight;

            if (notes.isHighlighted(i)) {
                g.drawRect(x, y, barWidth - 1, barHeight - 1);
            } else {
                g.fillRect(x, y, barWidth - 1, barHeight);
            }
        }
    }
}