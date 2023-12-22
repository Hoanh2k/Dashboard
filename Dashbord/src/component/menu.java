package component;

import com.raven.event.EventShowPopupMenu;
import event.eventMenu;
import event.eventMenuSelected;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;

import scrollbar.ScrollBarCustom;
import swing.MenuAnimation;
import swing.menuItem;

public class menu extends javax.swing.JPanel {

    @Override
    public MigLayout getLayout() {
        return layout;
    }

    public void setLayout(MigLayout layout) {
        this.layout = layout;
    }

    public eventMenuSelected getEvent() {
        return event;
    }

    public void addEvent(eventMenuSelected event) {
        this.event = event;
    }

    public boolean isEnableMenu() {
        return enableMenu;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public boolean isShowMenu() {
        return showMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    private MigLayout layout;

    private eventMenuSelected event;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    private EventShowPopupMenu eventShowPopup;

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    public menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap,fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);

    }

    private void addMenu(ModelMenu menu) {
        panel.add(new menuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon("src\\icon\\1.png"), "Trang chủ"));
        addMenu(new ModelMenu(new ImageIcon("src\\icon\\12.png"), "Hàng hoá", "Sản phẩm", "Mặt Hàng", "Nhà cung cấp"));
        addMenu(new ModelMenu(new ImageIcon("src\\icon\\4.png"), "Giao dịch", "Nhập Hàng", "Bán Hàng", "Trả Hàng", "Đổi hàng", "Hoá Đơn Bán hàng", "Hoá đơn Nhập hàng", "Hoá đơn trả hàng", "Hóa đơn đổi hàng"));
        addMenu(new ModelMenu(new ImageIcon("src\\icon\\3.png"), "Thống kê", "Thông kê doanh thu", "Thống kê doanh số"));
        addMenu(new ModelMenu(new ImageIcon("src\\icon\\5.png"), "Nhân viên", "Danh sách nhân viên"));
        addMenu(new ModelMenu(new ImageIcon("src\\icon\\10.png"), "Khách hàng"));
        addMenu(new ModelMenu(new ImageIcon("src\\icon\\user.png"), "Cá Nhân", "Thông tin cá nhân", "Đổi mật khẩu"));
        addMenu(new ModelMenu(new ImageIcon("src\\icon\\9.png"), "Khuyến mãi"));
        addMenu(new ModelMenu(new ImageIcon("src\\icon\\ExitAccount.png"), "Đăng xuất"));

    }

    private eventMenu getEventMenu() {
        return new eventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            menuItem item = (menuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sp.setOpaque(false);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 721, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shop (6).png"))); // NOI18N
        jLabel1.setText("App logo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(33, 105, 249), getWidth(), 0, new Color(93, 58, 196));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
