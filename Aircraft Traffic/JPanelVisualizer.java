/*import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class JPanelVisualizer extends JPanel implements ActionListener {
   private Timer timer;
   private int secondsPerFrame = 10;
   private Image icon = (new ImageIcon("Folder BACKGROUND/cat.PNG")).getImage();
   private int planeCount = (int)(Math.random() * (double)10.0F) + 1;
   private Plane[] planes;

   public JPanelVisualizer() {
      this.planes = new Plane[this.planeCount];

      for(int var1 = 0; var1 < this.planes.length; ++var1) {
         this.planes[var1] = new CargoPlane("Plane " + (var1 + 1), "Model " + (var1 + 1), 500.0D, "Flying", 10000.0D, 20000.0D, 10000.0D, 100);
         int var2 = (int)(Math.random() * (double)800.0F) + 1;
         int var3 = (int)(Math.random() * (double)800.0F) + 1;
         this.planes[var1].setTarget(new Vector2(var2, var3));
      }

      this.timer = new Timer(this.secondsPerFrame, this);
      this.timer.start();
   }

   public void actionPerformed(ActionEvent var1) {
      for(int var2 = 0; var2 < this.planes.length; ++var2) {
         this.planes[var2].moveTowards(1);
         if (this.planes[var2].getReachedTarget()) {
            this.planes[var2].changeTarget();
            this.planes[var2].setReachedTarget(false);
         }
      }

      this.repaint();
   }

   protected void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      var1.drawImage(this.icon, 100, 20, this);

      for(int var2 = 0; var2 < this.planes.length; ++var2) {
         var1.setColor(Color.YELLOW);
         var1.fillOval(this.planes[var2].getLocation().getxPos(), this.planes[var2].getLocation().getyPos(), 50, 50);
         var1.setColor(Color.BLACK);
         Plane var10001 = this.planes[var2];
         var1.drawString("This is plane " + var10001.getPlaneID(), this.planes[var2].getLocation().getxPos(), this.planes[var2].getLocation().getyPos());
      }

   }
}*/
