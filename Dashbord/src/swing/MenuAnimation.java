/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing;

import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author hoanh
 */
public class MenuAnimation {

    private final MigLayout layout;
    private final menuItem menuItem;
    private Animator animator;
    private boolean open;

    public MenuAnimation() {
        this.layout = null;
        this.menuItem = null;
    }

    public MenuAnimation(MigLayout layout, Component component) {
        this.layout = layout;
        this.menuItem = (menuItem) component;
        initAnimator(component, 200);
    }

    public MenuAnimation(MigLayout layout, Component component, int duration) {
        this.layout = layout;
        this.menuItem = (menuItem) component;
        initAnimator(component, duration);
    }

    private void initAnimator(Component component, int durator) {
        int height = component.getPreferredSize().height;
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float h;
                if (open) {
                    h = 40 + ((height - 40) * fraction);
                    menuItem.setAlpha(fraction);
                } else {
                    h = 40 + ((height - 40) * (1f - fraction));
                    menuItem.setAlpha(1f - fraction);
                }
                layout.setComponentConstraints(menuItem, "h " + h + "!");
                component.revalidate();
                component.repaint();
            }

        };
        animator = new Animator(durator, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
    }
    public void openMenu(){
        open = true;
        animator.start();
    }
    public void closeMenu(){
        open = false;
        animator.start();
    }
}
