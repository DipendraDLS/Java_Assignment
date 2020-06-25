package Q02_EllipseBean;

import java.awt.Image;
    import java.beans.BeanInfo;
    import java.beans.SimpleBeanInfo;

    public class EllipseBeanInfo extends SimpleBeanInfo {
        private final Image iconColor16;
        private final Image iconColor32;
        private final Image iconMono16;
        private final Image iconMono32;

        public EllipseBeanInfo() {
            iconColor16 = loadImage("/images/Ellipse16x16.png");
            iconColor32 = loadImage("/images/Ellipse32x32.png");
            iconMono16 = loadImage("/images/Ellipse16x16.png");
            iconMono32 = loadImage("/images/Ellipse32x32.png");
        }

        @Override
        public Image getIcon(int iconType) {
            switch (iconType) {
                case BeanInfo.ICON_COLOR_16x16:
                    return iconColor16;
                case BeanInfo.ICON_COLOR_32x32:
                    return iconColor32;
                case BeanInfo.ICON_MONO_16x16:
                    return iconMono16;
                case BeanInfo.ICON_MONO_32x32:
                    return iconMono32;
                default:
                    return null;
            }
        }
    }
