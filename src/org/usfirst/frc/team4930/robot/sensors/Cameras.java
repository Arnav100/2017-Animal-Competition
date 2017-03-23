package org.usfirst.frc.team4930.robot.sensors;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Cameras
{

  UsbCamera gearCamera;
  UsbCamera intakeCamera;
  VideoSink server;
  public boolean currentCam;

  public Cameras() {
    // create camera server
    CameraServer cs = CameraServer.getInstance();
    // create usb cameras
    gearCamera = cs.startAutomaticCapture("USBCamera0", 0);
    intakeCamera = cs.startAutomaticCapture("USBCamera1", 1);
    // add cameras to server
    cs.addCamera(gearCamera);
    cs.addCamera(intakeCamera);
    // settings for cam 0
    gearCamera.setResolution(320, 240);
    gearCamera.setFPS(15);
    // settings for cam 1
    intakeCamera.setResolution(320, 240);
    intakeCamera.setFPS(15);
    // start with cam 0
    server = cs.getServer();
    server.setSource(gearCamera);
    currentCam = true;
  }

  public void toggleCamera() {
    if (currentCam) {
      server.setSource(intakeCamera);
      SmartDashboard.putString("c", "INTAKE Camera");
    } else {
      server.setSource(gearCamera);
      SmartDashboard.putString("c", "GEAR Camera");
    }
    currentCam = !currentCam;

  }

}
