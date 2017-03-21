package org.usfirst.frc.team4930.robot.sensors;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Cameras
{

  UsbCamera gearCamera;
  UsbCamera intakeCamera;
  MjpegServer mjpegServer;
  public int currentCam;

  public Cameras() {
    // create camera server
    CameraServer cs = CameraServer.getInstance();
    // create usb cameras
    gearCamera = new UsbCamera("USBCamera0", 0);
    intakeCamera = new UsbCamera("USBCamera1", 1);
    // add cameras to server
    cs.addCamera(gearCamera);
    cs.addCamera(intakeCamera);
    // settings for cam 0
    gearCamera.setResolution(640, 480);
    gearCamera.setFPS(20);
    // settings for cam 1
    intakeCamera.setResolution(640, 480);
    intakeCamera.setFPS(20);
    // start with cam 0
    mjpegServer = cs.addServer("USBCameraServer");
    mjpegServer.setSource(gearCamera);
    currentCam = 0;
  }

  public void toggleCamera() {
    if (currentCam == 0) {
      mjpegServer.setSource(intakeCamera);
      SmartDashboard.putString("c", "INTAKE Camera");
      currentCam = 1;
    }
    if (currentCam == 1) {
      mjpegServer.setSource(gearCamera);
      SmartDashboard.putString("c", "GEAR Camera");
      currentCam = 0;
    }
  }

}
