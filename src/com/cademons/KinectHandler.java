package com.cademons;

import edu.ufl.digitalworlds.j4k.J4KSDK;
import edu.ufl.digitalworlds.j4k.DepthMap;
import edu.ufl.digitalworlds.j4k.Skeleton;
import edu.ufl.digitalworlds.j4k.VideoFrame;

public class KinectHandler extends J4KSDK {

    VideoFrame videoTexture;
    int frames = 0;

    public KinectHandler () {
        super ();
        videoTexture = new VideoFrame();
    }

    public KinectHandler(byte kinect_type) {
        super (kinect_type);
    }

    public KinectHandler (byte kinect_type, int id) {
        super (kinect_type, id);
    }

    public void onDepthFrameEvent(short[] depth_frame, byte[] player_index, float[] XYZ, float[] UV) {

        short[][] depth_2d = new short[getDepthHeight()][getDepthWidth()];

        for (int i = 0; i < depth_frame.length; i++) {
            int h_idx = i / getDepthHeight();
            int w_idx = i % getDepthHeight();
            depth_2d[h_idx][w_idx] = depth_frame[i];
        }

        if (frames++ == 20) {
            for (short[] line : depth_2d) {
                for (short depth : line) {
                    System.out.print(depth);
                    System.out.print(",");
                }
                System.out.println();
            }
        }

//        DepthMap map=new DepthMap(getDepthWidth(),getDepthHeight(),XYZ);
//
//
//        if (UV!=null) {
//            map.setUV(UV);
//        }
    }

    /*The following method will run every time a new skeleton frame
      is received from the Kinect sensor. The skeletons are converted
      into Skeleton objects.*/
    @Override
    public void onSkeletonFrameEvent(boolean[] skeleton_tracked, float[] joint_position, float[] joint_orientation, byte[] joint_status) {

        Skeleton skeletons[]=new Skeleton[getMaxNumberOfSkeletons()];
        for(int i=0;i<getMaxNumberOfSkeletons();i++)
            skeletons[i]=Skeleton.getSkeleton(i, skeleton_tracked, joint_position, joint_orientation, joint_status, this);
    }

    /*The following method will run every time a new color frame
      is received from the Kinect video camera. The incoming frame
      is passed to the videoTexture object to update its content.*/
    @Override
    public void onColorFrameEvent(byte[] data) {
        videoTexture.update(getColorWidth(), getColorHeight(), data);
    }
}
